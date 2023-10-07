import javax.management.NotCompliantMBeanException;
import java.security.PublicKey;
import java.util.*;
import java.util.ArrayList;

class Doctores{
    HashMap<String, String> DocHor = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    String hor;
    String name;

    public Doctores(){
        DocHor.put("9:00","Jorge");
        DocHor.put("14:00","Gabriel");
        DocHor.put("18:00","Lucia");
    }


    public void SetDoc(){
        System.out.printf("Introduce el nombre del Doctor: ");
        name = scan.nextLine();

        System.out.printf("Introduce el horario del Doctor: ");
        hor= scan.nextLine();

        DocHor.put(name,hor);
    }

    public HashMap GetDoc(){
        return DocHor;
    }


}
class Pacientes{

    HashMap<String, String> PacHor = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    String hor;
    String name;

    public Pacientes(){
        PacHor.put("Laura","9:00");
        PacHor.put("Daniel","16:00");
        PacHor.put("Francisco","21:00");
    }

    public String SetPac(){

        System.out.printf("Introduce el nombre del Paciente: ");
        name = scan.nextLine();


        System.out.printf("Introduce el horario del Paciente: ");
        hor= scan.nextLine();

        PacHor.put(hor,name);
        return hor;

    }

    public void DelPac(){
        name = scan.nextLine();
        PacHor.remove(name);
        System.out.printf("El paciente "+name+" se dio de alta");
    }

    public HashMap GetPac(){
        return PacHor;
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Properties
        Doctores doctores =new Doctores();
        Pacientes pacientes = new Pacientes();

        //Variables
        String validUsers[]={"123","456"};
        boolean On=false;
        String usuario;
        String opt;

        //Lineas de separacion
        String line ="\n====================\n";
        String line2 ="\n_____________________\n";

        //Nombre
        System.out.print(line);
        System.out.print("Introdusca el usuario: \n");
        usuario= scan.nextLine();
        System.out.print(line);

        for (String s : validUsers)
        {
            if (usuario.equals(s))
            {
                do {
                //Opcion
                System.out.print(line);
                System.out.print("Que desea hacer? \nA)Introducir Doctores \nB)Dar Paciente de alta \nC)Agendar cita \nD)Salir \n...");
                opt= scan.nextLine();
                System.out.print(line);
                switch (opt.toLowerCase())
                    {
                        case "a":
                            System.out.println(line2);
                            System.out.print("Los doctores que tenemos de momento son: \n");
                            System.out.println(doctores.GetDoc());
                            doctores.SetDoc();
                            System.out.println(line2);
                            break;

                        case "b":
                            System.out.println(line2);
                            System.out.println("Estos son los pacientes actuales: ");
                            System.out.println(pacientes.GetPac());
                            System.out.println("A cual desea dar de alta?");
                            pacientes.DelPac();
                            System.out.println(line2);
                            break;

                        case "c":
                            System.out.println(line2);

                            String X;
                            X= pacientes.SetPac();

                            if (doctores.GetDoc().containsKey(X))
                            {
                                System.out.println("Su cita se agendo con el doctor ");
                                System.out.println(doctores.GetDoc().get(X));
                            }
                            else {
                                System.out.println("De momento ningun Doctor tiene ese horario disponible, tenemos disponible estos horarios: ");
                                System.out.println(doctores.GetDoc());
                            }

                            System.out.println(line2);
                            break;

                        case "d":
                            System.out.println(line2);
                            System.out.println("Gracias por haber usado el sistema...");
                            On=true;
                            System.out.println(line2);
                            break;

                        default:
                            System.out.print(line2);
                            System.out.println("Porfavor selecciona una de las opcionas A) B) C) o D)");
                            opt=scan.nextLine();
                            System.out.print(line2);
                    }

                } while (!On);
            }
            else{ System.out.print("Usuario no valido \n..."); }
        }
    }
}