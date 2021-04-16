package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SabanaNominaTest {

    private static List<Employee> Engineeringemployees;
    private static List<Employee> FinancesEmployees;
    private static List<Employee> SalesEmployees;
    private static List<Employee> employees;
    private static List<Department> departments;

    private static Department department;
    private static Department department2;
    private static Department department3;

    private static SabanaPayroll sabanaPayroll;

    private static EmployeeBySalary employeeBySalary;
    private static EmployeeByHours employeeByHours;
    private static EmployeeByCommission employeeByCommission;
    private static EmployeeBySalary employeeBySalary2;
    private static EmployeeByHours employeeByHours2;
    private static EmployeeByCommission employeeByCommission2;
    private static EmployeeBySalary employeeBySalary3;
    private static EmployeeByHours employeeByHours3;
    private static EmployeeByCommission employeeByCommission3;
    private static Employee employee1;
    private static Employee employee2;
    private static Employee employee3;
    private static Employee employee4;
    private static Employee employee5;



    @BeforeAll
    public static void setUp(){

        department = new Department("Engineering");

        employeeBySalary = new EmployeeBySalary("Sebastian", "Padilla", department, 1200000);
        employeeByHours = new EmployeeByHours("Camila", "Ramirez", department, 160);
        employeeByCommission = new EmployeeByCommission("Laura", "Beltrán", department, 156);

        Engineeringemployees = new ArrayList<>();
        Engineeringemployees.add(employeeBySalary);
        Engineeringemployees.add(employeeByHours);
        Engineeringemployees.add(employeeByCommission);

        department2 = new Department("Finances");

        employeeBySalary2 = new EmployeeBySalary("Pepe", "Gonzalez", department2, 1400000);
        employeeByHours2 = new EmployeeByHours("Juan", "Perez", department2, 360);
        employeeByCommission2 = new EmployeeByCommission("Martin", "Garcia", department2, 90);

        FinancesEmployees = new ArrayList<>();
        FinancesEmployees.add(employeeBySalary2);
        FinancesEmployees.add(employeeByHours2);
        FinancesEmployees.add(employeeByCommission2);

        department3 = new Department("Sales");

        employeeBySalary3 = new EmployeeBySalary("Jorge", "Gomez", department, 2340000);
        employeeByHours3 = new EmployeeByHours("Esteban", "Peñaloza", department, 150);
        employeeByCommission3 = new EmployeeByCommission("Carolina", "Hernandez", department, 110);

        SalesEmployees = new ArrayList<>();
        SalesEmployees.add(employeeBySalary3);
        SalesEmployees.add(employeeByHours3);
        SalesEmployees.add(employeeByCommission3);

    }

    @Test
    @DisplayName("GIVEN a salaried employee WHEN calculate salary THEN get right salary")
    public void shouldCalculateSalaryBySalary(){
        assertEquals(1104000, employeeBySalary.calculateSalary());
    }

    @Test
    @DisplayName("GIVEN a employee working by hours WHEN calculate salary THEN get right salary")
    public void shouldCalculateSalaryByHours(){
        assertEquals(1040000, employeeByHours.calculateSalary());
    }

    @Test
    @DisplayName("GIVEN a employee working by commission WHEN calculate salary THEN get right salary")
    public void shouldCalculateSalaryByCommission(){
        assertEquals(2340000, employeeByCommission.calculateSalary());
    }

    @Test
    @DisplayName("GIVEN a department WHEN calculate salary THEN get department salary")
    public void shouldCalculateDepartmentSalaries(){
        department = new Department(Engineeringemployees);
        assertEquals(4484000, department.calculateDepartmentSalaries());
    }

    @Test
    @DisplayName("GIVEN the Sabana University WHEN calculate salary THEN get university salary")
    public void shouldCalculateUniversitySalaries(){
        department = new Department(Engineeringemployees);
        department2 = new Department(FinancesEmployees);
        department3 = new Department(SalesEmployees);

        departments = new ArrayList<>();
        departments.add(department);
        departments.add(department2);
        departments.add(department3);

        sabanaPayroll = new SabanaPayroll(employees, departments);
        assertEquals(14239800, sabanaPayroll.calculateUniversitySalaries());

    }

    @Test
    @DisplayName("GIVEN a employees WHEN toString THEN get right print format")
    public void shouldPrintEmployees(){
        employees = new ArrayList<>();
        employees.add(employeeByHours2);
        employees.add(employeeBySalary3);
        employees.add(employeeByCommission);

        sabanaPayroll = new SabanaPayroll(employees, departments);
        sabanaPayroll.printPayroll();

    }

    @Test
    @DisplayName("GIVEN a employee WHEN deposit to account THEN right deposit to account")
    public void shouldDepositToEmployee(){
        Check check = new Check(80000, LocalDate.now().plusMonths(1));
        BankAccount account = new Checking();
        employee1 = new EmployeeByCommission("Laura", "Pulido", department, 180, account);
        assertTrue(employee1.depositToEmployee(account, check, 0 ));
    }

    @Test
    @DisplayName("GIVEN a employee WHEN calculate balance THEN get right balance")
    public void shouldCalculateEmployeeBalance(){
        Check check = new Check(50000, LocalDate.now().plusMonths(2));
        BankAccount account = new Checking();
        double amount = 0;
        employee2 = new EmployeeByCommission("Javier", "Estrada", department2, 170, account);
        assertTrue(employee2.depositToEmployee(account, check, 0 ));
        assertEquals(90000, employee2.calculateEmployeeBalance(account, check, amount));
    }

}
