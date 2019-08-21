import java.io.IOException;
import java.util.ArrayList;

public class ScoreCalc {

    private int scoreForSorting;
    private String nameForSorting;

    private ScoreCalc(int scoreForSorting, String nameForSorting) {
        this.nameForSorting = nameForSorting;
        this.scoreForSorting = scoreForSorting;
    }

    ScoreCalc() {
    }

    public ArrayList<ScoreCalc> scoreCalc(String nameInput, int scoreInput) throws IOException {

        WritingFile writingFile = new WritingFile();
        ReadingFile readingFile = new ReadingFile();

        StringBuffer bufferedReader = readingFile.reading();

        bufferedReader.append(scoreInput).append(" ").append(nameInput).append("\n");

        String[] sorting = bufferedReader.toString().split("[\\n \\s]");

        ArrayList<ScoreCalc> sortingList = new ArrayList<>();

        for (int i = 0; i < sorting.length; i += 2) {
            setScoreForSorting(Integer.parseInt(sorting[i]));
            setNameForSorting(sorting[i + 1]);
            ScoreCalc scoreCalc = new ScoreCalc(Integer.parseInt(sorting[i]), sorting[i + 1]);
            sortingList.add(scoreCalc);
        }

        sortingList.sort(new CustomCompare());

        writingFile.writing(bufferedReader.toString());

        return sortingList;
    }

    public int getScoreForSorting() {
        return scoreForSorting;
    }

    public void setScoreForSorting(int scoreForSorting) {
        this.scoreForSorting = scoreForSorting;
    }

    public String getNameForSorting() {
        return nameForSorting;
    }

    public void setNameForSorting(String nameForSorting) {
        this.nameForSorting = nameForSorting;
    }
}
