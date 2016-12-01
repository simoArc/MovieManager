/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.io.Serializable;

/**
 *
 * @author Simone Bissolotti
 */
public class Movie implements Serializable {

    private Long id;
    private String name;
    private String producer;
    private Person person;

    public Movie(Long id, String title, String author) {
        this.id = id;
        this.name = title;
        this.producer = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getAuthor() {
        return producer;
    }

    public void setAuthor(String author) {
        this.producer = author;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    
    
}
