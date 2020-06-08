package pl.sda;

public class Debtor {
    private int age;
    private int income;
    private int[] loanInstallments;
    private boolean repaymentDelayed;
    private int amountOfCredit;
    private int periodInYears;

    public Debtor(int age, int income, int[] loanInstallments, boolean repaymentDelayed, int amountOfCredit, int periodInYears) {
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

    public int[] getLoanInstallments() {
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
