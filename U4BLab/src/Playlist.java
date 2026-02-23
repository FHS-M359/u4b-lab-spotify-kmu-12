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

    public void searchGenre(String genre){
        for(Song song: songs){
            if(song.getGenre().equalsIgnoreCase(genre)){
                System.out.println(song.toString());
            }
        }

    }

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
