import java.util.HashMap;
import java.util.Scanner;
public class Main {
    //Test Cases:
    public static void main(String[] args) {
        HashMap<String, String> cred = new HashMap<>();
        int exit = 0;
        while (exit == 0) { //Initialize our UI (Program will stop running if exit == 1)
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nWelcome to 'EXAMPLE SITE'\n");
            System.out.println("\n(Login) (Create an Account)\n");
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
            System.out.print("\nAccount already exists..\n");
        }
    }

    public static void loginAccount(HashMap<String, String> cred, String tUsername, String tPassword) {
        if (cred.containsKey(tUsername) && (cred.containsValue(tPassword))) {
            inAccount(cred,tUsername);
        } else {
            System.out.print("\nAccount invalid.\n\n");
        }
    }
    public static void inAccount(HashMap<String, String> cred, String tUsername){
        boolean ui = false;
        Scanner scanner = new Scanner(System.in);
        while (!ui){
            System.out.print("\n\nWelcome "+ tUsername+"\nWhat would you like to do?");
            String rply = scanner.nextLine().toLowerCase();
            switch (rply){
                case "logout":
                    ui = true;
                    break;
                case "change password","password":
                    System.out.print("\nNew password:");
                    String newpas = scanner.nextLine();
                    System.out.print("\nConfirm password:");
                    String newpasc = scanner.nextLine();
                    while (!(newpas.equals(newpasc))){
                        System.out.print("\nPASSWORDS DO NOT MATCH. TRY AGAIN.\n:");
                        System.out.print("\nNew password:");
                        newpas = scanner.nextLine();
                        System.out.print("\nConfirm password:");
                        newpasc = scanner.nextLine();
                    cred.remove(tUsername);
                    cred.put(tUsername, newpas);
                    System.out.print("\n\n\nPassword successfully changed!");
                    break;
            }
            }
        }
    }
}

