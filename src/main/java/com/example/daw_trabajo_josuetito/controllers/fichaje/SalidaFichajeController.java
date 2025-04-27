package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "registrarSalida", urlPatterns = {"/registrarSalida"})
public class SalidaFichajeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idTrabajadorStr = request.getParameter("idTrabajador");
        int idTrabajador = Integer.parseInt(idTrabajadorStr);

        try {
            FichajeDAO.registrarSalida(idTrabajador);
        } catch (SQLException e) {
            System.out.println(e);
        }

//        response.sendRedirect(request.getContextPath() + "/listaFichajes?idTrabajador=" + idTrabajador);
//        response.sendRedirect(request.getContextPath() + "/fichaje.jsp");
        response.sendRedirect(request.getContextPath() + "/listaFichajes");
    }
}