import java.sql.*;

public class sql {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:8080/informatik+projekt";
        String user ="root";
        String password = "";
        System.out.println("Meddl");
        //DriverManager.getConnection(url, user, password);
        try(Connection conn = DriverManager.getConnection(url, user, password)){
            //System.out.println("Verbindung");
            String query = "SELECT * FROM noten";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();
            for(int i = 1; i<=columns; i++)
                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));

            System.out.println();
            System.out.println("----------------------------------------------------------------");

            while(rs.next()) {
                for(int i = 1; i<=columns; i++)
                    System.out.print(String.format("%-15s", rs.getString(i)));
                System.out.println();
            }

            rs.close();
            stmt.close();
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }
}