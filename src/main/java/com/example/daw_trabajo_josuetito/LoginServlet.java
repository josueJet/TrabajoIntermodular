package com.example.daw_trabajo_josuetito;

import com.example.daw_trabajo_josuetito.BBDD.BBDDConnector;
import com.example.daw_trabajo_josuetito.models.Trabajador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        BBDDConnector connector = BBDDConnector.GetInstance();
        String user = request.getParameter("user");
        String pass = request.getParameter("password");

        try {

            String sql = "SELECT u.IdTrabajador, t.* FROM usuarios u " + "JOIN trabajadores t ON u.IdTrabajador = t.IdTrabajador " + "WHERE u.nombre = ? AND u.contraseña = ?";

            PreparedStatement ps = connector.GetConnection().prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                HttpSession oldSession = request.getSession(false);
                if (oldSession != null) {
                    oldSession.invalidate();
                }

                HttpSession newSession = request.getSession(true);

                int idTrabajador = rs.getInt("IdTrabajador");
                newSession.setAttribute("idTrabajador", idTrabajador);

                Trabajador trabajador = new Trabajador();
                trabajador.setId(idTrabajador);
                trabajador.setNombre(rs.getString("nombre"));

                newSession.setAttribute("trabajador", trabajador);

                response.sendRedirect(request.getContextPath() + "/listaFichajes");

            } else {
                request.setAttribute("error", "Usuario o contraseña incorrectos");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

        } catch (SQLException e) {
            throw new ServletException("Error de base de datos", e);
        }
    }
}