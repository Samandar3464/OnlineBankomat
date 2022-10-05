package uz.pdp.service;

import uz.pdp.model.BankCard;
import uz.pdp.model.User;

public class UserService implements DateBase {
    public User checkAdmin(String username, String password) {
        for (User user : users) {
            if (user != null) {
                if (user.getName().equals(username) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        }
        return null;
    }

    int counter = 0;

    public BankCard checkUser(long cardNums, int cardPassword) {

        int counter = 0;

        for (BankCard bankCard : bankCards) {
            if (bankCard.getCardNumber() != 0 && bankCard.getCardPassword() != 0) {
                if (bankCard.getCardNumber() == cardNums) {
                    if (bankCard.getCardPassword() == cardPassword) {
                        return bankCard;

                    }

                } else {
                    counter++;
                    if (counter == 3) {
                        bankCard.setInActive(false);
                        break;
                    }
                }
            }
        }
        return null;
    }

    public void allUsers() {
        for (User user : users) {
            if (user != null) {
                System.out.println(user);
            }
        }
    }

    public boolean changeBankCardPassword(int cardNumber, short oldBankCardPassword, short newPassport) {
        for (BankCard bankCard : bankCards) {
            if (bankCard != null) {
                if (bankCard.getCardNumber() == cardNumber && bankCard.getCardPassword() == oldBankCardPassword) {
                    bankCard.setCardPassword(newPassport);
                    return true;
                }
            }
        }
        return false;
    }
}

