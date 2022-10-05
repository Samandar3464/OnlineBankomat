package uz.pdp.model;

public class BankCard extends Base {
    private int userId;
    private String name;
    private boolean inActive = true;
    private int cardNumber;
    private short cardPassword;
    private double amount;
    public BankCard() {
    }

    public BankCard(int userId, String name, boolean inActive, int cardNumber, short cardPassword) {
        this.userId = userId;
        this.name = name;
        this.inActive = inActive;
        this.cardNumber = cardNumber;
        this.cardPassword = cardPassword;
    }



    public int getUserId() {
        return userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public short getCardPassword() {
        return cardPassword;
    }

    public void setCardPassword(short cardPassword) {
        this.cardPassword = cardPassword;
    }

    public boolean isInActive() {
        return inActive;
    }

    public void setInActive(boolean inActive) {
        this.inActive = inActive;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inActive=" + inActive +
                ", cardNumber=" + cardNumber +
                ", cardPassword=" + cardPassword +
                ", amount=" + amount +
                '}';
    }
}
