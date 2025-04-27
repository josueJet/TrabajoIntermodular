<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.daw_trabajo_josuetito.models.Trabajador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Integer idTrabajador = (Integer) session.getAttribute("idTrabajador");
    if (idTrabajador == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<html>
<head>
    <title>LISTA DE TRABAJADORES</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Styles/maincopy.css" rel="stylesheet">
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
            <li><a href="listaFichajes"><i class="fa fa-hourglass"></i> Fichar</a></li>
            <li class="active"><a href="obtenerLista"><i class="fas fa-user-tie"></i> Trabajadores</a></li>
            <li><a href="logout"><i class="fas fa-sign-out-alt"></i> Cerrar Sesión</a></li>
        </ul>
    </nav>


    <main class="main-content">
        <header class="content-header">
            <h1><i class="fas fa-user-tie"></i> Lista de Trabajadores</h1>
            <a href="añadirTrabajador.jsp" class="add-button">
                <i class="fas fa-plus"></i> Nuevo
            </a>
        </header>

        <div class="trabajadores-container">

            <%
                ArrayList<Trabajador> lista = (ArrayList<Trabajador>) request.getAttribute("trabajadores");
                if (lista != null && !lista.isEmpty()) {
                    for (Trabajador t : lista) {
            %>
            <div class="trabajador-card">
                <div class="card-header">
                    <h2><%= t.getNombre() %> <%= t.getPrimerApellido() %></h2>
                    <span class="badge sexo-<%= t.getSexo().toLowerCase() %>"><%= t.getSexo() %></span>
                </div>

                <div class="card-body">
                    <div class="info-group">
                        <span class="label">Edad:</span>
                        <span class="value"><%= t.getEdad() %> años</span>
                    </div>

                    <div class="info-group">
                        <span class="label">Ubicación:</span>
                        <span class="value"><%= t.getCiudad() %>, <%= t.getDireccion() %></span>
                    </div>

                    <div class="info-group">
                        <span class="label">Contacto:</span>
                        <span class="value"><%= t.getTelefono() %><br><%= t.getCorreo() %></span>
                    </div>
                </div>

                <div class="card-actions">
                    <a href="editarTrabajador?id=<%= t.getId()%>" class="action-btn edit-btn">Editar</a>
                    <a href="borrarTrabajador?id=<%= t.getId()%>" class="action-btn delete-btn">Borrar</a>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <div class="empty-state">
                <p>No hay trabajadores registrados</p>
                <a href=añadirTrabajador.jsp" class="add-button">
                    <i class="fas fa-plus"></i> Agregar primero
                </a>
            </div>
            <%
                }
            %>
        </div>
    </main>
</div>

<script>

    document.querySelector('.mobile-menu-toggle').addEventListener('click', function() {
        document.querySelector('.nav-links').classList.toggle('show');
    });

</script>
</body>
</html>