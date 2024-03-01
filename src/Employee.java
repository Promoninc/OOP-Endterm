public class Employee extends Person {
    String toStr() {
        return "Employee: " + getId() + ". " + getName() + " " + getSurname() + " " + getPosition() + " " + getPaymentAmount();
    }

    double getSalary() {
        return getPaymentAmount();
    }

    void setSalary(double salaryInput) {
        setPaymentAmount(salaryInput);
    }

    public String getType() {
        return "Employee";
    }

    Employee(String nameC, String surNameC) {
        setName(nameC);
        setSurname(surNameC);
    }

    Employee(String nameC, String surNameC, String positionC, double salaryC) {
        setName(nameC);
        setSurname(surNameC);
        setPosition(positionC);
        setSalary(salaryC);
    }
}