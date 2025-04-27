package com.example.daw_trabajo_josuetito.controllers.trabajador;


import com.example.daw_trabajo_josuetito.BBDD.DAO.TrabajadoresDAO;
import com.example.daw_trabajo_josuetito.models.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "updateTrabajador", urlPatterns = {"/updateTrabajador"})
public class UpdateTrabajadorController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idStr = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String primerApellido = request.getParameter("primerApellido");
        String segundoApellido = request.getParameter("segundoApellido");
        String sexo = request.getParameter("sexo");
        String edadStr = request.getParameter("edad");
        //String fechaNacimientoStr = req.getParameter("fechaNacimiento");
        String ciudad = request.getParameter("ciudad");
        String direccion = request.getParameter("direccion");
        String codigoPostal = request.getParameter("codigoPostal");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        int id = Integer.parseInt(idStr);
        int edad = Integer.parseInt(edadStr);
        //LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr);

        Trabajador trab = new Trabajador(id, nombre, primerApellido, segundoApellido, sexo, edad, ciudad, direccion, codigoPostal, correo, telefono);

        try {
            TrabajadoresDAO.UpdateTrabajador(trab);

        } catch (SQLException e) {
            System.out.println(e);

        }

        response.sendRedirect(request.getContextPath() + "/obtenerLista");
    }
}
