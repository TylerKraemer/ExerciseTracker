abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private String comment;
    private String date;
    private int duration;

    public Exercise(String name, String comment, String date, int duration) {
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public abstract String getType();

    public abstract double getCaloriesBurned();

    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return getType() + "\t" + name + "\t" + date + "\t" + getCaloriesBurned();
    }
}