import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Read the user's [name] from stdin and output it as the app's welcome message.
        System.out.println("Welcome to Attendance App!");

        Scanner scanner = new Scanner(System.in);
        // System.out.println("Enter Your Name: ");
        String userName = "Ryan";
        System.out.println("Welcome " + userName);

        ArrayList absences = listOfAbsences(userName);
        //output the list of absences.
        System.out.println("\nThe Elements Are: " + absences);

        int perfAttendance = perfectAttendance(absences);
        //output How many students had perfect attendance
        System.out.println("\nStudents with Perfect Attendance: " + perfAttendance);

        int fewerThanThree = fewerThanThreeAbsences(absences);
        System.out.println("\nStudents with Less Than 3 Absences: " + fewerThanThree);

        double absenceAvg = averageOfAbsences(absences);
        //output average number of absences
        System.out.println("\nAverage Number of Absences: " + absenceAvg);

        double threeAndPerf = percentFewerThanThreeAndPerfect(absences, perfAttendance);
        //output students who had fewer than 3 absences also had perfect attendance
        System.out.println(" % of Students Who Had Fewer than 3 Absences Also Had Perfect Attendance: " + threeAndPerf);

        System.out.println("\nEnter the Number of Absences You Want Find: ");
        int number = scanner.nextInt();
        int numOfAbs = specificNumOfAbs(absences, number);
        System.out.println(numOfAbs + " student(s) has " + number + " absence(s).");

        int moreThanTwice = absentMoreThanTwice(absences);
        //output students Absent more than Twice the Times the Course Meets
        System.out.println("\nStudent(s) Absent more than Twice the Times the Course Meets: " + moreThanTwice);
        //output percent of students who FE'd
        double percentFEd = percentOfStudentsFEd(absences);
        System.out.println("Percent of Student(s) FE'd: " + percentFEd);

        double avgAbsOfFEd = averageOfFEdAbsences(absences);
        System.out.println("The Average of Only the FE'd Absences: " + avgAbsOfFEd);

        double avgAbsOfNon = averageOfNonFEdAbsences(absences);
        System.out.println("The Average of Only the Non-FE'd Absences: " + avgAbsOfNon);

        System.out.println("\nWhat Number Would You Like to Add to the List of Absences? ");
        int newNum = scanner.nextInt();

        System.out.println("Add " + newNum + " at Which Element?");
        int index = scanner.nextInt();
        ArrayList<Integer> addAbs = addTheAbsences(absences, newNum, index);
        System.out.println("\nYour New List of Elements: " + addAbs);

        ArrayList<Integer> sort = sortElements(absences);
        //output sorted elements
        System.out.println("\nSorted Elements: " + sort);

        ArrayList<Integer> shuffle = shuffleElements(absences);
        //output shuffled elements
        System.out.println("Shuffled Elements: " + shuffle);

        Set<Integer> unique = returnUniqueValues(absences);
        System.out.println("\nThe Set of Unique Elements: " + unique);

        elementShuffle(absences);
        System.out.println("\nThe Shuffled Elements are: " + absences);

        elementSort(absences);
        System.out.println("The Sorted Elements are: " + absences);

        ArrayList<String> fiveNames = fiveDistinctNames();
        //output an ArrayList of 5 distinct names.
        System.out.println("\nFive Distinct Names: " + fiveNames);

        //output 5 shuffled names
        shuffleNames(fiveNames);
        System.out.println("\nShuffled Names: " + fiveNames);

        howManyOfEachAbsence(absences);

        // build a random list from a list of values.
        ArrayList<String> randomList = randomListOfValues(fiveNames, absences);
        //output the new list
        System.out.println("\nNew List (with added names): " + randomList);

        boolean namesUsedOrNot = allNamesUsedOrNot(randomList);
        //output if all names are used
        System.out.println("\nAre All Names Used at Least Once? " + namesUsedOrNot);

        ArrayList<String> perfAttendanceNames = studentNameWithPerfAttendance(randomList, absences);
        // output What are the names of the students with perfect attendance?
        System.out.println("\nStudent Name(s) with Perfect Attendance: " + perfAttendanceNames);

        ArrayList<String> fEDStudentNames = studentsNamesWhoFE(randomList, absences);
        // output What are the names of the students who have FE'd some course?
        System.out.println("Student Name(s) Who FE'd: " + fEDStudentNames);

        //ask the user for a name
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("\nEnter a Name that You Want to Search for: ");
        String userNameLookup = scanner1.nextLine();

        int howManyCourses = howManyCoursesForStudent(userNameLookup, randomList, absences);

        //output How many courses does [name] have?
        System.out.println(userNameLookup + " Has " + howManyCourses + " Courses");

        int coursesFE = whichCoursesFE(absences, userNameLookup, randomList);

        // output Which courses did [name] FE?
        System.out.println(userNameLookup + " FE'd " + coursesFE + " courses");

        LocalDate todaysDate = generateTodaysDate();
        //Output today's date.
        System.out.println("\nToday's Date: " + todaysDate);

        /**TODO How many days have you been alive?  Use date1.equals(date2) to check your result.**/
        // ask user for birth date (year, month, day)
        System.out.println("\nTo find out how many days you've been alive ENTER your birthday (year, month, day).");
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Year: ");
        int userYearLookup = scanner2.nextInt();
        System.out.println("Enter Month: ");
        int userMonthLookup = scanner2.nextInt();

        System.out.println("Enter Day: ");
        int userDayLookup = scanner2.nextInt();

        long daysAlive = howManyDaysLived(todaysDate, userYearLookup, userMonthLookup, userDayLookup);

        System.out.println("You've been alive " + daysAlive + " day(s).");

        /**TODO Create a list of LocalDate objects.**/

        /**TODO Store today's date.
         * Store your birthday using LocalDate.of().
         * Add dates until it has the same size as the names list. Use LocalDate.minusDays() to generate random dates within 20 days of today's date.
         * **/

        /**TODO What are the names of the students with the fewest absences?
         * pass names list as a parameter
         * look inside list
         *
         * **/

        /**TODO What are the names of students who have the longest number of days since an absence?
         * See LocalDate.isAfter().
         * **/
        /**TODO What is the range of absence dates?
         * What are the indexes of the students who have [X] absence date?
         *
         * **/
        /**TODO What are the indexes of the students who have the same absence date?
         * find the indexes that match
         * get the student names that match that index
         * return indexes**/


    }

    //calculate how many days the user has lived
    private static long howManyDaysLived(LocalDate todaysDate, int userYearLookup, int userMonthLookup, int userDayLookup) {
        LocalDate birthdate = LocalDate.of(userYearLookup, userMonthLookup, userDayLookup);

        long bday = birthdate.toEpochDay();
        long date = todaysDate.toEpochDay();

        long day = date - bday;

        return day;
    }

    // Generate today's date and return it.
    private static LocalDate generateTodaysDate() {
        /** Google "Java 8 LocalDate" and read how dates are used in Java.
         * LocalDate today = LocalDate.now();
         * */
        LocalDate today = LocalDate.now();
        return today;
    }

    //Which courses did [name] FE?
    private static int whichCoursesFE(ArrayList<Integer> absences, String userNameLookup, ArrayList<String> randomNameList) {
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            if (randomNameList.get(i).equalsIgnoreCase(userNameLookup) && absences.get(i).equals(absences.size() * 2 + 1)) {
                count++;
            }
        }
        return count;
    }

    //How many courses does [name] have?
    private static int howManyCoursesForStudent(String userNameLookup, ArrayList<String> randomList, ArrayList<Integer> absences) {
        int count = 0;
        //locate person in name list
        for (int i = 0; i < absences.size(); i++) {
            //get element at index
            // if the name equals the user input...
            if (userNameLookup.equalsIgnoreCase(randomList.get(i))) {
                count++;
            }
        }
        return count;
    }

    // What are the names of the students who have FE'd some course?
    private static ArrayList<String> studentsNamesWhoFE(ArrayList<String> randomList, ArrayList<Integer> absences) {
        //Create a user-defined unique function.
        //Ask me about using a Java Set to find unique or duplicate values.

        ArrayList<String> studentsWhoFEList = new ArrayList<>();

        for (int i = 0; i < randomList.size(); i++) {
            int product = absences.size() * 2 + 1;
            if (absences.get(i) == product) {
                studentsWhoFEList.add(randomList.get(i));
            }
        }

        return studentsWhoFEList;
    }

    // What are the names of the students with perfect attendance?
    private static ArrayList<String> studentNameWithPerfAttendance(ArrayList<String> randomList, ArrayList<Integer> absences) {
        ArrayList<String> perfectAttendanceNamesList = new ArrayList<>();
        for (int i = 0; i < randomList.size(); i++) {
            if (absences.get(i) == 0) {
                perfectAttendanceNamesList.add(randomList.get(i));
            }
        }
        return perfectAttendanceNamesList;
    }

    //calculate if all 5 names used at least once
    private static boolean allNamesUsedOrNot(ArrayList<String> randomList) {
        for (int i = 0; i < randomList.size(); i++) {
            for (int j = 0; j < fiveDistinctNames().size(); j++) {
                if (!randomList.contains(fiveDistinctNames().get(i))) {
                    return false;
                }
                if (randomList.contains(fiveDistinctNames().get(i))) {
                    return true;
                }
            }
        }
        return true;
    }

    //put randomly selected name into the same arrayList
    private static ArrayList<String> randomListOfValues(ArrayList<String> fiveNames, ArrayList<Integer> absences) {
        Random random = new Random();
        ArrayList<String> newListOfNames = new ArrayList<>();
        String randomName = "";
        for (int i = 0; i < absences.size(); i++) {
            //Randomly select one of the 5 names.
            randomName = fiveNames.get(random.nextInt(fiveNames.size()));
            //add randomly selected name to the list
            newListOfNames.add(randomName);

        }
        // Add that selected name to the ArrayList.
        return newListOfNames;
    }

    // Shuffle the names using a user-defined shuffle function.
    private static void shuffleNames(ArrayList<String> fiveNames) {
        Random random = new Random();
        for (int i = 0; i < fiveNames.size(); i++) {
            //next three lines do swap
            // set to random index
            int randomIndex = random.nextInt(fiveNames.size());
            String temp1 = fiveNames.get(randomIndex);
            fiveNames.set(randomIndex, fiveNames.get(i));
            fiveNames.set(i, temp1);

        }
    }

    //how many of each absence?
    private static void howManyOfEachAbsence(ArrayList<Integer> absences) {
        Map<Integer, Integer> eachAbsenceMap = new HashMap<>();
        for (int key : absences) {
            if (!eachAbsenceMap.containsKey(key)) {
                eachAbsenceMap.put(key, 1);
            } else {
                int value = eachAbsenceMap.get(key) + 1;
                eachAbsenceMap.put(key, value);
            }

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
    private static ArrayList elementShuffle(ArrayList<Integer> absences) {
        Random random = new Random();
        for (int i = 0; i < absences.size(); i++) {
            int shuffle = random.nextInt(absences.size());
            int temp1 = absences.get(shuffle);
            absences.set(shuffle, absences.get(i));
            absences.set(i, temp1);
        }
        return absences;
    }

    private static Set<Integer> returnUniqueValues(ArrayList<Integer> absences) {
        //user-defined unique values function
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
    private static ArrayList<Integer> addTheAbsences(ArrayList<Integer> absences, int newNum, int element) {
        // X is a positive, negative, or even zero integer.
        // Y can be any integer too.
        // No absence should be less than zero or more than 15 after performing this calculation.
        // If an absence would be negative, set it to zero. If an absence would be more than 15, set it to 15.
        ArrayList<Integer> addAbsArrayList = new ArrayList<>();
        addAbsArrayList = absences;
        for (int i = 0; i < addAbsArrayList.size(); i++) {
            if (addAbsArrayList.get(i) >= element) {
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

    //what the students missed more than twice the class time (FE)
    private static int absentMoreThanTwice(ArrayList<Integer> absences) {
        //the index(es) of the student(s) who were absent more than twice the number of times the course meets per week.
        /** english explanation
         *
         *
         * **/
        int count = 0;
        for (int i = 0; i < absences.size(); i++) {
            int product = absences.size() * 2 + 1;
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

