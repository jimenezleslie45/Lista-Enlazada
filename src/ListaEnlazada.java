import java.util.Scanner;

class Nodo {
    int dato;
    Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}

public class ListaEnlazada {
    Nodo cabeza;

    public ListaEnlazada() {
        this.cabeza = null;
    }

    public void insertarAlPrincipio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        nuevoNodo.siguiente = cabeza;
        cabeza = nuevoNodo;
    }

    public void insertarAlFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);

        if (cabeza == null) {
            cabeza = nuevoNodo;
            return;
        }

        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            temp = temp.siguiente;
        }

        temp.siguiente = nuevoNodo;
    }

    public void recorrer() {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.dato + " ");
            temp = temp.siguiente;
        }
        System.out.println();
    }

    public int buscar(int clave) {
        Nodo temp = cabeza;
        int indice = 0;

        while (temp != null) {
            if (temp.dato == clave) {
                return indice;
            }
            temp = temp.siguiente;
            indice++;
        }

        return -1;
    }

    public void eliminar(int clave) {
        if (cabeza == null) {
            System.out.println("La lista está vacía");
            return;
        }

        if (cabeza.dato == clave) {
            cabeza = cabeza.siguiente;
            return;
        }

        Nodo temp = cabeza;
        while (temp.siguiente != null) {
            if (temp.siguiente.dato == clave) {
                temp.siguiente = temp.siguiente.siguiente;
                return;
            }
            temp = temp.siguiente;
        }

        System.out.println("Elemento no encontrado en la lista");
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Scanner scanner = new Scanner(System.in);
        int opcion, dato, clave;

        while (true) {
            System.out.println("\nBienvenido a las operaciones de Lista Enlazada");
            System.out.println("1. Insertar al principio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Recorrer la lista");
            System.out.println("4. Buscar un elemento");
            System.out.println("5. Eliminar un elemento");
            System.out.println("6. Salir");

            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el dato a insertar: ");
                    dato = scanner.nextInt();
                    lista.insertarAlPrincipio(dato);
                    break;
                case 2:
                    System.out.print("Ingrese el dato a insertar: ");
                    dato = scanner.nextInt();
                    lista.insertarAlFinal(dato);
                    break;
                case 3:
                    lista.recorrer();
                    break;
                case 4:
                    System.out.print("Ingrese la clave a buscar: ");
                    clave = scanner.nextInt();
                    int indice = lista.buscar(clave);
                    if (indice != -1) {
                        System.out.println("Elemento encontrado en el índice " + indice);
                    } else {
                        System.out.println("Elemento no encontrado en la lista");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la clave a eliminar: ");
                    clave = scanner.nextInt();
                    lista.eliminar(clave);
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}
