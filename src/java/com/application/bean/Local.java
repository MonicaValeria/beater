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
public class Local {
    private int id_local;
    private int id_person;
    private String name_local;
    private String address;
    private String reference;
    private String telefono;
    private String dias;
    private String horario_inicio; 
    private String horario_fin;

    public Local() {
    }

    public Local(int id_local, int id_person, String name_local, String address, String reference, String telefono, String dias, String horario_inicio, String horario_fin) {
        this.id_local = id_local;
        this.id_person = id_person;
        this.name_local = name_local;
        this.address = address;
        this.reference = reference;
        this.telefono = telefono;
        this.dias = dias;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public Local(int id_person, String name_local, String address, String reference, String telefono, String dias, String horario_inicio, String horario_fin) {
        this.id_person = id_person;
        this.name_local = name_local;
        this.address = address;
        this.reference = reference;
        this.telefono = telefono;
        this.dias = dias;
        this.horario_inicio = horario_inicio;
        this.horario_fin = horario_fin;
    }

    public int getId_local() {
        return id_local;
    }

    public void setId_local(int id_local) {
        this.id_local = id_local;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public String getName_local() {
        return name_local;
    }

    public void setName_local(String name_local) {
        this.name_local = name_local;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHorario_inicio() {
        return horario_inicio;
    }

    public void setHorario_inicio(String horario_inicio) {
        this.horario_inicio = horario_inicio;
    }

    public String getHorario_fin() {
        return horario_fin;
    }

    public void setHorario_fin(String horario_fin) {
        this.horario_fin = horario_fin;
    }

    
    
}
