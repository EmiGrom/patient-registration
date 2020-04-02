public class CheckingAccountBalance {
    private Patient accountOwnership;
    private Double amountOfMoney;

    public CheckingAccountBalance(Patient patient) {
        accountOwnership = patient;
        amountOfMoney = 0.0;
    }

    public void wallet(double money) {
        amountOfMoney += money;
    }

    public void retraction(double money) throws NotEnoughMoney {
        if (money > amountOfMoney) {
            throw new NotEnoughMoney();
        } else
            amountOfMoney -= money;
    }

    public Double getAmountOfMoney() {
        return amountOfMoney;
    }

}
