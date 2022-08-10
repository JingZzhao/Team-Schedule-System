package domain;

import service.Status;

/**
 * @Auther: Jing Zhao
 * @Date: 7/31/2022 - 07 - 31 - 10:20 AM
 * @Description: Programmer
 * @version: 1.0
 */
public class Programmer extends Employee {

    private int memberId; //Used to record the ID of the member in the team after joining the development team.
    private Status status = Status.FREE;
    //Status is a custom class under the service package,
    // which declares three object properties, which respectively represent the status of members.
    private Equipment equipment; //Indicates the equipment used by the member

    public Programmer() {
        super();
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\tProgrammer\t" + status + "\t\t\t" + equipment.getDescription();
    }
}
