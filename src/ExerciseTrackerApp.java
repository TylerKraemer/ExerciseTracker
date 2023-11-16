import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is the super class that compiles all the other classes together to write the whole program and make it all work together
 */
public class ExerciseTrackerApp {
    /**
     * This is the main function that implements all the classes and accepts the user inputs for the exercies
     * @param args
     * @throws ParseException this is to catch any errors the user inputs
     */
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        List<Exercise> exerciseList = new ArrayList<>();

        while (true) {
            System.out.println("These are your choices:\n" +
                    "1. Add an exercise\n" +
                    "2. Print exercises to file\n" +
                    "3. List sorted by date\n" +
                    "4. List sorted by calories burned\n" +
                    "5. Exit\n" +
                    "Enter the number of your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                addExercise(scanner, exerciseList);
            } else if (choice == 2) {
                System.out.println("Enter the name of the file to save:");
                String filename = scanner.nextLine();
                ExerciseWriter.writeToFile(exerciseList, filename);
                System.out.println("Your exercises were written to the file.");
            } else if (choice == 3) {
                Collections.sort(exerciseList);
                ExerciseWriter.tabulateSummary(exerciseList);
            } else if (choice == 4) {
                exerciseList.sort(new ExerciseCompareByCalories());
                ExerciseWriter.tabulateSummary(exerciseList);
            } else if (choice == 5) {
                System.out.println("Congratulations on staying in shape!");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    /**
     * This function implements the ability to add an exercise to the list and input information about a new exerise.
     * @param scanner This is the scanner that scans the users inputs for the exercises
     * @param exerciseList This is the array list of all the exercises the user inputs
     * @throws ParseException This is to catch any errors the user inputs
     */
    private static void addExercise(Scanner scanner, List<Exercise> exerciseList) throws ParseException {
        System.out.println("Describe your workout:\nEnter R for run/walk, W for weightlifting, or C for rock climbing:");
        String exerciseType = scanner.nextLine();

        System.out.println("Enter a name for the workout:");
        String name = scanner.nextLine();

        System.out.println("Enter date of workout (MM/DD/YYYY):");
        String date = scanner.nextLine();

        if (exerciseType.equals("R")) {
            System.out.println("Enter distance you ran or walked in miles:");
            double distance = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("Enter a comment about the workout:");
            String commentR = scanner.nextLine();
            System.out.println("How long did you work out in minutes:");
            int durationR = scanner.nextInt();
            exerciseList.add(new RunWalk(name, commentR, date, durationR, distance));
        } else if (exerciseType.equals("W")) {
            System.out.println("Enter total weight lifted in pounds:");
            int totalWeight = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter a comment about the workout:");
            String commentW = scanner.nextLine();
            System.out.println("How long did you work out in minutes:");
            int durationW = scanner.nextInt();
            exerciseList.add(new WeightLifting(name, commentW, date, durationW, totalWeight));
        } else if (exerciseType.equals("C")) {
            System.out.println("Enter the height of the wall in feet:");
            int wallHeight = scanner.nextInt();
            System.out.println("Enter number of times you climbed it:");
            int repetitions = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.println("Enter a comment about the workout:");
            String commentC = scanner.nextLine();
            System.out.println("How long did you work out in minutes:");
            int durationC = scanner.nextInt();
            exerciseList.add(new RockClimbing(name, commentC, date, durationC, wallHeight, repetitions));
        } else {
            System.out.println("Invalid exercise type. Try again.");
        }
    }
}