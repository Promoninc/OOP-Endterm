public class Person implements Payable, Comparable<Person> {
    private int id;
    private static int idCount = 1;
    private String name;
    private String surname;
    private String position = "Person";
    private double paymentAmount = 0;

    String toStr() {
        return "Person: " + id + ". " + name + " " + surname + " " + getPaymentAmount();
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setName(String nameInput) {
        name = nameInput;
    }

    static void setIdCount(int idC) {
        idCount = idC;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surnameInput) {
        surname = surnameInput;
    }

    Person() {
        this.id = idCount;
        idCount++;
    }

    Person(String nameC, String surnameC) {
        this.id = idCount;
        idCount++;
        setName(nameC);
        setSurname(surnameC);
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double money) {
        paymentAmount = money;
    }

    public void setPosition(String pos) {
        position = pos;
    }

    String getPosition() {
        if (this.getClass() == Student.class) {
            setPosition("Student");
        }
        return position;
    }

    void setSalary(double salary) {
        setPaymentAmount(salary);
    }

    void setGpa(double gpa) {

    }

    double getGpa() {
        return 0;
    }

    @Override
    public int compareTo(Person o) {
        if (this.getPaymentAmount() > o.getPaymentAmount()) {
            return 1;
        } else {
            return -1;
        }
    }

    public String getType() {
        return "Person";
    }
}

