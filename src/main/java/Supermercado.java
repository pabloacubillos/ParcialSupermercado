import java.util.ArrayList;
import java.util.List;

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
            System.out.println(cliente.getNombre());
        }
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

}
