public class Mascota {
    private int Id;
    private String nombre;
    private String especie;
    private Estados_Mascota estado;
    private Dispositivo dispositivo;


    //Constructores
    public Mascota(int id, String nombre, String especie, Estados_Mascota estado) {
        Id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.estado = estado;
    }

    //******************************************
    //getters
    public int getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public Estados_Mascota getEstado() {
        return estado;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    //******************************************
    //setters
    public void setId(int id) {
        Id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEstado(Estados_Mascota estado) {
        this.estado = estado;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    //******************************************

    public String toString(){
        String deviceinfo = (dispositivo == null)
                ? "Sin asignar"
                : String.valueOf(dispositivo.getDevice_id());
        return "Especie: " + especie +
                "\nNombre: " + nombre +
                "\nEstado: " + estado +
                "\nID Dispositivo: " + deviceinfo;
    }

    //Asociar dispositivo con la mascota
    public void linkDevice(Dispositivo device){
        this.dispositivo = device;
    }


}
