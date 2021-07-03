import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class sqlNoten {
    Connection conn;

    public sqlNoten() {

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

    double getGradesMündlich(String Fach) {


        double averageMündl = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            String query = "SELECT Fach, AVG(Punktzahl) FROM noten WHERE Typ = 'Mündlich'AND FACH = " + "'" + Fach + "'";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    averageMündl = rs.getDouble(2);

                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

        return round(averageMündl, 2);
    }

    double getGradesSchriftlich(String Fach) {


        double averageSchriftl = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            String query = "SELECT Fach, AVG(Punktzahl) FROM noten WHERE Typ = 'Schriftlich' GROUP BY Fach HAVING Fach=" + "'" + Fach + "'";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    averageSchriftl = rs.getDouble(2);
                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

        return round(averageSchriftl,2);
    }

    double getGradesAll() {


        double avgAll = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            String query = "select avg(mw) from\n" +
                    "(SELECT avg(Punktzahl) as MW FROM `noten` WHERE typ = \"Mündlich\"\n" +
                    "union ALL\n" +
                    "SELECT  avg(Punktzahl) as MW FROM `noten` WHERE typ = \"Schriftlich\") as Untertab1";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columns = rs.getMetaData().getColumnCount();


            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    avgAll = rs.getDouble(1);
                }
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

        return round(avgAll,2);
    }



    double getGradesCombined(String Fach) {
        double averageCombined;

        averageCombined = (getGradesSchriftlich(Fach)+getGradesMündlich(Fach))/2;

        return round(averageCombined,2);
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


    double round(double number, int digits) {
        return   Math.round(number * Math.pow(10, digits)) / Math.pow(10, digits);
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
