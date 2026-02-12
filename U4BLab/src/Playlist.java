import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Playlist {
    private ArrayList<Song> songs;

    public Playlist() throws IOException, FileNotFoundException{
        songs = readText();
    }

    public ArrayList<Song> readText() throws IOException, FileNotFoundException{
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
        return list;
    }

    public ArrayList<Song> sortArtistAZ(){
        ArrayList<Song> list = songs;
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.size(); j++){
                Song a = list.get(i);
                Song b = list.get(j);
                if(a.getArtist().substring(0,1).compareToIgnoreCase(b.getArtist().substring(0,1))<0){
                        if(i<j){
                            list.remove(i);
                            list.add(j-1, a);
                        }
                        else{
                            list.remove(i);
                            list.add(j, a);
                        }
                }
                if(j==list.size()-1){

                }
            }
            i--;
        }
    }
}
