package uz.pdp.service;

import uz.pdp.model.Transaction;

public class TransactionService extends Transaction implements DateBase {
    public void showTransactionsCurrentATM(int ATMId) {
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getATMId() == ATMId) {
                    System.out.println(transaction);
                }
            }
        }
    }
    public void showTransactionsCurrentATMForUser(int ATMId, int cardNum) {
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getATMId() == ATMId&& transaction.getCardNum()==cardNum) {
                    System.out.println(transaction);
                }
            }
        }
    }

    public void showAllTransactions() {
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                System.out.println(transaction);
            }
        }
    }
    double allFilledMoney=0;
    public void sumAllFilledMoney() {

        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getFilled() != 0) {
                    allFilledMoney+=transaction.getFilled();
                }
            }

        }
        System.out.println(allFilledMoney);
    }
    double allWithdrawMoney=0;
    public void sumAllWithdrawMoney() {

        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getWithdrawed() != 0) {
                   allWithdrawMoney+=transaction.getWithdrawed();
                }
            }
        }
        System.out.println(allWithdrawMoney);
    }
    public void sumAllTransferedMoney() {
        double allTranferedMoney=0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getRecipientCardNum() != 0 && transaction.getSanderCardNum() != 0) {
                    allTranferedMoney+= transaction.getTransactionAmount();
                }
            }
        }
        System.out.println(allTranferedMoney);
    }

    public void allBenefitWithdraw() {
        double allBenefitWithdraw = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getBenefitWithdraw() != 0) {
                    allBenefitWithdraw += transaction.getBenefitWithdraw();
                }
            }
        }
        System.out.println(allBenefitWithdraw);
    }

    public void allBenefitTransfer() {
        double allBenefitTransfer = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                if (transaction.getBenefitTransfer() != 0) {
                    allBenefitTransfer += transaction.getBenefitTransfer();
                }
            }
        }
        System.out.println(allBenefitTransfer);
    }

}
