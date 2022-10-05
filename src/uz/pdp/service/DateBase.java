package uz.pdp.service;

import uz.pdp.model.BankCard;
import uz.pdp.model.ATM;
import uz.pdp.model.Transaction;
import uz.pdp.model.User;

import java.util.ArrayList;
import java.util.List;

public interface DateBase {
    List<User> users=new ArrayList<>();
    List<BankCard> bankCards=new ArrayList<>();
    List<ATM> ATMS =new ArrayList<>();
    List<Transaction> transactions=new ArrayList<>();
}
