package pl.sda;

import java.math.BigDecimal;

public class RulesEngine {
    private BigDecimal interestRate;;
    private BigDecimal commision;

    public RulesEngine(BigDecimal interestRate, BigDecimal commision) {
        this.interestRate = interestRate;
        this.commision = commision;
    }

    boolean isCreditApproved(Debtor debtor){
        // a wiek > 65 odrzuć
        if(debtor.getAge() > 65) return false;
        // b sumaryczne raty kredytów + rata nowego kredytu >= dochód * 0,80 odrzuć
        int loanInstallmentsSum = 0;
        for (int i = 0; i < debtor.getLoanInstallments().length; i++) {
            loanInstallmentsSum += debtor.getLoanInstallments()[i];
        }
        BigDecimal amountOfCreditBigDecimal = new BigDecimal(debtor.getAmountOfCredit());
        BigDecimal costOfCredit = new BigDecimal(String.valueOf(amountOfCreditBigDecimal.multiply(interestRate).add(commision)));
        BigDecimal installment = new BigDecimal(String.valueOf(amountOfCreditBigDecimal.add(costOfCredit).divide(new BigDecimal(debtor.getPeriodInYears()*12))));
        if(installment.add(new BigDecimal(loanInstallmentsSum)).compareTo(new BigDecimal(0.8*debtor.getIncome())) != -1) return false;
        // c opóźnienie w spłacie == tak odrzuć
        if(debtor.isRepaymentDelayed()) return false;
        // d wiek + okres spłaty > 65 odrzuć
        if(debtor.getAge()+debtor.getPeriodInYears() > 65) return false;
        return true;
    }
}
