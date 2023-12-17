package com.designpattern.strategy.character;

import com.designpattern.strategy.behavior.WeaponBehavior;

public abstract class Character {

    private WeaponBehavior mWeaponBehavior;

    public WeaponBehavior getWeaponBehavior() {
        return mWeaponBehavior;
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        mWeaponBehavior = weaponBehavior;
    }

    public void fight() {
        mWeaponBehavior.useWeapon();
    }

    public abstract void display();

}
