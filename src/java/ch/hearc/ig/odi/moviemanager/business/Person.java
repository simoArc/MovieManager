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
public class Person implements Serializable{
    
    private Long id;
    private String firstName;
    private String lastName;
    
    private Map<String, Movie> movies;

    public Person(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        
        movies = new HashMap();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public void setMovies(Map<String, Movie> movies) {
        this.movies = movies;
    }
    
/*    public ArrayList<Map.Entry<String, Movie>> getMovies() {
        return new ArrayList<>(movies.entrySet());
    }*/
    
    //id passée en paramètre url
    public Movie getMovieById(String id){
        return movies.get(id);
        
    }

    public void addMovie(Movie movie) {
        this.movies.put(movie.getTitle(), movie);
        
    }
    
    
    
}
