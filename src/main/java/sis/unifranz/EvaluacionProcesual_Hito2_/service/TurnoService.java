package sis.unifranz.EvaluacionProcesual_Hito2_.service;

import sis.unifranz.EvaluacionProcesual_Hito2_.model.Prioridad;
import sis.unifranz.EvaluacionProcesual_Hito2_.model.Turno;
import sis.unifranz.EvaluacionProcesual_Hito2_.util.ListaEnlazada;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class TurnoService {

    private final ListaEnlazada<Turno> turnos;
    private final Clock clock;

    public TurnoService() {
        this(Clock.systemDefaultZone());
    }

    public TurnoService(Clock clock) {
        this.clock = clock;
        this.turnos = new ListaEnlazada<>();

        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {

        LocalDateTime ahora = LocalDateTime.now(clock);

        turnos.agregar(new Turno(
                1,
                "EST001",
                "Pepe Perales",
                "Biblioteca",
                Prioridad.NORMAL,
                ahora.minusMinutes(5)
        ));

        turnos.agregar(new Turno(
                2,
                "EST002",
                "Ana Sosa",
                "Soporte",
                Prioridad.ALTA,
                ahora.minusMinutes(3)
        ));

        turnos.agregar(new Turno(
                3,
                "EST003",
                "Sofía López",
                "Registro",
                Prioridad.BAJA,
                ahora.minusMinutes(25)
        ));

        turnos.agregar(new Turno(
                4,
                "EST004",
                "Carlos Ruiz",
                "Caja",
                Prioridad.NORMAL,
                ahora.minusMinutes(30)
        ));
    }

    public ListaEnlazada<Turno> listar() {
        return turnos;
    }

    public Turno obtenerSiguienteTurno() {
        Turno candidato = null;

        for (int i = 0; i < turnos.tamano(); i++) {
            Turno actual = turnos.obtener(i);

            if (candidato == null) {
                candidato = actual;
                continue;
            }

            Prioridad prioActual = prioridadEfectiva(actual);
            Prioridad prioCandidato = prioridadEfectiva(candidato);

            if (prioActual.ordinal() > prioCandidato.ordinal()) {
                candidato = actual;
            } else if (prioActual.ordinal() == prioCandidato.ordinal()) {
                if (actual.getHoraRegistro().isBefore(candidato.getHoraRegistro())) {
                    candidato = actual;
                }
            }
        }

        return candidato;
    }

    public Turno atenderSiguiente() {
        Turno siguiente = obtenerSiguienteTurno();
        if (siguiente != null) {
            cancelarTurno(siguiente.getId());
        }
        return siguiente;
    }

    public boolean cancelarTurno(int id) {
        for (int i = 0; i < turnos.tamano(); i++) {
            Turno t = turnos.obtener(i);
            if (t.getId() == id) {
                return turnos.eliminar(i);
            }
        }
        return false;
    }

    public Turno buscarPorId(int id) {
        for (int i = 0; i < turnos.tamano(); i++) {
            Turno t = turnos.obtener(i);
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    private Prioridad prioridadEfectiva(Turno turno) {
        long minutos = minutosEsperando(turno);
        Prioridad original = turno.getPrioridad();

        if (original == Prioridad.BAJA && minutos > 10) {
            return Prioridad.NORMAL;
        }
        if (original == Prioridad.NORMAL && minutos > 20) {
            return Prioridad.ALTA;
        }

        return original;
    }

    private long minutosEsperando(Turno turno) {

        return Duration.between(
                turno.getHoraRegistro(),
                LocalDateTime.now(clock)
        ).toMinutes();
    }
}