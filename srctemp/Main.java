import java.util.HashMap;
import java.util.Scanner;
public class Main {
    //Test Cases:
    public static void main(String[] args) {
        HashMap<String, String> cred = new HashMap<>();
        int exit = 0;
        while (exit == 0) { //Initialize our UI (Program will stop running if exit == 1)
            Scanner scanner = new Scanner(System.in);
            System.out.print("Welcome to 'EXAMPLE SITE'\n Login to Continue:\n\n");
            System.out.println("\n(Login) (Create an Account)");
            String sel = scanner.nextLine().toLowerCase();
            switch (sel) {
                case "login":
                    System.out.print("\nUsername: ");
                    String tUsername = scanner.nextLine();
                    System.out.print("Password: ");
                    String tPassword = scanner.nextLine();
                    loginAccount(cred,tUsername,tPassword);
                    break;
                case "create", "create an account":
                    System.out.print("Create an account:\n\nUsername: ");
                    String username = scanner.nextLine();
                    System.out.print("\nPassword: ");
                    String password = scanner.nextLine();
                    createAccount(cred,username,password);
                    break;
            }
        }
    }

    public static void createAccount(HashMap<String, String> cred, String username, String password) {
        if (!cred.containsKey(username)){
            cred.put(username, password);
            System.out.print("Your account was successfully created!");
        }
        else {
            System.out.print("\nUser name already exists");
        }
    }

    public static void loginAccount(HashMap<String, String> cred, String tUsername, String tPassword) {
        if (cred.containsKey(tUsername) && (cred.containsValue(tPassword))){
            System.out.print("Logged in!");
        }
        else {
            System.out.print("\nAccount does not exist.\n\n");
        }
    }
}
