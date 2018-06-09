/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.application.bean;

import java.sql.Date;

/**
 *
 * @author Monica
 */
public class Event {
    private int id_ev;
    private int id_person;
    private String name_ev;
    private String dia_inicio;
    private String dia_fin;
    private String hora_inicio_ev;
    private String hora_fin_ev;
    private int id_local;
    private int id_gm;


    public Event() {
    }

    public Event(int id_ev, int id_person, String name_ev, String dia_inicio, String dia_fin, String hora_inicio_ev, String hora_fin_ev, int id_local, int id_gm) {
        this.id_ev = id_ev;
        this.id_person = id_person;
        this.name_ev = name_ev;
        this.dia_inicio = dia_inicio;
        this.dia_fin = dia_fin;
        this.hora_inicio_ev = hora_inicio_ev;
        this.hora_fin_ev = hora_fin_ev;
        this.id_local = id_local;
        this.id_gm = id_gm;
    }

    public Event(int id_person, String name_ev, String dia_inicio, String dia_fin, String hora_inicio_ev, String hora_fin_ev, int id_local, int id_gm) {
        this.id_person = id_person;
        this.name_ev = name_ev;
        this.dia_inicio = dia_inicio;
        this.dia_fin = dia_fin;
        this.hora_inicio_ev = hora_inicio_ev;
        this.hora_fin_ev = hora_fin_ev;
        this.id_local = id_local;
        this.id_gm = id_gm;
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

    public String getName_ev() {
        return name_ev;
    }

    public void setName_ev(String name_ev) {
        this.name_ev = name_ev;
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

    public String getHora_inicio_ev() {
        return hora_inicio_ev;
    }

    public void setHora_inicio_ev(String hora_inicio_ev) {
        this.hora_inicio_ev = hora_inicio_ev;
    }

    public String getHora_fin_ev() {
        return hora_fin_ev;
    }

    public void setHora_fin_ev(String hora_fin_ev) {
        this.hora_fin_ev = hora_fin_ev;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_gm() {
        return id_gm;
    }

    public void setId_gm(int id_gm) {
        this.id_gm = id_gm;
    }

    
   
}
