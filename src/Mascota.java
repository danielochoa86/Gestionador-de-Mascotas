public class Mascota {
    private int Id;
    private String nombre;
    private String especie;
    private Estados estado;
    private Dispositivo dispositivo;


    //Constructores
    public Mascota(int id, String nombre, String especie, Estados estado, Dispositivo dispositivo) {
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

    public Estados getEstado() {
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

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
}
