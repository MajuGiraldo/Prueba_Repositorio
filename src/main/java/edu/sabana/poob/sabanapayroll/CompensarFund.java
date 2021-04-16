package edu.sabana.poob.sabanapayroll;

import java.util.*;

public class CompensarFund implements IFamilyCompensationFund{

    private static List<Employee> registeredEmployees = new ArrayList<>();

    public CompensarFund() {

    }

    /**
     * No permite registrar empleados de tipo EmployeeByHours.
     *
     * @param employee
     * @return
     */
    @Override
    public boolean registerEmployee(Employee employee) {
        boolean result = false;

        if(employee instanceof EmployeeByCommission || employee instanceof EmployeeBySalary){
            if(!registeredEmployees.contains(employee)){
                registeredEmployees.add(employee);
                result = true;
            }
        }else {
            result = false;
        }

        return result;
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        boolean result = false;
        Iterator<Employee> it = registeredEmployees.iterator();
        while(it.hasNext()){
            UUID employee_id = it.next().getId();
            if(employee_id.equals(id)){
                it.remove();
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean isEmployeeRegistered(UUID id) {
        boolean result = false;
        for(Employee e: registeredEmployees){
            if(id.equals(e.getId())){
                result = true;
            }else {
                result = false;
            }
        }

        return result;
    }

    @Override
    public String printBenefits() {
        return "Los beneficios de esta caja de compensación son:\nBeneficioD...\nBeneficioE...\nBeneficioF...";
    }
}
