package sis.unifranz.EvaluacionProcesual_Hito2_.model;

import java.time.LocalDateTime;

public class Turno {

    private int id;
    private String codigoEstudiante;
    private String nombreEstudiante;
    private String servicio;
    private Prioridad prioridad;
    private LocalDateTime horaRegistro;
    private EstadoTurno estado;

    public Turno() {
    }

    public Turno(
            int id,
            String codigoEstudiante,
            String nombreEstudiante,
            String servicio,
            Prioridad prioridad,
            LocalDateTime horaRegistro
    ) {
        this.id = id;
        this.codigoEstudiante = codigoEstudiante;
        this.nombreEstudiante = nombreEstudiante;
        this.servicio = servicio;
        this.prioridad = prioridad;
        this.horaRegistro = horaRegistro;
        this.estado = EstadoTurno.PENDIENTE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    public void setCodigoEstudiante(String codigoEstudiante) {
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDateTime getHoraRegistro() {
        return horaRegistro;
    }

    public void setHoraRegistro(LocalDateTime horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", codigoEstudiante='" + codigoEstudiante + '\'' +
                ", servicio='" + servicio + '\'' +
                ", prioridad=" + prioridad +
                ", horaRegistro=" + horaRegistro +
                ", estado=" + estado +
                '}';
    }
}
