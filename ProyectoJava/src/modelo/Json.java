package modelo;

/**   
 * @author DavidGG      
 * @version 1.0
 */
public class Json {

    private String code;
    private String value;

    public Json() {
        super();
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
