package Units.Humanity.Cruisers;

import Units.UnitTemplate;
import Units.UnitTypes.Cruiser;
import Units.UnitTypes.TypeTemplate;

public class CR_Grandeur extends UnitTemplate {
    public CR_Grandeur(String UnitID, String UnitName) {
        super(UnitID, UnitName);

        //This unit is a Cruiser
        TypeTemplate type = new Cruiser();
        this.setType(type);

        //This Unit has 10000 Durability to start with
        int Durability = 10000;
        this.setUnitDurability(Durability);
        this.setMaxDurability(Durability);

        //This Unit has 1000 Damage mitigation
        int Armor = 1000;
        this.setCurrentArmor(Armor);

        //This Unit can be hit on a 13 or Lower
        this.setHitChance(13);

        this.setMaxSquadSize(2);
        this.setCurrentSquadSize(2);

    }
}
