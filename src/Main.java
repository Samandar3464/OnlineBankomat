import uz.Conctants;
import uz.pdp.model.BankCard;
import uz.pdp.model.ATM;
import uz.pdp.model.Transaction;
import uz.pdp.service.*;
import uz.pdp.model.User;

import java.util.Scanner;

public class Main implements DateBase, Conctants {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerStr = new Scanner(System.in);
    static UserService userService = new UserService();
    static ATMService ATMService = new ATMService();
    static CardService cardService = new CardService();
    static TransactionService transactionService = new TransactionService();
    static int cardNum = 0;
    static int ATMId = 0;
    static short ATMPercentage = 0;
    static  int userId;


    public static void main(String[] args) {
        BankCard bankCard = new BankCard(1, "uzkart", true, 1234, (short) 1234);
        bankCards.add(bankCard);
        User user = new User("admin", "12345", "admin", bankCard, "ADMIN");
        users.add(user);
        BankCard bankCard1 = new BankCard(2, "humo", false, 4321, (short) 4321);
        bankCards.add(bankCard1);
        User user1 = new User("user1", "54321", "user1", bankCard1, "USER");
        users.add(user1);
        User user2 = new User("user2", "user2", "USER");
        System.out.println();
        users.add(user2);
        int var = 10;
        while (var != 0) {
            userService.allUsers();
            System.out.println();
            System.out.println(ADMIN_LOGIN + " " + USER_LOGIN + " " + REGISTRATION);
            var = scannerInt.nextInt();
            switch (var) {
                // admin
                case 1 -> {
                    System.out.print("Enter UserName ");
                    String userName = scannerStr.nextLine();
                    System.out.print("Enter password ");
                    String password = scannerStr.nextLine();
                    User currentUser = userService.checkAdmin(userName, password);
                    if (currentUser.getRole().equals("ADMIN")) {
                        int var1 = 10;
                        while (var1 != 0) {
                            System.out.println(BANK_CARD + " " + ATM + " " + TRANSACTION);
                            var1 = scannerInt.nextInt();
                            switch (var1) {
                                case 1 -> {
                                    bankCardServices();
                                }
                                case 2 -> {
                                    ATM_CRUD();
                                }
                                case 3 -> {
                                    transactionsForAdmin();

                                }
                                case 0 -> {
                                }
                            }
                        }

                    }
                }
                // user
                case 2 -> {
                    int counter = 0;
                    int var5 = 10;
                    while (var5 != 0) {
                        System.out.print("Enter CardNumber ");
                        cardNum = scannerInt.nextInt();
                        var5 = cardNum;
                        System.out.print("card password ");
                        int cardPassword = scannerInt.nextInt();
                        userId= cardService.getIdByCardNumber(cardNum, cardPassword);
                        BankCard bankCard3 = userService.checkUser(cardNum, cardPassword);
                        if (bankCard3 == null) {
                            counter++;
                            if (counter == 3) {
                                System.out.println("karta bloklandi");
                                return;
                            }
                        } else {
                            System.out.println("List ATMs");
                            ATMService.show();
                            System.out.print("enter ATM id for enter ");
                            int id = scannerInt.nextInt();
                            if (id==0) break;else {
                                ATMId = id;
                                ATMPercentage = ATMService.ATMPercentage(id);
                                ATM currentATM = ATMService.choseATM(id);
                                if (currentATM != null) {
                                    intoATM();
                                    break;
                                }
                            }

                        }
                    }
                }

                case 3 -> {
                    registration();
                }

                case 0 -> {
                }
            }
        }
    }

    private static void registration() {
        System.out.print("enter telephone number ");
        String telNum = scannerStr.nextLine();
        for (User user1 : users) {
            if (user1 != null) {
                if (user1.getTelNumber().equals(telNum)) {
                    System.out.println(" this user already have");
                    break;
                } else {
                    System.out.print("enter name ");
                    String name = scannerStr.nextLine();
                    System.out.print("enter password ");
                    String password = scannerStr.nextLine();

                    User user = new User();
                    user.setTelNumber(telNum);
                    user.setName(name);
                    user.setPassword(password);
                    user.setRole("USER");
                    users.add(user);
                    break;
                }
            }
        }
    }

