package com.laboratorka.minerals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "country")
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", unique = true, nullable = false)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    public Country(int id, String name, List<Territory> territories) {
        this.id = id;
        this.name = name;
        this.territories = territories;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void setTerritories(List<Territory> territories) {
        this.territories = territories;
    }

    @OneToMany(mappedBy = "country")
    private List<Territory> territories;

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

    public Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Country() {
    }
}
