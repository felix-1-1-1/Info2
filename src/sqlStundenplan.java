import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class sqlStundenplan {
    Connection conn;
    String url ;
    String user ;
    String password;

    sqlGlobalAdmin sGA;
    public sqlStundenplan() {
        sGA = new sqlGlobalAdmin();
        url = sGA.adress;
        user = sGA.username;
        password = sGA.password;
    }




    //Fach mittels Stunde und Tag eindeutig abrufen
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


    //Kalender ändern
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

    //Runden
    double round(double number, int digits) {
        return Math.round(number * Math.pow(10, digits)) / Math.pow(10, digits);

    }
    public void resetDay(String Tag)
    {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            {
                String query = "TRUNCATE `"+ Tag +"`";
                Statement stmt = conn.createStatement();
                int rs = stmt.executeUpdate(query);
            }


        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }
    }
    public void resetData()
    {
      resetDay("montag");
      resetDay("dienstag");
      resetDay("mittwoch");
      resetDay("donnerstag");
      resetDay("freitag");
    }
    public void dummy()
    {
        String tag;
        for(int j=0;j<5;j++) {
            switch (j) {
                case 0 -> {
                    tag = "Montag";
                    for (int i = 1; i < 12; i++) {
                        if (i == 7) i = 8;
                        alterTable(randomFach(), tag, i);
                    }
                }
                case 1 -> {
                    tag = "Dienstag";
                    for (int i = 1; i < 12; i++) {
                        if (i == 7) i = 8;
                        alterTable(randomFach(), tag, i);
                    }
                }
                case 2 -> {
                    tag = "Mittwoch";
                    for (int i = 1; i < 7; i++) {
                        if (i == 7) i = 8;
                        alterTable(randomFach(), tag, i);
                    }
                }
                case 3 -> {
                    tag = "Donnerstag";
                    for (int i = 1; i < 10; i++) {
                        if (i == 7) i = 8;
                        alterTable(randomFach(), tag, i);
                    }
                }
                case 4 -> {
                    tag = "Freitag";
                    for (int i = 1; i < 7; i++) {
                        if (i == 7) i = 8;
                        alterTable(randomFach(), tag, i);
                    }
                }
            }
    }


    }
    String randomFach()
    {
        String fach;
        fach = "Informatik";
        Random ran = new Random();
        int x = ran.nextInt(15);
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
            case 14 -> "Sport";
            default -> fach;
        };
        return fach;
    }

}
