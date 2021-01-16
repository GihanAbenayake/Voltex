package Units;

import java.util.ArrayList;
import java.util.List;

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
            this.getFleetMakeup()[x].setAlly(true);
        }
    }

    public void setEnemy(){
        for(int x =0; x < getFleetMakeup().length; x++){
            this.getFleetMakeup()[x].setAlly(false);
        }
    }
    public UnitTemplate[] getSpecificTypeInFleet(String ShipType) {
        List<UnitTemplate> SpecificTypeArrayList = new ArrayList<>();

            for(int x = 0; 0 < FleetMakeup.length; x++){
                if(x == FleetMakeup.length-1){
                    SpecificTypeArrayList.add(FleetMakeup[x]);
                    break;
                }
                if(FleetMakeup[x].getType().getType().equals(ShipType)){
                SpecificTypeArrayList.add(FleetMakeup[x]);
                }
            }
            UnitTemplate[] SpecificTypeArray = new UnitTemplate[SpecificTypeArrayList.size()];

            for(int x = 0; 0 < SpecificTypeArrayList.size(); x++){
                if(x == SpecificTypeArrayList.size()-1){
                    SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
                    break;
                } else{
                    SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
                }
            }

            //Debug
        /*
        System.out.println("\n " + ShipType + " Arraylist");
        SpecificTypeArrayList.forEach(Ship -> System.out.println("\n" + Ship.getName()));
        System.out.println("\n " + ShipType + " Array");
        for(int x = 0; x < SpecificTypeArray.length; x++){
                System.out.println("\n " + SpecificTypeArray[x].getName());
            }

         */

            return SpecificTypeArray;
    }

    public UnitTemplate[] getSpecificRangeInFleet(int Range) {
        List<UnitTemplate> SpecificTypeArrayList = new ArrayList<>();

        for(int x = 0; 0 < FleetMakeup.length; x++){
            if(x == FleetMakeup.length-1){
                SpecificTypeArrayList.add(FleetMakeup[x]);
                break;
            }
            if(FleetMakeup[x].getCurrentRange() == Range){
                SpecificTypeArrayList.add(FleetMakeup[x]);
            }
        }
        UnitTemplate[] SpecificTypeArray = new UnitTemplate[SpecificTypeArrayList.size()];

        for(int x = 0; 0 < SpecificTypeArrayList.size(); x++){
            if(x == SpecificTypeArrayList.size()-1){
                SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
                break;
            } else{
                SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
            }
        }

        //Debug
        /*
        System.out.println("\n Ships at Range " + Range + " Arraylist");
        SpecificTypeArrayList.forEach(Ship -> System.out.println("\n" + Ship.getName()));
        System.out.println("\n Ships at Range " + Range + " Array");
        for(int x = 0; x < SpecificTypeArray.length; x++){
                System.out.println("\n " + SpecificTypeArray[x].getName());
            }

         */

        return SpecificTypeArray;
    }


    public UnitTemplate[] getSpecificTypeANDRangeInFleet(String ShipType,int Range) {
        List<UnitTemplate> SpecificTypeArrayList = new ArrayList<>();

        for(int x = 0; 0 < FleetMakeup.length; x++){
            if(x == FleetMakeup.length-1){
                SpecificTypeArrayList.add(FleetMakeup[x]);
                break;
            }
            if((FleetMakeup[x].getType().getType().equals(ShipType)) && (FleetMakeup[x].getCurrentRange() == Range)){
                SpecificTypeArrayList.add(FleetMakeup[x]);
            }
        }
        UnitTemplate[] SpecificTypeArray = new UnitTemplate[SpecificTypeArrayList.size()];

        for(int x = 0; 0 < SpecificTypeArrayList.size(); x++){
            if(x == SpecificTypeArrayList.size()-1){
                SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
                break;
            } else{
                SpecificTypeArray[x] = SpecificTypeArrayList.get(x);
            }
        }

        //Debug
        /*
        System.out.println("\n " + ShipType + " at Range" + Range +" Arraylist");
        SpecificTypeArrayList.forEach(Ship -> System.out.println("\n" + Ship.getName()));
        System.out.println("\n " + ShipType +" at Range " + Range + " Array");
        for(int x = 0; x < SpecificTypeArray.length; x++){
                System.out.println("\n " + SpecificTypeArray[x].getName());
            }

         */

        return SpecificTypeArray;
    }
}
