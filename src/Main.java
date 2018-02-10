import java.util.*;

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

        int fewerThanThree = fewerThanThreeAbsences(absences);
        System.out.println("Students with Less Than 3 Absences: " + fewerThanThree);

        double absenceAvg = averageOfAbsences(absences);
        //output average number of absences
        System.out.println("Average Number of Absences: " + absenceAvg);

        double threeAndPerf = percentFewerThanThreeAndPerfect(absences, perfAttendance);
        //output students who had fewer than 3 absences also had perfect attendance
        System.out.println(" % of Students who had fewer than 3 absences also had perfect attendance: " + threeAndPerf);

        System.out.println("Enter a Number: ");
        int number = scanner.nextInt();
        int numOfAbs = specificNumOfAbs(absences, number);
        System.out.println(numOfAbs + " student(s) has " + number + " absence(s).");

        int moreThanTwice = absentMoreThanTwice(absences);
        //output students Absent more than Twice the Times the Course Meets
        System.out.println("Student(s) Absent more than Twice the Times the Course Meets: " + moreThanTwice);
        //output percent of students who FE'd
        double percentFEd = percentOfStudentsFEd(absences);
        System.out.println("Percent of Student(s) FE'd: " + percentFEd);

        double avgAbsOfFEd = averageOfFEdAbsences(absences);
        System.out.println("The Average of Only the FE'd Absences: " + avgAbsOfFEd);

        double avgAbsOfNon = averageOfNonFEdAbsences(absences);
        System.out.println("The Average of Only the Non-FE'd Absences: " + avgAbsOfNon);

        System.out.println("What Number Would You Like to Add? ");
        int newNum = scanner.nextInt();

        System.out.println("Add " + newNum + " at Which Index?");
        int index = scanner.nextInt();
        ArrayList<Integer> addAbs = addTheAbsences(absences, newNum, index);
        System.out.println("Your New List of Elements: " + addAbs);

        ArrayList<Integer> sort = sortElements(absences);
        //output sorted elements
        System.out.println("Sorted Elements: " + sort);

        ArrayList<Integer> shuffle = shuffleElements(absences);
        //output shuffled elements
        System.out.println("Shuffled Elements: " + shuffle);

        Set<Integer> unique = returnUniqueValues(absences);
        System.out.println("The Set of Unique Elements: " + unique);

        elementShuffle(absences);
        System.out.println("The Shuffled Elements are: " + absences);

        elementSort(absences);
        System.out.println("The Sorted Elements are: " + absences);

        ArrayList<String> fiveNames = fiveDistinctNames();
        //output an ArrayList of 5 distinct names.
        System.out.println("Five Distinct Names: " + fiveNames);

        //TODO output 5 shuffled names
        shuffleNames(fiveNames);
        System.out.println("Shuffled Names: " + fiveNames);

        //TODO how many of each absence?

    }

    //TODO Shuffle the names using a user-defined shuffle function.
    private static void shuffleNames(ArrayList<String> fiveNames) {
        Random random = new Random();
        for (int i = 0; i < fiveNames.size(); i++) {
            int temp1 = random.nextInt(fiveNames.size());
//                    int temp2 = random.nextInt(fiveNames.size());
            fiveNames.set(i, fiveNames.get(temp1));
            fiveNames.set(temp1, );

        }
    }

    //Create an ArrayList of 5 distinct names.
    private static ArrayList<String> fiveDistinctNames() {
        ArrayList<String> names = new ArrayList<>();
        names.add("Olivia");
        names.add("James");
        names.add("Lance");
        names.add("Ryan");
        names.add("Alex");

        return names;
    }

    // Sort the absences using a user-defined sort function.
    private static void elementSort(ArrayList<Integer> absences) {
        for (int i = 0; i < absences.size(); i++) {
            for (int j = 0; j < absences.size(); j++) {
                if (absences.get(i) > absences.get(j)) {
                    int temp = absences.get(i);
                    absences.set(i, absences.get(j));
                    absences.set(j, temp);
                }
            }
        }
    }

    //Shuffle the absences using a user-defined shuffle() function.
    private static void elementShuffle(ArrayList<Integer> absences) {
        Random random = new Random();
        for (int i = 0; i < absences.size(); i++) {
            int temp1 = random.nextInt(absences.size());
            int temp2 = random.nextInt(absences.size());
            absences.set(i, temp1);
            absences.set(i, temp2);
        }
    }

    private static Set<Integer> returnUniqueValues(ArrayList<Integer> absences) {
        Set<Integer> storeUVals = new HashSet<>();
        for (int i = 0; i < absences.size(); i++) {
            storeUVals.add(absences.get(i));
        }
        return storeUVals;
    }

    private static ArrayList<Integer> shuffleElements(ArrayList<Integer> absences) {
        ArrayList<Integer> shuffleArray = new ArrayList<>();
        shuffleArray = absences;
        Collections.shuffle(shuffleArray);
        return shuffleArray;
    }

    private static ArrayList<Integer> sortElements(ArrayList<Integer> absences) {
        ArrayList<Integer> sortArray = new ArrayList<>();
        sortArray = absences;
        Collections.sort(sortArray);
        return sortArray;
    }

    //As a user, I need to be able to change the absences in the ArrayList.
    private static ArrayList<Integer> addTheAbsences(ArrayList<Integer> absences, int newNum, int index) {
        // X is a positive, negative, or even zero integer.
        // Y can be any integer too.
        // No absence should be less than zero or more than 15 after performing this calculation.
        // If an absence would be negative, set it to zero. If an absence would be more than 15, set it to 15.
        ArrayList<Integer> addAbsArrayList = new ArrayList<>();
        addAbsArrayList = absences;
        for (int i = 0; i < addAbsArrayList.size(); i++) {
            if (addAbsArrayList.get(i) > index) {
                //create new variable b/c you're getting a new number
                int newSpot = addAbsArrayList.get(i) + newNum;
                //set new number to i
                addAbsArrayList.set(i, newSpot);
            }
            if (addAbsArrayList.get(i) < 0) {
                addAbsArrayList.set(i, 0);
            }
            if (addAbsArrayList.get(i) > 15) {
                addAbsArrayList.set(i, 15);
            }
        }
        return addAbsArrayList;
    }

    //What is the average of only the non-FE'd absences?
    private static double averageOfNonFEdAbsences(ArrayList<Integer> absences) {
        int nonFEd;
        int sum = 0;
        double avg;
        int moreThanTwice = absentMoreThanTwice(absences);

        nonFEd = absences.size() - moreThanTwice;
        sum += nonFEd;
        avg = (double) sum / absences.size();

        return avg;
    }

    //What is the average of only the FE'd absences
    private static double averageOfFEdAbsences(ArrayList<Integer> absences) {
        double avg = 0;
        int sum = 0;
        int moreThanTwice = absentMoreThanTwice(absences);

        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) >= moreThanTwice) {
                sum += absences.get(i);
                avg = (double) sum / absences.size();
            }
        }
        return avg;
    }

    // the percentage of students who have FE'd the course.
    private static double percentOfStudentsFEd(ArrayList<Integer> absences) {
        //call moreThanTwice function
        int moreThanTwice = absentMoreThanTwice(absences);
        double qoutient = moreThanTwice / absences.size();
        return qoutient;
    }

    //what percentage of the students have FE'd the course
    private static int absentMoreThanTwice(ArrayList<Integer> absences) {
        //the index(es) of the student(s) who were absent more than twice the number of times the course meets per week.
        /** english explanation
         *
         *
         * **/
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            int product = absences.size() * 2;
            if (absences.get(i) >= product) {
                count++;
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

    //how many students had fewer than 3 absences
    private static int fewerThanThreeAbsences(ArrayList<Integer> absences) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (absences.get(i) < 3) {
                count++;
            }
        }
        return count;
    }

    //calculate percentage of students who had fewer than 3 absences also had perfect attendance
    private static double percentFewerThanThreeAndPerfect(ArrayList<Integer> absences, int perfAttendance) {
        int lessThan = fewerThanThreeAbsences(absences);
        int perf = perfectAttendance(absences);
        double percent = (double) perf / lessThan;

        return percent;
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

