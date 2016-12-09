/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Simone Bissolotti
 */
public class Movie implements Serializable {

    private Long id;
    private String name;
    private String producer;

    private Map<Long, Person> people;

    public Movie(Long id, String title, String author) {
        this.id = id;
        this.name = title;
        this.producer = author;

        people = new HashMap();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void addPerson(Person person){
        this.people.put(person.getId(), person);
    }
    /*public Map<Long, Person> getPeople() {
        return people;
    }*/
    public ArrayList<Map.Entry<Long, Person>> getPeople() {
        return new ArrayList<>(people.entrySet());
    }


}
