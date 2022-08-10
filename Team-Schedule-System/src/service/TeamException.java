package service;

/**
 * @Auther: Jing Zhao
 * @Date: 8/5/2022 - 08 - 05 - 4:40 PM
 * @Description: Exception
 * @version: 1.0
 */
public class TeamException extends Exception{

    static final long serialVersionUID = -338786993124229948L;

    public TeamException() {
    }

    public TeamException(String message) {
        super(message);
    }
}
