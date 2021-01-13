package Units;
import Units.UnitTypes.Type;

public class Unit {

    //System Id for the unit
    private String ID;

    //Displayed Name of the unit
    private String Name;

    //Type of the unit. IE. Fighter, Corvette ect
    private Type Type;

    //Class of the unit (Different from type)
    //private String Class;

    //Durability/Health of the unit
    private int UnitHealth;

    //Armor of the unit (Used for Damage reduction)
    private int UnitArmor;

    public Unit(String UnitID, String UnitName){
        this.ID = UnitID;
        this.Name = UnitName;
        //this.Class = UnitClass;
    }

    public Unit Build(){
        Unit BuiltUnit = new Unit(ID,Name);
        System.out.println( BuiltUnit.Name + "Was built");
        return BuiltUnit;
    }

    public String toString(){
        return "Unit Id: " + ID + "\n" +
                "Unit Name: " + Name + "\n" +
                "Unit Type: " + Type.GetType() + "\n" +
                "Unit Durability: " + UnitHealth + "\n" +
                "Unit Armor: " + UnitArmor;
    }

    public void setType(Type type){
        this.Type = type;
    }

    public void setUnitDurability(int health){
        this.UnitHealth = health;
    }

    public void setUnitArmor(int Armor){
        this.UnitArmor = Armor;
    }

}
