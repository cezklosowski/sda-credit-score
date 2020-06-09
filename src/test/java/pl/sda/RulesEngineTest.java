package pl.sda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class RulesEngineTest {

    private static BigDecimal interestRate;
    private static BigDecimal commission;
    private static RulesEngine rulesEngine;

    @BeforeAll
    public static void setUp(){
        interestRate = new BigDecimal(0.06);
        commission = new BigDecimal(3000);
        rulesEngine = new RulesEngine(interestRate, commission);
    }

    // Debtor debtor = new Debtor(age,income,loanInstallments,repaymentDelayed,amountOfCredit,periodInYears);

    @Test
    void isCreditApprovedYES() {
        Debtor debtor = new Debtor(20,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},false,10000,2);
        Assertions.assertTrue(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongAge() {
        Debtor debtor = new Debtor(70,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},false,10000,2);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongIncome() {
        Debtor debtor = new Debtor(20,10,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},false,10000,2);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongLoanInstallments() {
        Debtor debtor = new Debtor(20,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500), new BigDecimal(10000)},false,10000,2);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongRepaymentDelayed() {
        Debtor debtor = new Debtor(20,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},true,10000,2);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongAmountOfCredit() {
        Debtor debtor = new Debtor(20,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},false,10000000,2);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }

    @Test
    void isCreditApprovedNO_wrongPeriodInYears() {
        Debtor debtor = new Debtor(20,10000,new BigDecimal[] {new BigDecimal(1000),new BigDecimal(500)},false,10000,80);
        Assertions.assertFalse(rulesEngine.isCreditApproved(debtor));
    }



}