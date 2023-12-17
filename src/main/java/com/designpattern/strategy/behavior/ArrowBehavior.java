package com.designpattern.strategy.behavior;

public class ArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("Shooting an arrow!");
    }

}
