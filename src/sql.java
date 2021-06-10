import java.sql.*;

public class sql {
    public static void main(String[] args) {
        sql sql = new sql();
        sql.getGradesMündlich("Deutsch");
        //sql.getGradesSchriftlich("Deutsch");
        //sql.executeQuery();
        System.out.println("TEST: "+sql.getGradesMündlich("Deutsch"));

    }

    public sql()
    {

    }
    Connection conn;


    double getGradesMündlich(String Fach)
    { String url = "jdbc:mysql://localhost:3306/informatik projekt";
        String user ="root";
        String password = "";

        double averageMündl = 0;


        try(Connection conn2 = DriverManager.getConnection(url, user, password)){
            conn = conn2;
            System.out.println("Verbindung");

            String query = "SELECT Fach, AVG(Punktzahl) FROM noten WHERE Typ = 'Mündlich' GROUP BY Fach HAVING Fach=" + "'"+Fach+"'";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("query");

            int columns = rs.getMetaData().getColumnCount();
           // for(int i = 1; i<=columns; i++)
             //   System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));

           // System.out.println();
            //System.out.println("-----------------------------------");

            while(rs.next()) {
                for(int i = 1; i<=columns; i++)
                {
                    averageMündl = rs.getDouble(2);
                   // System.out.print(String.format("%-15s", rs.getString(i)));
                System.out.println();
            }}
            rs.close();
            stmt.close();

        }

        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }

    return averageMündl;}


    void getGradesSchriftlich(String Fach)
    { String url = "jdbc:mysql://localhost:3306/informatik projekt";
        String user ="root";
        String password = "";


        try(Connection conn2 = DriverManager.getConnection(url, user, password)){
            conn = conn2;
            System.out.println("Verbindung");

            String query = "SELECT Fach, AVG(Punktzahl) FROM noten WHERE Typ = 'Schriftlich' GROUP BY Fach HAVING Fach=" + "'"+Fach+"'";
            Statement stmt = conn.createStatement();
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("query");

            int columns = rs.getMetaData().getColumnCount();
            for(int i = 1; i<=columns; i++)
                System.out.print(String.format("%-15s", rs.getMetaData().getColumnLabel(i)));

            System.out.println();
            System.out.println("-----------------------------------");

            while(rs.next()) {
                for(int i = 1; i<=columns; i++)
                    System.out.print(String.format("%-15s", rs.getString(i)));
                System.out.println();
            }

            rs.close();
            stmt.close();

        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            System.out.println("fail");
        }}



    void executeQuery()
    {
        try {
        String query = "SELECT * FROM noten";
        Statement stmt = conn.createStatement();
        stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println("query");
        }
        catch (SQLException ex){System.out.println("fail");}
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
