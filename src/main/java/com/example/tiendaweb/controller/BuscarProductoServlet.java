package com.example.tiendaweb.controller;

import com.example.tiendaweb.model.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "BuscarProductoServlet",value ="/buscarProducto")
public class BuscarProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/buscarProducto.jsp");
        String ubicacion=request.getParameter("ubicacion");
        String tipoConstruccion=request.getParameter("tipoConstruccion");
        if(!ubicacion.isEmpty() || !tipoConstruccion.isEmpty()){
            Producto producto=new Producto(tipoConstruccion,ubicacion,0);
            ArrayList<Producto>productos=producto.buscarProducto();
            if(productos.size() != 0){
                System.out.println("");
                request.setAttribute("productos",productos);
            }
        }
        requestDispatcher.forward(request,response);
    }
}
