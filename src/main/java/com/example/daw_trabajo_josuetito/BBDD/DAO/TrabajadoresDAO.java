package com.example.daw_trabajo_josuetito.BBDD.DAO;

import com.example.daw_trabajo_josuetito.BBDD.BBDDConnector;
import com.example.daw_trabajo_josuetito.models.Trabajador;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import static com.example.daw_trabajo_josuetito.BBDD.BBDDConnector.GetInstance;


public class TrabajadoresDAO {

    public static ArrayList<Trabajador> GetAll() throws SQLException {
            ArrayList<Trabajador> aux = new ArrayList<>();

            String query = "SELECT * FROM trabajadores";

            Connection conn = GetInstance().GetConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Trabajador trab = new Trabajador();
                trab.setId(rs.getInt("idTrabajador"));
                trab.setNombre(rs.getString("Nombre"));
                trab.setPrimerApellido(rs.getString("PrimerApellido"));
                trab.setSegundoApellido(rs.getString("SegundoApellido"));
                trab.setSexo(rs.getString("Sexo"));
                trab.setEdad(rs.getInt("Edad"));
//                trab.setFechaNacimiento(rs.getObject("FechaNacimiento", LocalDate.class));
                trab.setCiudad(rs.getString("Ciudad"));
                trab.setDireccion(rs.getString("Direccion"));
                trab.setCodigoPostal(rs.getString("CodigoPostal"));
                trab.setCorreo(rs.getString("Correo"));
                trab.setTelefono(rs.getString("Telefono"));

                aux.add(trab);
            }

            return aux;
        }

        public static boolean DeleteTrabajador(int id) throws SQLException {
            String query = "DELETE FROM trabajadores WHERE idTrabajador = ?";

            Connection conn = GetInstance().GetConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            return rows > 0;
        }

        public static boolean AddTrabajador(Trabajador trabajador) throws SQLException {
            String query = "INSERT INTO trabajadores (Nombre, PrimerApellido, SegundoApellido, Sexo, Edad, Ciudad, Direccion, CodigoPostal, Correo, Telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            Connection conn = GetInstance().GetConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getPrimerApellido());
            ps.setString(3, trabajador.getSegundoApellido());
            ps.setString(4, trabajador.getSexo());
            ps.setInt(5, trabajador.getEdad());
//            LocalDate fechaNacimiento = trabajador.getFechaNacimiento();
//            ps.setDate(5, java.sql.Date.valueOf(fechaNacimiento));
            ps.setString(6, trabajador.getCiudad());
            ps.setString(7, trabajador.getDireccion());
            ps.setString(8, trabajador.getCodigoPostal());
            ps.setString(9, trabajador.getCorreo());
            ps.setString(10, trabajador.getTelefono());

            int rows = ps.executeUpdate();

            return rows > 0;
        }


        public static boolean UpdateTrabajador(Trabajador trabajador) throws SQLException {
            String query = "UPDATE trabajadores SET Nombre = ?, PrimerApellido = ?, SegundoApellido = ?, Sexo = ?, Edad = ?, Ciudad = ?, Direccion = ?, CodigoPostal = ?, Correo = ?, Telefono = ? WHERE idTrabajador = ?";

            Connection conn = GetInstance().GetConnection();
            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1, trabajador.getNombre());
            ps.setString(2, trabajador.getPrimerApellido());
            ps.setString(3, trabajador.getSegundoApellido());
            ps.setString(4, trabajador.getSexo());
            ps.setInt(5, trabajador.getEdad());
//            LocalDate fechaNacimiento = trabajador.getFechaNacimiento();
//            ps.setDate(5, java.sql.Date.valueOf(fechaNacimiento));
            ps.setString(6, trabajador.getCiudad());
            ps.setString(7, trabajador.getDireccion());
            ps.setString(8, trabajador.getCodigoPostal());
            ps.setString(9, trabajador.getCorreo());
            ps.setString(10, trabajador.getTelefono());

            ps.setInt(11, trabajador.getId());

            int rows = ps.executeUpdate();

            return rows > 0;
        }

    public static Trabajador autenticar(String user, String password) throws SQLException {
        String query = "SELECT * FROM trabajadores WHERE nombre = ? AND contraseña = ?";

        try (Connection conn = GetInstance().GetConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, user);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Trabajador trab = new Trabajador();
                trab.setId(rs.getInt("idTrabajador"));
                // ... (setear otros campos)
                return trab;
            }
            return null;
        }
    }




}