    private static void transactionsForAdmin() {
        int var = 10;
        while (var != 0) {
            System.out.println(SHOW_ALL_TRANSACTIONS + ONE_ATM_TRANSACTION + " " + ALL_FILLED_AMOUNT + " "
                    + ALL_WITHDRAW + " " + ALL_TRANSFER + " " + ALL_PROFIT_IS_TRANSFER + " " + ALL_PROFIT_IS_WITHDRAW+" "+BACK);
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    transactionService.showAllTransactions();
                }
                case 2 -> {
                   ATMService.show();
                    System.out.print("enter ATM id for see transaction ");
                    ATMId=scannerInt.nextInt();
                    transactionService.showTransactionsCurrentATM(ATMId);
                }

                case 3 -> {
                    System.out.print("All felled sum ");
                    transactionService.sumAllFilledMoney();
                }
                case 4 -> {
                    System.out.print("All AllWithdrawMoney sum ");
                    transactionService.sumAllWithdrawMoney();
                }
                case 5 -> {
                    System.out.print("All TransferedMoney sum ");
                    transactionService.sumAllTransferedMoney();
                }
                case 6 -> {
                    System.out.print("All BenefitTransfer sum ");
                    transactionService.allBenefitTransfer();
                }
                case 7 -> {
                    System.out.print("AllBenefitWithdraw sum ");
                    transactionService.allBenefitWithdraw();
                }
                case 0 -> {

                }
            }
        }
    }

    private static void intoATM() {
        int var3 = 10;
        while (var3 != 0) {
            System.out.println(FILL_BALANCE+" "+ WITHDRAW+" "+TRANSFER+" "+TRANSACTION_FOR_USER+" "+ CHANGE_CARD_PASSWORD+" "+SHOW_BALANCE+" "+BACK);
            var3 = scannerInt.nextInt();
            switch (var3) {
                case 1 -> {
                    System.out.print("enter amount ");
                    int amount = scannerInt.nextInt();
                    System.out.println(cardService.addAmount(cardNum, amount));
                    Transaction transaction = new Transaction();
                    transaction.setFilled(amount);
                    transaction.setATMId(ATMId);
                    transaction.setCardNum(cardNum);
                    transactions.add(transaction);
                }
                case 2 -> {
                    System.out.print("enter cash to withdraw ");
                    int cashToWithdraw = scannerInt.nextInt();
                    BankCard bankForWithdraw = cardService.withdrawMoney(cardNum, cashToWithdraw, ATMPercentage);
                    if (bankForWithdraw != null) {
                        bankForWithdraw.setAmount(bankForWithdraw.getAmount() - cashToWithdraw - ((cashToWithdraw * ATMPercentage) / 100));
                        System.out.println("Balance " + bankForWithdraw.getAmount() + " sum" + " money withdrawn " + (cashToWithdraw + ((cashToWithdraw * ATMPercentage) / 100)) + " sum");

                        Transaction transaction = new Transaction();
                        transaction.setWithdrawed(cashToWithdraw);
                        transaction.setATMId(ATMId);
                        transaction.setBenefitWithdraw((cashToWithdraw * ATMPercentage) / 100);
                        transaction.setCardNum(cardNum);
                        transactions.add(transaction);

                    } else {
                        System.out.println("you have not enough money ");
                    }
                }
                case 3 -> {
                    System.out.print("enter receivingCard ");
                    int receivingCard = scannerInt.nextInt();
                    System.out.print("enter amountBeingSent ");
                    double amountBeingSent = scannerInt.nextDouble();
                    cardService.moneyTransfer(cardNum, receivingCard, amountBeingSent, ATMPercentage);
                    System.out.println(" money withdrawn your shot  " + (amountBeingSent + (amountBeingSent * ATMPercentage) / 100) + " sum");
                    cardService.showBalance(cardNum);

                    Transaction transaction = new Transaction();
                    transaction.setSanderCardNum(cardNum);
                    transaction.setCardNum(transaction.getSanderCardNum());
                    transaction.setRecipientCardNum(receivingCard);
                    transaction.setTransactionAmount(amountBeingSent);
                    transaction.setBenefitTransfer((amountBeingSent * ATMPercentage) / 100);
                    transaction.setATMId(ATMId);
                    transactions.add(transaction);
                }
                case 4 -> {
                    transactionService.showTransactionsCurrentATMForUser(ATMId,cardNum);
                }
                case 5 -> {

                    System.out.print("enter oldCardPassword");
                    short oldp = scannerInt.nextShort();
                    System.out.print("enter newCardPassword");
                    short newp = scannerInt.nextShort();
                    System.out.println(userService.changeBankCardPassword(cardNum, oldp, newp));
                }
                case 6 -> {
                    cardService.showBalance(cardNum);
                }
                case 0 -> {
                }
            }
        }
    }

    private static void ATM_CRUD() {
        int var = 10;
        while (var != 0) {
            System.out.println(ADD_ATM + " " + SHOW_ALL_ATMS + " " + UPDATE_ATM + " " + DELETE_ATM);
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    System.out.print("enter ATM name ");
                    String name = scannerStr.nextLine();
                    System.out.print("enter ATM protsent ");
                    byte protsent = scannerInt.nextByte();
                    ATMService.add(name, protsent);
                }
                case 2 -> {
                    ATMService.show();
                }
                case 3 -> {
                    System.out.println("enter ATMId");
                    int id = scannerInt.nextInt();
                    Object o = ATMService.update(id);
                    if (o != null) {
                        ATM updateATM = (ATM) o;
                        System.out.print("new name ");
                        updateATM.setName(scannerStr.nextLine());
                        System.out.print("new protsent ");
                        updateATM.setProtsantATM(scannerInt.nextByte());

                    }

                }
                case 4 -> {
                    System.out.print("enter ATMId ");
                    int id = scannerInt.nextInt();
                    System.out.println(ATMService.delete(id));

                }
                case 0 -> {
                }
            }
        }
    }

    private static void bankCardServices() {
        int var = 10;
        while (var != 0) {
            System.out.println(ADD_BANK_CARD + " " + OPEN_BLOCKED_BANKCARD + " " + SHOW_ALL_BANK_CARDS+" "+BACK);
            var = scannerInt.nextInt();
            switch (var) {
                case 1 -> {
                    userService.allUsers();
                    System.out.print("enter userId ");
                    int userId = scannerInt.nextInt();
                    System.out.print("enter card name ");
                    String name = scannerStr.nextLine();
                    System.out.print("enter card number ");
                    int cardNum = scannerInt.nextInt();
                    System.out.print("enter card password ");
                    short cardPass = scannerInt.nextShort();
                    cardService.addCard(userId, name, cardNum, cardPass);
                }
                case 2 -> {
                    System.out.print("enter card number ");
                    int cardNum = scannerInt.nextInt();
                    cardService.openBlock(cardNum);
                }
                case 3 -> {
                    cardService.show();
                }
                case 0 -> {
                }
            }
        }
    }
}
