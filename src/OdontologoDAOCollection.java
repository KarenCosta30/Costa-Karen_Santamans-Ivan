import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOCollection implements OdontologoDAO {

    private List<Odontologo> odontologos = new ArrayList<>();

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        odontologos.add(odontologo);
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return new ArrayList<>(odontologos);
    }
}
