package Controllers.SubControllers;

import Controllers.CombatController;
import Units.UnitTemplate;
import Units.Weapons.WeaponTemplate;

//Combat action Sub Controller
public class CSC extends CombatSubControllerTemplate {
    private UnitTemplate Actor;
    private WeaponTemplate FiredWeapon;
    private int HitRoll;
    private int TrueDamageDone;
    private int ArmorDamageDone;
    private int HullDamageDone;
    private int SquadDestroyed;
    private UnitTemplate EnemyTarget;
    public CSC(CombatController Controller) {
        super(Controller);
    }

    public void HoldFire(){
        this.getActor().setCombatAction("Holding Fire");
    }

    //When fire, a weapon must be selected and an enemy must be set.
    public void FireWeapon(WeaponTemplate Weapon, UnitTemplate Enemy){
        this.setFiredWeapon(Weapon);
        this.setActor(Weapon.getMountedVehicle());
        System.out.println("Enemy set to be targeted: " + Enemy.getName());
        this.setEnemyTarget(Enemy);

        //Setting the combat action to occur for weapon firing
        switch (Weapon.getWeaponType()){
            case "Bomb" : {
                this.getActor().setCombatAction("Dropping " + Weapon.getWeaponName() + "'s");
                break;
            }

            case "Torpedo" : {
                this.getActor().setCombatAction("Releasing " + Weapon.getWeaponName() + "'s");
                break;
            }

            default: {
                this.getActor().setCombatAction("Firing " + Weapon.getWeaponName() + "'s");
                break;
            }

        }

    }

    public void CombatActionCommences(){
        //Firing shots
        if(this.getActor().getCombatAction().contains("Dropping " + this.getFiredWeapon().getWeaponName() + "'s") == true || this.getActor().getCombatAction().contains("Releasing " + this.getFiredWeapon().getWeaponName() + "'s") == true || this.getActor().getCombatAction().contains("Firing " + this.getFiredWeapon().getWeaponName() + "'s") == true){
            for(int x = 0; x < this.getFiredWeapon().getNumberOfShotsFired(); x++){
                //Rolling the hit number for the shot
                this.rollWeaponBaseHitRoll();
                //Debug printing to the console
                System.out.println("\nBase HitRoll = " + this.getHitRoll());
                //Used in the Eventlog later
                int baseroll = this.getHitRoll();
                //Bonus to hit based on the weapons modifiers, Used in EventLog and HitRolls
                System.out.println("Weapon bonus = " + this.WeaponBonus());
                //Setting total Hit number
                this.setHitRoll(this.getHitRoll() + this.WeaponBonus());
                System.out.println("Total Roll to hit = " + this.getHitRoll());
                //Getting the status of the hit against the enemy
                System.out.println(this.HitStatus());
                //Rolling damage based on the hit type (Critical's Roll Max damage and add another roll of damage)
                this.rollWeaponBaseDamageRoll(this.HitStatus());

                System.out.println("The shot did " + this.getTrueDamageDone() + " points of damage total.");
                this.calcArmorAndHullDamage();
                System.out.println("The shot did " + this.getArmorDamageDone() + " points of damage to the Armor of the enemy");
                System.out.println("The shot did " + this.getHullDamageDone() + " points of damage to the Hull of the enemy");
                this.setEnemyHullAndArmor();
                System.out.println("Enemy Durability left: " + this.getEnemyTarget().getUnitDurability());
                System.out.println("Enemy Craft left : " + this.getEnemyTarget().getCurrentSquadSize());
                //Flavor text decision based on hit type
                String result;
                this.getFiredWeapon().setEnemyTargeted(EnemyTarget);
                switch (HitStatus()){
                    case "Critical" : {
                        result = this.getFiredWeapon().OnCritical();
                        break;
                    }
                    case "Hit": {
                        result = this.getFiredWeapon().OnHit();
                        break;
                    }
                    default: {
                        result = this.getFiredWeapon().OnMiss();
                        break;
                    }
                }
                //Eventlog display of the hit events
                this.getAssignedController().getAssignedController().GetEventLog().append("\n\n" + this.getActor().getName() + " rolled a total of " + this.getHitRoll() + " ( " + baseroll + " Base + " + this.WeaponBonus() + " from weapon Modifiers )" + result + "\nThe burst dealt " + this.getArmorDamageDone() + " points of damage to " + this.getEnemyTarget().getName() + "'s Armor and " + this.getHullDamageDone() + " points of damage to their hull.\nAs a result of the fight, " + this.getEnemyTarget().getName() + " have lost " + this.getSquadDestroyed() + "/" + this.getEnemyTarget().getMaxSquadSize() + " Units from their Wing." );
            }
        } else {
            System.out.println(this.getActor().getName() + " is holding fire.");
        }


    }

    //Rolls the number of times the enemy is hit in a burst
    public void rollWeaponBaseHitRoll(){
        int HitRoll = this.getFiredWeapon().getFiringDice().Roll();
        this.setHitRoll(HitRoll);
    }

