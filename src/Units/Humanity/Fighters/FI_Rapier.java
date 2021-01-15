package Units.Humanity.Fighters;

import Units.UnitTemplate;
import Units.UnitTypes.Fighter;
import Units.UnitTypes.TypeTemplate;
import Units.Weapons.Light_AutoCannon;
import Units.Weapons.WeaponTemplate;
import com.sun.tools.javac.Main;

public class FI_Rapier extends UnitTemplate {

    public FI_Rapier(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This unit is at its base, A fighter
        TypeTemplate type = new Fighter();
        this.setType(type);

        //This unit has a damage reduction of 10
        int armor = 10;
        this.setCurrentArmor(armor);
        this.setMaxArmor(armor);

        //This unit has a hull of 300 to start with
        int durability = 300;
        this.setUnitDurability(durability);
        this.setMaxDurability(durability);

        //Upon rolling a 15 or higher, this unit can be hit
        this.setHitChance(15);

        //There are five entities within this squad that provide additional chances to hit and ammo for missiles and bombs
        this.setMaxSquadSize(5);
        this.setCurrentSquadSize(5);

        this.setUnitDesc("\bRapier\b\n\nRapiers are single seater transport craft that have been hastily refit into high speed interceptors. Originally the craft was designed to be a single seat transporter used by civilians to quickly move individuals between land and space. Now its elongated reverse arrow design allows its powerful engines and mediocre weapons to be used to intercept or screen against fighters and bombers."
                +"\n\n Durability\t: "+ this.getUnitDurability()
                +"\n Armor\t: " + this.getCurrentArmor()
                +"\nSquadron Size: 0" + this.getCurrentSquadSize()
                +"\n\n\bArmament\b\n\n1 x Light Autocannon Per Craft.");
        //Weapon Attach Method
        WeaponAttach(this);

    }

    public void WeaponAttach(FI_Rapier Rapier){
        WeaponTemplate[] Weapons = new WeaponTemplate[1];
        Light_AutoCannon Mainguns = new Light_AutoCannon();
        Mainguns.AttachWeapon(Rapier);
        Rapier.setWeapons(Weapons);
        Weapons[0] = Mainguns;
        Weapons[0].setWeaponDesc("\n\bLight Autocannon\b\n\nThe Light AutoCannon is the most basic of weapons generally mounted on fighters. This single barrel weapon fires a burst of five bursts of high explosive anti-fighter shrapnel rounds at high velocity towards its target and shreds through fighters though it struggles against armoured bombers.\n Rolls " + this.getWeapons()[0].getNumberOfDmgDice() + " " + this.getWeapons()[0].getDmgDice().GetDice() + " Damage dice.");
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
