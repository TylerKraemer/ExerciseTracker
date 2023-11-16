import java.text.ParseException;

/**
 * This class implements the get and set functions for rockclimbing exercise
 */
class RockClimbing extends Exercise {
    private int wallHeight;
    private int repetitions;

    /**
     * This function introduces all the strings for the information needed to document the rock climbing exercise
     * @param name this is the name of the workout
     * @param comment this is a comment about the workout
     * @param date this is the date the workout was completed
     * @param duration this is the duration of the workout
     * @param wallHeight this is the height of the wall climbed
     * @param repetitions this is the amount of times the user climbed the wall
     * @throws ParseException this is to catch any errors the user may have inputted
     */
    public RockClimbing(String name, String comment, String date, int duration, int wallHeight, int repetitions) throws ParseException {
        super(name, comment, date, duration);
        this.wallHeight = wallHeight;
        this.repetitions = repetitions;
    }

    /**
     * This function gets the type of the exercise the user wants to input
     * @return this returns the rock climbing exercise if it is the choice the user makes
     */
    @Override
    public String getType() {
        return "Rock Climbing";
    }

    /**
     * This is the function that calculates the amount of calories burned during the workout
     * @return this returns the amount of calories burned
     */
    @Override
    public double getCaloriesBurned() {
        return (wallHeight * repetitions / getDuration()) * 100;
    }
}