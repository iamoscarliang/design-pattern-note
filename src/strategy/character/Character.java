package strategy.character;

import strategy.behavior.WeaponBehavior;

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
