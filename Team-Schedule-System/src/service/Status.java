package service;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:31 AM
 * @Description: The Status enumeration class encapsulates the status of employees.
 * @version: 1.0
 */
public class Status {

    private final String NAME;
    public Status(String name){
        super();
        NAME = name;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status VOCATION = new Status("VOCATION");
    public static final Status BUSY = new Status("BUSY");

    public String getNAME() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
