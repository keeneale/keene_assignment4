import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;

public class DuplicateCounter {
    HashMap<String, Integer> wordCounter = new HashMap<String, Integer>();

    // Determines number of times each word in file appears
    public void count(String dataFile)
    {
        Scanner in = null;
        String storeWord;

        try
        {
            in = new Scanner(Paths.get(dataFile));

            while(in.hasNext())
            {
                // Stores unique words in lowercase without punctuation
                storeWord = in.next().toLowerCase().replaceAll("[\\W]", "");

                if (wordCounter.containsKey(storeWord))
                {
                    wordCounter.replace(storeWord, wordCounter.get(storeWord) + 1);
                }
                else
                {
                    wordCounter.put(storeWord, 1);
                }
            }
        }

        catch(IOException exception)
        {
            System.out.println("Error: There has been an issue reading " + exception.getMessage());
            System.exit(0);
        }

        finally
        {
            if (in != null)
            {
                in.close();
            }
        }
    }

    // Prints unique words and their counts to file
    public void write(String outputFile)
    {
        Formatter out = null;

        try
        {
            out = new Formatter(outputFile);

            for (String word : wordCounter.keySet())
            {
                out.format("- %s (%s)%n", word, wordCounter.get(word));
            }
        }

        catch(IOException exception)
        {
            System.out.println("Error: There has been an issue writing " + exception.getMessage());
            System.exit(0);
        }

        finally
        {
            if (out != null)
            {
                out.close();
            }
        }
    }
}





// count method shall determine the number of occurrences of each word contained in dataFIle
// and store each unique word and its count in the associated DuplicateCounter object
// count method shall terminate the program and alert the user when an exceptional IO event occurs
// count method shall clean up any and all resources allocated during method execution

// write method shall print the current collection of unique words and their counts to outputFile
// write method shall terminate the program and alert the user when an exceptional IO event occurs
// write method shall clean up any and all resources allocated during method execution


