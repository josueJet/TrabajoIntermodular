package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "borrarFichaje", urlPatterns = {"/borrarFichaje"})
public class BorrarFichajeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFichajeStr = request.getParameter("idFichaje");
        String idTrabajadorStr = request.getParameter("idTrabajador");

        int idFichaje = Integer.parseInt(idFichajeStr);
        int idTrabajador = Integer.parseInt(idTrabajadorStr);

        try {
            FichajeDAO.deleteFichaje(idFichaje);
        } catch (SQLException e) {
            System.out.println(e);
        }

        response.sendRedirect(request.getContextPath() + "/listarFichajes?idTrabajador=" + idTrabajador);
    }
}