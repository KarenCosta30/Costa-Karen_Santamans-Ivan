import java.util.List;

public class Main {
    public static void main(String[] args) {

        OdontologoDAO odontologoDAOH2 = new OdontologoDAOH2();
        OdontologoDAO odontologoDAOCollection = new OdontologoDAOCollection();


        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Maria", "Gomez");


        odontologoDAOH2.guardarOdontologo(odontologo1);
        odontologoDAOH2.guardarOdontologo(odontologo2);


        odontologoDAOCollection.guardarOdontologo(odontologo1);
        odontologoDAOCollection.guardarOdontologo(odontologo2);


        List<Odontologo> odontologosH2 = odontologoDAOH2.listarOdontologos();
        List<Odontologo> odontologosCollection = odontologoDAOCollection.listarOdontologos();


        System.out.println("Odontólogos en H2:");
        for (Odontologo odontologo : odontologosH2) {
            System.out.println(odontologo.getNombre() + " " + odontologo.getApellido());
        }

        System.out.println("Odontólogos en la colección:");
        for (Odontologo odontologo : odontologosCollection) {
            System.out.println(odontologo.getNombre() + " " + odontologo.getApellido());
        }
    }
}
