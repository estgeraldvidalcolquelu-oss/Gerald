package sis.unifranz.EvaluacionProcesual_Hito2_.controller;

import sis.unifranz.EvaluacionProcesual_Hito2_.model.Turno;
import sis.unifranz.EvaluacionProcesual_Hito2_.service.TurnoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {

    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping
    public Object listar() {
        return turnoService.listar();
    }

    @GetMapping("/siguiente")
    public ResponseEntity<Turno> siguiente() {

        Turno turno = turnoService.obtenerSiguienteTurno();

        if (turno == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(turno);
    }

    @PostMapping("/{id}/atender")
    public ResponseEntity<Turno> atender() {

        Turno turno = turnoService.atenderSiguiente();

        if (turno == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(turno);
    }

    @PostMapping("/{id}/cancelar")
    public ResponseEntity<String> cancelar(@PathVariable int id) {

        boolean resultado = turnoService.cancelarTurno(id);

        if (resultado) {
            return ResponseEntity.ok(
                    "Turno cancelado correctamente"
            );
        }

        return ResponseEntity.badRequest().body(
                "No se pudo cancelar el turno"
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turno> buscar(@PathVariable int id) {

        Turno turno = turnoService.buscarPorId(id);

        if (turno == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(turno);
    }
}

