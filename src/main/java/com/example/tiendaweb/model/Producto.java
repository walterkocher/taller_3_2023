package com.example.tiendaweb.model;

import com.example.tiendaweb.model.data.DBConnector;
import com.example.tiendaweb.model.data.dao.ProductoDAO;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.ArrayList;

public class Producto {
    private String tipoConstruccion;
    private String ubicacion;
    private int precio;

    public Producto(String tipoConstruccion, String ubicacion, int precio) {
        this.tipoConstruccion=tipoConstruccion;
        this.ubicacion = ubicacion;
        this.precio=precio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean registrarProducto(){
        Connection connection= DBConnector.connection("tienda","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return new ProductoDAO().registrarProducto(query,this);
    }
    public ArrayList<Producto> buscarProducto(){
        Connection connection= DBConnector.connection("tienda","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return new ProductoDAO().buscarProducto(query,this);
    }
    public boolean modificarProducto(){
        Connection connection= DBConnector.connection("tienda","root","");
        DSLContext query= DSL.using(connection);
        System.out.println("a");
        return new ProductoDAO().modificarProducto(query,this);
    }
}
