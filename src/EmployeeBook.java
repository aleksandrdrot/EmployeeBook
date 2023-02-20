import java.util.Scanner;

public class EmployeeBook {
    ExceptionErrors er = new ExceptionErrors();
    Scanner input = new Scanner(System.in);
    int arrlength = 10;  // устанавливаем размерность списка
    private Employee[] employee = new Employee[arrlength];
    private int count = 0;


    public void start(){
        System.out.print(" Добавить - 1\n Удалить - 2\n Найти - 3\n Найти по отделам - 4\n Найти с меньшей зарплатой - 5\n " +
                "Найти с большей зарплатой - 6\n Общая сумма зарплат - 7\n Среднее значение зарплаты - 8\n Изменить зарплату - 9\n Изменить отдел - 10\n" +
                " Список всех сотрудников - 11\n ");
        System.out.print("Выберите действие: ");
        int level = input.nextInt();
        switch (level){
            case 1: addEmployee(); break;
            case 2: deleteEmployee(); break;
            case 3: int index = searchEmployee(); employee[index].print(); break;
            case 4: searchDepartment(); break;
            case 5: minSalary(); break;
            case 6: maxSalary(); break;
            case 7: allSalary(); break;
            case 8: averageSalary(); break;
            case 9: changeSalary(); break;
            case 10: changeDepartment(); break;
            case 11: printAllPiople(); break;
        }
        System.out.println();
        start();
    }
/*
    public void addEmployee(String firstName, String lastName, String middleName, int salary, int department) {
        if (count >= employee.length) {
            System.out.println("Нельзя добавить сотрудника, закончилось место");
        }
        Employee newEmployee = new Employee(firstName,lastName,middleName,salary,department);
        employee[count++] = newEmployee;

    }

 */

    public void addEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите Фамилию: ");
        String lastName = input.nextLine();
        System.out.print("Введите Имя: ");
        String firstName = input.nextLine();
        System.out.print("Введите Отчество: ");
        String middleName = input.nextLine();
        System.out.print("Сумма зарплаты: ");
        int salary = input.nextInt();
        System.out.print("Отдел №: ");
        int department = input.nextInt();

        if (firstName.isEmpty() || lastName.isEmpty() || middleName.isEmpty() || salary == 0 || department == 0){
            er.error1();
            start();
        }else {
            Employee newEmployee = new Employee(firstName,lastName,middleName,salary,department);
            employee[count++] = newEmployee;
            if (count == arrlength) {
                er.error2();
                start();
            }
        }
        System.out.println("\n Сотрудник добавлен! \n");
    }

    public int searchEmployee(){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите Фамилию: ");
        String lastName = input.nextLine();
        System.out.print("Введите Имя: ");
        String firstName = input.nextLine();
        System.out.print("Введите Отчество: ");
        String middleName = input.nextLine();
        int index = 0;
        for (;index < count;) {
            if (employee[index].getFirstName().equals(firstName)){
                if (employee[index].getLastName().equals(lastName)){
                    if (employee[index].getMiddleName().equals(middleName)){
                        break;
                    }
                }
            }
            index++;
            if (index == count){
                er.error3();
                start();
            }
        }
        return index;
    }

    public void searchDepartment(){
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведите намер отдела: ");
        int indexDeportment = input.nextInt();
        boolean piople = true;
        for (int index = 0; index < count; index++){
            if (indexDeportment == employee[index].getDepartment()){
                piople = false;
                employee[index].print();
            }
        }
        if (piople){er.error3();}
    }

    public void deleteEmployee(){
        int index = searchEmployee();
        employee[index] = null;
        count--;
        System.out.println("\nСотрудник удален!\n\n");
    }

    public void minSalary() {
        int index = 0;
        int salary = employee[0].getSalary();
        for (int i = 0; i < count;i++) {
            if (salary > employee[i].getSalary()) {
                salary = employee[i].getSalary();
                index = i;
            }
        }
        System.out.println("Наименьшая зарплата у:");
        employee[index].print();
    }

    public void maxSalary() {
        int index = 0;
        int salary = employee[0].getSalary();
        for (int i = 0; i < count;i++) {
            if (salary < employee[i].getSalary()) {
                salary = employee[i].getSalary();
                index = i;
            }
        }
        System.out.println("Наибольшая зарплата у:");
        employee[index].print();
    }

    public void averageSalary(){
        float salary = 0f;
        for (int i = 0; i < count; i++){
            salary += employee[i].getSalary();
        }
        System.out.println("Средняя зарплата: "+ salary/count + "\n");
    }

    public void allSalary(){
        int salary = 0;
        for (int i = 0; i < count; i++){
            salary += employee[i].getSalary();
        }
        System.out.println("\nСумма необходимая для зарплаты - "+ salary + "\n");
    }

    public void changeSalary(){
        int index = searchEmployee();
        employee[index].print();
        System.out.print("Введите сумму: ");
        int sum = input.nextInt();
        employee[index].setSalary(sum);
        employee[index].print();
        System.out.print("Зарплата изменена!\n ");
    }

    public void changeDepartment(){
        int index = searchEmployee();
        employee[index].print();
        System.out.print("Введите отдел: ");
        int dep = input.nextInt();
        employee[index].setDepartment(dep);
        employee[index].print();
        System.out.print("Отдел изменен!\n ");
    }

    public void printAllPiople(){
        for (int i = 0;i < count;i++){
            employee[i].print();
        }
    }

}
