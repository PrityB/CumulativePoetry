import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

class CumulativePoetry {
    private static final String INTRO = "This is ";
    private static final String FILE_PATH = "src/main/java/Poem.txt";

    public static void main(String args[]) {
        System.out.println(printTillDay(5));
    }

    static String printTillDay(int days) {
        List<String> lines = getLinesFromFile();
        String poem = new String();
        String finalPoem = new String();

        int linesLength = lines.size();
        for (int index = linesLength - 1; index >= linesLength - days; index--) {
            poem = lines.get(index) + "\n" + poem;
        }

        finalPoem += INTRO + poem;

        return finalPoem;
    }

    static List<String> getLinesFromFile() {
        List<String> lists = new ArrayList<>();

        try {
            BufferedReader in = new BufferedReader(new FileReader(FILE_PATH));
            String tempStr;
            while ((tempStr = in.readLine()) != null)
                lists.add(tempStr);

            return lists;
        } catch (FileNotFoundException exception) {
            System.err.println("File not found - " + exception.getMessage());
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }

        return lists;
    }
}