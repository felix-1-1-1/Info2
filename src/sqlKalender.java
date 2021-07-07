
import java.sql.*;
import java.util.Random;

public class sqlKalender {
    Connection conn;
    String url ;
    String user ;
    String password;

    sqlGlobalAdmin sGA;

    public sqlKalender() {
        sGA = new sqlGlobalAdmin();
        url = sGA.adress;
        user = sGA.username;
        password = sGA.password;

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

            String query = "SELECT  Datum,Termin FROM `kalendar` ORDER BY Datum ASC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();
            allDates = new String[(columns) * rowCount()];


            int arrayIndex = 0;

            for (int i = 0; i < rowCount(); i++) {
                while (rs.next()) {
                    for (int ax = 0; ax < 1; ax++) {

                        allDates[arrayIndex] = rs.getString("Datum");

                        allDates[arrayIndex + 1] = rs.getString("Termin");

                    }
                    arrayIndex += 2;
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

    void addDate( String Datum,String Termin) {
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            {
                String query = "INSERT INTO `kalendar` (`PI`, `Datum`, `Termin`) VALUES (NULL, '"+Datum+"', '"+Termin+"')";
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
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            {
                String query = "TRUNCATE `kalendar`";
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
           Random ran = new Random();
           int year = 2020 + ran.nextInt(2022 - 2020 + 1);
           int day = 01 + ran.nextInt(28 - 01 + 1);
           int month = 01 + ran.nextInt(12 - 01 + 1);
            addDate(year+"-"+month+"-"+day,randomVeranstaltung());
       }


    }
    String randomVeranstaltung()
    {
        String fach;
        fach = "Informatik";
        Random ran = new Random();
        int x = ran.nextInt(14);
        switch(x){
            case 0: fach ="Deutsch Test"; break;
            case 1: fach ="Mathe Klausur";break;
            case 2: fach ="Englisch Vokabeltest";break;
            case 3: fach ="Physik Abfrage";break;
            case 4: fach ="P-Seminar Treffen";break;
            case 5: fach ="W-Seminar Besprechung";break;
            case 6: fach ="Informatik Ex";break;
            case 7: fach ="Wirtschaft Test";break;
            case 8: fach ="Geographie Klausur";break;
            case 9: fach ="Geschichte Exkursion";break;
            case 10: fach ="Sozialkunde Ex";break;
            case 11: fach ="Französisch Vokabeltest";break;
            case 12: fach ="Latein Vokabeltest";break;
            case 13: fach ="Russisch Vokabeltest";break;
        }
        return fach;
    }
    }






