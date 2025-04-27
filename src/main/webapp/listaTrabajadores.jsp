<%@ page import="java.util.ArrayList" %>

<%@ page import="com.example.daw_trabajo_josuetito.models.Trabajador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LISTA</title>
    <link href="Styles/main.css" rel="stylesheet">
</head>
<body>
<a href="añadirTrabajador.jsp" class="add">+</a>
    <div class="container">
        <%
            ArrayList<Trabajador> lista = (ArrayList<Trabajador>) request.getAttribute("trabajadores");

            if (lista!=null){
                for (int i = 0; i < lista.size(); i++) {
        %>
            <div>
                <p>NOMBRE: <%= lista.get(i).getNombre() %></p>
                <p>PRIMER APELLLIDO: <%= lista.get(i).getPrimerApellido() %></p>
                <p>SEGUNDO APELLLIDO: <%= lista.get(i).getSegundoApellido() %></p>
                <p>SEXO: <%= lista.get(i).getSexo() %></p>
                <p>EDAD: <%= lista.get(i).getEdad() %></p>

<%--                <p>FECHA DE NACIMIENTO: <%= lista.get(i).getFechaNacimiento() %></p>--%>
                <p>CIUDAD: <%= lista.get(i).getCiudad() %></p>
                <p>DIRECCIÓN: <%= lista.get(i).getDireccion() %></p>
                <p>CÓDIGO POSTAL: <%= lista.get(i).getCodigoPostal() %></p>
                <p>CORREO: <%= lista.get(i).getCorreo() %></p>
                <p>TELÉFONO: <%= lista.get(i).getTelefono() %></p>
                <a href="borrarTrabajador?id=<%= lista.get(i).getId()%>">
                    <button>BORRAR</button>
                </a>
                <a href="editarTrabajador?id=<%= lista.get(i).getId()%>">
                    <button>EDITAR</button>
                </a>
            </div>
        <%
                }
            }
        %>
    </div>
</body>
</html>
