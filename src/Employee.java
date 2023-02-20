public class Employee {
    private String firstName = "";
    private String lastName = "";
    private String middleName = "";
    private int salary = 0;
    private int department = 0;
    private int id = 0;
    static int count = 0;

    public Employee(String firstName, String lastName, String middleName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.salary = salary;
        this.department = department;
        this.id = count;
        count++;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public void print(){
        System.out.println("Имя "+firstName + "\nФамилия " + lastName + "\nОтчество " + middleName + "\nЗарплата " + salary + "\nОтдел " + department + "\n");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }
}

