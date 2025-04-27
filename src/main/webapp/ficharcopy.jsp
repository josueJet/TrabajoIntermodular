<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <span>Gestor Trabajadores</span>
        </div>
        <button class="mobile-menu-toggle" aria-label="Toggle menu">
            <i class="fas fa-bars"></i>
        </button>
        <ul class="nav-links">
            <li><a href="index.jsp"><i class="fas fa-home"></i> Inicio</a></li>
            <li class="active"><a href="ficharcopy.jsp"><i class="fa fa-hourglass"></i> Fichar</a></li>
            <li><a href="tareas.jsp"><i class="fas fa-tasks"></i> Tareas</a></li>
            <li><a href="obtenerLista"><i class="fas fa-user-tie"></i> Trabajadores</a></li>
        </ul>
    </nav>

    <main class="fichaje-container">
        <div class="fichaje-header">
            <h1><i class="fa fa-hourglass"></i> Sistema de Fichaje</h1>
            <div class="fecha-actual" id="fecha"></div>
        </div>

        <div class="fichaje-buttons">
            <form action="/RegistrarFichaje" method="post">
                <input type="hidden" name="tipo" value="inicio">
                <button type="submit" class="fichaje-btn iniciar-btn">
                    <i class="fas fa-play-circle"></i> INICIAR
                </button>
            </form>

            <form action="/RegistrarFichaje" method="post">
                <input type="hidden" name="tipo" value="fin">
                <button type="submit" class="fichaje-btn detener-btn">
                    <i class="fas fa-stop-circle"></i> DETENER
                </button>
            </form>
        </div>

        <div class="fichaje-historial">
            <h3><i class="fas fa-history"></i> Historial Reciente</h3>
            <div class="historial-item">
                <span class="historial-fecha">20/04/2024 08:15:00</span>
                <span class="historial-tipo iniciado">Jornada iniciada</span>
            </div>
            <div class="historial-item">
                <span class="historial-fecha">19/04/2024 18:30:45</span>
                <span class="historial-tipo finalizado">Jornada finalizada</span>
            </div>
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