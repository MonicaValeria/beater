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
public class MusicGenre {
    private int id_mg;
    private int id_person;
    private String name_mg;
    private String artist_ref;
    private String detail_mg;

    public MusicGenre() {
    }

    public MusicGenre(int id_mg, int id_person, String name_mg, String artist_ref, String detail_mg) {
        this.id_mg = id_mg;
        this.id_person = id_person;
        this.name_mg = name_mg;
        this.artist_ref = artist_ref;
        this.detail_mg = detail_mg;
    }

    public MusicGenre(int id_person, String name_mg, String artist_ref, String detail_mg) {
        this.id_person = id_person;
        this.name_mg = name_mg;
        this.artist_ref = artist_ref;
        this.detail_mg = detail_mg;
    }

    
    

  
    
    public int getId_mg() {
        return id_mg;
    }

    public void setId_mg(int id_mg) {
        this.id_mg = id_mg;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getName_mg() {
        return name_mg;
    }

    public void setName_mg(String name_mg) {
        this.name_mg = name_mg;
    }

    public String getArtist_ref() {
        return artist_ref;
    }

    public void setArtist_ref(String artist_ref) {
        this.artist_ref = artist_ref;
    }

    public String getDetail_mg() {
        return detail_mg;
    }

    public void setDetail_mg(String detail_mg) {
        this.detail_mg = detail_mg;
    }
    
    
    
}
