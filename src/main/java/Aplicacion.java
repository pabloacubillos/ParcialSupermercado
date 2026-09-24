import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SocketHandler;


public class Aplicacion {
    public static void main (String[] args) {
        Supermercado marketPlus = new Supermercado("Market Plus","Carrera 15 calle 13", "39028362");
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
            System.out.println("-----Registrar cliente-----");
            System.out.println("Ingresa el nombre del cliente:");
            String nombreCliente = sc.nextLine();

            System.out.println("Ingresa el documento de identidad del cliente:");
            String documentoCliente = sc.nextLine();

            System.out.println("Ingresa el telefono del cliente: ");
            String telefonoCliente = sc.nextLine();

            System.out.println("Ingresa el correo electronico del cliente");
            String correoCliente = sc.nextLine();

            Cliente cliente = new Cliente(nombreCliente,documentoCliente,telefonoCliente,correoCliente);
            break;

        case 2:

            System.out.println("-----Modificar cliente-----");

            System.out.println("Documento cliente: ");
            String documentoModificar = sc.nextLine();

            System.out.println("Nuevo nombre cliente: ");
            String nuevoNombre = sc.nextLine();

            System.out.println("Nuevo teléfono: ");
            String nuevoTelefono = sc.nextLine();

            System.out.println("Nuevo correo: ");
            String nuevoCorreo = sc.nextLine();

            Cliente clienteModificado = new Cliente(nuevoNombre,documentoModificar, nuevoTelefono, nuevoCorreo);


            break;

        case 3:
            //Mostrar clientes
            marketPlus.mostrarClientes();
            break;


        case 5:
            //Registrar Compra
            System.out.println("Ingresa el codigo de la compra:");
            String codigo = sc.nextLine();



            MetodoPago metodoPago;

        case 0:
            System.out.println("Programa finalizado.....");
            break;

        default:
            System.out.println("Opción no valida.....");





        case 4:
            // Registrar producto
            System.out.println("--- Registrar Producto ---");

            System.out.println("Código del producto: ");
            String codigoProducto = sc.nextLine();

            System.out.println("Nombre del producto: ");
            String nombreProducto = sc.nextLine();

            System.out.println("Precio del producto: ");
            double precioProducto = sc.nextDouble();

            System.out.println("Cantidad disponible: ");
            int cantidadProducto = sc.nextInt();

            int opcionCategoria;
            Categoria categoria = null;

            do {
                System.out.println(
                        "Seleccione la categoría:\n" +
                                "1. ASEO\n" +
                                "2. BEBIDAS\n" +
                                "3. ALIMENTOS\n" +
                                "4. CUIDADO_PERSONAL"
                );

                opcionCategoria = sc.nextInt();
                sc.nextLine();

                switch (opcionCategoria) {
                    case 1:
                        categoria = Categoria.ASEO;
                        break;

                    case 2:
                        categoria = Categoria.BEBIDAS;
                        break;

                    case 3:
                        categoria = Categoria.ALIMENTOS;
                        break;

                    case 4:
                        categoria = Categoria.CUIDADO_PERSONAL;
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } while (opcionCategoria < 1 || opcionCategoria > 4);

            Producto producto = new Producto(
                    codigoProducto,
                    nombreProducto,
                    precioProducto,
                    cantidadProducto,
                    categoria
            );

            marketPlus.registrarProducto(producto);

            System.out.println("Producto registrado correctamente.");

            break;
}







} while (opcion != 0);






        sc.close();
    }

}
