package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import com.example.daw_trabajo_josuetito.models.Fichaje;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "editarFichaje", urlPatterns = {"/editarFichaje"})
public class EditarFichajeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFichajeStr = request.getParameter("idFichaje");
        int idFichaje = Integer.parseInt(idFichajeStr);
        Fichaje fichaje = FichajeDAO.getFichajeById(idFichaje);
        request.setAttribute("fichaje", fichaje);

        RequestDispatcher dispatcher = request.getRequestDispatcher("fichaje.jsp");
        dispatcher.forward(request, response);

//        try {
//            Fichaje fichaje = FichajeDAO.getFichajeById(idFichaje);
//            request.setAttribute("fichaje", fichaje);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("editarFichaje.jsp");
//            dispatcher.forward(request, response);
//
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
    }
}