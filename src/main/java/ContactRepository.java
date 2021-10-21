import java.sql.SQLException;
import java.util.List;

public interface ContactRepository {

    void save(Contact contact) throws SQLException;

    void saveBulk(List<Contact> contact);

    void update( int id);

    void delete(int id);

    List<Contact> getContacts();

    Contact getContactById(int id);

}