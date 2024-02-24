import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements OdontologoDAO {

    private Connection connection;

    public OdontologoDAOH2() {
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            crearTabla();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void crearTabla() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Odontologo (" +
                    "numeroMatricula INT PRIMARY KEY, " +
                    "nombre VARCHAR(50), " +
                    "apellido VARCHAR(50))";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardarOdontologo(Odontologo odontologo) {
        try {
            PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO Odontologo (numeroMatricula, nombre, apellido) VALUES (?, ?, ?)");
            stmt.setInt(1, odontologo.getNumeroMatricula());
            stmt.setString(2, odontologo.getNombre());
            stmt.setString(3, odontologo.getApellido());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        List<Odontologo> odontologos = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Odontologo");
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(
                        rs.getInt("numeroMatricula"),
                        rs.getString("nombre"),
                        rs.getString("apellido")
                );
                odontologos.add(odontologo);
            }
            stmt.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return odontologos;
    }
}
