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
    @Column(name = "description", nullable = false, length = 1000)
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathToImage() {
        return pathToImage;
    }

    public void setPathToImage(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Column(name = "path", length = 500)
    private String pathToImage;

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

    public Mineral(int id, String name, String description, String pathToImage,
                   List<Field> fields, List<Ore> ores, List<Publication> publications) {
        this.id = id;
        this.name = name;
        this.fields = fields;
        this.ores = ores;
        this.publications = publications;
        this.pathToImage = pathToImage;
        this.description = description;
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
