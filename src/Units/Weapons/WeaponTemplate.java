package Units.Weapons;

import Dice.D20;
import Dice.DiceTemplate;
import Units.UnitTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeaponTemplate {
    //Name of the Weapon
    private String WeaponName;

    //Type of the Weapon (Ballistic,Missile,Laser)
    private String WeaponType;

    //Specific SubClass for the Weapon eg Railgun, Swarm missile, Ion Laser ect
    private String WeaponClass;

    //What range the Weapon is most effective at (Ranges higher then this will not hit or will be unable to fire at)
    private String WeaponRange;

    //Description of the weapon
    private String WeaponDesc;

    //Dice used to determine HitChance for the weapon
    private DiceTemplate FiringDice = new D20();

    //Number of Shots fired per roll. More Shots = Higher possibility of hitting per shot
    private int NumberOfShotsFired;

    //Dice used to determine damage of the weapon
    private DiceTemplate DmgDice;

    //Number of dice rolled to determine damage
    private int NumberOfDmgDice;

    //Any Modifiers the weapons has (Eg Medium weapons can only be mounted on Frigates and above ect)
    private String[] Modifiers;

    //Only used for Missiles or other Subweapons
    private int MaximumAmmunition;
    private int CurrentAmmunition;

    //What the unit that has this weapon mounted is.
    private UnitTemplate MountedVehicle;

    private String MissText = "";

    private String HitText = "";

    private String CriticalText = "";

    private UnitTemplate EnemyTargeted;


    public String OnMiss(){
        return MissText;
    }

    public String OnHit(){
        return HitText;
    }

    public String OnCritical(){
        return CriticalText;
    }


    public String getWeaponName() {
        return WeaponName;
    }

    public void setWeaponName(String weaponName) {
        WeaponName = weaponName;
    }

    public String getWeaponType() {
        return WeaponType;
    }

    public void setWeaponType(String weaponType) {
        WeaponType = weaponType;
    }

    public String getWeaponClass() {
        return WeaponClass;
    }

    public void setWeaponClass(String weaponClass) {
        WeaponClass = weaponClass;
    }

    public int getWeaponRange() {

        switch(WeaponRange){
            case "Close Combat" : {
                return 0;
            }
            case "Short" : {
                return 1;
            }
            case "Medium" : {
                return 2;
            }
            case "Long" : {
                return 3;
            }
            default:
                System.out.println(this.getWeaponName() + " doesnt have a range assigned to it. FIX THIS");
                return 3;
        }
    }

    public void setWeaponRange(String weaponRange) {
        WeaponRange = weaponRange;
    }

    public String getWeaponDesc() {
        return WeaponDesc;
    }

    public void setWeaponDesc(String weaponDesc) {
        WeaponDesc = weaponDesc;
    }

    public DiceTemplate getFiringDice() {
        return FiringDice;
    }

    public void setFiringDice(DiceTemplate firingDice) {
        FiringDice = firingDice;
    }

    public int getNumberOfShotsFired() {
        return NumberOfShotsFired;
    }

    public void setNumberOfShotsFired(int numberOfShotsFired) {
        NumberOfShotsFired = numberOfShotsFired;
    }

    public DiceTemplate getDmgDice() {
        return DmgDice;
    }

    public void setDmgDice(DiceTemplate dmgDice) {
        DmgDice = dmgDice;
    }

    public int getNumberOfDmgDice() {
        return NumberOfDmgDice;
    }

    public void setNumberOfDmgDice(int numberOfDmgDice) {
        NumberOfDmgDice = numberOfDmgDice;
    }

    public String[] getModifiers() {
        return Modifiers;
    }

    public void setModifiers(String[] modifiers) {
        Modifiers = modifiers;
    }

    public boolean HasModifier(String Modifier){
        boolean HasModifier = false;
        for(int x = 0; x < this.getModifiers().length; x++){
            if(Modifiers[x].equalsIgnoreCase(Modifier)){
                HasModifier = true;
            }
        }
    return HasModifier;
    }

    public UnitTemplate getMountedVehicle() {
        return MountedVehicle;
    }

    public void AttachWeapon(UnitTemplate mountedVehicle) {
        MountedVehicle = mountedVehicle;
    }

    public UnitTemplate getEnemyTargeted() {
        return EnemyTargeted;
    }

    public void setEnemyTargeted(UnitTemplate enemyTargeted) {
        EnemyTargeted = enemyTargeted;
    }

    public int getCurrentAmmunition() {
        return CurrentAmmunition;
    }

    public void setCurrentAmmunition(int currentAmmunition) {
        CurrentAmmunition = currentAmmunition;
    }

    public int getMaximumAmmunition() {
        return MaximumAmmunition;
    }

    public void setMaximumAmmunition(int maximumAmmunition) {
        MaximumAmmunition = maximumAmmunition;
    }
    public void setMountedVehicle(UnitTemplate Ship){
        MountedVehicle = Ship;
    }
}
