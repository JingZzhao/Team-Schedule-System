package view;

import domain.Employee;
import domain.Programmer;
import service.NameListService;
import service.TeamException;
import service.TeamService;

/**
 * @Auther: Jing Zhao
 * @Date: 8/9/2022 - 08 - 09 - 5:08 PM
 * @Description: TeamView
 * @version: 1.0
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    //Main menu and control methods
    public void enterMainMenu(){
        boolean loopFlag = true;
        char key = 0;

        do{
            if(key != '1'){
                listAllEmployees();
            }
            System.out.print("1-Team List  2-Add Member  3-Remove Member 4-Exit   Please choose(1-4)：");
            key = TSUtility.readMenuSelection();

            switch(key){
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("Comfirm(Y/N): ");
                    char yn = TSUtility.readConfirmSelection();
                    if(yn == 'Y'){
                        loopFlag = false;
                    }
                    break;
            }
        }while (loopFlag);
    }

    //List all members of the company in a table.
    private void listAllEmployees(){
        System.out.println("\n--------------------------Development Team Scheduling---------------------------\n");
        Employee[] emps = listSvc.getAllEmployees();
        if(emps.length == 0){
            System.out.println("No records!");
        }else{
            System.out.println("ID\tName\tAge\tSalary\tPosition\tStatus\tBonus\tStock\tEquipment");
        }

        for(Employee e : emps){
            System.out.println(e);
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    // list all members in the team
    private void getTeam() {
        System.out.println("\n------------------Team Members-------------------\n");
        Programmer[] prgs = teamSvc.getTeam();
        if (prgs.length == 0) {
            System.out.println("No members in the development team!");
        } else {
            System.out.println("TID/ID\tName\tAge\tSalary\tPosition\tBonus\tStock");
        }

        for (Programmer p : prgs) {
            System.out.println(" " + p.getDetailsForTeam());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
    private void addMember(){
        System.out.println("---------------------Add Member---------------------");
        System.out.print("Please enter the employee ID to be added：");

        int id = TSUtility.readInt();

        Employee e = null;
        try {
            e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("Success!");
        } catch (TeamException te) {
            System.out.println("Failed: " + te.getMessage());
        }
        // Press Enter to continue...
        TSUtility.readReturn();
    }

    private void deleteMember(){
        System.out.println("---------------------Delete Member---------------------");
        System.out.print("Please enter the employee ID to be deleted：");

        int id = TSUtility.readInt();

        System.out.println("Confirm(Y/N): ");
        char yn = TSUtility.readConfirmSelection();
        if(yn == 'N')
            return;

        try {
            teamSvc.removeMember(id);
            System.out.println("Success!");
        } catch (TeamException te) {
            System.out.println("Failed: " + te.getMessage());
        }
        // Press Enter to continue...
        TSUtility.readReturn();
    }

    public static void main(String[] args){
        TeamView tv = new TeamView();
        tv.enterMainMenu();
    }
}
