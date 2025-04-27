package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import com.example.daw_trabajo_josuetito.models.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registrarEntrada", urlPatterns = {"/registrarEntrada"})
public class EntradaFichajeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("idTrabajador") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        int idTrabajador = (Integer) session.getAttribute("idTrabajador");

        try {
            FichajeDAO.registrarEntrada(idTrabajador);
        } catch (SQLException e) {
            System.out.println(e);
        }

        response.sendRedirect(request.getContextPath() + "/listaFichajes");
//        response.sendRedirect(request.getContextPath() + "/listaFichajes?idTrabajador=" + idTrabajador);
//        response.sendRedirect(request.getContextPath() + "/fichaje.jsp");
    }
}