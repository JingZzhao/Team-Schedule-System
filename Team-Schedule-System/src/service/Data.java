package service;

public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"10", "1", "MaY", "22", "3000"},
        {"13", "2", "MaHT", "32", "18000", "15000", "2000"},
        {"11", "3", "LiHY", "23", "7000"},
        {"11", "4", "LiuQD", "24", "7300"},
        {"12", "5", "LeiJ", "28", "10000", "5000"},
        {"11", "6", "RenZQ", "22", "6800"},
        {"12", "7", "LiuCZ", "29", "10800","5200"},
        {"13", "8", "YangYQ", "30", "19800", "15000", "2500"},
        {"12", "9", "ShiYZ", "26", "9800", "5500"},
        {"11", "10", "DingL", "21", "6600"},
        {"11", "11", "ZhangCY", "25", "7100"},
        {"12", "12", "YangZY", "27", "9600", "4800"}
    };
    
    //EQUIPMENTS array elements one-to-one correspondence with the above EMPLOYEES array elements
    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, name, type 
    public static final String[][] EQUIPMENTS = {
        {},
        {"22", "LenovoT4", "6000"},
        {"21", "Dell", "NEC17'"},
        {"21", "Dell", "Samsung 17'"},
        {"23", "Canon 2900", "Laser"},
        {"21", "ASUS", "Samsung 17'"},
        {"21", "ASUS", "Samsung 17'"},
        {"23", "Epson20K", "Stylus"},
        {"22", "HPm6", "5800"},
        {"21", "Dell", "NEC 17'"},
        {"21", "ASUS","Samsung 17'"},
        {"22", "NPm6", "5800"}
    };
}
