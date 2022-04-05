package com.laboratorka.minerals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "mineral")
public class Mineral implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "mineral_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "minerals")
    private List<Field> fields;

    @ManyToMany(mappedBy = "minerals")
    private List<Ore> ores;

    @ManyToMany(mappedBy = "minerals")
    private List<Publication> publications;

    public List<Ore> getOres() {
        return ores;
    }

    public void setOres(List<Ore> ores) {
        this.ores = ores;
    }

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Mineral(int id, String name, List<Field> fields, List<Ore> ores, List<Publication> publications) {
        this.id = id;
        this.name = name;
        this.fields = fields;
        this.ores = ores;
        this.publications = publications;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }


    public Mineral() {
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
}
