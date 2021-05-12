package com.ciandt.tdd.handson.tddhandson.entity;

public class User {

    private int id;
    private String name;
    private Departament departament;

    public User(int id, String name, Departament departament) {
        this.id = id;
        this.name = name;
        this.departament = departament;
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

    public Departament getDepartament() {
        return departament;
    }

    public static User createUser(String name, Departament departament) {
        return new User(0, name, departament);
    }
}
