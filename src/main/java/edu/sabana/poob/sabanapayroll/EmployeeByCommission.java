package edu.sabana.poob.sabanapayroll;

public class EmployeeByCommission extends Employee {

    private static final double COMMISSION = 15000;

    private int soldProducts;
    private BankAccount account;

    public EmployeeByCommission(String name, String lastName, Department department, int soldProducts) {
        super(name, lastName, department);
        this.soldProducts = soldProducts;
    }

    public EmployeeByCommission(String name, String lastName, Department department, int soldProducts, BankAccount account) {
        super(name, lastName, department);
        this.soldProducts = soldProducts;
        this.account = account;
    }


    @Override
    public double calculateSalary() {
        return this.soldProducts * EmployeeByCommission.COMMISSION;
    }

    @Override
    public String toString() {
        return super.toString() + " payment by commission.";
    }

    @Override
    public boolean assignFamilyCompensation(IFamilyCompensationFund familyCompensationFund){
        boolean result = false;
        if(familyCompensationFund instanceof CompensarFund || familyCompensationFund instanceof CafamFund){
            this.familyCompensationFund = familyCompensationFund;
            result = true;
        }else {
            this.familyCompensationFund = null;
            result = false;
        }
        return result;
    }


}

