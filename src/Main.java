import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/Endterm";
            Properties authorization = new Properties();
            authorization.put("user", "postgres");
            authorization.put("password", "perpavbek");
            Connection connection = DriverManager.getConnection(url, authorization);
            PersonManager pm = new PersonManager();
            DBManager dbManager = new DBManager(connection, pm);
            Scanner sc = new Scanner(System.in);
            while (true) {
                Menu mainMenu = new Menu("Choose an option: ",
                        Arrays.asList("Add person", "Edit person", "Delete person", "List persons"));
                mainMenu.printMenu();
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        dbManager.insertPerson();
                        break;
                    case 3:
                        dbManager.deletePerson();
                        break;
                    case 2:
                        dbManager.editPerson();
                        break;
                    case 4:
                        pm.listPersons();
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}