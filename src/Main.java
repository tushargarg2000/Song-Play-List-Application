import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args){

        Album album = new Album("Album1","AC/DC");

        album.addSong("TNT",4.5);
        album.addSong("Highway to hell",3.5);
        album.addSong("ThunderStruck",5.0);
        albums.add(album);

        album = new Album("Album2", "Eminem");

        album.addSong("Rap god",4.5);
        album.addSong("Not Afraid",3.5);
        album.addSong("Lose yourself",4.5);

        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();

        albums.get(0).addToPlayList("TNT",playList_1);
        albums.get(0).addToPlayList("Highway to hell",playList_1);
        albums.get(1).addToPlayList("Rap god",playList_1);
        albums.get(1).addToPlayList("Lose yourself",playList_1);

        play(playList_1);

    }
/*

    TNT
    Highway
    rap god
    lose yourself

 */
    public static void play(LinkedList<Song> playList_1){

        Scanner sc = new Scanner(System.in);

        boolean quit = false;

        boolean forward = true;

        ListIterator<Song> listIterator = playList_1.listIterator();

        if(playList_1.size()>0){
            System.out.println("Now playing the song"+ listIterator.next().toString());
            printMenu();
        }
        else{
            System.out.println("Empty playlist");
        }

        while(!quit){

            int action = sc.nextInt();

            switch (action){

                case 0:

                    System.out.println("Thanks for listening the playList....bbyee");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing "+ listIterator.next().toString());
                    }else{
                        System.out.println("We are playing the last song");
                        forward = false;
                    }
                    break;

                case 2:
                    if(forward){

                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+ listIterator.previous().toString());
                    }else{
                        System.out.println("We are at the first song");
                        forward = false;
                    }
                    break;
                case 3:
                    if(forward){

                    }else{

                    }
                    break;
                case 4:
                    printAllSongs(playList_1);
                    break;
                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList_1.size()>0){
                        listIterator.remove();
                    }

                    if(listIterator.hasNext()){
                        System.out.println("Now playing "+listIterator.next().toString());
                    }
                    else if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }
            }
        }
    }
    public static void printAllSongs(LinkedList<Song> playList){

        ListIterator<Song> listIterator = playList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next().toString());
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }
}
