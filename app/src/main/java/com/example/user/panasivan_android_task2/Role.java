package com.example.user.panasivan_android_task2;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class Role implements Parcelable {
    private String name;
    private String description;
   // private Person person;
    //private Film film;

    public Role(String name, Person person, Film film) {
        this.name = name;
       // this.person = person;
       // this.film = film;
    }

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    protected Role(Parcel in) {
        name = in.readString();
        description = in.readString();
       // person = in.readParcelable(Person.class.getClassLoader());
       // film = in.readParcelable(Film.class.getClassLoader());
    }

    public static final Creator<Role> CREATOR = new Creator<Role>() {
        @Override
        public Role createFromParcel(Parcel in) {
            return new Role(in);
        }

        @Override
        public Role[] newArray(int size) {
            return new Role[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //public Person getPerson() {
    //    return person;
   // }

    //public void setPerson(Person person) {
    //    this.person = person;
    //}

    //public Film getFilm() {
    //    return film;
    //}

    //public void setFilm(Film film) {
    //    this.film = film;
    //}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name); //&&
         //       Objects.equals(person, role.person) &&
        //        Objects.equals(film, role.film);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);//, person, film);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        //dest.writeParcelable(person, flags);
       // dest.writeParcelable(film, flags);
    }
}
