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
import org.wisdom.api.templates.Template;
import org.wisdom.orientdb.object.OrientDbCrud;
import todolist.model.Todo;
import todolist.model.TodoList;

import static org.wisdom.api.http.HttpMethod.GET;

/**
 * created: 5/15/14.
 *
 * @author <a href="mailto:jbardin@tech-arts.com">Jonathan M. Bardin</a>
 * @version 1.0
 */
@Controller
@Path("/")
public class HomeController extends DefaultController{
    static {Class workaround = Proxy.class;}
    @View("home")
    private Template home;


    @Model(value = TodoList.class)
    private OrientDbCrud<TodoList,String> listCrud;

    @Model(value = Todo.class)
    private OrientDbCrud<Todo,String> todoCrud;

    /**
     * Return the todolist view.
     *
     * @response.mime text/html
     * @return list of todolist.
     */
    @Route(method = GET,uri = "")
    public Result getList(){
        return ok(render(home));
    }
}
