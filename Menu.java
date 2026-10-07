import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Queue<ObjVisitante> cola = new LinkedList<>();
        Metodos m = new Metodos();

        boolean continuar = true;

        while (continuar) {

            System.out.println("\nRECEPCIÓN EMPRESARIAL");
            System.out.println("1) Registrar visitante");
            System.out.println("2) Mostrar visitantes");
            System.out.println("3) Llamar visitante");
            System.out.println("4) Registrar que no responde");
            System.out.println("5) Cancelar visita");
            System.out.println("6) Cambiar funcionario");
            System.out.println("7) Atender visitante");
            System.out.println("8) Mostrar visitantes pendientes");
            System.out.println("9) Mostrar visitantes atendidos");
            System.out.println("10) Salir");

            int opt = m.ValidarEntero(sc);

            switch (opt) {

                case 1:
                    cola = m.LlenarCola(cola, sc);
                    break;

                case 2:
                    m.MostrarVisitantes(cola);
                    break;

                case 3:
                    cola = m.LlamarVisitante(cola);
                    break;

                case 4:
                    cola = m.NoResponde(cola, sc);
                    break;

                case 5:
                    cola = m.CancelarVisita(cola, sc);
                    break;

                case 6:
                    cola = m.CambiarFuncionario(cola, sc);
                    break;

                case 7:
                    cola = m.AtenderVisitante(cola);
                    break;

                case 8:
                    m.MostrarPorEstado(cola, 1);
                    break;

                case 9:
                    m.MostrarPorEstado(cola, 3);
                    break;

                case 10:
                    System.out.println("Hasta luego");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no valida, por favor intente de nuevo");
                    break;
            }
        }
    }
}