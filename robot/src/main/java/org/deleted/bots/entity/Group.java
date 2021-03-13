package org.deleted.bots.entity;

import java.io.Serializable;

public class Group implements Serializable {

    private Long id;//群号
    private String name;//群名
    private String permission;//机器人在此群权限

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

}
