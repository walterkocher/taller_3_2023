package com.example.tiendaweb.model.data.dao;

import com.example.tiendaweb.model.Vendedor;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;

public class ClienteDAO {
    public boolean registrarCliente(DSLContext query, Vendedor vendedor){
        String rutCliente= vendedor.getRut();
        String nombreCliente= vendedor.getNombre();
        int result=0;
        try{
            result=query.insertInto(DSL.table("usuario"),
                            DSL.field("rut"),DSL.field("nombre")).
                    values(rutCliente,nombreCliente).execute();
        }catch (Exception e){
            System.err.println("Error al ejecutar la consulta: " + e.getMessage());
        }
        return result==1;
    }
}
