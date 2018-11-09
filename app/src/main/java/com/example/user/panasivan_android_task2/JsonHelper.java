package com.example.user.panasivan_android_task2;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonHelper {
    private Context context;

    public JsonHelper(Context context) {
        this.context = context;
    }

    public List<Film> getFilms() {
        List<Film> filmList = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();
        List<Language> languageList = new ArrayList<>();
        List<Genre> genreList = new ArrayList<>();
        String filmsJson;

        try {
            InputStream is = context.getAssets().open("films.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            filmsJson = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(filmsJson);

            for (int i = 0; i < jsonArray.length(); i++) {
                Film film = new Film();
                JSONObject obj = jsonArray.getJSONObject(i);
                film.setTitle(obj.getString("Title"));
                film.setYear(obj.getString("Year"));
                film.setRuntime(obj.getString("Runtime"));
                film.setPlot(obj.getString("Plot"));
                film.setAwards(obj.getString("Awards"));

                String genresArray = obj.getString("Genre");
                initGenres(genreList, getGenreObjects(genresArray), film);
                String langsArray = obj.getString("Language");
                initLanguages(languageList, getLanguageObjects(langsArray), film);
                String statesArray = obj.getString("Country");
                initCountries(countryList, getCountryObjects(statesArray), film);
                String actorsArray = obj.getString("Actors");
                initPersons(personList, getPersonObjects(actorsArray), film, new Role("Actor"));
                String writersArray = obj.getString("Writer");
                initPersons(personList, getPersonObjects(writersArray), film, new Role("Writer"));
                String directorsArray = obj.getString("Director");
                initPersons(personList, getPersonObjects(directorsArray), film, new Role("Director"));

                filmList.add(film);
            }
        } catch (Exception e) {

        }

        return filmList;
    }

    public List<Person> getPersonObjects(String parseString){
        List<Person> personList = new ArrayList<>();
        for (String str: parseString.split(",")){
            Person person = new Person(str.trim());
            personList.add(person);
        }
        return personList;
    }

    public List<Genre> getGenreObjects(String parseString){
        List<Genre> genreList = new ArrayList<>();
        for (String str: parseString.split(",")){
            Genre genre = new Genre(str.trim());
            genreList.add(genre);
        }
        return genreList;
    }

    public List<Language> getLanguageObjects(String parseString){
        List<Language> languageList = new ArrayList<>();
        for (String str: parseString.split(",")){
            Language language = new Language(str.trim());
            languageList.add(language);
        }
        return languageList;
    }

    public List<Country> getCountryObjects(String parseString) {
        List<Country> countryList = new ArrayList<>();
        for (String str: parseString.split(",")){
            Country country = new Country(str.trim());
            countryList.add(country);
        }
        return countryList;
    }

    public void initGenres(List<Genre> genreListOrigin, List<Genre> genreListToInit, Film film){
        for (Genre genre: genreListToInit) {
            if(!genreListOrigin.contains(genre)){
                genreListOrigin.add(genre);
            }
            Genre genreInit = genreListOrigin.get(genreListOrigin.indexOf(genre));
            //genreInit.getFilms().add(film);
            film.addGenre(genre);
        }
    }

    public void initCountries(List<Country> countryListOrigin, List<Country> countryListToInit, Film film){
        for (Country country: countryListToInit) {
            if(!countryListOrigin.contains(country)){
                countryListOrigin.add(country);
            }
            Country countryInit = countryListOrigin.get(countryListOrigin.indexOf(country));
            //countryInit.getFilms().add(film);
            film.addCountry(country);
        }
    }

    public void initLanguages(List<Language> langListOrigin, List<Language> langListToInit, Film film){
        for (Language lang: langListToInit) {
            if(!langListOrigin.contains(lang)){
                langListOrigin.add(lang);
            }
            Language langInit = langListOrigin.get(langListOrigin.indexOf(lang));
            //langInit.getFilms().add(film);
            film.addLanguage(lang);
        }
    }

    public void initPersons(List<Person> personListOrigin, List<Person> personListToInit, Film film, Role role){

        for (Person person: personListToInit) {
            Role initRole = new Role(role.getName());
            if(initRole.getName() == "Writer"){
                Pattern pattern = Pattern.compile("\\((.*?)\\)");
                Matcher m = pattern.matcher(person.getName());
                while (m.find()) {
                    String s = m.group(0);
                    initRole.setDescription(s);
                    String name = person.getName().replace(s, "");
                    person.setName(name.trim());
                }
            }
            if(!personListOrigin.contains(person)){
                personListOrigin.add(person);
            }
            //Person personInit = personListOrigin.get(personListOrigin.indexOf(person));
            //personInit.setRole(role);
            //role.setPerson(personInit);
            //role.setFilm(film);
            person.setRole(initRole);
            switch (initRole.getName()){
                case "Actor":
                    //film.setActor(personInit);
                    film.setActor(person);
                    break;
                case "Writer":
                    //film.setWriter(personInit);
                    film.setWriter(person);
                    break;
                case "Director":
                    //film.setDirector(personInit);
                    film.setDirector(person);
                    break;
                default:
                    //film.setPerson(personInit);
                    film.setPerson(person);
                    break;
            }
        }
    }
}
