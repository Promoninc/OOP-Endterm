import java.util.ArrayList;
import java.util.Objects;
import java.sql.*;

public class DBManager {
    PersonManager pm = null;
    PersonCreator pc = new PersonCreator();
    ArrayList<Person> persons = new ArrayList<>();
    private Connection connection = null;

    DBManager(Connection c, PersonManager personManager) throws SQLException {
        this.connection = c;
        this.pm = personManager;
        readTable();
    }

    private void readTable() throws SQLException {
        ResultSet table = connection.createStatement().executeQuery("SELECT * FROM persons");
        Person person = null;
        while (table.next()) {
            Person.setIdCount(table.getInt("id"));
            if (Objects.equals(table.getString("type"), "Person")) {
                Person.setIdCount(table.getInt("id"));
                person = pc.createPerson("Person", table.getString("name"), table.getString("surname"));
                pm.persons.add(person);
            } else if (Objects.equals(table.getString("type"), "Student")) {
                Person.setIdCount(table.getInt("id"));
                person = pc.createPerson("Student", table.getString("name"), table.getString("surname"), table.getDouble("gpa"));
                pm.persons.add(person);
            } else if (Objects.equals(table.getString("type"), "Employee")) {
                person = pc.createPerson("Employee", table.getString("name"), table.getString("surname"), table.getString("position"), table.getDouble("paymentamount"));
                pm.persons.add(person);
            }
        }
    }

    public void insertPerson() {
        try {
            Person person = pm.addPerson();
            PreparedStatement st = connection.prepareStatement("INSERT INTO Persons (type, id, name, surname, position, paymentamount, gpa) VALUES (?, ?, ?, ?, ?, ?, ?)");
            st.setString(1, person.getType());
            st.setInt(2, person.getId());
            st.setString(3, person.getName());
            st.setString(4, person.getSurname());
            st.setString(5, person.getPosition());
            st.setDouble(6, person.getPaymentAmount());
            if (person.getClass() == Student.class) {
                st.setDouble(7, ((Student) person).getGpa());
            } else {
                st.setDouble(7, 0);
            }
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletePerson() throws SQLException {
        Person person = pm.deletePerson();
        ResultSet table = connection.createStatement().executeQuery("SELECT * FROM persons");
        while (table.next()) {
            if (table.getInt("id") == person.getId()) {
                PreparedStatement st = connection.prepareStatement("DELETE FROM persons WHERE id = ?");
                st.setInt(1, person.getId());
                st.executeUpdate();
                st.close();
                break;
            }
        }
    }

    public void editPerson() throws SQLException {
        Person person = pm.editPerson();
        ResultSet table = connection.createStatement().executeQuery("SELECT * FROM persons");
        PreparedStatement st = null;
        while (table.next()) {
            if (table.getInt("id") == person.getId()) {
                if (!Objects.equals(person.getName(), table.getString("name"))) {
                    st = connection.prepareStatement("UPDATE persons SET name = ? WHERE id = ?");
                    st.setString(1, person.getName());
                    st.setInt(2, person.getId());
                } else if (!Objects.equals(person.getSurname(), table.getString("surname"))) {
                    st = connection.prepareStatement("UPDATE persons SET surname = ? WHERE id = ?");
                    st.setString(1, person.getSurname());
                    st.setInt(2, person.getId());
                } else if (!Objects.equals(person.getPosition(), table.getString("position"))) {
                    st = connection.prepareStatement("UPDATE persons SET position = ? WHERE id = ?");
                    st.setString(1, person.getPosition());
                    st.setInt(2, person.getId());
                } else if (person.getPaymentAmount() != table.getDouble("paymentamount")) {
                    st = connection.prepareStatement("UPDATE persons SET paymentamount = ? WHERE id = ?");
                    st.setDouble(1, person.getPaymentAmount());
                    st.setInt(2, person.getId());
                } else if (person.getGpa() != table.getDouble("gpa")) {
                    st = connection.prepareStatement("UPDATE persons SET gpa = ? WHERE id = ?");
                    st.setDouble(2, person.getGpa());
                    st.setInt(3, person.getId());
                }
            }
        }
        if (st != null) {
            st.executeUpdate();
            st.close();
        }
    }
}
