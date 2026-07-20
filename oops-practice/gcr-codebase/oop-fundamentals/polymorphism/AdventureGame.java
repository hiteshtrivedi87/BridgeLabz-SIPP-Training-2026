class GameCharacter {
    String characterName;

    public GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    public void performAttack() {
        System.out.println(characterName + " prepares to strike!");
    }
}

class Warrior extends GameCharacter {
    public Warrior(String characterName) { super(characterName); }

    @Override
    public void performAttack() {
        System.out.println("[Warrior] " + characterName + " slashes with a broadsword!");
    }
}

class Mage extends GameCharacter {
    public Mage(String characterName) { super(characterName); }

    @Override
    public void performAttack() {
        System.out.println("[Mage] " + characterName + " casts a blazing Fireball!");
    }
}

class Archer extends GameCharacter {
    public Archer(String characterName) { super(characterName); }

    @Override
    public void performAttack() {
        System.out.println("[Archer] " + characterName + " shoots a piercing arrow!");
    }
}

public class AdventureGame {
    
    public static void startBattle(GameCharacter[] characters) {
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        System.out.println("=== The Battle Begins! ===");
        for (GameCharacter c : characters) {
            c.performAttack();

            if (c instanceof Warrior) warriorCount++;
            else if (c instanceof Mage) mageCount++;
            else if (c instanceof Archer) archerCount++;
        }

        System.out.println("\n=== Battle Statistics ===");
        System.out.println("Warriors participated: " + warriorCount);
        System.out.println("Mages participated: " + mageCount);
        System.out.println("Archers participated: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] party = {
            new Warrior("Thorin"),
            new Mage("Gandalf"),
            new Archer("Legolas"),
            new Warrior("Arthur")
        };

        startBattle(party);
    }
}