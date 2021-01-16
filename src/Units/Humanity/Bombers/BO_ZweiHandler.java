package Units.Humanity.Bombers;

import Units.Humanity.Fighters.FI_Rapier;
import Units.UnitTemplate;
import Units.UnitTypes.Bomber;
import Units.UnitTypes.TypeTemplate;
import Units.Weapons.Light_AutoCannon;
import Units.Weapons.Swordfish_Light_Bomb;
import Units.Weapons.WeaponTemplate;

public class BO_ZweiHandler extends UnitTemplate {

    public BO_ZweiHandler(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This unit at its base, is a Bomber
        TypeTemplate Type = new Bomber();
        this.setType(Type);

        //This unit starts with 500 durability
        int Durability = 500;
        this.setUnitDurability(Durability);
        this.setMaxDurability(Durability);

        //This unit has 30 points of damage reduction to start with
        int Armor = 30;
        this.setCurrentArmor(Armor);
        this.setMaxArmor(Armor);

        //A roll of 13 or higher can hit this unit
        this.setHitChance(13);

        //This unit is formed of four entities
        this.setMaxSquadSize(4);
        this.setCurrentSquadSize(4);

       //Weapon attaching to the craft
        this.WeaponAttach(this);

        this.setUnitDesc("\bZweiHandler\b\n\nZweiHandlers are named as such due to their originally dual cockpit design. Now that they've been militarised, one cockpit houses the pilot while the other houses the gunner and their ordinance. Due to its civilian origin's its tight on space and low on capacity meaning it carries a subpar bomb load for its bulky size. "
                +"\n\n Durability\t: "+ this.getUnitDurability()
                +"\n Armor\t: " + this.getCurrentArmor()
                +"\nSquadron Size: 0" + this.getCurrentSquadSize()
                +"\n\n\bArmament\b\n\n 2x Swordfish Light Bombs Per Craft.");
    }

    public void WeaponAttach(BO_ZweiHandler ZH){
        WeaponTemplate[] AttachedWeapons = new WeaponTemplate[1];
        Swordfish_Light_Bomb MainBomb = new Swordfish_Light_Bomb();
        MainBomb.AttachWeapon(this);
        AttachedWeapons[0] = MainBomb;
        ZH.setWeapons(AttachedWeapons);
        MainBomb.setMountedVehicle(ZH);
        MainBomb.setWeaponDesc("\n\bSwordfish Light Bomb\b\n\nSwordfish's are the lightest bombs on the market when it comes to damage and ammunition capacity. Each craft in a squadron can hold two of these allowing for six runs on average. Upon deployment, The warheads gravity assistance syncs with the deploying crafts systems and directs the bomb 'downwards' away from its deployer and towards the enemy. As this is a bomb, it can only be used against Frigate and higher class vessels.\n Rolls " + this.getWeapons()[0].getNumberOfDmgDice() + " " + this.getWeapons()[0].getDmgDice().GetDice() + " Damage dice.");
    }

    @Override
    public String toString(){
        String Weapondescriptions = "";
        for(int x = 0; x < this.getWeapons().length; x++){
            Weapondescriptions = Weapondescriptions + "\n" + this.getWeapons()[x].getWeaponDesc();
        }
        String a = this.getUnitDesc();
        String c = a + "\n"+ Weapondescriptions;
        return c;
    }
}
