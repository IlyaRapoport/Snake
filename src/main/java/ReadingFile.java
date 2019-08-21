import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFile {

    public StringBuffer reading() throws IOException {

        File file = new File("src/main/resources/scores.txt");

        if (file.createNewFile()) {
        }

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while ((line = bufferedReader.readLine()) != null) {

            stringBuffer.append(line).append("\n");
        }

        return stringBuffer;
    }
}
