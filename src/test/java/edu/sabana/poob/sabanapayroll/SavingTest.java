package edu.sabana.poob.sabanapayroll;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SavingTest {

    @Test
    public void shouldGetDepositDiscount() {
        Savings account = new Savings();
        assertTrue(Double.compare(2000, account.getDepositDiscount()) == 0);
    }
    @Test
    public void shouldGetdepositMontlyInterest() {
        Savings account = new Savings();
        assertTrue(Double.compare(9991.666666666666, account.depositMontlyInterest())==0);
    }
    @Test

    public void shouldDepositAmount() {
        Savings account = new Savings();
        boolean result = account.deposit(10000);
        assertTrue(result);
        assertTrue(Double.compare(8000, account.getBalance()) == 0);//beria dar  8000
    }

    @Test
    public void shouldNotDepositAmount() {
        Savings account = new Savings();

        assertFalse(account.deposit(2000));
        assertFalse(account.deposit(1000));
        assertTrue(Double.compare(0, account.getBalance()) == 0);
    }


}
