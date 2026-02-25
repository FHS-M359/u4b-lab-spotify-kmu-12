import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Playlist {
    private ArrayList<Song> songs;

    // Description: calls readText() to initialize the songs variable
    // Input: none
    // Output: none
    public Playlist() throws IOException, FileNotFoundException{
        readText();
    }

    // Description: formats the array list songs into a string using the toString method in the Song class
    // Input: none
    // Output: String with all the Song elements formatted
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

    // Description: reads in the text and initializes Song elements in the array list
    // Input: none
    // Output: none
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

    // Description: sorts songs by artist alphabetically A to Z using selection sort
    // Input: none
    // Output: none
    public void sortArtistAZ(){
        for(int i=0; i<songs.size()-1; i++){
            int minIndex = i;
            for(int j=i+1; j<songs.size(); j++){
                Song a = songs.get(minIndex);
                Song b = songs.get(j);
                if(a.getArtist().compareToIgnoreCase(b.getArtist())>0){
                    minIndex = j;
                }
            }
            songs.set(i, songs.set(minIndex, songs.get(i)));
        }
    }

    // Description: sorts songs by artist alphabetically Z to A using selection sort
    // Input: none
    // Output: none
    public void sortArtistZA(){
        for(int i=0; i<songs.size()-1; i++){
            int maxIndex = i;
            for(int j=i+1; j<songs.size(); j++){
                Song a = songs.get(maxIndex);
                Song b = songs.get(j);
                if(a.getArtist().compareToIgnoreCase(b.getArtist())<0){
                    maxIndex = j;
                }
            }
            songs.set(i, songs.set(maxIndex, songs.get(i)));
        }
    }

    // Description: filters all songs with a specific genre and prints it
    // Input: genre, the genre typed from the
    // Output: songs  or none found PRINTED, nothing returned
    public void searchGenre(String genre){
        boolean found = false;
        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                found = true;
                System.out.println(song.toString());
            }
        }
        if(!found){
            System.out.println("Genre not found");
        }

    }

    // Description: sorts songs by year from newest (greatest year) to oldest (smallest year) using insertion sort
    // Input: none
    // Output: none
    public void sortYearNewtoOld(){
        for(int i=1; i<songs.size(); i++){
            int position = i;
            Song temporaryValue = songs.get(i);
            while(position>0 && songs.get(position-1).getYear()<temporaryValue.getYear()){
                songs.set(position, songs.get(position-1));
                position--;
            }
            songs.set(position, temporaryValue);
        }
    }

    // Description: sorts songs by year from oldest to newest using insertion sort
    // Input: none
    // Output: none
    public void sortYearOldtoNew(){
        for(int i=1; i<songs.size(); i++){
            int position = i;
            Song temporaryValue = songs.get(i);
            while(position>0 && songs.get(position-1).getYear()>temporaryValue.getYear()){
                songs.set(position, songs.get(position-1));
                position--;
            }
            songs.set(position, temporaryValue);
        }
    }


}
