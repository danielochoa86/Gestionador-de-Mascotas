import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Dispositivo {
    private String device_id;
    private int logcounter;
    private String DeviceStatus;
    private ArrayList<Registros> registros;

    public Dispositivo(String device_id, String deviceStatus) {
        this.device_id = device_id;
        DeviceStatus = deviceStatus;
        this.registros = new ArrayList<>();
        this.logcounter = 1;
    }

    public void log(double latitud, double longitud){
        Registros newlog = new Registros(
                                logcounter++,
                                LocalDateTime.now(),
                                latitud,
                                longitud);
        registros.add(newlog);
    }

    public ArrayList<Registros> getRegistros(){
        return registros;
    }

    /*
        Hace for loop para todos los logs en el array list
        construye un string con cada log, y luego hace el return
     */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dispositivo: ").append(device_id).append("\n");
        sb.append("Registros:\n");

        for (Registros r : registros){
            sb.append("   ").append(r).append("\n");
        }

        return sb.toString();

    }

}
