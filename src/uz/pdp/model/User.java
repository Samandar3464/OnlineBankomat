package uz.pdp.model;

public class User extends Base {


    private String role;
    private String password;
    private BankCard bankCard;
    private  String telNumber;

    public User() {
    }

    public User( String name,String telNumber,String password,BankCard bankCard,String role) {
        this.name=name;
        this.telNumber=telNumber;
        this.password = password;
        this.bankCard = bankCard;
        this.role = role;
    }

    public User(String  name,String password,String role) {
        this.name=name;
        this.role = role;
        this.password = password;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankCard getBankCard() {
        return bankCard;
    }

    public void setBankCard(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telNum= "+ telNumber+
                ", role='" + role + '\'' +
                ", password=" + password +
                ", bankCard=" + bankCard +
                '}';
    }
}
