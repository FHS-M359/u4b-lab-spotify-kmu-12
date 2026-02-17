import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SpotifyTester {
    public static void main(String[] args) throws IOException, FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        boolean everythingsFine = false;
        boolean gameContinuity = true;
        while(gameContinuity){
            System.out.println("=~=~= Spotify MENU =~=~=");
            System.out.println("1) Sort by artist (A through Z)\n2) Sort by artist (Z through A)");
            System.out.println("3) Sort by year (oldest to newest)\n4) Sort by year (newest to oldest)");
            System.out.print("5) Search by genre\n6) Display all songs\n7) Quit\nEnter you choice (1-7): ");
            int choice = 0;
            while(!everythingsFine){
                try{
                    choice = scan.nextInt();
                    if(!(choice>0&&choice<8)){
                        System.out.print("Enter a number between 1 and 7: ");
                    }
                    else{
                        everythingsFine = true;
                    }
                }
                catch (InputMismatchException e){
                    System.out.print("Invalid input. Enter a number between 1 and 7: ");
                    scan.nextLine();
                }
            }

            if(choice==7){gameContinuity = false;}
            else{
                Playlist playList = new Playlist();
                if(choice==1){
                    playList.sortArtistAZ();
                    System.out.println("\n" + playList.toString());
                }
                else if(choice==2){
                    playList.sortArtistZA();
                    System.out.println("\n" + playList.toString());}
                else if(choice==3){
                    playList.sortYear();
                    System.out.println("\n" + playList.toString());
                }
                else if(choice==5){
                    System.out.print("\nEnter genre to search: ");
                    String input = "";
                            scan.nextLine();
                            input = scan.nextLine();
                    playList.searchGenre(input);
                    System.out.println("\n");
                }
                everythingsFine = false;
            }

        }
    }
}
