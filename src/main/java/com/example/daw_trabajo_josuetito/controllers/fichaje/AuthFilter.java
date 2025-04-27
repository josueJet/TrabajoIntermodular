package com.example.daw_trabajo_josuetito.controllers.fichaje;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({"/fichaje.jsp", "/registrarEntrada", "/registrarSalida"})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("idTrabajador") == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }


        if (request.getParameter("idTrabajador") != null) {
            int idParam = Integer.parseInt(request.getParameter("idTrabajador"));
            int idSesion = (Integer) session.getAttribute("idTrabajador");

            if (idParam != idSesion) {
                response.sendError(HttpServletResponse.SC_FORBIDDEN, "No tienes permiso para esta acción");
                return;
            }
        }

        chain.doFilter(req, res);
    }
}