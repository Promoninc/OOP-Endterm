public class Student extends Person {
    private double gpa;

    double getGpa() {
        return gpa;
    }

    void setGpa(double gpaInput) {
        gpa = gpaInput;
        if (gpa > 2.67) {
            setPaymentAmount(42000);
        } else {
            setPaymentAmount(0);
        }
    }

    String toStr() {
        return "Student: " + getId() + ". " + getName() + " " + getSurname() + " " + getPaymentAmount();
    }

    public String getType() {
        return "Student";
    }

    Student(String nameC, String surnameC) {
        setName(nameC);
        setSurname(surnameC);
    }

    Student(String nameC, String surnameC, double gpaC) {
        setName(nameC);
        setSurname(surnameC);
        setGpa(gpaC);
    }
}