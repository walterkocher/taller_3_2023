package com.example.tiendaweb.controller;

import com.example.tiendaweb.model.Producto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EditarProductoServlet", value = "/editarProducto")
public class EditarProductoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tipoConstruccion = request.getParameter("tipo");
        String ubicacion=request.getParameter("ubicacion");
        String precio=request.getParameter("p");
        request.setAttribute("tipo", tipoConstruccion);
        request.setAttribute("ubicacion", ubicacion);
        request.setAttribute("precio",precio);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("editarProducto.jsp");
        requestDispatcher.forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("buscarProducto.jsp");
        int idProducto= Integer.parseInt(
                !request.getParameter("id").isEmpty()?request.getParameter("id"):"0"
        );
        String tipoConstruccion= request.getParameter("tipoProducto");
        String ubicacion=request.getParameter("nombre");
        int precio= Integer.parseInt(
                !request.getParameter("precio").isEmpty()?request.getParameter("precio"):"0"
        );
        if(tipoConstruccion.isEmpty() && !ubicacion.isEmpty() && precio!=0){
            Producto producto=new Producto(tipoConstruccion,ubicacion,precio);
            if(producto.modificarProducto()){
                request.setAttribute("status","Fue modificado correctamente el producto");
            }else{
                request.setAttribute("status","Ocurrio un error al intentar modificar");
            }
        }else {
            request.setAttribute("status","Rellene correctamente todos los campos");
        }
        requestDispatcher.forward(request,response);
    }
}