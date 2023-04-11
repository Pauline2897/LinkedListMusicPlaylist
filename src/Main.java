import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Song song1 = new Song("love", 3.22);
        Song song2 = new Song("life", 5.34);
        Song song3 = new Song("hate", 2.51);
        Song song4 = new Song("pride", 3.05);
        Song song5 = new Song("time", 3.15);

        Album album = new Album("Love&Life");
        album.addSong(song1);
        album.addSong(song2);
        album.addSong(song3);
        album.addSong(song4);
        album.addSong(song5);

        Album album1 = new Album("Love");
        Song song6 = new Song("money", 3.15);
        Song song7 = new Song("envy", 4.30);
        Song song8 = new Song("lux", 2.55);

        album1.addSong(song6);
        album1.addSong(song7);
        album1.addSong(song8);

        ArrayList<Album> list = new ArrayList<>();
        list.add(album);
        list.add(album1);

        Playlist playlist = new Playlist("Playlist1");

        playlist.addSongToPlaylist(list, "Love&Life", "love");
        playlist.addSongToPlaylist(list, "Love&Life", "time");
        playlist.addSongToPlaylist(list, "Love", "money");
        playlist.addSongToPlaylist(list, "Love", "envy");
        playlist.addSongToPlaylist(list, "Love", "lux");
        playlist.addSongToPlaylist(list, "Love&Life", "pride");

        playlist.play();
    }
}
