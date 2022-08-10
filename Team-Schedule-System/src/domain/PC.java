package domain;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:25 AM
 * @Description: PC
 * @version: 1.0
 */
public class PC implements Equipment {

    private String model;
    private String display;

    public PC() {
        super();
    }

    public PC(String model, String display) {
        super();
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + "(" + display + ")";
    }
}
