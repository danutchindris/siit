package ro.siit.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Reads the content of a text file from a specified URL
 * and prints it out at the standard output stream.
 */
public class UrlDemo {

    public static void main(final String[] args) {
        if (args.length > 0) {
            try (final BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new URL(args[0]).openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Something wrong has happened while reading from the URL" + e.getMessage());
            }
        } else {
            System.out.println("Please pass the URL as argument");
        }
    }
}
