package uz.pdp.service;

import uz.pdp.model.ATM;

public class ATMService implements DateBase, BaseService {
    @Override
    public void show() {
        for (ATM ATM : ATMS) {
            if (ATM != null) {
                System.out.println(ATM);
            }
        }
    }

    @Override
    public boolean add(String name, byte percentage) {
        ATM ATM = new ATM();
        ATM.setName(name);
        ATM.setProtsantATM(percentage);
        ATMS.add(ATM);
        show();
        return true;
    }

    @Override
    public boolean delete(int bankomatId) {
        for (ATM ATM : ATMS) {
            if (ATM != null) {
                if (ATM.getId() == bankomatId) {
                    ATMS.remove(ATM);
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public Object update(int ATMId) {
        for (ATM ATM : ATMS) {
            if (ATM != null) {
                if (ATM.getId() == ATMId) {
                    return ATM;
                }
            }
        }
        return null;
    }

    public ATM choseATM(int ATMId){
        for (ATM ATM : ATMS) {
            if (ATM !=null){
                if (ATM.getId()==ATMId){
                    return ATM;
                }
            }
        }
        return null;
    }
    public short ATMPercentage(int ATMId){
        for (ATM ATM : ATMS) {
            if (ATM !=null){
                if (ATM.getId()==ATMId){
                    return ATM.getProtsantATM();
                }
            }
        }
        return 0;
    }
}
