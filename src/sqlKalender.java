
import java.sql.*;
import java.util.Random;

public class sqlKalender {
    Connection conn;
    String url ;
    String user ;
    String password;

    sqlGlobalAdmin sGA;

    public sqlKalender() {
        //SQL Paramter Abrufen
        sGA = new sqlGlobalAdmin();
        url = sGA.adress;
        user = sGA.username;
        password = sGA.password;

    }


    int rowCount() {

        int rowCount = 0;

        //Verbindung SQL Datenbank
        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;

            //sql query and connection

            String query = "SELECT COUNT(*)  FROM `kalendar`WHERE Datum >= CURRENT_DATE() ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (rs.next()) {
                //Daten aus Abfrage abrufen
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
        //Alle Termine in String Array ausgeben

        String[] allDates = new String[0];


        try (Connection conn2 = DriverManager.getConnection(url, user, password)) {
            conn = conn2;
            //SQL Abfrage
            String query = "SELECT  Datum,Termin FROM `kalendar` WHERE Datum >= CURRENT_DATE() ORDER BY Datum ASC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            int columns = rs.getMetaData().getColumnCount();
            allDates = new String[(columns) * rowCount()];


            int arrayIndex = 0;
            //Daten in Array kopieren
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

//Array ausgeben (Debug)
    void printArray(String  [] a) {
        for (String s : a) {
            System.out.println(s);
        }
    }

    //Termin hinzufügen
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
        fach = switch (x) {
            case 0 -> "Deutsch Test";
            case 1 -> "Mathe Klausur";
            case 2 -> "Englisch Vokabeltest";
            case 3 -> "Physik Abfrage";
            case 4 -> "P-Seminar Treffen";
            case 5 -> "W-Seminar Besprechung";
            case 6 -> "Informatik Ex";
            case 7 -> "Wirtschaft Test";
            case 8 -> "Geographie Klausur";
            case 9 -> "Geschichte Exkursion";
            case 10 -> "Sozialkunde Ex";
            case 11 -> "Französisch Vokabeltest";
            case 12 -> "Latein Vokabeltest";
            case 13 -> "Russisch Vokabeltest";
            default -> fach;
        };
        return fach;
    }
    }






