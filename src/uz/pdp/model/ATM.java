package uz.pdp.model;

import uz.pdp.service.DateBase;

public class ATM extends Base implements DateBase {
    private byte percentageATM;

    public byte getProtsantATM() {
        return percentageATM;
    }

    public void setProtsantATM(byte protsantATM) {
        this.percentageATM = protsantATM;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", protsantATM=" + percentageATM +" %"+
                '}';
    }
}
