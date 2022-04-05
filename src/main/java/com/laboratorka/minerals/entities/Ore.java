package com.laboratorka.minerals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Руда
 **/
@Entity
@Table(name = "ore")
public class Ore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ore_id", nullable = false, unique = true)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    public List<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<Mineral> minerals) {
        this.minerals = minerals;
    }

    public Ore(int id, String name, List<Mineral> minerals) {
        this.id = id;
        this.name = name;
        this.minerals = minerals;
    }

    @ManyToMany
    @JoinTable(
            name = "ore_has_mineral",
            joinColumns = @JoinColumn(name = "ore_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private List<Mineral> minerals;

    public Ore() {
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
