import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {

    private String codigo;
    private LocalDate fecha;
    private MetodoPago metodoPago;
    private List<Producto> listaProductos;
    private Cliente cliente;


    public Compra(String codigo, LocalDate fecha, MetodoPago metodoPago, Cliente cliente) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        listaProductos = new ArrayList<>();
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                ", listaProductos=" + listaProductos +
                ", cliente=" + cliente +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
