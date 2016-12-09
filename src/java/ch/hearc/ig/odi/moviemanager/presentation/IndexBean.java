/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.presentation;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.business.Person;
import ch.hearc.ig.odi.moviemanager.exception.InvalidParameterException;
import ch.hearc.ig.odi.moviemanager.exception.NullParameterException;
import ch.hearc.ig.odi.moviemanager.exception.UniqueException;
import ch.hearc.ig.odi.moviemanager.service.Services;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
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
    private Map<Long, Movie> movies;
    private Person person;
    private Long personId;
    private Movie newMovie;

    public IndexBean() {

    }

    /**
     * Initialisation de la liste avec toutes les personnes existentes
     */
    public void initList() {
        this.people = service.getPeople();
        this.movies = service.getMovies();
    }

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
        person = service.getPersonWithId(personId);
    }

    public Movie getNewMovie() {
        return newMovie;
    }

    public void setNewMovie(Movie newMovie) {
        this.newMovie = newMovie;
    }

    
    public ArrayList<Map.Entry<Long, Movie>> getMovies() {
        ArrayList<Map.Entry<Long, Movie>> list = new ArrayList<>(movies.entrySet());
        return list;
    }

    /**
     * Initialisation de l'id passé en paramètre url avec l'id de la personne
     * concernée
     */
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

    /**
     * Suppression d'un film sur une personne, efface aussi la personne lié au
     * film
     *
     * @param person
     * @param movie
     */
    public void removeMovie(Person person, Movie movie) {
        try {
            service.removeMovieFromPerson(person, movie);
        } catch (NullParameterException | InvalidParameterException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String save(Person person) throws NullParameterException {
        service.savePerson(person);
        return "/index.xhtml?faces-redirect=true";

    }

    /**
     * Utilisation de la liste déroulante pour l'ajout de film à une personne
     */
    public void addMovie() {
        try {
            service.addMovieToPerson(person, newMovie);

        } catch (NullParameterException | UniqueException ex) {
            Logger.getLogger(IndexBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Retourne la liste de film n'étant pas déjà chez la personne
     * @return liste de films disponible
     */
     public List<Movie> getListMovies(){
        List<Movie> listMovies = new ArrayList(service.getMoviesList());
        
            for(Map.Entry<Long, Movie> moviePerson : person.getMovies()){
                listMovies.remove(moviePerson.getValue());
            }
        return listMovies;
    }
}
