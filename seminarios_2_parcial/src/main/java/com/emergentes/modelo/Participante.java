
package com.emergentes.modelo;

public class Participante {
    private int id;
    private String apellidos;
    private String nombres;
    private int id_seminario;
    private int confirmado;
    private String seminario;

    public Participante(int id, String apellidos, String nombres, int id_seminario, int confirmado, String seminario) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.id_seminario = id_seminario;
        this.confirmado = confirmado;
        this.seminario = seminario;
    }

    public Participante() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    
    
}
