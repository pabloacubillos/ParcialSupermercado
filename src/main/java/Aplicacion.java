import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.logging.SocketHandler;


public class Aplicacion {
    public static void main (String[] args) {

        // Menu interactivo
        Scanner sc = new Scanner(System.in);

int opcion;
do{
    System.out.println("====== MENU Supermercado======");

    System.out.println("1. Registrar Cliente");
    System.out.println("2. Mostrar  Cliente");
    System.out.println("3. Modificar Cliente");

    System.out.println("--------------------");

    System.out.println("4. Registrar Producto");
    System.out.println("5. Registrar Compra");

    System.out.println("--------------------");

    System.out.println("6. Reporte de Venta");

    System.out.println("--------------------");
    System.out.println("0. Salir");


    System.out.print("Seleccione la opción: ");
    opcion = sc.nextInt();
    sc.nextLine();

    switch (opcion){
        case 1:
            //Registrar cliente
            System.out.println("Ingresa el nombre del cliente:");
            String nombre = sc.nextLine();

            System.out.println("Ingresa el documento de identidad del cliente:");
            String documento = sc.nextLine();

            System.out.println("Ingresa el telefono del cliente: ");
            int telefono = sc.nextInt();

            sc.nextLine();
            System.out.println("Ingresa el correo electronico del cliente");
            String correo = sc.nextLine();

            Cliente cliente = new Cliente(nombre,documento,telefono,correo);

            break;


        case 2:

            break;




    }



} while (opcion != 0);






        sc.close();
    }

}
