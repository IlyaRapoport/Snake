import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WritingFile {

    public void writing(String fileForWriting) throws IOException {

        File outputFile = new File("src/main/resources/scores.txt");

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(fileForWriting);

        writer.close();
    }
}
