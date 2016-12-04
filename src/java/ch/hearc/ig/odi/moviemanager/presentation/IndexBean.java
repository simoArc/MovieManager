/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation;

import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Simone Bissolotti
 */
@Named("indexBean")
@ViewScoped
public class IndexBean implements Serializable {

    @Inject
    Services service;

    private Map<Long, Person> people;
    private Person person;
    private Long personId;

    public IndexBean() {
        
    }
    
    public void initList(){
        this.people = service.getPeople();
    }

   /* public List getPeopleList() {
        return service.getPeopleList();
    }*/

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public List getMoviesList() {
        return service.getMoviesList();
    }

        public void initPerson() {
        String idParam = FacesContext
                .getCurrentInstance()
                .getExternalContext()
                .getRequestParameterMap().get("id");
        if (!(idParam == null || idParam.isEmpty())) {
            personId = new Long(idParam);
            person = service.getPersonWithId(personId);
        }
    }
        
    public ArrayList<Map.Entry<Long, Person>> getPeople() {
        ArrayList<Map.Entry<Long, Person>> list = new ArrayList<>(people.entrySet());
        return list;
    }
}
