package pl.sda;

import java.math.BigDecimal;

public class Debtor {
    private int age;
    private int income;
    private BigDecimal[] loanInstallments;
    private boolean repaymentDelayed;
    private int amountOfCredit;
    private int periodInYears;

    public Debtor(int age, int income, BigDecimal[] loanInstallments, boolean repaymentDelayed, int amountOfCredit, int periodInYears) {
        this.age = age;
        this.income = income;
        this.loanInstallments = loanInstallments;
        this.repaymentDelayed = repaymentDelayed;
        this.amountOfCredit = amountOfCredit;
        this.periodInYears = periodInYears;
    }

    public int getAge() {
        return age;
    }

    public int getIncome() {
        return income;
    }

    public BigDecimal[] getLoanInstallments() {
        return loanInstallments;
    }

    public boolean isRepaymentDelayed() {
        return repaymentDelayed;
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public int getPeriodInYears() {
        return periodInYears;
    }
}
