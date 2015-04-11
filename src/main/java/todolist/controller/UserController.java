/*
 * Copyright 2014, Technologic Arts Vietnam.
 * All right reserved.
 */

package todolist.controller;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import javassist.util.proxy.Proxy;
import org.apache.felix.ipojo.annotations.Validate;
import org.wisdom.api.DefaultController;
import org.wisdom.api.annotations.*;
import org.wisdom.api.http.Result;
import org.wisdom.orientdb.object.OrientDbCrud;

import todolist.model.User;

import java.util.Iterator;

import static org.wisdom.api.http.HttpMethod.*;

/**
 * Simple TodoList rest api.
 *
 * @version 1.0
 * @author <a href="mailto:jbardin@tech-arts.com">Jonathan M. Bardin</a>
 *
 * modded by Romain Pellerin aka @rom1
 */
@Controller
@Path("/user")
public class UserController extends DefaultController{
    static {Class workaround = Proxy.class;}

    @Model(value = User.class)
    private OrientDbCrud<User,String> userCrud;

    /**
     * Return the list of users.
     *
     * @response.mime text/json
     * @return list of users.
     */
    @Route(method = GET,uri = "/name/{name}")
    public Result getUserByName(final @Parameter("name") String name){
        Iterator<User> iter = userCrud.findAll().iterator();

        // search for a user with this name
        User user = null;
        while (iter.hasNext()){
            user = iter.next();
            if (user.getName().equals(name)) break;
            user = null;
        }

        return (user == null ? notFound().render("unknown") : ok(user).json());
    }

}
