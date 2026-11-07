class Playlist {
    private String[] songs;
    private int count;
    private final int maxSize;

    public Playlist(int maxSize) {
        this.maxSize = maxSize;
        this.songs = new String[maxSize];
        this.count = 0;
    }

    public void addSong(String song) {
        if (count < maxSize && song != null) {
            this.songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[count];
        System.arraycopy(this.songs, 0, copy, 0, count);
        return copy;
    }

    public int getSongCount() {
        return this.count;
    }
}

public class M2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Original playlist songs:");
        for (String s : copy) {
            System.out.println(s);
        }

        copy[0] = "Hacked";
        System.out.println("\nAfter modifying copy:");
        String[] copy2 = p.getSongs();
        for (String s : copy2) {
            System.out.println(s);
        }

        System.out.println("\nSong count: " + p.getSongCount());
    }
}