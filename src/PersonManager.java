import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PersonManager {
    ArrayList<Person> persons = new ArrayList<>();
    PersonCreator pc = new PersonCreator();
    Scanner sc = new Scanner(System.in);

    public Person addPerson() {
        Person person = null;
        Menu menu = new Menu("Choose an type of person: ",
                Arrays.asList("Person", "Student", "Employee"));
        menu.printMenu();
        int choice = sc.nextInt();
        String name, surname;
        System.out.println("Write name: ");
        name = sc.next();
        System.out.println("Write surname: ");
        surname = sc.next();
        switch (choice) {
            case 1:
                person = pc.createPerson("Person", name, surname);
                persons.add(person);
                break;
            case 2:
                System.out.println("Write gpa: ");
                double gpa = sc.nextDouble();
                person = pc.createPerson("Student", name, surname, gpa);
                persons.add(person);
                break;
            case 3:
                System.out.println("Write position: ");
                String position = sc.next();
                System.out.println("Write salary: ");
                double salary = sc.nextDouble();
                person = pc.createPerson("Employee", name, surname, position, salary);
                persons.add(person);
                break;
            default:
                System.out.println("Incorrect!");
                break;
        }
        return person;
    }

    public void listPersons() {
        for (Person person : persons) {
            System.out.println(person.toStr());
        }
    }

    public Person deletePerson() {
        Person person = null;
        ArrayList<String> personsData = new ArrayList<>();
        for (Person personI : persons) {
            personsData.add(personI.toStr());
        }
        Menu menu = new Menu("Choose the user to delete: ", personsData);
        menu.printMenu();
        int choice = sc.nextInt() - 1;
        if (choice < 0 || choice > persons.size()) {
            System.out.println("Invalid choice!");
        } else {
            person = persons.get(choice);
            persons.remove(choice);
        }
        return person;
    }

    public Person editPerson() {
        Person person = null;
        ArrayList<String> personsData = new ArrayList<>();
        for (Person personI : persons) {
            personsData.add(personI.toStr());
        }
        Menu menu = new Menu("Choose the person: ", personsData);
        menu.printMenu();
        int personChoice = sc.nextInt() - 1;
        if (personChoice > personsData.size() || personChoice < 0) {
            System.out.println("Invalid input!");
        } else {
            int choice = 0;
            switch (persons.get(personChoice).getType()) {
                case "Person":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            person = persons.get(personChoice);
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
                case "Student":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname", "GPA"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 3:
                            System.out.println("Enter new gpa: ");
                            persons.get(personChoice).setGpa(sc.nextDouble());
                            person = persons.get(personChoice);
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
                case "Employee":
                    menu = new Menu("Choose the option to edit: ", Arrays.asList("Name", "Surname", "position", "salary"));
                    menu.printMenu();
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Enter new name: ");
                            persons.get(personChoice).setName(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 2:
                            System.out.println("Enter new surname: ");
                            persons.get(personChoice).setSurname(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 3:
                            System.out.println("Enter new position: ");
                            persons.get(personChoice).setPosition(sc.next());
                            person = persons.get(personChoice);
                            break;
                        case 4:
                            System.out.println("Enter new salary: ");
                            persons.get(personChoice).setSalary(sc.nextDouble());
                            person = persons.get(personChoice);
                            break;
                        default:
                            System.out.println("Invalid input!");
                            break;
                    }
                    break;
            }
        }
        return person;
    }
}