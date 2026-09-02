package sis.unifranz.EvaluacionProcesual_Hito2_.model;

public enum Prioridad
{
    URGENTE(4),
    ALTA(3),
    NORMAL(2),
    BAJA(1);

    private final int nivel;

    Prioridad(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}
