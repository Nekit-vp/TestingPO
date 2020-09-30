package SignIN;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class User {

    private static ArrayList<User> users = new ArrayList<>();
    private static String fileName = "users.txt";

    private String password;
    private String login;

    public User(String login, String password) {
        this.password = password;
        this.login = login;
    }

    public static void addAllUsers() throws IOException {
        File file = new File("src/"+fileName);
        FileReader fr = new FileReader(file);
        Scanner scanner  = new Scanner(fr);
        while (scanner.hasNext()) {
            String userTxt = scanner.nextLine();
            String[] array = userTxt.split("/");
            users.add(new User(array[0],array[1]));
        }
        fr.close();
    }

    public static boolean check(String log, String pas){
        //isValid(log, pas);
        for (User us : users) {
            if (us.login.equals(log) && us.password.equals(pas)) return true;
        }
        return false;
    }

//    public static void isValid(String log, String pas) throws CustomFieldException {
//        if (isNull(log) || log.isBlank()) {
//            throw new CustomFieldException("Login could not be empty or null");
//        }
//        if (isNull(pas) || pas.isBlank()) {
//            throw new CustomFieldException("Password could not be null");
//        }
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
