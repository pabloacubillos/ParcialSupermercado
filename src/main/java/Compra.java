import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Compra {

    private String codigo;
    private Date fecha;
    private MetodoPago metodoPago;
    private List<Producto> listaProductos;


    public Compra(String codigo, Date fecha, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        listaProductos = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", metodoPago=" + metodoPago +
                ", listaProductos=" + listaProductos +
                '}';
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
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
}
