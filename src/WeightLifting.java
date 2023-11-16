import java.text.ParseException;

/**
 * This class implements the get and set functions to document the weightlifting exercise.
 */
class WeightLifting extends Exercise {
    /**
     * This introduces the integer for the total weight lifted
     */
    private int totalWeight;

    /**
     * This introduces all the strings needed for the weightlifting exercise to be documented
     * @param name this is the name of the workout
     * @param comment this is a comment about the workout
     * @param date this is the date the workout was completed
     * @param duration this is the duration of the workout
     * @param totalWeight this is the total weight that was lifted during the workout
     * @throws ParseException this is to catch any errors the user may have inputted
     */
    public WeightLifting(String name, String comment, String date, int duration, int totalWeight) throws ParseException {
        super(name, comment, date, duration);
        this.totalWeight = totalWeight;
    }

    /**
     * This is the function gets the type of the exercise the user inputs
     * @return this returns the weightlifting exercise if it is what the user chose
     */
    @Override
    public String getType() {
        return "Weightlifting";
    }

    /**
     * This function calculates the amount of calories burned in the weightlifting exercise
     * @return
     */
    @Override
    public double getCaloriesBurned() {
        return (totalWeight / getDuration()) * 50;
    }
}