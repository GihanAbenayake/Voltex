package Units.Weapons;
import Dice.D10;
import Dice.D2;
import Dice.DiceTemplate;
import Units.UnitTemplate;

public class Light_AutoCannon extends WeaponTemplate {

    public Light_AutoCannon(){
        this.setWeaponName("Light AutoCannon");
        this.setWeaponType("Ballistic");
        this.setWeaponClass("Cannon");
        this.setWeaponRange("Close Combat");
        this.setNumberOfShotsFired(5);
        this.setDmgDice(new D10());
        this.setNumberOfDmgDice(4);
        this.setModifiers(new String[] {"Small Weapon", "Main Weapon","Anti-Fighter","Anti-Bomber"});
    }

    @Override
    public String OnMiss(){
        DiceTemplate D2 = new D2();
        if(D2.Roll() == 1){
            return "\n" + this.getMountedVehicle().getName() + " fires a burst from its Light Autocannons at " + this.getEnemyTargeted().getName() + " but the rounds miss, flying off endlessly into the void of space.";
        }else {
            return "\n" +this.getMountedVehicle().getName() + " sprays a burst of rounds from its Light Autocannon to no effect.";
        }
    }
    
    @Override
    public String OnHit(){
        DiceTemplate D2 = new D2();
        if(D2.Roll() == 1){
            return "\n" +"Tracers light up the the armor plates of " + this.getEnemyTargeted().getName() + " as " + this.getMountedVehicle().getName() + " opens fire with its Light Autocannons.";
        }else{
            return "\n" +this.getMountedVehicle().getName() + "'s Light Autocannons sents a burst of high explosive shrapnel hurtling into " + this.getEnemyTargeted().getName() + " scoring hits across its armor and hull.";
        }
    }

    @Override
    public String OnCritical(){
        DiceTemplate D2 = new D2();
        if(D2.Roll() == 1){
            return "\n" +" High explosive rounds pepper " + this.getEnemyTargeted().getName() +" as "+ this.getMountedVehicle().getName() + "opens up with its Light Autocannon, scoring hits on multiple critical components!";
        }else {
            return "\n" +this.getMountedVehicle().getName() + " tails " + this.getEnemyTargeted().getName() + " just before they burst down a critical piece of the enemy craft";

        }
    }

    @Override
    public void AttachWeapon(UnitTemplate mountedVehicle) {
        this.setNumberOfDmgDice(2*mountedVehicle.getCurrentSquadSize());
    }
}
