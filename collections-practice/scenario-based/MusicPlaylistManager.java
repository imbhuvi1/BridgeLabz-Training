package scenario_based;

import java.util.*;

//Custom exception
class SongAlreadyExistsException extends Exception {
 public SongAlreadyExistsException(String title) {
     super("Duplicate: " + title + " already in playlist");
 }
}

class Song {
 private String title;
 private String artist;
 
 public Song(String title, String artist) {
     this.title = title;
     this.artist = artist;
 }
 
 public String getTitle() { return title; }
 public String getArtist() { return artist; }
 
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (!(o instanceof Song)) return false;
     return title.equals(((Song) o).title);
 }
 
 @Override
 public int hashCode() {
     return title.hashCode();
 }
 
 @Override
 public String toString() {
     return title + " - " + artist;
 }
}

public class MusicPlaylistManager {
 private LinkedList<Song> playlist = new LinkedList<>();
 private Stack<Song> history = new Stack<>();
 private Set<Song> uniqueSongs = new HashSet<>();
 private Scanner sc = new Scanner(System.in);
 
 public void addSong() throws SongAlreadyExistsException {
     System.out.print("Title: ");
     String title = sc.nextLine();
     System.out.print("Artist: ");
     String artist = sc.nextLine();
     
     Song song = new Song(title, artist);
     if (!uniqueSongs.add(song)) {
         throw new SongAlreadyExistsException(title);
     }
     
     playlist.addLast(song);
     System.out.println("Added " + song);
 }
 
 public void playSong() {
     if (playlist.isEmpty()) {
         System.out.println("Empty playlist");
         return;
     }
     Song song = playlist.removeFirst();
     history.push(song);
     playlist.addLast(song); // rotate to end
     System.out.println("Playing: " + song);
 }
 
 public void viewPlaylist() {
     System.out.println("Playlist: " + playlist);
 }
 
 public void viewHistory() {
     System.out.println("History: " + history);
 }
 
 public void removeSong() {
     System.out.print("Title: ");
     String title = sc.nextLine();
     Song toRemove = new Song(title, "");
     
     if (playlist.remove(toRemove)) {
         uniqueSongs.remove(toRemove);
         System.out.println("Removed " + title);
     } else {
         System.out.println("Not found");
     }
 }
 
 public void menu() {
     while (true) {
         System.out.print("\n1.Add 2.Play 3.Playlist 4.History 5.Remove 0.Exit: ");
         int choice = sc.nextInt();
         sc.nextLine(); // consume newline
         try {
             if (choice == 1) addSong();
             else if (choice == 2) playSong();
             else if (choice == 3) viewPlaylist();
             else if (choice == 4) viewHistory();
             else if (choice == 5) removeSong();
             else if (choice == 0) break;
         } catch (Exception e) {
             System.out.println(e.getMessage());
         }
     }
     sc.close();
 }
 
 public static void main(String[] args) {
     new MusicPlaylistManager().menu();
 }
}
