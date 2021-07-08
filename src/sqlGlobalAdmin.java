public class sqlGlobalAdmin {
    String adress;
    String password;
    String username;

    //Globale Variablen für SQL Datenbank festlegen (zentrale Verwaltung)
    public sqlGlobalAdmin()
    {
        adress= "jdbc:mysql://localhost:3306/informatik projekt";
        username = "root";
        password = "";
    }
}
