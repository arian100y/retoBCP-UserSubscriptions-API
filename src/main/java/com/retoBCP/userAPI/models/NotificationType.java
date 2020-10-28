package com.retoBCP.userAPI.models;

import javax.persistence.*;


public class NotificationType {

    private Integer id;
    private String type;
    private String description;

    public NotificationType(Integer id, String type, String description) {
        this.id = id;
        this.type = type;
        this.description = description;
    }
    public NotificationType(){super();}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
