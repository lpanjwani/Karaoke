/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework2;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

/**
 *
 * @author LaveshPanjwani
 */

interface Utils {

    public static List<Song> ReadTabFile(String fileName) throws FileNotFoundException {
        // Get File with Relative Path
        File file = new File(RelativeFilePath(fileName).getFile());

        // Try Reading from File
        try (Scanner scanner = new Scanner(file)) {
            // Create Blank New List for Storing Library Songs information
            List<Song> library = new ArrayList<Song>();

            // Iterate over each line of the file
            while (scanner.hasNextLine()) {
                // Retrieve Line Data
                String data = scanner.nextLine();

                // Split & Store Song Data by Tabs (Tubular) Format
                String[] rawSong = data.split("\t");

                // Parse Song Play Time Integer
                int playTime = Integer.parseInt(rawSong[2]);

                // Add Data to Song Object for Easy Accessability
                Song current = new Song(rawSong[0], rawSong[1], playTime, rawSong[3]);

                // Add Song Object to Library
                library.add(current);
            }

            // Return Library List
            return library;
        } catch (FileNotFoundException e) {
            // Print StackTrace if Error occurs during Reading
            e.printStackTrace();
        }
        // Default Returns null
        return null;
    }

    public static URL RelativeFilePath(String fileName) throws FileNotFoundException {
        // Get Resource File Path
        URL path = Utils.class.getResource(fileName);

        // File Object for File Exists Check
        File f = new File(path.toExternalForm());
        // File Exists Conditional Routing
        if (f.exists() && !f.isDirectory())
            // Throw Exception if file doesn't exist
            throw new FileNotFoundException();

        // Return Path is file exists
        return path;
    }
}
