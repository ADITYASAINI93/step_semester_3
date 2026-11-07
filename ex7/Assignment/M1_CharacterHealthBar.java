class Character {
    private final int maxHealth;
    private int currentHealth;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount < 0) {
            return;
        }
        this.currentHealth = Math.max(0, this.currentHealth - amount);
    }

    public void heal(int amount) {
        if (amount < 0) {
            return;
        }
        this.currentHealth = Math.min(this.maxHealth, this.currentHealth + amount);
    }

    public int getHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }
}

public class M1_CharacterHealthBar {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println("Health after taking 30 damage: " + c.getHealth()); // Expected: 70

        c.heal(50);
        System.out.println("Health after healing 50: " + c.getHealth()); // Expected: 100 (capped)

        c.takeDamage(150);
        System.out.println("Health after taking 150 damage: " + c.getHealth()); // Expected: 0 (floored)
    }
}