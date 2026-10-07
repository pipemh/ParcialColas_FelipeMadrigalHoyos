
import java.util.Queue;
import java.util.Scanner;

public class Metodos {

    public String MostrarEstado(int estado) {

        String mensaje = "";

        switch (estado) {
            /*
             * ESTADOS:
             * 1 = Esperando
             * 2 = Llamado
             * 3 = Atendido
             * 4 = No respondió
             * 5 = Cancelado
             */
            case 1:
                mensaje = "Esperando";
                break;

            case 2:
                mensaje = "Llamado";
                break;

            case 3:
                mensaje = "Atendido";
                break;

            case 4:
                mensaje = "No respondió";
                break;

            case 5:
                mensaje = "Cancelado";
                break;

            default:
                mensaje = "Estado desconocido";
                break;
        }

        return mensaje;
    }

    public int ValidarEntero(Scanner sc) {

        while (!sc.hasNextInt()) {

            System.out.println("Por favor ingrese un dato numérico válido");
            sc.next();
        }

        return sc.nextInt();
    }

    public Queue<ObjVisitante> LlenarCola(Queue<ObjVisitante> cola, Scanner sc) {

        boolean continuar = true;

        while (continuar) {

            ObjVisitante o = new ObjVisitante();

            o.setTurno(ValidarTurno(cola));

            System.out.println("\nIngrese el nombre del visitante:");
            o.setNombre(sc.next());

            System.out.println("Ingrese el documento:");
            o.setDocumento(ValidarEntero(sc));

            o.setFuncionario(MenuFuncionario(sc));

            o.setEstado(1);

            cola.offer(o);

            System.out.println("Visitante registrado correctamente.");
            System.out.println("Su turno es: " + o.getTurno());

            System.out.println("\n¿Desea registrar otro visitante?");
            System.out.println("1. Si");
            System.out.println("2. No");

            int opt = ValidarEntero(sc);

            if (opt == 2) {
                continuar = false;
            }
        }

        return cola;
    }

    public String MostrarFuncionario(int funcionario) {

        String mensaje = "";

        switch (funcionario) {

            case 1:
                mensaje = "Gerente";
                break;

            case 2:
                mensaje = "Líder de Recursos Humanos";
                break;

            case 3:
                mensaje = "Auxiliar de Contabilidad";
                break;

            case 4:
                mensaje = "Ingeniero del departamento de Sistemas";
                break;

            case 5:
                mensaje = "Líder Comercial";
                break;

            default:
                mensaje = "Funcionario no definido";
                break;
        }

        return mensaje;
    }

    public Queue<ObjVisitante> LlamarVisitante(Queue<ObjVisitante> cola) {

        for (ObjVisitante o : cola) {
            if (o.getEstado() != 1) {

                System.out.println("No hay visitantes en espera para ser llamados.");
                break;
            }
            if (o.getEstado() == 1) {

                o.setEstado(2);

                System.out.println("\nVisitante llamado:");
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Funcionario: "
                        + MostrarFuncionario(o.getFuncionario()));

                break;
            }
        }

        return cola;
    }

    public Queue<ObjVisitante> NoResponde(Queue<ObjVisitante> cola, Scanner sc) {

        System.out.println("\nIngrese el turno del visitante:");
        int turno = ValidarEntero(sc);

        for (ObjVisitante o : cola) {

            if (o.getTurno() == turno && o.getEstado() == 2) {

                o.setEstado(4);

                System.out.println("El visitante no respondió.");

                break;
            }
        }

        return cola;
    }

    public Queue<ObjVisitante> CancelarVisita(Queue<ObjVisitante> cola, Scanner sc) {

        System.out.println("\nIngrese el turno que desea cancelar:");
        int turno = ValidarEntero(sc);

        for (ObjVisitante o : cola) {

            if (o.getTurno() == turno
                    && (o.getEstado() == 1 || o.getEstado() == 2)) {

                o.setEstado(5);

                System.out.println("La visita fue cancelada.");

                break;
            }
        }

        return cola;
    }

    public Queue<ObjVisitante> CambiarFuncionario(
            Queue<ObjVisitante> cola, Scanner sc) {

        System.out.println("\nIngrese el turno del visitante:");
        int turno = ValidarEntero(sc);

        for (ObjVisitante o : cola) {
            if (o.getTurno() == turno && o.getEstado() != 1) {

                System.out.println("El visitante ya fue atendido. No se puede cambiar el funcionario.");
                break;
            }
            if (o.getTurno() == turno && o.getEstado() == 1) {

                System.out.println("Funcionario actual: "
                        + MostrarFuncionario(o.getFuncionario()));

                o.setFuncionario(MenuFuncionario(sc));

                System.out.println("Funcionario cambiado correctamente.");

                break;
            }
        }

        return cola;
    }

    public Queue<ObjVisitante> AtenderVisitante(Queue<ObjVisitante> cola) {

        for (ObjVisitante o : cola) {
            if (o.getEstado() != 2) {

                System.out.println("Primero debes llamar al visitante para poderlo atender.");
                break;
            }
            if (o.getEstado() == 2) {

                o.setEstado(3);

                System.out.println("\nVisitante atendido:");
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Nombre: " + o.getNombre());

                break;
            }
        }

        return cola;
    }

    public void MostrarVisitantes(Queue<ObjVisitante> cola) {

        for (ObjVisitante o : cola) {
            System.out.println("--");
            System.out.println("Turno: " + o.getTurno());
            System.out.println("Nombre: " + o.getNombre());
            System.out.println("Documento: " + o.getDocumento());
            System.out.println("Funcionario: " + MostrarFuncionario(o.getFuncionario()));
            System.out.println("Estado: " + MostrarEstado(o.getEstado()));
        }
    }

    public void MostrarPorEstado(
            Queue<ObjVisitante> cola, int estado) {

        for (ObjVisitante o : cola) {
            if (o.getEstado() != estado) {
                System.out.println("No hay visitantes en estado " + MostrarEstado(estado));
            }
            if (o.getEstado() == estado) {
                System.out.println("---");
                System.out.println("Turno: " + o.getTurno());
                System.out.println("Nombre: " + o.getNombre());
                System.out.println("Documento: " + o.getDocumento());
                System.out.println("Funcionario: "
                        + MostrarFuncionario(o.getFuncionario()));
                System.out.println("Estado: " + MostrarEstado(o.getEstado()));
            }
        }
    }

    public int ValidarTurno(Queue<ObjVisitante> cola) {

        int turno;

        if (cola.isEmpty()) {
            turno = 1;
        } else {
            turno = cola.size() + 1;
        }

        return turno;
    }

    public int MenuFuncionario(Scanner sc) {

        System.out.println("\n¿A qué funcionario desea visitar?");
        System.out.println("1. Gerente");
        System.out.println("2. Líder de Recursos Humanos");
        System.out.println("3. Auxiliar de Contabilidad");
        System.out.println("4. Ingeniero del departamento de Sistemas");
        System.out.println("5. Líder Comercial");

        return ValidarEntero(sc);
    }

}
