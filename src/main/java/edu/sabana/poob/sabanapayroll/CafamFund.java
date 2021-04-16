package edu.sabana.poob.sabanapayroll;

import java.util.*;

public class CafamFund implements IFamilyCompensationFund{

    private static Set<Employee> registeredEmployees = new HashSet<>();

    public CafamFund() {

    }

    /**
     * Permite registrar cualquier empleado.
     *
     * @param employee
     * @return
     */
    @Override
    public boolean registerEmployee(Employee employee) {
        boolean result = false;

        if(registeredEmployees.add(employee)){
            result = true;
        }else {
            result = false;
        }

        return result;
    }

    @Override
    public boolean deleteEmployee(UUID id) {
        boolean result = false;
        for(Employee e: registeredEmployees){
            if(id.equals(e.getId())){
                registeredEmployees.remove(e);
                result = true;
            }else {
                result = false;
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
        return "Los beneficios de esta caja de compensación son:\nBeneficioG...\nBeneficioH...\nBeneficioI...";
    }
}
