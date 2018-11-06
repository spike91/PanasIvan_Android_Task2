package com.example.user.panasivan_android_task2;

import java.util.ArrayList;
import java.util.List;

public class Film {
    private String title;
    private String year;
    private String runtime;
    private String plot;
    private String awards;
    private List<Person> personList = new ArrayList<>();
    private List<Person> actors = new ArrayList<>();
    private List<Person> directors = new ArrayList<>();
    private List<Person> writers = new ArrayList<>();
    private List<Language> languages = new ArrayList<>();
    private List<Genre> genres = new ArrayList<>();
    private List<Country> countries = new ArrayList<>();

    public Film() {
    }

    public Film(String title, String year, String runtime, String plot, String awards) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.plot = plot;
        this.awards = awards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public List<Person> getActors() {
        return actors;
    }

    public void setActors(List<Person> actors) {
        this.actors = actors;
    }

    public void setActor(Person actor) {
        this.actors.add(actor);
    }

    public List<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Person> directors) {
        this.directors = directors;
    }

    public void setDirector(Person director) {
        this.directors.add(director);
    }

    public List<Person> getWriters() {
        return writers;
    }

    public void setWriters(List<Person> writers) {
        this.writers = writers;
    }

    public void setWriter(Person writer) {
        this.writers.add(writer);
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void addLanguage(Language language) {
        this.languages.add(language);
    }

    public void addCountry(Country country) {
        this.countries.add(country);
    }


    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public void setPerson(Person person) {
        this.personList.add(person);
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}
