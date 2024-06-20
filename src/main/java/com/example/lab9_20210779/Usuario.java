package com.example.lab9_20210779;

public class Usuario {
    private String nombres;
    private String apellidos;

    private String tipoLicencia;
    private String estadoLicencia;
    private String paisProcedencia;
    private int reservasCanceladas;

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getRol_idrol() {
        return rol_idrol;
    }

    public void setRol_idrol(String rol_idrol) {
        this.rol_idrol = rol_idrol;
    }

    private String telefono;
    private String rol_idrol;


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getEstadoLicencia() {
        return estadoLicencia;
    }

    public void setEstadoLicencia(String estadoLicencia) {
        this.estadoLicencia = estadoLicencia;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    public void setPaisProcedencia(String paisProcedencia) {
        this.paisProcedencia = paisProcedencia;
    }

    public int getReservasCanceladas() {
        return reservasCanceladas;
    }

    public void setReservasCanceladas(int reservasCanceladas) {
        this.reservasCanceladas = reservasCanceladas;
    }
}



