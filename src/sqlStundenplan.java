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
        switch(j) {
        case 0: tag = "Montag";
            for (int i = 1; i < 12; i++) {
                if(i==7)i=8;
                alterTable(randomFach(),tag, i);
            }break;
            case 1: tag = "Dienstag";
                for (int i = 1; i < 12; i++) {
                    if(i==7)i=8;
                    alterTable(randomFach(),tag, i);
                }break;
            case 2: tag = "Mittwoch";
                for (int i = 1; i < 7; i++) {
                    if(i==7)i=8;
                    alterTable(randomFach(),tag, i);
                }break;
            case 3: tag = "Donnerstag";
                for (int i = 1; i < 10; i++) {
                    if(i==7)i=8;
                    alterTable(randomFach(),tag, i);
                }break;
            case 4: tag = "Freitag";
                for (int i = 1; i < 7; i++) {
                    if(i==7)i=8;
                    alterTable(randomFach(),tag, i);
                }break;
        }
    }


    }
    String randomFach()
    {
        String fach;
        fach = "Informatik";
        Random ran = new Random();
        int x = ran.nextInt(14);
        switch(x){
            case 0: fach ="Deutsch"; break;
            case 1: fach ="Mathe";break;
            case 2: fach ="Englisch";break;
            case 3: fach ="Physik";break;
            case 4: fach ="P-Seminar";break;
            case 5: fach ="W-Seminar";break;
            case 6: fach ="Informatik";break;
            case 7: fach ="Wirtschaft";break;
            case 8: fach ="Geographie";break;
            case 9: fach ="Geschichte";break;
            case 10: fach ="Sozialkunde";break;
            case 11: fach ="Französisch";break;
            case 12: fach ="Latein";break;
            case 13: fach ="Russisch";break;
        }
        return fach;
    }

}
