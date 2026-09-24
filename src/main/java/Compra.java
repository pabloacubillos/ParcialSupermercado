import java.util.Date;

public class Compra {

    private String codigo;
    private Date fecha;
    private String telefano;
    private String correo;
    private MetodoPago metodoPago;

    public Compra(String codigo, Date fecha, String telefano, String correo, MetodoPago metodoPago) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.telefano = telefano;
        this.correo = correo;
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "codigo='" + codigo + '\'' +
                ", fecha=" + fecha +
                ", telefano='" + telefano + '\'' +
                ", correo='" + correo + '\'' +
                ", metodoPago=" + metodoPago +
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

    public String getTelefano() {
        return telefano;
    }

    public void setTelefano(String telefano) {
        this.telefano = telefano;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
}
