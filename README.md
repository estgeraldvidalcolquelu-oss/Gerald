# Análisis de Complejidad Temporal (Big O)

## 1. Operaciones de ListaEnlazada
* **`agregar(T elemento)`**: O(n) - Recorre los n elementos hasta el último nodo para realizar la inserción al final.
* **`obtener(int posicion)`**: O(n) - Recorre la lista desde la cabeza hasta llegar al índice n.
* **`eliminar(int posicion)`**: O(n) - Recorre hasta la posición n-1 para reajustar los punteros.

## 2. Métodos del TurnoService
* **`prioridadEfectiva(Turno turno)`**: O(1) - Realiza cálculos aritméticos y comparaciones directas de tiempo.
* **`obtenerSiguienteTurno()`**: O(n) - Recorre los n turnos de la lista y realiza comparaciones de prioridad para encontrar el óptimo.
* **`atenderSiguiente()`**: O(n) - Llama a `obtenerSiguienteTurno()` (O(n)) y luego elimina el turno por ID (O(n)), resultando en O(n).
* **`cancelarTurno(int id)`**: O(n) - Busca el turno por ID mediante un recorrido secuencial y elimina el nodo correspondiente.