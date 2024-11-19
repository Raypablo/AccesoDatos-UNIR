package model;

import lombok.Getter;

@Getter
public enum Tipo {

    EXTERNO(1, "EXT", "Trabajador externo"),
    INDEFINIDO(2, "IND", "Trabajador indefinido"),
    BECARIO(3, "BEC", "Trabajador becario");


    private int id;
    private String siglas, descripcion;

    Tipo(int id, String siglas, String descripcion) {

        this.id = id;
        this.siglas = siglas;
        this.descripcion = descripcion;

    }

}
