package assignment;



import java.util.*;

public class RecentlyPlayedStore {
    private int capacity;
    private Map<String, String[]> store;

    public RecentlyPlayedStore(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>();
    }

    public void addSong(String user, String song) {
        if (!store.containsKey(user)) {
            store.put(user, new String[capacity]);
        }

        String[] playlist = store.get(user);
        int size= playlist.length ;
        // Shift the existing songs to the Left
        for (int i = 0; i <size - 1 ; i++) {
            playlist[i] = playlist[i+1];
        }

        // Add the new song at the last
        playlist[size-1] = song; 
    }

    public String[] getRecentlyPlayedSongs(String user) {
        return store.getOrDefault(user, new String[0]);
    }

    public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");

        System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("user1"))); // Output: [S1,S2,S3]

        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");

        System.out.println(Arrays.toString(store.getRecentlyPlayedSongs("user1"))); // Output: [S1, S2, S4]
    }
}



