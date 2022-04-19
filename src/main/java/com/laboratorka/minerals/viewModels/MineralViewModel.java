package com.laboratorka.minerals.viewModels;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

public class MineralViewModel {
    private int id;
    private String name;
    private String description;
    private String researchers;
    private String publications;
    private String territories;
    private String fields;


    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public String getTerritories() {
        return territories;
    }

    public void setTerritories(String territories) {
        this.territories = territories;
    }

    public String getPublications() {
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }

    public String getResearchers() {
        return researchers;
    }

    public void setResearchers(String researchers) {
        this.researchers = researchers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
