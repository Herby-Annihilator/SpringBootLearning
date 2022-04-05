package com.laboratorka.minerals.entities;


import org.apache.tomcat.util.descriptor.web.NamingResources;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "territory")
public class Territory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "territory_id", nullable = false, unique = true)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "territory")
    private List<Field> fields;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Territory(int id, String name, Country country, List<Field> fields) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.fields = fields;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Territory(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Territory() {
    }
}
