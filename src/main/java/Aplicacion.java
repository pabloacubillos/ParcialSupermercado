import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.SocketHandler;


public class Aplicacion {
    public static void main (String[] args) {
        Supermercado marketPlus = new Supermercado("Market Plus", "Carrera 15 calle 13", "39028362");
        // Menu interactivo
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n====== MENU SUPERMERCADO ======");

            // ===== CLIENTES =====
            System.out.println("\n--- CLIENTES ---");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Modificar Cliente");

            // ===== PRODUCTOS =====
            System.out.println("\n--- PRODUCTOS ---");
            System.out.println("4. Registrar Producto");
            System.out.println("5. Mostrar Productos Disponibles");
            System.out.println("6. Modificar Producto");
            System.out.println("7. Ingresar Productos");

            // ===== COMPRAS =====
            System.out.println("\n--- COMPRAS ---");
            System.out.println("8. Registrar Compra");

            // ===== REPORTES =====
            System.out.println("\n--- REPORTES ---");
            System.out.println("9. Reporte de Venta");

            System.out.println("\n0. Salir");

            System.out.print("\nSeleccione la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                // =========================
                // CLIENTES
                // =========================

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

                    Cliente cliente = new Cliente(nombreCliente, documentoCliente, telefonoCliente, correoCliente);
                    marketPlus.registrarCliente(cliente);
                    break;
                case 2:
                    //Mostrar Cliente
                    marketPlus.mostrarClientes();
                    break;

                case 3:
                    //Modificar cliente
                    System.out.println("-----Modificar cliente-----");

                    System.out.println("Documento cliente: ");
                    String documentoModificado = sc.nextLine();

                    System.out.println("Nuevo nombre cliente: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.println("Nuevo teléfono: ");
                    String nuevoTelefono = sc.nextLine();

                    System.out.println("Nuevo correo: ");
                    String nuevoCorreo = sc.nextLine();

                    Cliente clienteModificado = new Cliente(nuevoNombre, documentoModificado, nuevoTelefono, nuevoCorreo);
                    marketPlus.modificarCliente(documentoModificado, clienteModificado);

                    break;
                case 4:
                    // Registrar producto
                    System.out.println("--- Registrar Producto ---");

                    System.out.print("Código del producto: ");
                    String codigo = sc.nextLine();

                    System.out.print("Nombre del producto: ");
                    String nombreProducto = sc.nextLine();

                    System.out.print("Precio unitario: ");
                    double precio = sc.nextDouble();

                    System.out.print("Cantidad disponible: ");
                    int cantidad = sc.nextInt();

                    int opcionCategoria;
                    Categoria categoria = null;

                    do {
                        System.out.println("\nSeleccione la categoría:");
                        System.out.println("1. ASEO");
                        System.out.println("2. BEBIDAS");
                        System.out.println("3. ALIMENTOS");
                        System.out.println("4. CUIDADO_PERSONAL");

                        opcionCategoria = sc.nextInt();

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
                                System.out.println("Categoría inválida.");
                        }

                    } while (categoria == null);

                    sc.nextLine();

                    Producto producto = new Producto(codigo, nombreProducto,
                            precio, cantidad, categoria);

                    if (marketPlus.registrarProducto(producto)) {
                        System.out.println("Producto registrado correctamente.");
                    } else {
                        System.out.println("Ya existe un producto con ese código.");
                    }

                    break;

                case 5:
                    // Mostrar productos
                    System.out.println("--- Productos disponibles ---");
                    marketPlus.mostrarProductos();
                    break;

                case 6:
                    // modificar producto
                    System.out.println("Ingresa el codigo del producto que quieres modificar: ");
                    String codigoActualizado = sc.nextLine();

                    System.out.println("Nuevo nombre: ");
                    String nombreActualizado = sc.nextLine();

                    System.out.println("Nuevo precio: ");
                    double precioActualizado = sc.nextDouble();

                    System.out.println("Nuevo cantidad disponible: ");
                    int cantidadActualizado = sc.nextInt();

                    //Nota: falta categoria
                    Producto productoModificado = new Producto(codigoActualizado, nombreActualizado,
                            precioActualizado, cantidadActualizado, null);

                    break;

                case 7:
                    System.out.println("--- Ingresar Productos ---");

                    System.out.print("Ingrese el código del producto: ");
                    String codigoProducto = sc.nextLine();

                    System.out.print("Ingrese la cantidad de productos que llegaron: ");
                    int cantidadIngresada = sc.nextInt();
                    sc.nextLine();

                    if (marketPlus.ingresarProducto(codigoProducto, cantidadIngresada)) {
                        System.out.println("Productos ingresados correctamente.");
                    } else {
                        System.out.println("No se encontró un producto con ese código.");
                    }

                    break;
                case 8:
                    //Registrar Compra
                    System.out.println("Ingresa el codigo de la compra:");
                    String codigoCompra = sc.nextLine();

                    LocalDate fechaCompra = LocalDate.now();
                    System.out.println();

                    int opcionMetodo;
                    MetodoPago metodoPago = null;
                    do {
                        System.out.println("Seleccione el metodo:\n" +
                                "1. TARJETA\n" +
                                "2. TRANSFERENCIA\n" +
                                "3. EFECTIVO");

                        opcionMetodo = sc.nextInt();
                        sc.nextLine();

                        switch (opcionMetodo) {
                            case 1:
                                metodoPago = MetodoPago.TARJETA;
                                break;

                            case 2:
                                metodoPago = MetodoPago.TRANSFERENCIA;
                                break;

                            case 3:
                                metodoPago = MetodoPago.EFECTIVO;
                                break;

                            default:
                                System.out.println("Opción inválida.");
                        }


                    } while (opcionMetodo < 1 || opcionMetodo > 3);

                    System.out.println("Metodo de pago seleccionado: " + metodoPago);

                    System.out.println("Ingrese el numero de documento de identidad del cliente:");
                    documentoCliente = sc.nextLine();

                    Cliente clienteCompra = marketPlus.encontrarCliente(documentoCliente);

                    Compra compra = new Compra(codigoCompra, fechaCompra, metodoPago, clienteCompra);
                    marketPlus.registrarCompra(compra);
                    break;

                case 9:
                    // Reporte de venta
                    System.out.println("A continuacion, ingresa la informacion correspondiente a la fecha del reporte:");

                    System.out.println("-Año: ");
                    int anio = sc.nextInt();

                    System.out.println("-Mes: ");
                    int mes = sc.nextInt();

                    System.out.println("-Dia: ");
                    int dia = sc.nextInt();

                    LocalDate fecha = LocalDate.of(anio, mes, dia);

                    marketPlus.reportarVenta(fecha);
                    break;


                case 0:
                    System.out.println("Programa finalizado.....");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }

}