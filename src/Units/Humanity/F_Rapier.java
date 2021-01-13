package Units.Humanity;

import Units.Unit;
import Units.UnitTypes.Fighter;
import Units.UnitTypes.Type;

public class F_Rapier extends Unit {
    private Type Type = new Fighter();
    private int Durability = 300;
    private int Armor = 10;

    public F_Rapier(String UnitID, String UnitName) {
        super(UnitID, UnitName);
        this.setType(Type);
        this.setUnitArmor(Armor);
        this.setUnitDurability(Durability);

    }
}
