package domain;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:24 AM
 * @Description: NoteBook
 * @version: 1.0
 */
public class NoteBook implements Equipment {

    private String model;
    private double price;

    public NoteBook() {
        super();
    }

    public NoteBook(String model, double price) {
        super();
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
