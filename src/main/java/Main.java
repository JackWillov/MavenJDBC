import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mysqldatabes";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String frd = "delete from persons where personid=1";

    public Main() {
    }

    public static void main(String[] args) {

        Connection con = null;
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  * from Persons");
            ContactRepositoryImpl repository = new ContactRepositoryImpl(statement, con);
List<Contact> list = repository.getContacts();
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getPersoID());
                System.out.println(list.get(i).getLastName());
                System.out.println(list.get(i).getAdres());
                System.out.println(list.get(i).getFirstName());
            }


            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}

