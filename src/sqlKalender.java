import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sqlKalender {
    Connection conn;

    public sqlKalender() {

    }

    public static void main(String[] args) {
        sqlKalender sqlKalender = new sqlKalender();
        System.out.println(sqlKalender.rowCount());
    }

    String url = "jdbc:mysql://laptop-fz:3306/informatik projekt";
    String user = "root";
    String password = "123";



String getDate()
{
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    return dtf.format(now);
}

    int rowCount() {

        int rowCount = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT COUNT(*)  FROM `kalendar` ";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if(rs.next())
            {            rowCount = rs.getInt(1);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
        return rowCount;
    }


    void getDates() {




        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT  Datum,Termin, Erledigt FROM `kalendar` ORDER BY Datum ASC";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();

            Object[][] dates = new Object[columns][];

            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {

                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

    }








    void addGrade(String Fach, int Punktzahl, String Typ)
    {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            if(Punktzahl!=-1)
            { String query = "INSERT INTO `noten` (`PK`,  `Fach`, `Datum`, `Punktzahl`, `Typ`) VALUES (NULL, '"+Fach+"', '"+getDate()+"', '"+Punktzahl+"', '"+Typ+"');";
                Statement stmt = conn.createStatement();
                stmt = conn.createStatement();
                int rs = stmt.executeUpdate(query);}
            else{}




        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }



    /**
     *
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

     String query = "SELECT * FROM noten";
     Statement stmt = conn.createStatement();
     stmt = conn.createStatement();
     ResultSet rs = stmt.executeQuery(query);
     */
}
