package com.example.daw_trabajo_josuetito.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Fichaje {
    private int idFichaje;
    private int idTrabajador;
    private LocalDate fecha;
    private LocalTime horaEntrada;
    private LocalTime horaSalida;
    private float horasTrabajadas;

    public Fichaje() {
    }

    public Fichaje(int idFichaje, int idTrabajador, LocalDate fecha, LocalTime horaEntrada, LocalTime horaSalida, float horasTrabajadas) {
        this.idFichaje = idFichaje;
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.horasTrabajadas = horasTrabajadas;
    }

    public Fichaje(int idFichaje, int idTrabajador, LocalDate fecha, LocalTime horaEntrada, LocalTime horaSalida) {
        this.idFichaje = idFichaje;
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Fichaje(int idFichaje, int idTrabajador, LocalDate fecha, LocalTime horaEntrada, float horasTrabajadas) {
        this.idFichaje = idFichaje;
        this.idTrabajador = idTrabajador;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getIdFichaje() {
        return idFichaje;
    }

    public void setIdFichaje(int idFichaje) {
        this.idFichaje = idFichaje;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public float getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(float horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }


    public static float calculoHorasTrabajadas(LocalTime entrada, LocalTime salida) {
        if (entrada == null || salida == null) {
            return 0.0f;
        }
        return (float) (java.time.Duration.between(entrada, salida).toMinutes() / 60.0);
    }


    public void actualizarHorasTrabajadas() {
        if (this.horaEntrada != null && this.horaSalida != null) {
            this.horasTrabajadas = calculoHorasTrabajadas(this.horaEntrada, this.horaSalida);
        } else {
            this.horasTrabajadas = 0.0f;
        }
    }

    @Override
    public String toString() {
        return "RegistroHorario{" +
                "idFichaje=" + idFichaje +
                ", idTrabajador=" + idTrabajador +
                ", fecha=" + fecha +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                ", horasTrabajadas=" + horasTrabajadas +
                '}';
    }
}