package coursework2;

public class Song {

    private String name;
    private String artist;
    private int playTime;
    private String videoPath;

    public Song(String name, String artist, int playTime, String videoPath) {
        this.name = name;
        this.artist = artist;
        this.playTime = playTime;
        this.videoPath = videoPath;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public int getPlayTime() {
        return playTime;
    }

    public String getLocation() {
        return videoPath;
    }
}