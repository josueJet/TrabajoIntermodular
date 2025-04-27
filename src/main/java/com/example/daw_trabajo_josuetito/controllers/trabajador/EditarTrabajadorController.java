package com.example.daw_trabajo_josuetito.controllers.trabajador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "editarTrabajador", urlPatterns = {"/editarTrabajador"})
public class EditarTrabajadorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);

        request.setAttribute("id", idNumber);

        RequestDispatcher dispatcher = request.getRequestDispatcher("editarTrabajador.jsp");
        dispatcher.forward(request, response);
    }
}
