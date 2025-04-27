package com.example.daw_trabajo_josuetito.controllers.trabajador;

import com.example.daw_trabajo_josuetito.BBDD.DAO.TrabajadoresDAO;
import com.example.daw_trabajo_josuetito.models.Trabajador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "obtenerLista", urlPatterns = {"/obtenerLista"})
public class ListaTrabajadorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Trabajador> lista = TrabajadoresDAO.GetAll();

            request.setAttribute("trabajadores", lista);

            RequestDispatcher dispatcher = request.getRequestDispatcher("listaTrabajadoresCopy.jsp");
            dispatcher.forward(request,response);

        } catch (SQLException e) {
            System.out.println(e);

        }

    }

}
