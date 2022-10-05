package uz.pdp.model;

public abstract class Base {
    private  static int idGen=0;
    protected int id;
    protected String name;

    public Base() {
        this.id=idGen++;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
