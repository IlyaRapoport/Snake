import java.util.Comparator;

public class CustomCompare implements Comparator<ScoreCalc> {

    public int compare(ScoreCalc o1, ScoreCalc o2) {
        if (o1.getScoreForSorting() < o2.getScoreForSorting()) {
            return 1;
        } else if (o1.getScoreForSorting() > o2.getScoreForSorting()) {
            return -1;
        }
        return 0;
    }
}
