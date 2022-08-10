package domain;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:20 AM
 * @Description: Designer
 * @version: 1.0
 */
public class Designer extends Programmer {

    private double bonus;

    public Designer() {
        super();
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\tDesigner\t" + getStatus() + "\t" + bonus + "\t\t"
                + getEquipment().getDescription();
    }
}
