package view;

import java.util.*;
/**
 * 
 * @Description Provide TSUtility.java for inputting by keyboard.
 * @author JingZ Email:zjhebut@gmail.com
 * @version
 * @date Jul 14, 20227:17:49 PM
 */
public class TSUtility {
    private static Scanner scanner = new Scanner(System.in);
    /**
     * 
     * @Description Read the keyboard, if user input any char from ’1’to ’4’, return methods.
     * Return value is the char that user input. 
     * @author JingZ
     * @date Jul 14, 20227:18:27 PM
     * @return
     */
	public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false);
            c = str.charAt(0);
            if (c != '1' && c != '2' &&
                c != '3' && c != '4') {
                System.out.print("Incorrect selection, please re-enter:");
            } else break;
        }
        return c;
    }
	/**
	 * 
	 * @Description The method prompts and waits until the user presses the enter key to return.
	 * @author JingZ
	 * @date Jul 14, 20227:22:04 PM
	 */
    public static void readReturn() {
        System.out.print("Press Enter to continue...");
        readKeyBoard(100, true);
    }
    /**
     * 
     * @Description This method reads an integer up to 2 digits in length from the keyboard and uses it as the method's return value.
     * @author JingZ
     * @date Jul 14, 20227:23:20 PM
     * @return
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(2, false);
            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Incorrect number, please re-enter:");
            }
        }
        return n;
    }
    /**
     * 
     * @Description Read 'Y' or 'N' from the keyboard and use it as the method's return value.
     * @author JingZ
     * @date Jul 14, 20227:24:18 PM
     * @return
     */
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.print("Incorrect selection, please re-enter:");
            }
        }
        return c;
    }

    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line = "";

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.length() == 0) {
                if (blankReturn) return line;
                else continue;
            }

            if (line.length() < 1 || line.length() > limit) {
                System.out.print("Input length (not greater than" + limit + ")error, please re-enter:");
                continue;
            }
            break;
        }

        return line;
    }
}

