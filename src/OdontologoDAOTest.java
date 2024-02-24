import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OdontologoDAOTest {

    @Test
    void testListarOdontologos() {
        OdontologoDAO odontologoDAO = new OdontologoDAOH2();
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Maria", "Gomez");
        odontologoDAO.guardarOdontologo(odontologo1);
        odontologoDAO.guardarOdontologo(odontologo2);
        List<Odontologo> odontologos = odontologoDAO.listarOdontologos();
        assertEquals(2, odontologos.size());
    }
}
