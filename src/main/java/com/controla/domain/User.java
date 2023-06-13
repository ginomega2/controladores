package com.controla.domain;


public class User {


    private String fullName;
    private int age;
    private boolean asegurado;
    private String genero;

    public User() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAsegurado() {
        return asegurado;
    }

    public void setAsegurado(boolean asegurado) {
        this.asegurado = asegurado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public User(String fullName, int age, boolean asegurado, String genero) {
        this.fullName = fullName;
        this.age = age;
        this.asegurado = asegurado;
        this.genero = genero;
    }
}
