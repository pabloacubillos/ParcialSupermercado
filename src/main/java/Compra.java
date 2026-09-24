import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {

    private String codigo;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private List<Producto> listaProductos;
    private Cliente cliente;
    private double valorTotal;

    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.listaProductos = new ArrayList<>();
        this.cliente = cliente;
        this.valorTotal = 0.0;
    }


    public boolean agregarProducto(Producto producto, int cantidad) {
        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return false;
        }
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a 0.");
            return false;
        }
        if (producto.getCantidadDisponible() < cantidad) {
            System.out.println("No hay suficiente stock. Disponible: " + producto.getCantidadDisponible());
            return false;
        }


        producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);


        for (int i = 0; i < cantidad; i++) {
            listaProductos.add(producto);
        }


        valorTotal += producto.getPrecioUnitario() * cantidad;

        System.out.println("Producto agregado correctamente. Subtotal actual: $" + valorTotal);
        return true;
    }


    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public MetodoPago getMetodoPago() { return metodoPago; }
    public void setMetodoPago(MetodoPago metodoPago) { this.metodoPago = metodoPago; }

    public List<Producto> getListaProductos() { return listaProductos; }
    public void setListaProductos(List<Producto> listaProductos) { this.listaProductos = listaProductos; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                ", valorTotal=" + valorTotal +
                ", cliente=" + (cliente != null ? cliente.getNombre() : "null") +
                ", productos=" + listaProductos.size() +
                '}';
    }
}