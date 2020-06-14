package com.sandipbhattacharya.flappybird;

import java.io.Serializable;

public class MiCuenta implements Serializable {

    private int id;
    private String NombreMedalla;
    private int Puntos;
    private int RecordPersonal;
    private int NumeroMedallas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreMedalla() {
        return NombreMedalla;
    }

    public void setNombreMedalla(String nombreMedalla) {
        NombreMedalla = nombreMedalla;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public int getRecordPersonal() {
        return RecordPersonal;
    }

    public void setRecordPersonal(int recordPersonal) {
        RecordPersonal = recordPersonal;
    }

    public int getNumeroMedallas() {
        return NumeroMedallas;
    }

    public void setNumeroMedallas(int numeroMedallas) {
        NumeroMedallas = numeroMedallas;
    }
}
