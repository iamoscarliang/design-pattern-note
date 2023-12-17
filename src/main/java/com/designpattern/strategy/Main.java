package com.designpattern.strategy;

import com.designpattern.strategy.behavior.ArrowBehavior;
import com.designpattern.strategy.behavior.SwordBehavior;
import com.designpattern.strategy.character.King;
import com.designpattern.strategy.character.Character;

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
