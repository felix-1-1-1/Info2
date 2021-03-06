import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class sqlNoten {
    Connection conn;
    String url ;
    String user ;
    String password;

    sqlGlobalAdmin sGA;
    public sqlNoten() {
        sGA = new sqlGlobalAdmin();
        url = sGA.adress;
        user = sGA.username;
        password = sGA.password;

    }

    //Aktuelles Datum ausgeben
    String getDate()  {
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

        return round(averageSchriftl, 2);
    }

    double getGradesAll() {


        double avgAll = 0;


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            String query = "SELECT AVG(mw) from (SELECT avg(Punktzahl) as MW FROM `noten` WHERE typ = 'Mündlich' union ALL SELECT  avg(Punktzahl) as MW FROM `noten` WHERE typ = 'Schriftlich') as Untertab1";
            Statement stmt = conn.createStatement();
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

        return round(avgAll, 2);
    }


    double getGradesCombined(String Fach) {
        double averageCombined;

        averageCombined = (getGradesSchriftlich(Fach) + getGradesMündlich(Fach)) / 2;

        return round(averageCombined, 2);
    }

    void addGrade(String Fach, int Punktzahl, String Typ) {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            if (Punktzahl != -1) {
                String query = "INSERT INTO `noten` (`PK`,  `Fach`, `Datum`, `Punktzahl`, `Typ`) VALUES (NULL, '" + Fach + "', '" + getDate() + "', '" + Punktzahl + "', '" + Typ + "');";
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
    public void resetData()
    {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            {
                String query = "TRUNCATE `noten`";
                Statement stmt = conn.createStatement();
                int rs = stmt.executeUpdate(query);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }
    public void dummy(int anzahl)
    {
        if(anzahl>=100)anzahl=99;
        for(int i=0;i<anzahl;i++)
        {
            String mos="Schriftlich";
            Random ran = new Random();
            int grade = 00 + ran.nextInt(15 - 00 + 1);
            int ms = ran.nextInt(2); // Mündlich oder Schriftliche Note
            switch (ms) {
                case 0 -> mos = "Mündlich";
                case 1 -> mos = "Schriftlich";
            }
            addGrade(randomFach(),grade,mos);

        }


    }
    String randomFach()
    {
        String fach;
        fach = "Informatik";
        Random ran = new Random();
        int x = ran.nextInt(14);
        fach = switch (x) {
            case 0 -> "Deutsch";
            case 1 -> "Mathe";
            case 2 -> "Englisch";
            case 3 -> "Physik";
            case 4 -> "P-Seminar";
            case 5 -> "W-Seminar";
            case 6 -> "Informatik";
            case 7 -> "Wirtschaft";
            case 8 -> "Geographie";
            case 9 -> "Geschichte";
            case 10 -> "Sozialkunde";
            case 11 -> "Französisch";
            case 12 -> "Latein";
            case 13 -> "Russisch";
            default -> fach;
        };
    return fach;
    }


}
