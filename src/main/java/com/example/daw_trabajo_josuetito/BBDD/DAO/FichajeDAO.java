package com.example.daw_trabajo_josuetito.BBDD.DAO;

import com.example.daw_trabajo_josuetito.BBDD.BBDDConnector;
import com.example.daw_trabajo_josuetito.models.Fichaje;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FichajeDAO {

    public static ArrayList<Fichaje> getAll() throws SQLException {
        ArrayList<Fichaje> registros = new ArrayList<>();

        String query = "SELECT * FROM fichajes";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Fichaje registro = new Fichaje();
            registro.setIdFichaje(rs.getInt("idFichaje"));
            registro.setIdTrabajador(rs.getInt("idTrabajador"));
            registro.setFecha(rs.getObject("fecha", LocalDate.class));
            registro.setHoraEntrada(rs.getObject("horaEntrada", LocalTime.class));
            registro.setHoraSalida(rs.getObject("horaSalida", LocalTime.class));
            registro.setHorasTrabajadas(rs.getFloat("horasTrabajadas"));

            registros.add(registro);
        }

        return registros;
    }

    public static ArrayList<Fichaje> getByTrabajador(int idTrabajador) throws SQLException {
        ArrayList<Fichaje> registros = new ArrayList<>();

        String query = "SELECT * FROM fichajes WHERE idTrabajador = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idTrabajador);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Fichaje registro = new Fichaje();
            registro.setIdFichaje(rs.getInt("idFichaje"));
            registro.setIdTrabajador(rs.getInt("idTrabajador"));
            registro.setFecha(rs.getObject("fecha", LocalDate.class));
            registro.setHoraEntrada(rs.getObject("horaEntrada", LocalTime.class));
            registro.setHoraSalida(rs.getObject("horaSalida", LocalTime.class));
            registro.setHorasTrabajadas(rs.getFloat("horasTrabajadas"));

            registros.add(registro);
        }

        return registros;
    }

    public static boolean deleteFichaje(int idFichaje) throws SQLException {
        String query = "DELETE FROM fichajes WHERE idFichaje = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idFichaje);

        int rows = ps.executeUpdate();

        return rows > 0;
    }

    public static boolean addFichaje(Fichaje registro) throws SQLException {
        String query = "INSERT INTO fichajes (idTrabajador, fecha, horaEntrada, horaSalida, horasTrabajadas) VALUES (?, ?, ?, ?, ?)";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, registro.getIdTrabajador());
        ps.setDate(2, Date.valueOf(registro.getFecha()));
        ps.setTime(3, Time.valueOf(registro.getHoraEntrada()));

        if (registro.getHoraSalida() != null) {
            ps.setTime(4, Time.valueOf(registro.getHoraSalida()));
        } else {
            ps.setNull(4, Types.TIME);
        }
        ps.setFloat(5, registro.getHorasTrabajadas());

        int rows = ps.executeUpdate();

        return rows > 0;
    }

    public static boolean updateFichaje(Fichaje registro) throws SQLException {
        String query = "UPDATE fichajes SET idFichaje = ?, idTrabajador = ?, fecha = ?, horaEntrada = ?, horaSalida = ?, horasTrabajadas = ? WHERE idFichaje = ?";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, registro.getIdTrabajador());
        ps.setDate(2, Date.valueOf(registro.getFecha()));
        ps.setTime(3, Time.valueOf(registro.getHoraEntrada()));

        if (registro.getHoraSalida() != null) {
            ps.setTime(4, Time.valueOf(registro.getHoraSalida()));
        } else {
            ps.setNull(4, Types.TIME);
        }
        ps.setFloat(5, registro.getHorasTrabajadas());
        ps.setInt(6, registro.getIdFichaje());

        int rows = ps.executeUpdate();

        return rows > 0;
    }

    public static boolean registrarEntrada(int idTrabajador) throws SQLException {
//        String verificacion = "SELECT idTrabajador FROM trabajadores WHERE idTrabajador = ?";
        String query = "INSERT INTO fichajes (idTrabajador, fecha, horaEntrada, horasTrabajadas) VALUES (?, CURRENT_DATE, CURRENT_TIME, 0)";

        Connection conn = BBDDConnector.GetInstance().GetConnection();

//        try (PreparedStatement ps = conn.prepareStatement(verificacion)) {
//            ps.setInt(1, idTrabajador);
//            ResultSet rs = ps.executeQuery();
//            if (!rs.next()) {
//                return false;
//            }
//        }

        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idTrabajador);

        int rows = ps.executeUpdate();

        return rows > 0;
    }

    public static boolean registrarSalida(int idTrabajador) throws SQLException {
        // Primero obtenemos el último fichaje sin salida del trabajador
        String querySelect = "SELECT idFichaje, horaEntrada FROM fichajes " + "WHERE idTrabajador = ? AND fecha = CURRENT_DATE AND horaSalida IS NULL " + "ORDER BY idFichaje DESC LIMIT 1";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement psSelect = conn.prepareStatement(querySelect);
        psSelect.setInt(1, idTrabajador);
        ResultSet rs = psSelect.executeQuery();

        if (!rs.next()) {
            return false;
        }

        int idFichaje = rs.getInt("idFichaje");
        LocalTime horaEntrada = rs.getObject("horaEntrada", LocalTime.class);
        LocalTime horaSalida = LocalTime.now();
        float horasTrabajadas = Fichaje.calculoHorasTrabajadas(horaEntrada, horaSalida);

        // Actualizamos la BBDD con la hora de salida y las horas trabajadas
        String queryUpdate = "UPDATE fichajes SET horaSalida = ?, horasTrabajadas = ? WHERE idFichaje = ?";
        PreparedStatement psUpdate = conn.prepareStatement(queryUpdate);
        psUpdate.setTime(1, Time.valueOf(horaSalida));
        psUpdate.setFloat(2, horasTrabajadas);
        psUpdate.setInt(3, idFichaje);

        int rows = psUpdate.executeUpdate();

        return rows > 0;
    }

    public static Fichaje getUltimoFichaje(int idTrabajador) throws SQLException {
        String query = "SELECT * FROM fichajes WHERE idTrabajador = ? ORDER BY fecha DESC, horaEntrada DESC LIMIT 1";

        Connection conn = BBDDConnector.GetInstance().GetConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, idTrabajador);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            Fichaje registro = new Fichaje();
            registro.setIdFichaje(rs.getInt("idFichaje"));
            registro.setIdTrabajador(rs.getInt("idTrabajador"));
            registro.setFecha(rs.getObject("fecha", LocalDate.class));
            registro.setHoraEntrada(rs.getObject("horaEntrada", LocalTime.class));
            registro.setHoraSalida(rs.getObject("horaSalida", LocalTime.class));
            registro.setHorasTrabajadas(rs.getFloat("horasTrabajadas"));
            return registro;
        }

        return null;
    }

    public static Fichaje getFichajeById(int idFichaje) {
        return null;
    }
}