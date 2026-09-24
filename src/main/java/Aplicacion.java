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
    System.out.println("1.Registrar Cliente");
    System.out.println("--------------------");
    System.out.println("2. Registrar Producto");
    System.out.println("3. Registrar Compra");

    System.out.println("--------------------");
    System.out.println("4. Reporte de venta");
    System.out.println("--------------------");
    System.out.println("0. Salir");


    System.out.print("Seleccione la opción: ");
    opcion = sc.nextInt();
    sc.nextLine();

    switch (opcion){
        case 1:
    }



} while (opcion != 0);






        sc.close();
    }

}
