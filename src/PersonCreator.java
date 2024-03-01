public class PersonCreator {
    public Person createPerson(String type, String name, String surname) {
        Person person = null;
        switch (type) {
            case "Student":
                person = new Student(name, surname);
                break;
            case "Employee":
                person = new Employee(name, surname);
                break;
            default:
                person = new Person(name, surname);
                break;
        }
        return person;
    }

    public Person createPerson(String type, String name, String surname, double gpa) {
        Person person = null;
        switch (type) {
            case "Student":
                person = new Student(name, surname, gpa);
                break;
            default:
                person = new Person();
                break;
        }
        return person;
    }

    public Person createPerson(String type, String name, String surname, String position, double salary) {
        Person person = null;
        switch (type) {
            case "Employee":
                person = new Employee(name, surname, position, salary);
                break;
            default:
                person = new Person();
                break;
        }
        return person;
    }
}