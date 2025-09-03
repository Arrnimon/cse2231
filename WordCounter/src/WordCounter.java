import components.map.Map;
import components.map.Map.Pair;
import components.map.Map1L;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Utility class for reading a text file, counting the occurrences of each word,
 * and generating an HTML table output of the counts sorted alphabetically.
 *
 * <p>
 * This class is a utility class: all methods are static, and it cannot be
 * instantiated or subclassed.
 * </p>
 *
 * @author Arnav Satish Muley
 *
 */
public final class WordCounter {

    /**
     * Private constructor to prevent instantiation of this utility class.
     * Attempting to instantiate will throw an AssertionError.
     */
    private WordCounter() {

    }

    /**
     * No argument constructor--private to prevent instantiation.
     */

    /**
     * Reads an input text file and counts the occurrences of each word.
     *
     * <p>
     * Words are considered as any sequence of characters separated by
     * whitespace. Counts are stored in a {@code Map<String, Integer>} where the
     * key is the word and the value is its frequency.
     * </p>
     *
     * @param inputFile
     *            the path to the input file
     * @return a map of words and their corresponding counts
     */
    public static Map<String, Integer> readFile(String inputFile) {
        SimpleReader1L fileReader = new SimpleReader1L(inputFile);
        Map<String, Integer> wordMap = new Map1L<>();

        while (!fileReader.atEOS()) {
            String line = fileReader.nextLine();
            line = line.toLowerCase();
            String currentWord = "";

            for (int i = 0; i < line.length(); i++) {

                char character = line.charAt(i);
                String characterEqualComparison = String.valueOf(character);

                if (!Character.isWhitespace(character)
                        && !characterEqualComparison.equals(".")
                        && !characterEqualComparison.equals(",")
                        && !characterEqualComparison.equals("-")) {
                    currentWord += character;

                } else {
                    if (!wordMap.hasKey(currentWord)) {
                        wordMap.add(currentWord, 1);
                    } else {
                        wordMap.replaceValue(currentWord, wordMap.value(currentWord) + 1);
                    }
                    currentWord = "";
                }
            }
        }

        fileReader.close();

        return wordMap;

    }

    /**
     * Prints the introduction section of the HTML output, including a title
     * with the input file name.
     *
     * @param output
     *            the output writer
     * @param inputFile
     *            the name of the input file
     */
    public static void printIntroduction(SimpleWriter output, String inputFile) {
        output.print("<html><body><h1> Words counted in " + inputFile);

    }

    /**
     * Prints the word counts in an HTML table, sorted alphabetically by the
     * first letter of each word.
     *
     * <p>
     * Each row contains a word and its corresponding count.
     * </p>
     *
     * @param output
     *            the output writer
     * @param wordMap
     *            the map of words and their counts
     */
    public static void printAlphabeticallyIntoTable(SimpleWriter output,
            Map<String, Integer> wordMap) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        output.println("<table>");
        output.println("<tr><th> Words </th> <th>Counts</th>");
        String pairToPrint = "";

        wordMap.remove("");

        while (wordMap.size() > 0) {
            pairToPrint = "";
            int weakestCharacterPower = Integer.MAX_VALUE;
            for (Pair<String, Integer> pair : wordMap) {
                if (alphabet.indexOf(pair.key().charAt(0)) < weakestCharacterPower) {
                    weakestCharacterPower = alphabet.indexOf(pair.key().charAt(0));
                    pairToPrint = pair.key();
                } else if (alphabet
                        .indexOf(pair.key().charAt(0)) == weakestCharacterPower) {
                    boolean alternateLetterFound = false;
                    int i = 1;
                    while (!alternateLetterFound && i < pair.key().length()
                            && i < pairToPrint.length()) {

                        int c1 = alphabet.indexOf(pair.key().charAt(i));
                        int c2 = alphabet.indexOf(pairToPrint.charAt(i));

                        if (c1 < c2) {
                            pairToPrint = pair.key();
                            alternateLetterFound = true;
                        } else if (c1 > c2) {
                            alternateLetterFound = true;
                        } else {
                            i++;
                        }
                    }
                }

            }

            output.println("<tr><td> " + pairToPrint + " </td><td>"
                    + wordMap.value(pairToPrint) + "</td></tr>");

            wordMap.remove(pairToPrint);

        }

        output.println("</table>");

    }

    /**
     * Prints the footer of the HTML output.
     *
     * @param output
     *            the output writer
     */
    public static void printFooter(SimpleWriter output) {
        output.println("</body></html>");
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        /*
         * Put your main program code here
         */
        String outputFile = "";
        String inputFile = "";

        SimpleReader1L input = new SimpleReader1L();
        SimpleWriter1L output = new SimpleWriter1L();

        output.print("Enter an input file");
        inputFile = input.nextLine();
        output.print("Enter an output file");
        outputFile = input.nextLine();

        SimpleWriter outputFileWriter = new SimpleWriter1L(outputFile);

        Map<String, Integer> wordMap = readFile(inputFile);

        printIntroduction(outputFileWriter, inputFile);

        printAlphabeticallyIntoTable(outputFileWriter, wordMap);

        printFooter(outputFileWriter);

        input.close();
        output.close();

    }

}
