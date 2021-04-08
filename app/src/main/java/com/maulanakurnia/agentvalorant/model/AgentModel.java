package com.maulanakurnia.agentvalorant.model;

public class AgentModel {
    private String image,name,role,summary;

    public AgentModel(String image, String name, String role, String summary) {
        this.image   = image;
        this.name    = name;
        this.role    = role;
        this.summary = summary;
    }

    public AgentModel() {

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}