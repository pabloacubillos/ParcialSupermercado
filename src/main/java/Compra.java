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
}
