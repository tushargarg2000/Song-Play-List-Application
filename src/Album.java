import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    String name;
    String artist;
    ArrayList<Song> songs; //Objects /Reference variables....they always have to be initalized

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();

    }

    public Song findSong(String title){

        for(Song checkSong : songs){

            if(checkSong.title==title){
                return checkSong;
            }
        }
        return null;
    }

    public void addSong(String title,double duration){

        if(findSong(title)==null){
            //Adding the song
            Song newSong = new Song(title,duration);
            this.songs.add(newSong);

        }
        else{
            System.out.println("The song is already present");
        }
    }
    //trackNo --> this particular number of the album ---> should be added to playlist
    public boolean addToPlayList(int trackNo, LinkedList<Song> playList){

        int index = trackNo - 1;

        if(index>=0 && index <this.songs.size()){
            playList.add(this.songs.get(index));
            return true;
        }

        //Make some checks on the index ----> add that index song in the playList
        return false;
    }

    public boolean addToPlayList(String title,LinkedList<Song> playList){


        for(Song checkedSong : this.songs){

            if(checkedSong.title==title){
                playList.add(checkedSong);
                return true;
            }
        }
        //Find the song for that title ---> Add that song in the playList
        return false;
    }




}
