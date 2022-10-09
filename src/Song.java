
public class Song {

    String title;
    double duration;

    public Song(String name, double duration) {
        this.title = name;
        this.duration = duration;
    }

    //Used to print the content of the Class Song
    @Override
    public String toString() {
        return "Song{" +
                "name='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
