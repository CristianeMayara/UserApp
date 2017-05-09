package com.mobile.movies.model.vo;

/**
 * Created by Cristiane on 28/04/2017.
 */

public class Movie {

    private int id;
    private String brazilianTitle;
    private String originalTitle;
    private int genre;
    private String synopsis;
    private String director;
    private String cast;
    private int country;
    private int year;
    private int runtime;
    private boolean isFavorite;

    public Movie(int id, String brazilianTitle, int genre, int year, String cast, int runtime) {
        this.id = id;
        this.brazilianTitle = brazilianTitle;
        this.genre = genre;
        this.year = year;
        this.cast = cast;
        this.runtime = runtime;
    }

    public Movie(int id, String brazilianTitle, String originalTitle, int genre, String synopsis, String director, String cast, int country, int year, int runtime, boolean isFavorite) {
        this.id = id;
        this.brazilianTitle = brazilianTitle;
        this.originalTitle = originalTitle;
        this.genre = genre;
        this.synopsis = synopsis;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.year = year;
        this.runtime = runtime;
        this.isFavorite = isFavorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrazilianTitle() {
        return brazilianTitle;
    }

    public void setBrazilianTitle(String brazilianTitle) {
        this.brazilianTitle = brazilianTitle;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
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

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
