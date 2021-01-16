package Units.Weapons;
import Dice.D10;
import Dice.D2;
import Dice.D20;
import Dice.DiceTemplate;
import Units.UnitTemplate;

public class Swordfish_Light_Bomb extends WeaponTemplate {

    public Swordfish_Light_Bomb(){
        this.setWeaponName("Swordfish Light Bomb");
        this.setWeaponType("Missile");
        this.setWeaponClass("Bomb");
        this.setWeaponRange("Close Combat");
        this.setNumberOfShotsFired(10);
        this.setDmgDice(new D20());
        this.setNumberOfDmgDice(12);
        this.setModifiers(new String[] {"Small Weapon", "Sub Weapon", "Has Ammo","Sundering","Anti-Frigate","Anti-Cruiser"});
        }

    @Override
    public String OnMiss(){
        DiceTemplate D2 = new D2();
        if(D2.Roll() == 0){
            return this.getMountedVehicle().getName() + " decelerates, opening its bomb chutes and beginning its bombing run on " + this.getEnemyTargeted() + ". Heavy point defense forces the Bombers to cease its run early and ends up not doing any noticable damage.";
        }else{
            return "The Swordfish bombs of " + this.getMountedVehicle().getName() + " begin dropping through their gravity assisted warheads as the bombers approach their target. Unfortunately heavy point defense intercepts the bombs and forces " + this.getMountedVehicle().getName() + " to retreat.";
        }
    }

    @Override
    public String OnHit(){
        DiceTemplate d2 = new D2();
        if(d2.Roll() == 0){
            return this.getMountedVehicle().getName() + " begins its bombing run on " + this.getEnemyTargeted().getName() + " at lightning speed to get under its point defense, once under, its scores multiple damaging hit on " + this.getEnemyTargeted().getName() + " before retreating.";
        }else {

            return "Explosions resound on " + this.getEnemyTargeted().getName() +"'s armor plates and hull as Swordfish bombs detonate successfully from " + this.getMountedVehicle().getName() +"'s bombing run.";
        }
    }

    @Override
    public String OnCritical(){
        DiceTemplate D2 = new D2();
        if(D2.Roll() == 0){
            return "Major explosions detonate from " + this.getEnemyTargeted().getName() + "'s hull as the Swordfish Bombs find major weakpoints in its armor, inflicting critical damage.";
        }else {
            return this.getMountedVehicle().getName() + "'s bombing run is successful as it rushes to get under " + this.getEnemyTargeted().getName() +"'s point defense, doing so successfully allows it drop explosives on critcal areas of the ship below.";
        }
    }
    @Override
    public void AttachWeapon(UnitTemplate mountedVehicle) {
        this.setMaximumAmmunition(2*mountedVehicle.getMaxSquadSize());
        this.setCurrentAmmunition(2*mountedVehicle.getCurrentSquadSize());
        this.setNumberOfDmgDice(3*mountedVehicle.getCurrentSquadSize());
    }



}
