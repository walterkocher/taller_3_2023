package com.example.tiendaweb.model.data.dao;

import com.example.tiendaweb.model.Producto;
import com.example.tiendaweb.model.data.DBConnector;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.util.ArrayList;


public class ProductoDAO {
    public boolean registrarProducto(DSLContext query, Producto producto) {
        String tipoConstruccion=producto.getTipoConstruccion();
        String ubicacion=producto.getUbicacion();
        int precio=producto.getPrecio();
        int result=query.insertInto(DSL.table("producto"),
                DSL.field("tipo_construccion"),DSL.field("ubicacion    "),DSL.field("precio"))
                .values(tipoConstruccion,ubicacion,precio)
                .execute();
        DBConnector.closeConnection();
        return result==1;
    }

    public ArrayList<Producto> buscarProducto(DSLContext query, Producto producto) {
        String nombreProducto=producto.getTipoConstruccion();
        Result results = query
                .select()
                .from(DSL.table("producto"))
                .where(DSL.field("producto_nombre").eq(nombreProducto)
                        .or(DSL.field("categoria").eq(nombreProducto)))
                .fetch();
        ArrayList<Producto> productosEncontrados=new ArrayList<>();
        for (int i = 0; i < results.size(); i++) {
            productosEncontrados.add(new Producto(
                    (String) results.getValue(i,"tipo_construccion"),

                    (String) results.getValue(i,"ubicacion"),

                    (Integer) results.getValue(i,"precio")
            ));
        }
        return productosEncontrados;
    }

    public boolean modificarProducto(DSLContext query, Producto producto) {
        String tipoConstruccion= producto.getTipoConstruccion();
        String nombreProducto=producto.getUbicacion();

        int precio=producto.getPrecio();
        int result=query.update(DSL.table("inmueble")).
                set(DSL.field("ubicacion"),nombreProducto).
        set(DSL.field("precio"),precio).where(DSL.field("tipo_construcion").eq(tipoConstruccion))
                .execute();
        return result==1;
    }
}
