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
public class Postulaciones {
    private int id_postulaciones;
    private int id_persona;
    private int id_of;

    public Postulaciones(int id_postulaciones, int id_persona, int id_of) {
        this.id_postulaciones = id_postulaciones;
        this.id_persona = id_persona;
        this.id_of = id_of;
    }

    public Postulaciones(int id_persona, int id_of) {
        this.id_persona = id_persona;
        this.id_of = id_of;
    }

    public int getId_postulaciones() {
        return id_postulaciones;
    }

    public void setId_postulaciones(int id_postulaciones) {
        this.id_postulaciones = id_postulaciones;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_of() {
        return id_of;
    }

    public void setId_of(int id_of) {
        this.id_of = id_of;
    }
    
    
    
}
