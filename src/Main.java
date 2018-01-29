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

        double absenceAvg = averageOfAbsences(absences);
        //output average number of absences
        System.out.println("Average Number of Absences: " + absenceAvg);

        int threeAndPerf = fewerThanThreeAndPerfect(absences);
        //output students who had fewer than 3 absences also had perfect attendance
        System.out.println("Students who had fewer than 3 absences also had perfect attendance: " + threeAndPerf);

        System.out.println("Enter a Number: ");
        int number = scanner.nextInt();
        int numOfAbs = specificNumOfAbs(absences, number);
        System.out.println(numOfAbs + " student(s) has " + number + " absence(s).");
    }

    private static int specificNumOfAbs(ArrayList<Integer> absences, int number) {
        // the index(es) of the students who had a specified number of absences.
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (number == absences.get(i)) {
                count++;
            }
        }
        return count;
    }

    private static int fewerThanThreeAndPerfect(ArrayList<Integer> absences) {
        int count = 0;

        for (int i = 0; i < absences.size(); i++) {

            if (absences.get(i) < 3 && absences.get(i).equals(0)) {
                count++;
            }
        }
        return count;
    }

    private static double averageOfAbsences(ArrayList absences) {
        //average = the elements added up, then divide by absences.size()
        Integer avg = 0;
        if (!absences.isEmpty()) {
            for (int i = 0; i < absences.size(); i++) {
                avg += i;
            }
            return avg.doubleValue() / absences.size();
        }


        return avg;
    }

    private static ArrayList<Integer> listOfAbsences(String userName) {

        //Create and array list of absences
        ArrayList<Integer> absencesList = new ArrayList<>(userName.length());
        Random random = new Random();
        for (int i = 0; i < userName.length(); i++) {
            absencesList.add(random.nextInt(10));
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

    //the average of all the absences
}

