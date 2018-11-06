package com.example.user.panasivan_android_task2;

import android.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private List<Pair<Film,Role>> roles = new ArrayList<>();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pair<Film, Role>> getRoles() {
        return roles;
    }

    public void setRole(Pair<Film, Role> role) {
        this.roles.add(role);
    }

    public void setRoles(List<Pair<Film, Role>> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
