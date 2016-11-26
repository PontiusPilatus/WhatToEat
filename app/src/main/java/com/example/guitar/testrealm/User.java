package com.example.guitar.testrealm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Required;

/**
 * Created by guitar on 25.11.16.
 */

public class User extends RealmObject implements Serializable{

    @Required
    private String name;
    private String id;
    private String descriptionfirst;
    private String descriptionsecond;
    private String descriptionthird;

    @Ignore
    private List<User> users;

    public User()
    {}
    User (String name, String id) {
        this.name = name;
        this.id = id;
    }
//
//    public User(String name, String id, String activity_1, String activity_2, String activity_3) {
//        this.name = name;
//        this.id = id;
//        this.description_1 = activity_1;
//        this.description_2 = activity_2;
//        this.description_3 = activity_3;
//    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public void setDescriptionfirst(String descriptionfirst) {
        this.descriptionfirst = descriptionfirst;
    }

    public void setDescriptionsecond(String descriptionsecond) {
        this.descriptionsecond = descriptionsecond;
    }

    public void setDescriptionthird(String descriptionthird) {
        this.descriptionthird = descriptionthird;
    }

    public String getDescriptionfirst() {

        return descriptionfirst;
    }

    public String getDescriptionsecond() {
        return descriptionsecond;
    }

    public String getDescriptionthird() {
        return descriptionthird;
    }
}
