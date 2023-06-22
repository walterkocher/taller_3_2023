package com.example.tiendaweb.model;

import com.example.tiendaweb.model.data.dao.ClienteDAO;
import com.example.tiendaweb.model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;

public class Vendedor {
    String rut;
    String nombre;

    String direccion;
    String titulo;
    String estCivil;

    public Vendedor(String rut, String nombre, String direccion, String titulo, String estCivil) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion=direccion;
        this.titulo=titulo;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean registrarCliente(){
        Connection connection= DBConnector.connection("tienda","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return new ClienteDAO().registrarCliente(query,this);
    }
}
