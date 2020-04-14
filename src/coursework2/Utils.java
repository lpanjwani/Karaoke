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

public class Utils {

    public static List<Song> ReadTabFile() throws FileNotFoundException {
        File file = new File(RelativeFilePath("songs.txt").getFile());

        try (Scanner scanner = new Scanner(file)) {
            List<Song> library = new ArrayList<Song>();

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();

                String[] rawSong = data.split("\t");

                int playTime = Integer.parseInt(rawSong[2]);

                Song current = new Song(rawSong[0], rawSong[1], playTime, rawSong[3]);

                library.add(current);
            }

            return library;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL RelativeFilePath(String fileName) throws FileNotFoundException {

        URL path = Utils.class.getResource(fileName);

        File f = new File(path.toExternalForm());
        if (f.exists() && !f.isDirectory())
            throw new FileNotFoundException();

        return path;
    }
}
