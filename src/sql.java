import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class sql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8080/informatik+projekt";
        String user ="root";
        String password = "";
        System.out.println("Meddl");
        //DriverManager.getConnection(url, user, password);
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            System.out.println("Verbindung");
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }
}
