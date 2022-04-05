package com.laboratorka.minerals.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "publication")
public class Publication implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publication_id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "creation_date", nullable = false)
    private Date creationDate;

    public List<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(List<Researcher> researchers) {
        this.researchers = researchers;
    }

    public List<Mineral> getMinerals() {
        return minerals;
    }

    public void setMinerals(List<Mineral> minerals) {
        this.minerals = minerals;
    }

    public Publication(int id, String name, Date creationDate, List<Researcher> researchers, List<Mineral> minerals) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.researchers = researchers;
        this.minerals = minerals;
    }

    @ManyToMany
    @JoinTable(
            name = "researcher_has_publication",
            joinColumns = @JoinColumn(name = "publication_id"),
            inverseJoinColumns = @JoinColumn(name = "researcher_id")
    )
    private List<Researcher> researchers;

    @ManyToMany
    @JoinTable(
            name = "publication_describes_mineral",
            joinColumns = @JoinColumn(name = "publication_id"),
            inverseJoinColumns = @JoinColumn(name = "mineral_id")
    )
    private List<Mineral> minerals;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Publication() {
    }
}
