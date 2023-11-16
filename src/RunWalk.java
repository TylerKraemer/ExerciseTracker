import java.text.ParseException;

/**
 * This class implements the get and set functions for the Run/Walk exercise
 */
class RunWalk extends Exercise {
    private double distance;

    /**
     * This function introduces the strings for the run/walk exercise
     * @param name This is the name of the workout
     * @param comment this is a comment about the workout
     * @param date this is the date of the workout
     * @param duration this is the duration of the workout
     * @param distance this is the distance the user ran
     * @throws ParseException this is to catch any errors the user may have typed in
     */
    public RunWalk(String name, String comment, String date, int duration, double distance) throws ParseException {
        super(name, comment, date, duration);
        this.distance = distance;
    }

    /**
     * This function gets the type of exercise that is being called
     * @return this returns the run/walk exercise when it applies to the correct type
     */
    @Override
    public String getType() {
        return "Run/Walk";
    }

    /**
     * This function calculates how many calories were burned in this exercise
     * @return this returns the amount of calories burned
     */
    @Override
    public double getCaloriesBurned() {
        return (distance / getDuration()) * 9000;
    }
}
