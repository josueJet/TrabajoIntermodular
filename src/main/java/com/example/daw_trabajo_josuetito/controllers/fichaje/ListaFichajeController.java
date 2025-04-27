package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import com.example.daw_trabajo_josuetito.models.Fichaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "listaFichajes", urlPatterns = {"/listaFichajes"})
public class ListaFichajeController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("idTrabajador") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
            return;
        }

        try {
            int idTrabajador = (Integer) session.getAttribute("idTrabajador");

            List<Fichaje> fichajes = FichajeDAO.getByTrabajador(idTrabajador);
            Fichaje ultimoFichaje = FichajeDAO.getUltimoFichaje(idTrabajador);

            request.setAttribute("fichajes", fichajes);
            request.setAttribute("ultimoFichaje", ultimoFichaje);

            request.getRequestDispatcher("/fichaje.jsp").forward(request, response);

        } catch (SQLException e) {
            request.setAttribute("error", "Error al cargar fichajes");
            request.getRequestDispatcher("/fichaje.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        }
    }
}