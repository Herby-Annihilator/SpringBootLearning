package com.laboratorka.minerals.entities;

import org.apache.tomcat.util.descriptor.web.NamingResources;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "researcher")
public class Researcher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "researcher_id",nullable = false,unique = true)
    private int id;

    public List<Publication> getPublications() {
        return publications;
    }

    public void setPublications(List<Publication> publications) {
        this.publications = publications;
    }

    public Researcher(int id, String firstName, String lastName, String patronymic, List<Publication> publications) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.publications = publications;
    }

    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;

    @ManyToMany(mappedBy = "researchers")
    private List<Publication> publications;

    public Researcher() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
