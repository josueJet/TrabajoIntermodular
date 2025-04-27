<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDITAR TRABAJADOR</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Styles/maincopy.css" rel="stylesheet">
    <link href="Styles/menu.css" rel="stylesheet">
    <link href="Styles/edit.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="app-container">

    <!-- Contenido principal -->
    <main class="main-content">
        <div class="edit-container">
            <div class="edit-header">
                <h1><i class="fas fa-user-edit"></i> Editar Trabajador</h1>
                <a href="obtenerLista" class="cancel-btn">
                    <i class="fas fa-times"></i> Cancelar
                </a>
            </div>

            <form action="updateTrabajador" method="post" class="edit-form">
                <input type="hidden" name="id" value="<%=request.getAttribute("id")%>">

                <div class="form-group">
                    <label for="nombre">NOMBRE:</label>
                    <input type="text" id="nombre" name="nombre" placeholder="Nuevo nombre">
                </div>

                <div class="form-group">
                    <label for="primerApellido">PRIMER APELLIDO:</label>
                    <input type="text" id="primerApellido" name="primerApellido" placeholder="Nuevo primer apellido">
                </div>

                <div class="form-group">
                    <label for="segundoApellido">SEGUNDO APELLIDO:</label>
                    <input type="text" id="segundoApellido" name="segundoApellido" placeholder="Nuevo segundo apellido">
                </div>

                <div class="form-group">
                    <label for="sexo">SEXO:</label>
                    <input type="text" id="sexo" name="sexo" placeholder="Nuevo sexo (M/F/O)">
                </div>

                <div class="form-group">
                    <label for="edad">EDAD:</label>
                    <input type="number" id="edad" name="edad" placeholder="Nueva edad">
                </div>

                <div class="form-group">
                    <label for="ciudad">CIUDAD:</label>
                    <input type="text" id="ciudad" name="ciudad" placeholder="Nueva ciudad">
                </div>

                <div class="form-group">
                    <label for="direccion">DIRECCIÓN:</label>
                    <input type="text" id="direccion" name="direccion" placeholder="Nueva dirección">
                </div>

                <div class="form-group">
                    <label for="codigoPostal">CÓDIGO POSTAL:</label>
                    <input type="text" id="codigoPostal" name="codigoPostal" placeholder="Nuevo código postal">
                </div>

                <div class="form-group">
                    <label for="correo">CORREO:</label>
                    <input type="email" id="correo" name="correo" placeholder="Nuevo correo">
                </div>

                <div class="form-group">
                    <label for="telefono">TELÉFONO:</label>
                    <input type="tel" id="telefono" name="telefono" placeholder="Nuevo teléfono">
                </div>

                <div class="form-actions">
                    <button type="submit" class="submit-btn">
                        <i class="fas fa-save"></i> GUARDAR CAMBIOS
                    </button>
                </div>
            </form>
        </div>
    </main>

    <div id="confirmationPopup" class="popup" style="display: none;">
        <div class="popup-content">
            <p>Información del trabajador editada correctamente</p>
            <button id="closePopup">Aceptar</button>
        </div>
    </div>

</div>



<script>
    document.querySelector('.mobile-menu-toggle')?.addEventListener('click', function() {
        document.querySelector('.nav-links')?.classList.toggle('show');
    });

</script>
</body>
</html>