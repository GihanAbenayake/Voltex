package Units.Humanity.Battleships;

import Units.UnitTemplate;
import Units.UnitTypes.Battleship;
import Units.UnitTypes.TypeTemplate;

public class BA_Onager extends UnitTemplate {
    public BA_Onager(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This Unit is a Battleship
        TypeTemplate type = new Battleship();
        this.setType(type);

        //It Starts out with 50000 Durability
        int Durability = 50000;
        this.setUnitDurability(Durability);
        this.setMaxDurability(Durability);

        //It has 10000 damage Mitigation
        int Armor = 10000;
        this.setCurrentArmor(Armor);
        this.setMaxArmor(Armor);

        //It get hit on a 10 or higher
        this.setHitChance(10);

        //There is only a single unit of this
        this.setMaxSquadSize(1);
        this.setCurrentSquadSize(1);
    }
}
