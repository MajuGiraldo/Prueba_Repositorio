package edu.sabana.poob.sabanapayroll;

public class EmployeeByHours extends Employee {

    private static final double SALARY_BY_HOUR = 6500;

    private int hoursWorked;

    public EmployeeByHours(String name, String lastName, Department department, int hoursWorked) {
        super(name, lastName, department);
        this.hoursWorked = hoursWorked;
    }


    @Override
    public double calculateSalary() {
        return this.hoursWorked * EmployeeByHours.SALARY_BY_HOUR;
    }

    @Override
    public String toString() {
        return super.toString() + " payment by hours.";
    }

    @Override
    public boolean assignFamilyCompensation(IFamilyCompensationFund familyCompensationFund){
        boolean result = false;
        if(familyCompensationFund instanceof ColsubsidioFund || familyCompensationFund instanceof CafamFund){
            this.familyCompensationFund = familyCompensationFund;
            result = true;
        }else {
            this.familyCompensationFund = null;
            result = false;
        }
        return result;
    }

}
