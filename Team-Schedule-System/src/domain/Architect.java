package domain;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:21 AM
 * @Description: Architect
 * @version: 1.0
 */
public class Architect extends Designer{

    private int stock;

    public Architect() {
        super();
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment,
                     double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\tArchitect\t" + getStatus() + "\t" + getBonus()
                + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }
}
