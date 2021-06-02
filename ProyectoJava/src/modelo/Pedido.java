package modelo;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author DavidGG
 * @version 1.0
 */
public class Pedido implements Serializable{
    private int id;
    private String email_cliente;
    private double total_a_pagar;
    private ArrayList<Object> cuenta;
    private static final long serialVersionUID = 1L;

    public Pedido(int id, String email_cliente, double total_a_pagar) {
        this.id = id;
        this.email_cliente = email_cliente;
        this.total_a_pagar = total_a_pagar;
    }

    public Pedido(String email_cliente, double total_a_pagar) {
        this.email_cliente = email_cliente;
        this.total_a_pagar = total_a_pagar;
        this.cuenta = new ArrayList<Object>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public double getTotal_a_pagar() {
        return total_a_pagar;
    }

    public void setTotal_a_pagar(double total_a_pagar) {
        DecimalFormat df = new DecimalFormat("#.##");
        this.total_a_pagar = Double.valueOf(df.format(total_a_pagar));
    }

    public ArrayList<Object> getCuenta() {
        return cuenta;
    }

    public void setProductos(ArrayList<Object> productos) {
        this.cuenta = productos;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", email_cliente='" + email_cliente + '\'' +
                ", total_a_pagar=" + total_a_pagar +
                ", cuenta=" + cuenta +
                '}';
    }
}
