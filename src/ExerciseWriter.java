import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * This class writes the summary to screen for the program and also writes the exercises to a file of the users choice.
 */
class ExerciseWriter {
    /**
     * This function writes the exercises to a file
     * @param exercises this is the exercises that will be written to the file
     * @param filename this is the file name the user inputted of where they want the exercises written to
     */
    public static void writeToFile(List<Exercise> exercises, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Exercise exercise : exercises) {
                writer.write(exercise.toString());
                writer.newLine();
            }
            System.out.println("Exercises written to the file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * This function writes the exercises out to the screen on the program
     * @param exercises these are the inputted exercises from the user
     */
    public static void printToScreen(List<Exercise> exercises) {
        for (Exercise exercise : exercises) {
            System.out.println(exercise);
        }
    }

    /**
     * This is the summary created by the inputted exercises
     * @param exercises these are the exercises the user inputted
     */
    public static void tabulateSummary(List<Exercise> exercises) {
        System.out.println("Type\tName\tDate\tCalories Burned");
        for (Exercise exercise : exercises) {
            System.out.println(exercise.getType() + "\t" + exercise.getName() + "\t" + exercise.getDate() + "\t" + exercise.getCaloriesBurned());
        }
    }
}