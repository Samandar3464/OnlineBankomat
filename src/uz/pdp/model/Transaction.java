package uz.pdp.model;

import uz.pdp.service.DateBase;

public class Transaction extends Base implements DateBase {
    private int ATMId;
    private int sanderCardNum;
    private int recipientCardNum;
    private double transactionAmount;
    private int filled;
    private int withdrawed;
    private double benefitWithdraw;
    private double benefitTransfer;
    private  int cardNum;

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public double getBenefitWithdraw() {
        return benefitWithdraw;
    }

    public void setBenefitWithdraw(double benefitWithdraw) {
        this.benefitWithdraw = benefitWithdraw;
    }

    public double getBenefitTransfer() {
        return benefitTransfer;
    }

    public void setBenefitTransfer(double benefitTransfer) {
        this.benefitTransfer = benefitTransfer;
    }

    public int getWithdrawed() {
        return withdrawed;
    }

    public void setWithdrawed(int withdrawed) {
        this.withdrawed = withdrawed;
    }
    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }

    public int getATMId() {
        return ATMId;
    }

    public void setATMId(int ATMId) {
        this.ATMId = ATMId;
    }

    public int getSanderCardNum() {
        return sanderCardNum;
    }

    public void setSanderCardNum(int sanderCardNum) {
        this.sanderCardNum = sanderCardNum;
    }

    public int getRecipientCardNum() {
        return recipientCardNum;
    }

    public void setRecipientCardNum(int recipientCardNum) {
        this.recipientCardNum = recipientCardNum;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", ATMId=" + ATMId +
                ", filled=" + filled +
                ", withdrawed=" + withdrawed +
                ", transactionAmount=" + transactionAmount +
                ", sanderCardNum=" + sanderCardNum +
                ", recipientCardNum=" + recipientCardNum +
                '}';
    }
}