    //Bonus based on Enemy type and Weapon modifiers
    public int WeaponBonus(){
        switch (EnemyTarget.getType().getType()){
            case "Fighter" :{
                if(this.getFiredWeapon().HasModifier("Anti-Fighter")){
                    return 3;

                }else {
                    return 0;
                }
            }
            case "Bomber" : {
                if(this.getFiredWeapon().HasModifier("Anti-Bomber")){
                    return 3;
                }else {
                    return 0;
                }
            }
            case "Corvette" : {
                if(this.getFiredWeapon().HasModifier("Anti-Corvette")){
                    return 3;
                }else {
                    return 0;
                }
            }
            case "Frigate" : {
                if(this.getFiredWeapon().HasModifier("Anti-Frigate")){
                    return 3;
                }else {
                    return 0;
                }
            }

            case "Cruiser" : {
                if(this.getFiredWeapon().HasModifier("Anti-Cruiser")){
                    return 3;
                }else {
                    return 0;
                }
            }
            case "Battleship" : {
                if(this.getFiredWeapon().HasModifier("Anti-Battleship")){
                    return 3;
                }else {
                    return 0;
                }
            }
            default:
                return 0;

        }
    }

    public String HitStatus(){
        if(this.getHitRoll() == 20){
            return "Critical";
        } else
        if(this.getHitRoll() >= EnemyTarget.getHitChance()){
            return "Hit";
        } else {
            return "Miss";
        }

    }

    //Rolls Damage Number for the burst
    public void rollWeaponBaseDamageRoll(String HitStatus){
        int DamageDone;
        //Critical Damage
        if(HitStatus.equalsIgnoreCase("Critical")){
            int BaseCritDmg = this.getFiredWeapon().getDmgDice().getFaces() * this.getFiredWeapon().getNumberOfDmgDice();
            int CritBonus = this.getFiredWeapon().getDmgDice().RollMultipleCombinedResults(this.getFiredWeapon().getNumberOfDmgDice());
            DamageDone = BaseCritDmg + CritBonus;
            this.setTrueDamageDone(DamageDone);
        } else if(HitStatus.equalsIgnoreCase("Hit")) {
            DamageDone = this.getFiredWeapon().getDmgDice().RollMultipleCombinedResults(this.getFiredWeapon().getNumberOfDmgDice());
            this.setTrueDamageDone(DamageDone);
        }
        else{
            this.setTrueDamageDone(0);
        }
    }

    public void calcArmorAndHullDamage(){
        int SunderingType;
        if(this.getFiredWeapon().HasModifier("Sundering") == true){
            SunderingType = 1;
        }else {
            SunderingType = 0;
        }

        switch (SunderingType){
            case 1: {
                if(this.getTrueDamageDone() >= this.getEnemyTarget().getCurrentArmor()){
                    this.setArmorDamageDone(this.getEnemyTarget().getCurrentArmor());
                    this.setHullDamageDone(this.getEnemyTarget().getCurrentArmor() - this.getTrueDamageDone());
                }else{
                    int ArmorDamage = Math.round(Math.round((this.getTrueDamageDone() * 0.9)));
                    int HullDamage = Math.round(Math.round((this.getTrueDamageDone() * 0.1)));
                    this.setArmorDamageDone((ArmorDamage));
                    this.setHullDamageDone(HullDamage);
                }
                break;
            }

            default:{
                if(this.getTrueDamageDone() > this.getEnemyTarget().getCurrentArmor()){
                    this.setArmorDamageDone(0);
                    this.setHullDamageDone(this.getTrueDamageDone() - this.getEnemyTarget().getCurrentArmor());
                } else {
                    this.setArmorDamageDone(0);
                    this.setHullDamageDone(0);
                }
                break;
            }
        }

    }

