import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Dispositivo {
    private int device_id;
    private int logcounter;
    private EstadosDispositivo devicestatus;
    private ArrayList<RegistroUbicacion> registros;

    //constructor
    public Dispositivo(int device_id, EstadosDispositivo devicestatus) {
        this.device_id = device_id;
        this.devicestatus = devicestatus;
        this.registros = new ArrayList<>();
        this.logcounter = 1;
    }

    //registros de ubicación
    public void log(double latitud, double longitud){
        RegistroUbicacion newlog = new RegistroUbicacion(
                                logcounter++,
                                LocalDateTime.now(),
                                latitud,
                                longitud);
        registros.add(newlog);
    }

    //getter
    public ArrayList<RegistroUbicacion> getRegistros(){
        return registros;
    }

    public EstadosDispositivo getStatus(){
        return devicestatus;
    }

    public int getDevice_id() {
        return device_id;
    }

    /*
            Hace for loop para todos los logs en el array list
            construye un string con cada log, y luego hace el return
         */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Dispositivo: ").append(device_id).append("\n");
        sb.append("Registros:\n");
            for (RegistroUbicacion r : registros){
                sb.append("   ").append(r).append("\n");
            }
        return sb.toString();
    }

}
