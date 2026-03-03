import java.util.ArrayList;
import java.util.List;

public class ServicioMascota {
    private List<Mascota> mascotas = new ArrayList<>();
    public int mascotaCounter = 1;
    public int deviceCounter = 1;

    //método para registrar mascota y agregarla al arraylist
    public Mascota registrarMascota(String nombre, String especie, EstadoMascota estado){
        Mascota m = new Mascota(mascotaCounter++,nombre,especie,estado);
        mascotas.add(m);
        return m;
    }

    //devolver arraylist
    public List<Mascota> listarMascotas(){
        return List.copyOf(mascotas);
    }

    //buscar a la mascota por id
    public Mascota idLookup(int id){
        for (Mascota m : mascotas){
            if (m.getId() == id) return m;
        }
        return null;
    }

    public boolean crear_asignarDispositivo(Mascota mascota){
        if (mascota == null) return false;
        if (mascota.getDispositivo() != null) return false;

        Dispositivo device = new Dispositivo(deviceCounter++,EstadosDispositivo.LINKED);
        mascota.linkDevice(device);
        return true;
    }

    public boolean registrarUbicacion(Mascota mascota, double lat, double lon){
        if (mascota == null) return false;
        if (mascota.getDispositivo()==null) return false;
        mascota.getDispositivo().log(lat,lon);
        return true;
    }


}
