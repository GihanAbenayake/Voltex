package Units.Humanity.Corvettes;

import Units.UnitTemplate;
import Units.UnitTypes.Corvette;
import Units.UnitTypes.TypeTemplate;

public class CO_Longsword extends UnitTemplate {
    public CO_Longsword(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This unit is a Corvette
        TypeTemplate Type = new Corvette();
        this.setType(Type);

        //This unit has 1000 Durability to start with
        int Durability = 1000;
        this.setUnitDurability(Durability);
        this.setMaxDurability(Durability);

        //This unit has 100 damage mitigation to start with
        int Armor = 100;
        this.setCurrentArmor(Armor);
        this.setMaxArmor(Armor);

        //On a roll of 14 or higher this unit can be hit
        this.setHitChance(14);

        //There are 3 entities making up this unit
        this.setMaxSquadSize(3);
        this.setCurrentSquadSize(3);
    }
}
