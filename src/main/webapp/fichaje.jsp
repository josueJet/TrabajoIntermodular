<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.daw_trabajo_josuetito.models.Fichaje" %>
<%@ page import="java.util.List" %>
<%
    Integer idTrabajador = (Integer) session.getAttribute("idTrabajador");
    if (idTrabajador == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<html>
<head>
    <title>Sistema de Fichaje</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Styles/fichajecopy.css" rel="stylesheet">
    <link href="Styles/menu.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="app-container">
    <nav class="main-nav">
        <div class="nav-brand">
            <i class="fas fa-users"></i>
            <span>Sistema de trabajadores</span>
        </div>
        <button class="mobile-menu-toggle" aria-label="Toggle menu">
            <i class="fas fa-bars"></i>
        </button>
        <ul class="nav-links">
            <li class="active"><a href="listaFichajes"><i class="fa fa-hourglass"></i> Fichar</a></li>
            <li><a href="obtenerLista"><i class="fas fa-user-tie"></i> Trabajadores</a></li>
            <li><a href="logout"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a></li>
        </ul>
    </nav>

    <main class="fichaje-container">
        <div class="fichaje-header">
            <h1><i class="fa fa-hourglass"></i> Sistema de Fichaje</h1>
            <div class="fecha-actual" id="fecha"></div>
        </div>

        <div class="ultimo-fichaje">
            <h4>Estado actual</h4>
            <%
                Fichaje ultimoFichaje = (Fichaje) request.getAttribute("ultimoFichaje");
                if (ultimoFichaje != null && ultimoFichaje.getHoraSalida() == null) {
            %>
            <p class="estado-actual en-trabajo">
                <i class="fas fa-check-circle"></i> Actualmente trabajando (desde <%= ultimoFichaje.getHoraEntrada() %>)
            </p>
            <% } else { %>
            <p class="estado-actual no-trabajando">
                <i class="fas fa-times-circle"></i> No está trabajando actualmente
            </p>
            <% } %>
        </div>

        <div class="fichaje-buttons">
            <form action="registrarEntrada" method="post" class="form-fichaje">
                <button type="submit"
                        class="btn-fichaje btn-iniciar"
                        <%= (ultimoFichaje != null && ultimoFichaje.getHoraSalida() == null) ? "disabled" : "" %>>
                    <i class="fas fa-play-circle icono-btn"></i>
                    <span class="texto-btn">INICIAR JORNADA</span>
                </button>
            </form>

            <form action="registrarSalida" method="post" class="form-fichaje">
                <input type="hidden" name="idTrabajador" value="<%= idTrabajador %>">
                <button type="submit"
                        class="btn-fichaje btn-finalizar"
                        <%= (ultimoFichaje == null || ultimoFichaje.getHoraSalida() != null) ? "disabled" : "" %>>
                    <i class="fas fa-stop-circle icono-btn"></i>
                    <span class="texto-btn">FINALIZAR JORNADA</span>
                </button>
            </form>
        </div>

        <div class="fichaje-historial">
            <h3><i class="fas fa-history"></i> Historial Reciente</h3>
            <%
                List<Fichaje> fichajes = (List<Fichaje>) request.getAttribute("fichajes");
                if (fichajes != null && !fichajes.isEmpty()) {
                    for (Fichaje fichaje : fichajes) {
            %>
            <div class="historial-item">
                <span class="historial-fecha">
                    <%= fichaje.getFecha() %>
                    <%= fichaje.getHoraEntrada() %>
                    <% if (fichaje.getHoraSalida() != null) { %>
                        - <%= fichaje.getHoraSalida() %>
                    <% } %>
                </span>
                <span class="historial-tipo <%= fichaje.getHoraSalida() == null ? "iniciado" : "finalizado" %>">
                    <% if (fichaje.getHoraSalida() == null) { %>
                        Jornada iniciada
                    <% } else { %>
                        Jornada finalizada (<%= String.format("%.2f", fichaje.getHorasTrabajadas()) %> horas)
                    <% } %>
                </span>
            </div>
            <%
                }
            } else {
            %>
            <p>No hay registros de fichaje disponibles.</p>
            <%
                }
            %>
        </div>
    </main>
</div>

<script>
    function actualizarFecha() {
        const opciones = {
            weekday: 'long',
            year: 'numeric',
            month: 'long',
            day: 'numeric',
            hour: '2-digit',
            minute: '2-digit',
            second: '2-digit'
        };
        document.getElementById('fecha').textContent = new Date().toLocaleDateString('es-ES', opciones);
    }

    setInterval(actualizarFecha, 1000);
    actualizarFecha();

    document.querySelector('.mobile-menu-toggle')?.addEventListener('click', function() {
        document.querySelector('.nav-links').classList.toggle('show');
    });
</script>
</body>
</html>