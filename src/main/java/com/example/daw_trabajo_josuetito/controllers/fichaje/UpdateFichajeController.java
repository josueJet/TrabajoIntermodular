package com.example.daw_trabajo_josuetito.controllers.fichaje;

import com.example.daw_trabajo_josuetito.BBDD.DAO.FichajeDAO;
import com.example.daw_trabajo_josuetito.models.Fichaje;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet(name = "updateFichaje", urlPatterns = {"/updateFichaje"})
public class UpdateFichajeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFichajeStr = request.getParameter("idFichaje");
        String idTrabajadorStr = request.getParameter("idTrabajador");
        String fechaStr = request.getParameter("fecha");
        String horaEntradaStr = request.getParameter("horaEntrada");
        String horaSalidaStr = request.getParameter("horaSalida");

        int idFichaje = Integer.parseInt(idFichajeStr);
        int idTrabajador = Integer.parseInt(idTrabajadorStr);
        LocalDate fecha = LocalDate.parse(fechaStr);
        LocalTime horaEntrada = LocalTime.parse(horaEntradaStr);
        LocalTime horaSalida = horaSalidaStr != null && !horaSalidaStr.isEmpty() ?
                LocalTime.parse(horaSalidaStr) : null;

        Fichaje fichaje = new Fichaje(idFichaje, idTrabajador, fecha, horaEntrada, horaSalida, 0);

        try {
            FichajeDAO.updateFichaje(fichaje);
        } catch (SQLException e) {
            System.out.println(e);
        }

        response.sendRedirect(request.getContextPath() + "/listarFichajes?idTrabajador=" + idTrabajador);
    }
}