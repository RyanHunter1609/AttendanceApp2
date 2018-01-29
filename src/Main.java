import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Attendance App!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String userName = scanner.nextLine().toUpperCase();
        System.out.println("Welcome " + userName);
    }
}
