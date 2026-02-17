import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Playlist {
    private ArrayList<Song> songs;

    public Playlist() throws IOException, FileNotFoundException{
        readText();
    }

    public String toString(){
        String result = String.format("%-30s %-30s %-35s %-10s %-20s", "Title", "Artist", "Album", "Year", "Genre");
        result += "\n----------------------------------------------------------------------------------------" +
                "--------------------------------";
        result += "\n";
        for(Song a: songs){
            result += a.toString() + "\n";
        }
        return result;
    }

    public void readText() throws IOException, FileNotFoundException{
        Scanner inFile = new Scanner(new File("spotify_unique_years_artists.txt"));
        ArrayList<Song> list = new ArrayList<Song>();
        while(inFile.hasNextLine()){
            String line = inFile.nextLine();
            String[] split = line.split(",");
            String t = split[0];
            String art = split[1];
            String alb = split[2];
            String duration = split[3];
            String year = split[4];
            int y = Integer.parseInt(year);
            String g = split[5];
            Song cancion = new Song(t, art, alb, y, g);
            list.add(cancion);
        }
        songs = list;
    }

    public void sortArtistAZ(){
        for(int i=0; i<songs.size(); i++){
            for(int j=0; j<songs.size(); j++){
                if(j!=i){
                    Song a = songs.get(i);
                    Song b = songs.get(j);
                    if(a.getArtist().toUpperCase().compareTo(b.getArtist().toUpperCase())<=0){
                        songs.remove(i);
                        if(i<j){
                            songs.add(j-1, a);
                        }
                        else{
                            songs.add(j, a);
                            i--;
                        }
                        j=songs.size();
                    }
                    if(j==songs.size()-1){
                        songs.add(songs.remove(i));
                    }
                }
            }
        }
    }

    public void sortArtistZA(){
        sortArtistAZ();
        for(int i=0; i<=songs.size()/2; i++){
            songs.set(i, songs.set(songs.size()-i-1, songs.get(i)));
        }
    }

    public void searchGenre(String genre){
        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                System.out.println(song.toString());
            }
        }

    }

    public void sortYear(){
        for(int i=0; i<songs.size(); i++){
            for(int j=0; j<songs.size(); j++){
                Song a = songs.get(i);
                Song b = songs.get(j);
                if(a.getYear()<=b.getYear()){
                    songs.remove(i);
                    if(i<j){
                        songs.add(j-1, a);
                        i--;
                    }
                    else{
                        songs.add(j, a);
                    }
                    j=songs.size();
                }
                if(j==songs.size()-1){
                    songs.add(songs.remove(i));
                }
            }
        }
    }


}
