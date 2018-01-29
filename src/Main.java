import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Read the user's [name] from stdin and output it as the app's welcome message.
        System.out.println("Welcome to Attendance App!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String userName = scanner.nextLine().toUpperCase();
        System.out.println("Welcome " + userName);

        ArrayList absences = listOfAbsences(userName);
        //output the list of absences.
        System.out.println("The Elements Are: " + absences);

        int perfAttendance = perfectAttendance(absences);
        //output How many students had perfect attendance
        System.out.println("Students with Perfect Attendance: " + perfAttendance);

    }

    private static ArrayList<Integer> listOfAbsences(String userName) {

        //Create and array list of absences
        ArrayList<Integer> absencesList = new ArrayList<>(userName.length());
        Random random = new Random();
        for (int i = 0; i < userName.length(); i++) {
            absencesList.add(random.nextInt(10) - 1);
        }
        return absencesList;
    }

    //calculate How many students had perfect attendance
    private static int perfectAttendance(ArrayList absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i).equals(0)) {
                count++;
            }
        }
        return count;
    }
}

