package sis.unifranz.EvaluacionProcesual_Hito2_.util;

import java.util.Iterator;

public class ListaEnlazada<T> implements Iterable<T> {
    private Nodo<T> cabeza;
    private int tamano;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public void agregar(T elemento) {
        Nodo<T> nuevo = new Nodo<>(elemento);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo<T> aux = cabeza;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
        tamano++;
    }

    public T obtener(int posicion) {
        if (posicion < 0 || posicion >= tamano) return null;
        Nodo<T> aux = cabeza;
        for (int i = 0; i < posicion; i++) {
            aux = aux.siguiente;
        }
        return aux.dato;
    }

    public boolean eliminar(int posicion) {
        if (posicion < 0 || posicion >= tamano || cabeza == null) return false;
        if (posicion == 0) {
            cabeza = cabeza.siguiente;
        } else {
            Nodo<T> aux = cabeza;
            for (int i = 0; i < posicion - 1; i++) {
                aux = aux.siguiente;
            }
            aux.siguiente = aux.siguiente.siguiente;
        }
        tamano--;
        return true;
    }

    public int tamano() {
        return tamano;
    }

    public boolean estaVacia() {
        return tamano == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> actual = cabeza;

            @Override
            public boolean hasNext() {
                return actual != null;
            }

            @Override
            public T next() {
                T dato = actual.dato;
                actual = actual.siguiente;
                return dato;
            }
        };
    }
}