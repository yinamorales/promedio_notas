package com.example.promedio_notas;

public class Usuario {

    private int CODIGO;
    private String NOMBRE, NOTA, APROBAR;

    public Usuario() {
    }

    public int getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(int CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getNOTA() {
        return NOTA;
    }

    public void setNOTA(String NOTA) {
        this.NOTA = NOTA;
    }

    public String getAPROBAR() {
        return APROBAR;
    }

    public void setAPROBAR(String APROBAR) {
        this.APROBAR = APROBAR;
    }
}