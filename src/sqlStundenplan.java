import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sqlStundenplan {
    Connection conn;
    String url = "jdbc:mysql://laptop-fz:3306/informatik projekt";
    String user = "root";
    String password = "123";
    public sqlStundenplan() {

    }

    public static void main(String[] args) {
        sqlStundenplan sqlStundenplan = new sqlStundenplan();
        System.out.print(sqlStundenplan.getSubject(1, "Montag"));
        sqlStundenplan.alterTable("", "Dienstag", 11);
    }

    String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    String getSubject(int lesson, String day) {

        String result = "";


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT Fach FROM " + day + " WHERE Stunde=" + lesson;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    result = rs.getString(1);

                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

        return result;
    }


    void alterTable(String Fach, String Tag, int Stunde) {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            {
                String query = "INSERT INTO `" + Tag + "` (`PK`,  `Stunde`,  `Fach`) VALUES (NULL, '" + Stunde + "', '" + Fach + "');";
                Statement stmt = conn.createStatement();
                int rs = stmt.executeUpdate(query);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }


    double round(double number, int digits) {
        return Math.round(number * Math.pow(10, digits)) / Math.pow(10, digits);

    }

}
