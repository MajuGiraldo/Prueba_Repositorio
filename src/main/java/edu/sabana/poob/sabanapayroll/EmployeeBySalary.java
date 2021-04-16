package edu.sabana.poob.sabanapayroll;

public class EmployeeBySalary extends Employee {

    private static final double HEALTH_DISCOUNT = 0.04;
    private static final double SOCIAL_EQUITY_DISCOUNT = 0.04;

    private double salary;

    public EmployeeBySalary(String name, String lastName, Department department, double salary) {
        super(name, lastName, department);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return this.salary * (1.0 - (EmployeeBySalary.HEALTH_DISCOUNT + EmployeeBySalary.SOCIAL_EQUITY_DISCOUNT));
    }

    @Override
    public String toString() {
        return super.toString() + " payment by salary.";
    }

    @Override
    public boolean assignFamilyCompensation(IFamilyCompensationFund familyCompensationFund){
        boolean result = false;
        if(familyCompensationFund != null){
            this.familyCompensationFund = familyCompensationFund;
            result = true;
        }
        return result;
    }

}
