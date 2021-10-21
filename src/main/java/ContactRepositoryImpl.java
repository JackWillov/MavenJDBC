import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    Connection con = null;
    Statement statement = null;
    Contact cont = null;

    public ContactRepositoryImpl(Statement statement, Connection connection) {
        this.statement = statement;
        con = connection;
    }

    @Override
    public void save(Contact contact) {
        String sql = "INSERT INTO Persons VALUES ('" + contact.getPersoID() + "','" + contact.getLastName() + "','"
                + contact.getFirstName() + "','" + contact.getAdres() + "','" + contact.getCity() + "')";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact added to person table");
    }

    @Override
    public void saveBulk(List<Contact> contact) {
        for (int i = 0; i < contact.size(); i++) {
            String sql = "INSERT INTO Persons VALUES ('" + contact.get(i).getPersoID() + "','" + contact.get(i).getLastName() + "','"
                    + contact.get(i).getFirstName() + "','" + contact.get(i).getAdres() + "','" + contact.get(i).getCity() + "')";
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Contacts list added to person table");
    }

    @Override
    public void update(int id) {
        String sql = "UPDATE Persons " +
                "SET city = 'unknown' WHERE personid =" + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact updated in person table");
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Persons " +
                "WHERE personid =" + id;
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Contact deleted from person table");
    }

    @Override
    public List<Contact> getContacts() {
        List<Contact> list = new ArrayList<>();
        ResultSet rs1 = null;
        int count = 0;
        try {
            ResultSet rs = statement.executeQuery("select count(*) from Persons");
            rs.next();
            count = rs.getInt("count(*)");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 1; i < count + 1; i++) {
                Contact cont = new Contact(1, "default", "default", "default", "default");
                String query = "select PersonID, LastName, FirstNAme, Address, City from Persons where personid =" + i;
                rs1 = statement.executeQuery(query);
                while (rs1.next()) {
                    cont.setPersoID(rs1.getInt("PersonID"));
                    cont.setLastName(rs1.getString("LastName"));
                    cont.setFirstName(rs1.getString("FirstNAme"));
                    cont.setAdres(rs1.getString("Address"));
                    cont.setCity(rs1.getString("City"));
                    list.add(cont);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Contact getContactById(int id) {
        Contact cont = new Contact(1, "default", "default", "default", "default");
        String query = "select PersonID, LastName, FirstNAme, Address, City from Persons where personid =" + id;
        ResultSet rs = null;
        try {
            rs = statement.executeQuery(query);
            while (rs.next()) {
                cont.setPersoID(rs.getInt("PersonID"));
                cont.setLastName(rs.getString("LastName"));
                cont.setFirstName(rs.getString("FirstNAme"));
                cont.setAdres(rs.getString("Address"));
                cont.setCity(rs.getString("City"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cont;

    }
}
