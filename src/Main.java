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

        int moreThanTwice = AbsentMoreThanTwice(absences);
        //output students Absent more than Twice the Times the Course Meets
        System.out.println("Student(s) Absent more than Twice the Times the Course Meets: " + moreThanTwice);
        //output percent of students who FE'd
        double percentFEd = percentOfStudentsFEd(absences, moreThanTwice);
        System.out.println("Percent of Student(s) FE'd: " + percentFEd);

        double avgAbsOfNon = averageOfNonFEdAbsences(absences);
        System.out.println("The Average of Only the Non-FE'd Absences: " + avgAbsOfNon);


        addTheAbsences(absences, int index);


    }

    //As a user, I need to be able to change the absences in the ArrayList.
    private static void addTheAbsences(ArrayList<Integer> absences, int index) {
        // X is a positive, negative, or even zero integer.
        // Y can be any integer too.
        // No absence should be less than zero or more than 15 after performing this calculation.
        // If an absence would be negative, set it to zero. If an absence would be more than 15, set it to 15.
        int num;
        if (index < 0 || index > 15) {
            if (index <= num)
        }
        int[] array = new int[absences.size()];
        //add the element to get the resizing
        addTheAbsences(absences, index);
        //shift other elements
        for (int i = absences.size(); i < index; i--) {
            array[i] = array[i - 1];
        }
        //put new num in right place
        array[index] = absences;
    }

    //What is the average of only the non-FE'd absences?
    private static double averageOfNonFEdAbsences(ArrayList<Integer> absences) {
        Integer avg = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (!absences.isEmpty() && absences.get(i) < 6) {
                for (int j = 0; j < absences.size(); j++) {
                    avg += j;
                }
                return avg.doubleValue() / absences.size();
            }
        }
        return avg;
    }

    // the percentage of students who have FE'd the course.
    private static double percentOfStudentsFEd(ArrayList<Integer> absences, int moreThanTwice) {
        double qoutient = moreThanTwice / absences.size();
        return qoutient;
    }

    //what percentage of the students have FE'd the course
    private static int AbsentMoreThanTwice(ArrayList<Integer> absences) {
        //the index(es) of the student(s) who were absent more than twice the number of times the course meets per week.
        /** english explanation
         *
         *
         * **/
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            int product = absences.size() * 2;
            if (absences.get(i) >= product) {
                count += i;
            }
        }
        return count;
    }


    // the index(es) of the students who had a specified number of absences.
    private static int specificNumOfAbs(ArrayList<Integer> absences, int number) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (number == absences.get(i)) {
                count++;
            }
        }
        return count;
    }

    //calculate students who had fewer than 3 absences also had perfect attendance
    private static int fewerThanThreeAndPerfect(ArrayList<Integer> absences) {
        int count = 0;

        for (int i = 0; i < absences.size(); i++) {

            if (absences.get(i) < 3 && absences.get(i).equals(0)) {
                count++;
            }
        }
        return count;
    }

    //calculate the average of the absences
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

    //Create and array list of absences
    private static ArrayList<Integer> listOfAbsences(String userName) {

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


}

