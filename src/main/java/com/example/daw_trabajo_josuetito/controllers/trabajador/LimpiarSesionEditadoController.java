package com.example.daw_trabajo_josuetito.controllers.trabajador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "limpiarSesionEditado", urlPatterns = {"/limpiarSesionEditado"})
public class LimpiarSesionEditadoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().removeAttribute("trabajadorEditado");
        request.getSession().removeAttribute("errorEdicion");
        response.setStatus(HttpServletResponse.SC_OK);
    }
}