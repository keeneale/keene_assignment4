import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class DuplicateRemover
{
    Set<String> uniqueWords = new HashSet<String>();

    // Determines unique words in file
    public void remove(String dataFile)
    {
        Scanner in = null;

        try
        {
            in = new Scanner(Paths.get(dataFile));

            while (in.hasNext())
            {
                // Stores unique words in lowercase without punctuation
                uniqueWords.add(in.next().toLowerCase().replaceAll("[\\W]", ""));
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

    // Prints unique words to file
    public void write(String outputFile)
    {
        Formatter out = null;
        Iterator<String> iterator = uniqueWords.iterator();

        try
        {
            out = new Formatter(outputFile);

            while(iterator.hasNext())
            {
                out.format("- %s%n", iterator.next());
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