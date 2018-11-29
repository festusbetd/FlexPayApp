package com.example.mercy.flexpay.Activities;

public class MenuModel {

    public String id, menuName, url;
    public boolean hasChildren, isGroup;

    public MenuModel(String id,String menuName, boolean isGroup, boolean hasChildren, String url) {
        this.id = id;
        this.menuName = menuName;
        this.url = url;
        this.isGroup = isGroup;
        this.hasChildren = hasChildren;
    }

    public String getId() {
        return id;
    }
}
