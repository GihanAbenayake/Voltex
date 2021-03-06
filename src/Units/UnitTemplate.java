package Units;
import Units.UnitTypes.TypeTemplate;
import Units.Weapons.WeaponTemplate;

public class UnitTemplate {

    //System Id for the unit
    private String ID;

    //Displayed Name of the unit
    private String Name;

    //Type of the unit. IE. Fighter, Corvette ect
    private TypeTemplate Type;

    //The number that must be rolled to be hit
    private int HitChance;

    //Class of the unit (Different from type)
    //private String Class;

    //Maximum Durability of the unit
    private int MaxDurability;
    //Current Durability/Health of the unit
    private int CurrentDurability;

    //Maximum Armor of the Unit
    private int MaxArmor;
    //Current Armor of the unit (Used for Damage reduction)
    private int CurrentArmor;

    //Maximum size of the Unit, Used for dice scaling
    private int MaxSquadSize;

    //Current Size of the Unit, user for dice scaling
    private int CurrentSquadSize;

    //Current status of the Squadron/Unit
    private String Status = "Active";

    //Array containing all the Weapons of the craft
    private WeaponTemplate[] Weapons;

    //Any Modifiers the vessel has such as being a squadron or stealth craft
    private String[] Modifiers;

    //Description of the unit
    private String UnitDesc;

    //Combat variables to store as needed
    //Range area that the ship is currently at
    private int currentRange;

    //Initiative that the ship has rolled
    private int combatInitiative;

    //Movement action that is qued
    private String MovementAction;

    //Combat Action that is qued;
    private String CombatAction;

    //Sets status as an Ally (false = Enemy, true = Player)
    private Boolean Ally;

    public UnitTemplate(String UnitID, String UnitName){
        this.ID = UnitID;
        this.Name = UnitName;
        //this.Class = UnitClass;
    }

    public UnitTemplate Build(){
        UnitTemplate BuiltUnit = new UnitTemplate(ID,Name);
        System.out.println( BuiltUnit.Name + "Was built");
        return BuiltUnit;
    }

    public String ReadableString(){

        String result = "Name: " + Name + " " +
                "\tType: " + Type.getType() + " " +
                "\t\tDurability: " + CurrentDurability + " " +
                "\t\tArmor: " + CurrentArmor + " ";

        return result;
    }

    public String toString(){
        return "\nUnit Id: " + ID + " " +
                "Unit Name: " + Name + " " +
                "Unit Type: " + Type.getType() + " " +
                "Unit Durability: " + CurrentDurability + " " +
                "Unit Armor: " + CurrentArmor + " ";
    }

    public void setType(TypeTemplate type){
        this.Type = type;
    }

    public void setUnitDurability(int health){
        this.CurrentDurability = health;
    }
    public int getUnitDurability(){ return CurrentDurability;
    }

    public void setCurrentArmor(int Armor){
        this.CurrentArmor = Armor;
    }
    public int getCurrentArmor(){ return CurrentArmor;}

    public int getHitChance() {
        return HitChance;
    }

    public void setHitChance(int hitChance) {
        HitChance = hitChance;
    }

    public String getName(){
        return Name;
    }

    public int getMaxDurability() {
        return MaxDurability;
    }

    public void setMaxDurability(int maxDurability) {
        MaxDurability = maxDurability;
    }

    public int getMaxArmor() {
        return MaxArmor;
    }

    public void setMaxArmor(int maxArmor) {
        MaxArmor = maxArmor;
    }

    public int getMaxSquadSize() {
        return MaxSquadSize;
    }

    public void setMaxSquadSize(int maxSquadSize) {
        MaxSquadSize = maxSquadSize;
    }

    public int getCurrentSquadSize() {
        return CurrentSquadSize;
    }

    public void setCurrentSquadSize(int currentSquadSize) {
        CurrentSquadSize = currentSquadSize;
    }

    public String[] getModifiers() {
        return Modifiers;
    }

    public void setModifiers(String[] modifiers) {
        Modifiers = modifiers;
    }

    public WeaponTemplate[] getWeapons() {
        return Weapons;
    }

    public void setWeapons(WeaponTemplate[] weapons) {
        Weapons = weapons;
    }

    public String getUnitDesc() {
        if(UnitDesc.isEmpty() || UnitDesc == null){
            return this.getName()+"\n\nUnit description not set yet";
        }else
        return UnitDesc;
    }

    public void setUnitDesc(String unitDesc) {
        UnitDesc = unitDesc;
    }

    public int getCurrentRange() {
        switch (currentRange){
            case -1 : {
                return 1;
            }
            case -2 : {
                return 2;
            }
            case -3 : {
                return 3;
            }
            default:
                return 4;
        }
    }

    public void setCurrentRange(int currentRange) {
        this.currentRange = currentRange;
    }

    public boolean isAlly() {
        return Ally;
    }

    public void setAlly(boolean status) {
        Ally = status;
    }

    public int getCombatInitiative() {
        return combatInitiative;
    }

    public void setCombatInitiative(int combatInitiative) {
        this.combatInitiative = combatInitiative;
    }

    public String getMovementAction() {
        if(MovementAction == null||MovementAction.isEmpty()  ){
            return "Nothing";
        }else

        return MovementAction;
    }

    public void setMovementAction(String movementAction) {
        MovementAction = movementAction;
    }

    public String getCombatAction() {
        if(CombatAction == null ||CombatAction.isEmpty() ){
            return "Nothing";
        }else
        return CombatAction;
    }

    public void setCombatAction(String combatAction) {
        CombatAction = combatAction;
    }

    public TypeTemplate getType(){
        return Type;
    }

    public String getCombatDesc(){
        String CombatDesc = this.getUnitDesc() + "\n"
                +"Planned Movement Action: " + this.getMovementAction()
                +"Planned Combat Action: " + this.getCombatAction();

        return CombatDesc;

    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
