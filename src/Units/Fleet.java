package Units;

public class Fleet {
    private String FleetName;
    private UnitTemplate[] FleetMakeup;

    public Fleet(String NameOfFleet, UnitTemplate[] FleetComposition){
        this.setFleetName(NameOfFleet);
        this.setFleetMakeup(FleetComposition);

    }

    public String getFleetName() {
        return FleetName;
    }

    public void setFleetName(String fleetName) {
        FleetName = fleetName;
    }

    public UnitTemplate[] getFleetMakeup() {
        return FleetMakeup;
    }

    public void setFleetMakeup(UnitTemplate[] fleetMakeup) {
        FleetMakeup = fleetMakeup;
    }

    public String PrintFleet(){
        String compiledFleet = "";

        for(int x = 0; x < FleetMakeup.length; x++){
            compiledFleet = compiledFleet + "\n\n " + FleetMakeup[x].ReadableString();
        }

        compiledFleet = "\bFleet Composition\b" + compiledFleet;
        return compiledFleet;
    }

    public void setAlly(){
        for(int x =0; x < getFleetMakeup().length; x++){
            this.getFleetMakeup()[x].setAlly(1);
        }
    }

    public void setEnemy(){
        for(int x =0; x < getFleetMakeup().length; x++){
            this.getFleetMakeup()[x].setAlly(0);
        }
    }
}
