package coursework2;

/**
 * Song Class
 * 
 * Stores Song Information such as Song Name & Artist Name. Implements Easy
 * Methods for Quick Data Retrieval
 * 
 * @author LaveshPanjwani
 */
public class Song {
    // String: Song Name
    private String name;
    // String: Song Artist Name
    private String artist;
    // Integer: Song Play Time
    private int playTime;
    // String: Song Video Location
    private String videoPath;

    /*
     * New Song Constructor
     * 
     * @params Song Name, Artist Name, Play Time, Video Path
     */
    public Song(String name, String artist, int playTime, String videoPath) {
        this.name = name;
        this.artist = artist;
        this.playTime = playTime;
        this.videoPath = videoPath;
    }

    /*
     * Retrieve Song Name
     * 
     * @returns String
     */
    public String getName() {
        return name;
    }

    /*
     * Retrieve Song Artist Name
     * 
     * @returns String
     */
    public String getArtist() {
        return artist;
    }

    /*
     * Retrieve Song Play Time
     * 
     * @returns Integer
     */
    public int getPlayTime() {
        return playTime;
    }

    /*
     * Retrieve Song Video Path
     * 
     * @returns String
     */
    public String getLocation() {
        return videoPath;
    }

    /*
     * Return Display Name
     * 
     * @returns String
     */
    public String toString() {
        return name + " ft. " + artist;
    }
}