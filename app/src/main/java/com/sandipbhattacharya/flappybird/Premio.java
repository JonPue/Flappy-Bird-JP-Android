package com.sandipbhattacharya.flappybird;

import java.io.Serializable;

public class Premio implements Serializable {

    private int id;
    private String NombreMedalla;
    private int Puntos;

    public void setId(int id) {
        this.id = id;
    }

    public void setNombreMedalla(String nombreMedalla) {
        NombreMedalla = nombreMedalla;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public String getNombreMedalla() {
        return NombreMedalla;
    }

    public int getPuntos() {
        return Puntos;
    }
}
