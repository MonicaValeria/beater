/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.bean;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.sql.Time;

/**
 *
 * @author Monica
 */
public class Offer {
    private int id_offer;
    private int id_ev;
    private int id_person;
    private String title_of;
    private String dia_inicio;
    private String dia_fin;
    private String start_time_of;
    private String end_time_of;
    private String description_of;
    


    public Offer() {
    }

    public Offer(int id_offer, int id_ev, int id_person, String title_of, String dia_inicio, String dia_fin, String start_time_of, String end_time_of, String description_of) {
        this.id_offer = id_offer;
        this.id_ev = id_ev;
        this.id_person = id_person;
        this.title_of = title_of;
        this.dia_inicio = dia_inicio;
        this.dia_fin = dia_fin;
        this.start_time_of = start_time_of;
        this.end_time_of = end_time_of;
        this.description_of = description_of;
    }

    public Offer(int id_ev, int id_person, String title_of, String dia_inicio, String dia_fin, String start_time_of, String end_time_of, String description_of) {
        this.id_ev = id_ev;
        this.id_person = id_person;
        this.title_of = title_of;
        this.dia_inicio = dia_inicio;
        this.dia_fin = dia_fin;
        this.start_time_of = start_time_of;
        this.end_time_of = end_time_of;
        this.description_of = description_of;
    }

    public int getId_offer() {
        return id_offer;
    }

    public void setId_offer(int id_offer) {
        this.id_offer = id_offer;
    }

    public int getId_ev() {
        return id_ev;
    }

    public void setId_ev(int id_ev) {
        this.id_ev = id_ev;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getTitle_of() {
        return title_of;
    }

    public void setTitle_of(String title_of) {
        this.title_of = title_of;
    }

    public String getDia_inicio() {
        return dia_inicio;
    }

    public void setDia_inicio(String dia_inicio) {
        this.dia_inicio = dia_inicio;
    }

    public String getDia_fin() {
        return dia_fin;
    }

    public void setDia_fin(String dia_fin) {
        this.dia_fin = dia_fin;
    }

    public String getStart_time_of() {
        return start_time_of;
    }

    public void setStart_time_of(String start_time_of) {
        this.start_time_of = start_time_of;
    }

    public String getEnd_time_of() {
        return end_time_of;
    }

    public void setEnd_time_of(String end_time_of) {
        this.end_time_of = end_time_of;
    }

    public String getDescription_of() {
        return description_of;
    }

    public void setDescription_of(String description_of) {
        this.description_of = description_of;
    }

    
}
