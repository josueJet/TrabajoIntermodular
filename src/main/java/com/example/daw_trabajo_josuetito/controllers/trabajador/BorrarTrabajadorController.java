package com.example.daw_trabajo_josuetito.controllers.trabajador;

import com.example.daw_trabajo_josuetito.BBDD.DAO.TrabajadoresDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "borrarTrabajador", urlPatterns = {"/borrarTrabajador"})
public class BorrarTrabajadorController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int idNumber = Integer.parseInt(id);

        try {
            TrabajadoresDAO.DeleteTrabajador(idNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        response.sendRedirect(request.getContextPath() + "/obtenerLista");

    }
}