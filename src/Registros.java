import java.time.LocalDateTime;

public class Registros {
    private int log_id;
    private LocalDateTime logtimestamp;
    private double latitud;
    private double longitud;

    Registros(int log_id, LocalDateTime logtimestamp, double latitud, double longitud) {
        this.log_id = log_id;
        this.logtimestamp = logtimestamp;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String toString(){
        return "Registro #" + log_id +
                "\nFecha: " + logtimestamp +
                "\nLat: " + latitud +
                " , Long: " + longitud;
    }

}
