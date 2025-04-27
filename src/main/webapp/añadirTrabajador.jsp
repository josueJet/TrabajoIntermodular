<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AÑADIR TRABAJADOR</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="Styles/maincopy.css" rel="stylesheet">
    <link href="Styles/add.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="app-container">

    <main class="main-content">
        <div class="add-container">
            <div class="add-header">
                <h1><i class="fas fa-user-plus"></i> Añadir Nuevo Trabajador</h1>
                <a href="obtenerLista" class="cancel-btn">
                    <i class="fas fa-times"></i> Cancelar
                </a>
            </div>

            <form action="addTrabajador" method="post" class="add-form">
                <div class="form-group">
                    <label for="nombre">NOMBRE:</label>
                    <input type="text" id="nombre" name="nombre" placeholder="Nombre" required>
                </div>

                <div class="form-group">
                    <label for="primerApellido">PRIMER APELLIDO:</label>
                    <input type="text" id="primerApellido" name="primerApellido" placeholder="Primer apellido" required>
                </div>

                <div class="form-group">
                    <label for="segundoApellido">SEGUNDO APELLIDO:</label>
                    <input type="text" id="segundoApellido" name="segundoApellido" placeholder="Segundo apellido">
                </div>

                <div class="form-group">
                    <label for="sexo">SEXO (M/F/O):</label>
                    <input type="text" id="sexo" name="sexo" placeholder="M, F u O" required>
                </div>

                <div class="form-group">
                    <label for="edad">EDAD:</label>
                    <input type="number" id="edad" name="edad" placeholder="Edad" required min="16" max="99">
                </div>

                <div class="form-group">
                    <label for="ciudad">CIUDAD:</label>
                    <input type="text" id="ciudad" name="ciudad" placeholder="Ciudad" required>
                </div>

                <div class="form-group">
                    <label for="direccion">DIRECCIÓN:</label>
                    <input type="text" id="direccion" name="direccion" placeholder="Dirección" required>
                </div>

                <div class="form-group">
                    <label for="codigoPostal">CÓDIGO POSTAL:</label>
                    <input type="text" id="codigoPostal" name="codigoPostal" placeholder="Código postal" required>
                </div>

                <div class="form-group">
                    <label for="correo">CORREO:</label>
                    <input type="email" id="correo" name="correo" placeholder="Correo electrónico" required>
                </div>

                <div class="form-group">
                    <label for="telefono">TELÉFONO:</label>
                    <input type="tel" id="telefono" name="telefono" placeholder="Teléfono" required>
                </div>

                <div class="form-actions">
                    <button type="submit" class="submit-btn">
                        <i class="fas fa-save"></i> AÑADIR TRABAJADOR
                    </button>
                </div>
            </form>
        </div>
    </main>
</div>

</body>
</html>