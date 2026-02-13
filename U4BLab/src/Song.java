public class Song {
    private String title;
    private String artist;
    private String album;
    private int year;
    private String genre;

    public Song(String t, String art, String alb, int y, String g){
        title = t;
        artist = art;
        album = alb;
        year = y;
        genre = g;
    }

    public String toString(){
        String result = String.format("%-30s %-30s %-35s %-10d %-20s", title, artist, album, year, genre);
        return result;
    }
    public String getArtist(){return artist;}
    public int getYear(){return year;}

}
