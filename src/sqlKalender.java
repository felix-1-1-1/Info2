
import java.sql.*;

public class sqlKalender {
    Connection conn;
    String url = "jdbc:mysql://laptop-fz:3306/informatik projekt";
    String user = "root";
    String password = "123";

    public sqlKalender() {

    }


    int rowCount() {

        int rowCount = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT COUNT(*)  FROM `kalendar` ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                rowCount = rs.getInt(1);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return rowCount;
    }


    String[] allDates() {

        String[] allDates = new String[0];


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT  Datum,Termin, Erledigt FROM `kalendar` ORDER BY Datum ASC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();
            allDates = new String[(columns) * rowCount()];


            int arrayIndex = 0;

            for (int i = 0; i < rowCount(); i++) {
                while (rs.next()) {
                    for (int ax = 0; ax < 2; ax++) {

                        allDates[arrayIndex] = rs.getString("Datum");

                        allDates[arrayIndex + 1] = rs.getString("Termin");

                        allDates[arrayIndex + 2] = rs.getString("Erledigt");
                    }
                    arrayIndex += 3;
                }
            }


            rs.close();
            stmt.close();

        } catch (SQLException ex) {            System.err.println(ex);


        }
        return allDates;
    }


    void printArray(String  [] a) {
        for (String s : a) {
            System.out.println(s);
        }
    }


}




