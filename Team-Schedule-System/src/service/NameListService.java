package service;

import domain.*;

/**
 * @Auther: Jing Zhao
 * @Date: 8/5/2022 - 08 - 05 - 4:34 PM
 * @Description: It is responsible for encapsulating the data in the Data into the Employee[] array,
 *               and provides methods for related operations on Employee[].
 * @version: 1.0
 */

public class NameListService {
    private Employee[] employees; //Store all employees.

    public NameListService() {
    }

    /**
     *
     * @return An array contains all employees.
     */
    public Employee[] getAllEmployees(){
        employees = new Employee[Data.EMPLOYEES.length];

        for(int i = 0; i < Data.EMPLOYEES.length; i++){
            // Get generic properties
            int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
            int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
            String name = Data.EMPLOYEES[i][2];
            int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
            double salary = Double.parseDouble(Data.EMPLOYEES[i][4]);

            Equipment eq;
            double bonus;
            int stock;

            switch(type) {
                case Data.EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case Data.PROGRAMMER:
                    eq = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, eq);
                    break;
                case Data.DESIGNER:
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, eq, bonus);
                    break;
                case Data.ARCHITECT:
                    eq = createEquipment(i);
                    bonus = Double.parseDouble(Data.EMPLOYEES[i][5]);
                    stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, eq, bonus, stock);
                    break;
            }

        }
        return employees;
    }

    public Equipment createEquipment(int index){
        int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
        switch (type){
            case Data.PC:
                return new PC(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
            case Data.NOTEBOOK:
                return new NoteBook(Data.EQUIPMENTS[index][1], Double.parseDouble(Data.EQUIPMENTS[index][2]));
            case Data.PRINTER:
                return new Printer(Data.EQUIPMENTS[index][1], Data.EQUIPMENTS[index][2]);
        }
        return null;
    }

    /**
     *
     * @param id
     * @return Employee with specified ID.
     * @throws TeamException : Can't find the employee with specified ID.
     */
    public Employee getEmployee(int id) throws TeamException {

        for(Employee e : employees){
            if(e.getId() == id){
                return e;
            }
        }

        throw new TeamException("The Employee doesn't exist!");

    }
}
