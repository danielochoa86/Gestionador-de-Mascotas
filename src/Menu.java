import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Menu {

    public int mascotaCounter;
    public int deviceCounter;
    private Scanner sc;
    private ArrayList<String> opciones = new ArrayList<String>();

    public Menu(){
        this.sc = new Scanner(System.in);
    }

    public void run(){


    }

    private Mascota crearMascota(){
        System.out.println("Por favor ingrese la información que " +
                "se le solicita para registrar a su mascota.");
        String petSpec = userInput("Especie: ");
        String petName = userInput("Nombre de las mascota: ");
        mascotaCounter++;
        return new Mascota(mascotaCounter,petName,petSpec,Estados.REGISTRADO);
    }

    private String userInput(String p){
        while (true){
            System.out.println(p);
            String s = sc.nextLine();
            if(!s.isEmpty()) return s;
            System.out.println("Por favor, ingrese un valor.");
            }
        }

    //metodo para desplegar las opciones del menú principal
    private void mostrarOpciones(){
        opciones.clear();
        add("0","Salir");
        add("1", "Registro de mascota");
        add("2", "Registro de dispositivo");
        add("3", "Asociar dispositivo a una mascota");
        add("4", "Registro de ubicación");
        add("5", "Consultar información");
    }

    //método para solicitar información al usuario
    private void add(String abc, String t){
        opciones.add(abc);
        System.out.println("["+abc+"]"+t);
    }
}
