import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Playlist {
    private String name;
    private LinkedList<Song> playlist;


    public Playlist(String name) {
        this.name = name;
        playlist = new LinkedList<>();
    }

    public void printOptions() {
        System.out.println("Choose option:");
        System.out.println("1.Show playlist");
        System.out.println("2.Skip forward");
        System.out.println("3.Skip backwards");
        System.out.println("4.Replay song");
        System.out.println("5.Remove current song");
        System.out.println("6.End.");
    }

    public void play() {
        printOptions();
        Scanner scan = new Scanner(System.in);
        ListIterator listIterator = playlist.listIterator();
        boolean goingForward = true;
        boolean play = true;
        while (play) {
            System.out.println("Enter choice");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    showSongsInPlaylist();
                    break;

                case 2:

                    if (!goingForward) {
                        listIterator.next();
                    }
                    goingForward = true;
                    if (listIterator.hasNext()) {
                        System.out.println("Now listening to: " + listIterator.next().toString());
                    } else {
                        System.out.println("Got to the end of the playlist");
                    }
                    break;

                case 3:

                    if (goingForward) {
                        listIterator.previous();
                    }
                    goingForward = false;
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now listening to: " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached the beginning of playlist");
                    }
                    break;

                case 4:

                    if (!goingForward) {
                        goingForward = true;
                        System.out.println("Now listening to: " + listIterator.next().toString());
                    } else if (goingForward) {
                        goingForward = false;
                        System.out.println("Now listening to: " + listIterator.previous().toString());
                    }
                    break;

                case 5:

                    listIterator.remove();
                    break;

                case 6:
                    play = false;
                    break;

                default:
                    break;

            }
        }
    }

    private void showSongsInPlaylist() {
        if (!playlist.isEmpty()) {
            for (Song song : playlist) {
                System.out.println(playlist.indexOf(song) + 1 + ". " + playlist.get(playlist.indexOf(song)).toString());
            }
        } else {
            System.out.println("Playlist is empty");
        }
    }

    private int findAlbum(ArrayList<Album> albums, String albumName) {

        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getTitle().equals(albumName)) {
                return i;
            }
        }

        return -1;
    }

    public void addSongToPlaylist(ArrayList<Album> albums, String albumName, String songTitle) {
        int found = findAlbum(albums, albumName);
        if (found >= 0) {
            int foundSong = albums.get(found).findSong(songTitle);
            if (foundSong >= 0) {
                playlist.add(albums.get(found).getAlbum().get(foundSong));
            } else {
                System.out.println("Song was not found, cannot be added to playlist");
            }
        } else {
            System.out.println("Album was not found");
        }

    }

    public String getName() {
        return name;
    }


    public LinkedList<Song> getPlaylist() {
        return playlist;
    }


}


