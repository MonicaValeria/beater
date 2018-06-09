/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.bean;

/**
 *
 * @author Monica
 */
public class Person {
    private int id;
    private String user;
    private String password;
    private String name;
    private String lastName;
    private String correo;
    private int score;
    private String description;
    private int id_type;

    public Person() {
    }

    public Person(int id, String user, String password, String name, String lastName, String correo, int score, String description, int id_type) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.correo = correo;
        this.score = score;
        this.description = description;
        this.id_type = id_type;
    }

    public Person(String user, String password, String name, String lastName, String correo, int score, String description, int id_type) {
        this.user = user;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.correo = correo;
        this.score = score;
        this.description = description;
        this.id_type = id_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    
            
}
