<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
        <title>INICIAR SESION</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Styles/login.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="login-container">
    <h1><i class="fas fa-hand wave"></i>Te hemos echado de menos</h1>
    <h2>Inicia sesión para comenzar el día</h2>
    <br/>
    <form method="post" class="login-form" action="login">
        <input type="text" placeholder="Nombre de usuario" minlength="3" name="user" required>
        <input type="password" placeholder="Contraseña" minlength="4" name="password" required>
        <input type="submit" name="Acceder" required>
    </form>
    <%-- Mostrar mensaje de error si existe --%>
    <% if (request.getAttribute("error") != null) { %>
    <div class="error-message">
        <i class="fas fa-exclamation-circle"></i> <%= request.getAttribute("error") %>
    </div>
    <% } %>
</div>
</body>
</html>


