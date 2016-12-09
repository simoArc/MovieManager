/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hearc.ig.odi.moviemanager.converter;

import ch.hearc.ig.odi.moviemanager.business.Movie;
import ch.hearc.ig.odi.moviemanager.service.Services;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Simone Bissolotti
 */
@Named(value = "movieLOVConverter")
@RequestScoped
public class MovieLOVConverter implements Converter {

    @Inject
    Services service;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null) {
            return null;
        } else {
            return service.getMovieWithId(new Long(value));
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value == null){
            return null;
        }else if(value instanceof Movie){
            return ((Movie)value).getId().toString();
        }else{
            return "";
        }
    }

}
