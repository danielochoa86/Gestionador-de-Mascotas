public class Main {

    public static void main (String[] args){

        ServicioMascota service = new ServicioMascota();
        Menu menu = new Menu(service);
        menu.run();

    }
}
