package com.example.tiendaweb.controller;

import com.example.tiendaweb.model.Vendedor;
import com.example.tiendaweb.utils.ValidarRut;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistroClienteServlet",value = "/registroCliente")
public class RegistroVendedorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rut= ValidarRut.eliminarCaracteresRut(request.getParameter("rut"));
        boolean rutValido= ValidarRut.validarRut(rut);
        String nombre=request.getParameter("nombre");
        String direccion=request.getParameter("direccion");
        String titulo=request.getParameter("titulo");
        String estCivil=request.getParameter("estado civil");
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("/crearCliente.jsp");
        if(!nombre.isEmpty() && rutValido){
            Vendedor vendedor =new Vendedor(rut,nombre,direccion,titulo, estCivil);
            if(vendedor.registrarCliente()){
                request.setAttribute("status","Se ha registrado correctamente");
            }else{
                request.setAttribute("status","El rut ya ha sido registrado");
            }
        }else{
            request.setAttribute("status","Corrobore los datos ingresados");
        }
        requestDispatcher.forward(request,response);
    }
}
