class NameTag {
    private final String firstName;
    private final String lastName;

    public NameTag(String fullName) {
        String[] parts = fullName.split(" ", 2);
        this.firstName = parts[0];
        this.lastName = parts[1];
    }

    public String getNickname() {
        return this.firstName + " " + this.lastName.charAt(0) + ".";
    }
}

public class M3_NameTag {
    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname()); // Expected: Maria G.

        NameTag tag2 = new NameTag("Maria Gomez");
        System.out.println("Second tag nickname: " + tag2.getNickname()); // Expected: Maria G.
        System.out.println("Are they the same object? " + (tag == tag2)); // Expected: false
    }
}