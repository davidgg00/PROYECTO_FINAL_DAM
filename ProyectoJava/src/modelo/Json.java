/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author DavidGG
 */
public class Json {

    private String code;
    private String value;

    public Json() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Json(String codigo, String value) {
        super();
        this.code = codigo;
        this.value = value;
    }

    public String getCodigo() {
        return code;
    }

    public void setCodigo(String codigo) {
        this.code = codigo;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Json [codigo=" + code + ", value=" + value + "]";
    }

}
