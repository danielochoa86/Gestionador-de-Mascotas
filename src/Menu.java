import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Menu {

    private Scanner sc;
    private ArrayList<String> opciones = new ArrayList<String>();
    private ServicioMascota service;

    public Menu(ServicioMascota service) {
        this.service = service;
        this.sc = new Scanner(System.in);
    }

    public void run() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1) Registrar mascota");
            System.out.println("2) Listar mascotas");
            System.out.println("3) Ver mascota");
            System.out.println("4) Salir");
            System.out.print("Seleccione: ");

            int seleccion = leerEntero();

            switch (seleccion) {
                case 1-> registrarMascotaUI();
                case 2-> listarMascotaUI();
                case 3-> verMascotaUI();
                case 4-> {
                    salir=true;
                    System.out.println("Saliendo del sistema.");
                }
                default->System.out.println("Opción inválida.");
            }
        }
    }

    private void registrarMascotaUI() {
        System.out.println("Por favor ingrese la información que " +
                "se le solicita para registrar a su mascota.");
        String petSpec = userInput("Especie: ");
        String petName = userInput("Nombre de las mascota: ");
        Mascota m = service.registrarMascota(petName, petSpec, Estados_Mascota.REGISTRADO);
        System.out.println("Registrada: " + m);
    }

    private void listarMascotaUI(){
        List<Mascota> mascotas = service.listarMascotas();
        if (mascotas.isEmpty()){
            System.out.println("No hay mascotas registradas aún.");
            return;
        }
        for (Mascota m : mascotas){
            System.out.println(m.getId() + " - " + m.getNombre() +
                    " (" + m.getEspecie() + ") " +
                    (m.getDispositivo() == null ? "[SIN DISPOSITIVO]" : "[CON DISPOSITIVO]"));
        }
    }

    private void verMascotaUI(){
        int id = userInputINT("Ingrese Id de mascota: ");
        Mascota m = service.idLookup(id);

        if (m==null){
            System.out.println("Mascota no encontrada");
            return;
        }

        boolean volver = false;
        while (!volver){
            System.out.println("\n=== DETALLE MASCOTA ===");
            System.out.println(m);

            if (m.getDispositivo() == null){
                System.out.println("1) Crear y asignar dispositivo");
                System.out.println("2) Volver");
                System.out.print("Seleccione: ");
                int op = leerEntero();

                switch (op){
                    case 1 -> {
                        boolean ok = service.crear_asignarDispositivo(m);
                        System.out.println(ok ? "Dispositivo asignado." : "No se pudo asignar.");
                    }
                    case 2 ->volver = true;
                    default -> System.out.println("Opción inválida.");
                }
            } else {
                System.out.println("1) Registrar ubicación");
                System.out.println("2) Ver ubicaciones");
                System.out.println("3) Volver");
                System.out.print("Seleccione: ");
                int op = leerEntero();

                switch (op){
                    case 1-> logUbic(m);
                    case 2-> verUbicaciones(m);
                    case 3-> volver = true;
                    default->System.out.println("Opción inválida.");
                }
            }
        }
    }

    private void logUbic(Mascota m){
        double lat = userInputDouble("Latitud: ");
        double lon = userInputDouble("Longitud:");
        boolean ok = service.registrarUbicacion(m,lat,lon);
        System.out.println(ok ? "Ubicación registrada." : "No se pudo registrar ubicación.");
    }

    private void verUbicaciones(Mascota m){
        var logs = m.getDispositivo().getRegistros();
        if (logs.isEmpty()){
            System.out.println("No hay registros.");
            return;
        }
        for (var r : logs){
            System.out.println(r);
        }
    }

    //lectores
    private String userInput(String p) {
        while (true) {
            System.out.println(p);
            String s = sc.nextLine();
            if (!s.isEmpty()){
                return s;
            } else
            System.out.println("Por favor, ingrese un valor.");
        }
        }

    private int userInputINT (String p){
        while (true) {
            System.out.print(p);

            try {
                String input = sc.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    private int leerEntero(){
        while (true) {
            try {
                String s = sc.nextLine();
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    private double userInputDouble (String p){
        while (true) {
            System.out.print(p);

            try {
                String input = sc.nextLine();
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }
}