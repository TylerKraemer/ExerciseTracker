import java.util.Comparator;

/**
 * This class implements logic to compare the exercises based on how many calories are burned
 */
class ExerciseCompareByCalories implements Comparator<Exercise> {
    @Override
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e2.getCaloriesBurned(), e1.getCaloriesBurned());
    }
}