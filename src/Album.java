import java.util.ArrayList;

public class Album {
    private String title;
    private ArrayList<Song> album;

    public Album(String title) {
        this.title = title;
        album = new ArrayList<>();
    }

    public int findSong(String songName) {

        for (int i = 0; i < this.album.size(); i++) {
            if (this.album.get(i).getTitle().equals(songName)) {
                return i;
            }
        }
        return -1;

    }

    public void addSong(Song song) {
        this.album.add(song);
    }

    public String getTitle() {
        return title;
    }


    public ArrayList<Song> getAlbum() {
        return album;
    }


}
