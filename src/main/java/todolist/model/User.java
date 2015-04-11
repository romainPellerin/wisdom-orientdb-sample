package todolist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by Romain Pellerin-Rezzi aka @rom1 on 08/04/2015.
 * Twitter: @rom1_ubidreams
 */
@Entity
@JsonIgnoreProperties("handler")
public class User {
    @Id
    private String id;

    private String name;

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }




}
