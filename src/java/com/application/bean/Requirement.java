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
public class Requirement {
    private int id_req;
    private int id_of;
    private String description_req;

    public Requirement() {
    }

    public Requirement(int id_req, int id_of, String description_req) {
        this.id_req = id_req;
        this.id_of = id_of;
        this.description_req = description_req;
    }

    public Requirement(int id_of, String description_req) {
        this.id_of = id_of;
        this.description_req = description_req;
    }

    public int getId_req() {
        return id_req;
    }

    public void setId_req(int id_req) {
        this.id_req = id_req;
    }

    public int getId_of() {
        return id_of;
    }

    public void setId_of(int id_of) {
        this.id_of = id_of;
    }

    public String getDescription_req() {
        return description_req;
    }

    public void setDescription_req(String description_req) {
        this.description_req = description_req;
    }
    
    
}
