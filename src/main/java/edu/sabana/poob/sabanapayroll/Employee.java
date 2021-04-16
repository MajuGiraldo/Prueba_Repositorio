package edu.sabana.poob.sabanapayroll;

import java.util.UUID;

public abstract class Employee {

    private UUID employeeId;
    private String name;
    private String lastName;
    private Department department;
    private BankAccount account;
    protected IFamilyCompensationFund familyCompensationFund;

    public Employee(String name, String lastName, Department department) {
        this.employeeId = UUID.randomUUID();
        this.name = name;
        this.lastName = lastName;
        this.department = department;
    }

    public Employee(String name, String lastName, BankAccount account){
        this.name = name;
        this.lastName = lastName;
        this.account = account;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return String.format("%s %s, department %s, salary $%s,", this.name, this.lastName, this.department.getName(), this.calculateSalary());
    }

    public boolean depositToEmployee(BankAccount account, Check check, double amount){
        boolean result = false;
        if(account instanceof Checking){
            ((Checking) account).processCheck(check);
            result = true;
        }
        if(account instanceof Savings){
            account.deposit(amount);
            result = true;
        }
        return result;
    }

    public double calculateEmployeeBalance(BankAccount account, Check check, double amount){
        if(account instanceof Checking){
            ((Checking) account).processCheck(check);
        }
        if(account instanceof Savings){
            account.deposit(amount);
        }
        return account.getBalance();
    }

    public UUID getId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public abstract boolean assignFamilyCompensation(IFamilyCompensationFund familyCompensationFund);

}
