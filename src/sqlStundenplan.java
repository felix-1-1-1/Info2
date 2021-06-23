import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class sqlStundenplan {
    Connection conn;

    public static void main(String[] args) {
        sqlStundenplan sqlStundenplan = new sqlStundenplan();
        System.out.print(sqlStundenplan.getSubject(1, "Montag"));
    }

    public sqlStundenplan() {

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

    String getSubject(int lesson, String day) {

    String result="";


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT Fach FROM "+day+ " WHERE Stunde="+lesson;
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
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


    double round(double number, int digits)
    {
        double result = Math.round(number*Math.pow(10,digits))/Math.pow(10, digits);
        return result;
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
