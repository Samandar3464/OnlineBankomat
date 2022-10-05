package uz.pdp.service;

import uz.pdp.model.BankCard;
import uz.pdp.model.User;

public class CardService implements DateBase, BaseService {
    @Override
    public void show() {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                System.out.println(bankCard);
            }
        }
    }

    public boolean addCard(int userId, String cardName, int cardNums, short cardPassword) {
        BankCard bankCard = new BankCard();
        bankCard.setUserId(userId);
        bankCard.setName(cardName);
        bankCard.setCardNumber(cardNums);
        bankCard.setCardPassword(cardPassword);
        bankCard.setInActive(true);
        bankCards.add(bankCard);
        for (User user : users) {
            if (user != null) {
                if (user.getId() == userId) {
                    user.setBankCard(bankCard);
                }
            }
        }
        return true;
    }

    public boolean openBlock(int cardNums) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == cardNums && bankCard.isInActive() == false) {
                    bankCard.setInActive(true);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAmount(int cardNum, int amount) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == cardNum) {
                    double balanse = (bankCard.getAmount() + amount);
                    bankCard.setAmount(balanse);
                    return true;
                }
            }
        }
        return false;
    }

    public BankCard withdrawMoney(int cardNum, int amount, short bankomatProtsent) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == cardNum && bankCard.getAmount() >= (amount + ((amount * bankomatProtsent) / 100))) {
                    return bankCard;
                }
            }
        }
        return null;
    }

    public boolean moneyTransfer(int currentCardNumber, int receivingCard, double amountBeingSent, short ATMPercentage) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == currentCardNumber && bankCard.getAmount() >= (amountBeingSent + ((amountBeingSent * ATMPercentage) / 100))) {
                    for (BankCard card : bankCards) {
                        if (card != null) {
                            if (card.getCardNumber() == receivingCard) {
                                bankCard.setAmount(bankCard.getAmount() - (amountBeingSent + ((amountBeingSent * ATMPercentage) / 100)));
                                card.setAmount(card.getAmount() + amountBeingSent);

                                return true;
                            }
                        }
                    }

                }
            }
        }
        return false;
    }

    public void showBalance(int cardNum) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == cardNum) {
                    System.out.println("Balance "+bankCard.getAmount()+" sum");
                }
            }
        }
    }
public  int getIdByCardNumber(int cardNum, int cardPassword){
    for (BankCard bankCard : bankCards) {
        if (bankCard!=null){
            if (bankCard.getCardNumber()==cardNum&&bankCard.getCardPassword()==cardPassword){
                return bankCard.getUserId();
            }
        }
    }
    return 0;
}
    @Override
    public boolean add(String name, byte percentage) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Object update(int id) {
        return null;
    }


}
