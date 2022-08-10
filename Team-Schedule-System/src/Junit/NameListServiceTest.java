package Junit;

import domain.Employee;
import org.junit.Test;
import service.NameListService;
import service.TeamException;

/**
 * @Auther: Jing Zhao
 * @Date: 8/8/2022 - 08 - 08 - 5:24 PM
 * @Description: Junit
 * @version: 1.0
 */
public class NameListServiceTest {

    @Test
    public void testGetAllEmployees(){
        NameListService nls = new NameListService();

        Employee[] employees = nls.getAllEmployees();

        for(int i = 0; i < employees.length; i++){
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        int id = 2;
        NameListService nls = new NameListService();
        try{
            Employee emp = nls.getEmployee(id);
            System.out.println(emp);
        }catch(TeamException e){
            System.out.println(e.getMessage());
        }
    }
}
