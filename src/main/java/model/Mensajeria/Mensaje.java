package model.Mensajeria;

public class Mensaje {
    private int idRemitente;
    private String mensaje;
    private int idDestinatario;

    public Mensaje(int idRemitente, String mensaje, int idDestinatario) {
        this.idRemitente = idRemitente;
        this.mensaje = mensaje;
        this.idDestinatario = idDestinatario;
    }

    public int getIdRemitente() {
        return idRemitente;
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getIdDestinatario() {
        return idDestinatario;
    }
}
