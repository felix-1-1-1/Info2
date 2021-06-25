import java.sql.*;
public class sqlConn
{
    String url = "jdbc:mysql://laptop-fz:3306/informatik projekt";
    String user = "root";
    String password = "123";

    Connection conn;

    public sqlConn()
    {establishConnection();}

    void establishConnection()
    {
        try(Connection conn2 = DriverManager.getConnection(url, user, password))
        {
            conn = conn2;
        }
        catch (SQLException ex){}
    }
}
