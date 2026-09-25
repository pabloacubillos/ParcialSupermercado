import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Supermercado {
    private String nombre;
    private String direccion;
    private String telefono;

    //creacion de listas
private List<Producto> listaProductos;
private List<Compra> listaCompras;
private List<Cliente> listaClientes;


    public Supermercado(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;

        //inicializar listas
        listaProductos = new ArrayList<>();
        listaCompras = new ArrayList<>();
        listaClientes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public List<Compra> getListaCompras() {
        return listaCompras;
    }
    public void setListaCompras(List<Compra> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }
    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public boolean registrarCliente (Cliente cliente){
        boolean agregado = verificarCliente(cliente.getDocumento());
        if (!agregado){
            listaClientes.add(cliente);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarCliente (String documento){
        boolean existe = false;
        if (listaClientes.contains(documento)){
            existe = true;
        }
        return existe;
    }

    public void mostrarClientes (){
        for (Cliente cliente : listaClientes){
            System.out.println(cliente.toString());
        }
    }

    public Cliente encontrarCliente (String documento){
        Cliente clienteEncontrado = null;
        for (Cliente cliente : listaClientes){
            if (cliente.getDocumento().equals(documento)){
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }

    public Producto encontrarProducto (String codigo){
        Producto productoEncontrado = null;
        for (Producto producto : listaProductos){
            if (producto.getCodigo().equals(codigo)){
                productoEncontrado = producto;
                break;
            }
        }
        return productoEncontrado;
    }
    // Registrar compra
    public boolean registrarCompra (Compra compra){
        boolean agregado = verificarCompra(compra.getCodigo());
        if (!agregado){
            listaCompras.add(compra);
            agregado = true;
        }
        return agregado;
    }

    public boolean verificarCompra (String codigo){
        boolean existe = false;
        if (listaCompras.contains(codigo)){
            existe = true;
        }
        return existe;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono + ", lista de productos="
                + listaProductos+", lista de compras=" + listaCompras +
                ", lista de clientes=" + listaClientes+
                '}';
    }

    //Método modificar cliente

    public boolean modificarCliente(String documento, Cliente clienteModificado){
        boolean estaModificado = false;
        for(Cliente cliente: listaClientes){
            if(cliente.getDocumento().equals(documento)){
                cliente.setNombre(clienteModificado.getNombre());
                cliente.setTelefono(clienteModificado.getTelefono());
                cliente.setCorreo(clienteModificado.getCorreo());
                estaModificado=true;
                break;
            }
        }
        return estaModificado;
    }
    //Registrar producto nuevo
    public boolean registrarProducto(Producto producto) {
        boolean agregado = false;

        if (!verificarProducto(producto.getCodigo())) {
            listaProductos.add(producto);
            agregado = true;
        }

        return agregado;
    }
//Verificar si el producto es existente
    public boolean verificarProducto(String codigo) {
        boolean existe = false;

        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                existe = true;
                break;
            }
        }

        return existe;
    }

    //Ingresar / Aumentar productos en el almacen
    public boolean ingresarProducto(String codigo, int cantidad) {
        boolean ingresado = false;

        for (Producto producto : listaProductos) {
            if (producto.getCodigo().equals(codigo)) {
                producto.setCantidadDisponible(
                        producto.getCantidadDisponible() + cantidad
                );

                ingresado = true;
                break;
            }
        }

        return ingresado;
    }
//Mostrar productos

    public void  mostrarProductos (){
        for (Producto producto : listaProductos){
            System.out.println(producto);
        }
    }

    // Modificar producto

    public boolean modificarProducto(String codigo, String nuevoNombre, double nuevoPrecio, int nuevaCantidad,
                                     Categoria nuevaCategoria) {

        boolean modificado = false;

        for (Producto producto : listaProductos) {

            if (producto.getCodigo().equals(codigo)) {

                producto.setNombre(nuevoNombre);
                producto.setPrecioUnitario(nuevoPrecio);
                producto.setCantidadDisponible(nuevaCantidad);
                producto.setCategoria(nuevaCategoria);

                modificado = true;
                break;
            }
        }

        return modificado;
    }

    //Conocer el valor total vendido en una fecha determinada
    public String reportarVenta(LocalDate fecha){


        double valorTotal = 0;

        for (Compra compra : listaCompras){
            if (compra.getFecha().equals(fecha)){
                valorTotal+= compra.getValorTotal();
            }
        }

        return "El valor total adquirido la fecha " + fecha + "fue: " + valorTotal;
    }

}
