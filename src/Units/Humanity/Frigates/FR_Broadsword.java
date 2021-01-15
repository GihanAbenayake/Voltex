package Units.Humanity.Frigates;

import Units.UnitTemplate;
import Units.UnitTypes.Frigate;
import Units.UnitTypes.TypeTemplate;

public class FR_Broadsword extends UnitTemplate {
    public FR_Broadsword(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This unit is a Frigate
        TypeTemplate type = new Frigate();
        this.setType(type);

        //This unit has 5000 Durability to start with
        int Durability = 5000;
        this.setUnitDurability(Durability);
        this.setMaxDurability(Durability);

        //This unit has 400 Armor to start with
        int Armor = 400;
        this.setCurrentArmor(Armor);
        this.setMaxDurability(Armor);

        //On a roll of 12 or higher this unit can be hit
        this.setHitChance(12);

        this.setMaxSquadSize(2);
        this.setCurrentSquadSize(2);
    }
}
