package Controllers;

import Units.Fleet;
import Units.Humanity.Bombers.BO_ZweiHandler;
import Units.Humanity.Corvettes.CO_Longsword;
import Units.Humanity.Fighters.FI_Rapier;
import Units.UnitTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class FleetController {
   private List<Fleet> FleetList = new ArrayList<>();

   //Creates a fleet of Rapiers equal to the number in RequiredFighterAmount with the fleet being named after FleetName
   public void GenerateFighterFleet(String FleetName,int RequiredFighterAmount){

      UnitTemplate[] NewFighterFleet = new UnitTemplate[RequiredFighterAmount];

      for(int x = 0;x < RequiredFighterAmount; x++){
         NewFighterFleet[x] = new FI_Rapier("Rapier" + x,"Rapier " + x);
      }

      Fleet FighterFleet = new Fleet(FleetName,NewFighterFleet);
      FleetList.add(FighterFleet);

      //Debug Text
      System.out.println("Generated a Rapier fleet called " + FleetName + " that contains " + RequiredFighterAmount + " Rapiers.");
   }

   //Creates a fleet of ZweiHandlers
   public void GenerateBomberFleet(String FleetName,int RequiredFighterAmount){

      UnitTemplate[] NewFighterFleet = new UnitTemplate[RequiredFighterAmount];

      for(int x = 0;x < RequiredFighterAmount; x++){
         NewFighterFleet[x] = new BO_ZweiHandler("ZweiHandler " + x,"ZweiHandler " +x);
      }

      Fleet FighterFleet = new Fleet(FleetName,NewFighterFleet);
      FleetList.add(FighterFleet);

      //Debug Text
      System.out.println("Generated a ZweiHandler fleet called " + FleetName + " that contains " + RequiredFighterAmount + " Zweihandlers.");
   }

   public void GenerateCorvetteFleet(String FleetName,int RequiredFighterAmount){

      UnitTemplate[] NewCorvetteFleet = new UnitTemplate[RequiredFighterAmount];

      for(int x = 0;x < RequiredFighterAmount; x++){
         NewCorvetteFleet[x] = new CO_Longsword("Longsword " + x,"Longsword " +x);
      }

      Fleet CorvetteFleet = new Fleet(FleetName,NewCorvetteFleet);
      FleetList.add(CorvetteFleet);

      //Debug Text
      System.out.println("Generated a Longsword fleet called " + FleetName + " that contains " + RequiredFighterAmount + " Longsword.");
   }

   public void GenerateCustomFleet(String FleetName, UnitTemplate[] FleetShips){
      Fleet NewFleet = new Fleet(FleetName,FleetShips);
      FleetList.add(NewFleet);
   }

   public void RemoveFleet(String FleetNameOfFleetToRemove){

      for(int x = 0; x < FleetList.size(); x++){
         if(FleetList.get(x).getFleetName().equalsIgnoreCase(FleetNameOfFleetToRemove)){
            System.out.println(FleetNameOfFleetToRemove + " has been removed from the Fleet List.");
            FleetList.remove(x);
            break;
         }else {
            System.out.println("Fleet not found in index " + x);
         }
      }
   }

   public List<Fleet> getFleetList() {
      return FleetList;
   }

   public void setFleetList(List<Fleet> fleetList) {
      FleetList = fleetList;
   }

   public void ToString(){
      FleetList.forEach(Fleet -> System.out.println("\n" + Fleet.getFleetName()));
   }
}