    public void setEnemyHullAndArmor(){
        this.getEnemyTarget().setCurrentArmor(this.getEnemyTarget().getCurrentArmor() - this.getArmorDamageDone());
        this.getEnemyTarget().setUnitDurability(this.getEnemyTarget().getUnitDurability() - this.getHullDamageDone());

        int SquadLeft = this.getEnemyTarget().getMaxSquadSize();
        int MaxDurability = this.getEnemyTarget().getMaxDurability();
        int CurrentDurability = this.getEnemyTarget().getUnitDurability()*100;
        long ratio = CurrentDurability*100/MaxDurability;

        //Switch allows for procedurable destruction of a unit and lowering of their damage output as a result
        switch (SquadLeft){
            case 5 : {
                if(CurrentDurability/MaxDurability < 100){
                    if(CurrentDurability/MaxDurability >= 80 && CurrentDurability/MaxDurability < 100){
                        this.getEnemyTarget().setCurrentSquadSize(4);
                        this.setSquadDestroyed(1);
                        break;
                    }else if(CurrentDurability/MaxDurability >= 60 && CurrentDurability/MaxDurability < 80){
                        this.getEnemyTarget().setCurrentSquadSize(3);
                        this.setSquadDestroyed(2);
                        break;
                    }else if(CurrentDurability/MaxDurability >= 40 && CurrentDurability/MaxDurability < 60){
                        this.getEnemyTarget().setCurrentSquadSize(2);
                        this.setSquadDestroyed(3);
                        break;
                    }else if(CurrentDurability/MaxDurability >= 20 || (CurrentDurability/MaxDurability > 0 && CurrentDurability/MaxDurability < 40)){
                        this.getEnemyTarget().setCurrentSquadSize(1);
                        this.setSquadDestroyed(4);
                        break;
                    }else if(CurrentDurability/MaxDurability <= 0){
                        this.getEnemyTarget().setCurrentSquadSize(0);
                        this.getEnemyTarget().setStatus("Destroyed");
                        this.setSquadDestroyed(5);
                        break;
                    }

                }


            }

            case 4: {
                if (CurrentDurability / MaxDurability < 100) {
                    if (CurrentDurability / MaxDurability >= 75 && CurrentDurability/MaxDurability < 100) {
                        this.getEnemyTarget().setCurrentSquadSize(3);
                        this.setSquadDestroyed(1);
                        break;
                    } else if (CurrentDurability / MaxDurability >= 50 && CurrentDurability/MaxDurability < 75) {
                        this.getEnemyTarget().setCurrentSquadSize(2);
                        this.setSquadDestroyed(2);
                        break;
                    } else if (CurrentDurability / MaxDurability >= 25 || (CurrentDurability / MaxDurability > 0 && CurrentDurability / MaxDurability < 50)) {
                        this.getEnemyTarget().setCurrentSquadSize(1);
                        this.setSquadDestroyed(3);
                        break;
                    } else if (CurrentDurability / MaxDurability <= 0) {
                        this.getEnemyTarget().setCurrentSquadSize(0);
                        this.getEnemyTarget().setStatus("Destroyed");
                        this.setSquadDestroyed(4);
                        break;
                    }

                }
            }

            case 3 : {

                if (CurrentDurability / MaxDurability < 100) {
                    if (CurrentDurability / MaxDurability >= 66 && CurrentDurability/MaxDurability < 100) {
                        this.getEnemyTarget().setCurrentSquadSize(2);
                        this.setSquadDestroyed(1);
                        break;
                    } else if (CurrentDurability / MaxDurability >= 33 || (CurrentDurability / MaxDurability > 0 && CurrentDurability / MaxDurability < 66)) {
                        this.getEnemyTarget().setCurrentSquadSize(1);
                        this.setSquadDestroyed(2);
                        break;
                    } else if (CurrentDurability / MaxDurability <= 0) {
                        this.getEnemyTarget().setCurrentSquadSize(0);
                        this.getEnemyTarget().setStatus("Destroyed");
                        this.setSquadDestroyed(3);
                        break;
                    }

                }

            }

            case 2: {
                if (CurrentDurability / MaxDurability < 100) {
                    if (CurrentDurability / MaxDurability <= 50 && CurrentDurability/MaxDurability > 0 ) {
                        this.getEnemyTarget().setCurrentSquadSize(1);
                        this.setSquadDestroyed(1);
                        break;
                    } else if (CurrentDurability / MaxDurability <= 0) {
                        this.getEnemyTarget().setCurrentSquadSize(0);
                        this.getEnemyTarget().setStatus("Destroyed");
                        this.setSquadDestroyed(2);
                        break;
                    }

                }
            }

            default: {
                if(CurrentDurability/MaxDurability <= 0){
                    this.getEnemyTarget().setCurrentSquadSize(0);
                    this.getEnemyTarget().setStatus("Destroyed");
                    this.setSquadDestroyed(1);
                }else
                {

                }
            }




        }

    }

    public UnitTemplate getActor() {
        return Actor;
    }

    public void setActor(UnitTemplate actor) {
        Actor = actor;
    }

    public UnitTemplate getEnemyTarget(){
        return EnemyTarget;
    }

    public void setEnemyTarget( UnitTemplate Enemy){
        this.EnemyTarget = Enemy;
    }

    public WeaponTemplate getFiredWeapon() {
        return FiredWeapon;
    }

    public void setFiredWeapon(WeaponTemplate firedWeapon) {
        FiredWeapon = firedWeapon;
    }

    public int getTrueDamageDone() {
        return TrueDamageDone;
    }

    public void setTrueDamageDone(int trueDamageDone) {
        TrueDamageDone = trueDamageDone;
    }

    public int getHitRoll() {
        return HitRoll;
    }

    public void setHitRoll(int hitRoll) {
        HitRoll = hitRoll;
    }

    public int getArmorDamageDone() {
        return ArmorDamageDone;
    }

    public void setArmorDamageDone(int armorDamageDone) {
        ArmorDamageDone = armorDamageDone;
    }

    public int getHullDamageDone() {
        return HullDamageDone;
    }

    public void setHullDamageDone(int hullDamageDone) {
        HullDamageDone = hullDamageDone;
    }

    public int getSquadDestroyed() {
        return SquadDestroyed;
    }

    public void setSquadDestroyed(int squadDestroyed) {
        SquadDestroyed = squadDestroyed;
    }
}
