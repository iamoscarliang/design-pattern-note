package strategy;

import strategy.behavior.ArrowBehavior;
import strategy.behavior.SwordBehavior;
import strategy.character.Character;
import strategy.character.King;

public class Main {

    public static void main(String[] args) {
        // Init a king from supertype
        Character king = new King();

        // Init a sword weapon to the king
        king.setWeaponBehavior(new SwordBehavior());
        king.display();
        king.fight();

        // Init an arrow weapon to the king
        king.setWeaponBehavior(new ArrowBehavior());
        king.display();
        king.fight();
    }

}
