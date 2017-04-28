package com.mobile.movies.model.vo;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class Movie {

    private int id;
    private String name;
    private int genre;
    private String synopsis;
    private String director;
    private String cast;
    private int country;
    private int year;
    private boolean isFavorite;

    public Movie(int id, String name, int genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public Movie(int id, String name, int genre, String synopsis, String director, String cast, int country, int year, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.year = year;
        this.isFavorite = isFavorite;
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

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
