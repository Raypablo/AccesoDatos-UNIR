package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Producto implements Serializable {

    private static final long serialVersionUID = 12345L; //Este numero me lo invento, el que me interese
    private int id;
    private String title;
    private double price;
    private int stock;

    public void mostrarDatos(){

        System.out.println("serialVersionUID = " + serialVersionUID);
        System.out.println("id = " + id);
        System.out.println("title = " + title);
        System.out.println("price = " + price);
        System.out.println("stock = " + stock);

    }

}
