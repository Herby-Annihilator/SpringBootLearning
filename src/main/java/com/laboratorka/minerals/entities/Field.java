package com.laboratorka.minerals.entities;

import javax.naming.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "field")
public class Field implements Serializable {
    public List<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<Mineral> minerals) {
        this.minerals = minerals;
    }

    public Field(int id, String name, Territory territory, List<Mineral> minerals) {
        this.id = id;
        this.name = name;
        this.territory = territory;
        this.minerals = minerals;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "territory_id")
    private Territory territory;

    @ManyToMany
    @JoinTable(
            name = "field_has_mineral",
            joinColumns = @JoinColumn(name = "field_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private List<Mineral> minerals;

    public Field() {
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

    public Territory getTerritory() {
        return territory;
    }

    public void setTerritory(Territory territory) {
        this.territory = territory;
    }
}
