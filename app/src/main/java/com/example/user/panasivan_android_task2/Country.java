package com.example.user.panasivan_android_task2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Country implements Parcelable {
    private String name;
    //private List<Film> films = new ArrayList<>();

    public Country(String name) {
        this.name = name;
    }

    protected Country(Parcel in) {
        name = in.readString();
       // films = in.createTypedArrayList(Film.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
     //   dest.writeTypedList(films);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Country> CREATOR = new Creator<Country>() {
        @Override
        public Country createFromParcel(Parcel in) {
            return new Country(in);
        }

        @Override
        public Country[] newArray(int size) {
            return new Country[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public List<Film> getFilms() {
    //    return films;
    //}

    //public void setFilms(List<Film> films) {
    //    this.films = films;
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
