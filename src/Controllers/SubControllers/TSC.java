package Controllers.SubControllers;

import Controllers.CombatController;
import Dice.D2;
import Dice.DiceTemplate;
import Units.Humanity.Bombers.BO_ZweiHandler;
import Units.Humanity.Fighters.FI_Rapier;
import Units.UnitTemplate;
import Units.UnitTypes.Fighter;

//Turn Sub Controller
public class TSC extends CombatSubControllerTemplate {

    public TSC(CombatController Controller) {
        super(Controller);
    }

    public void CombatStart(){

        //Range Assignment
        for(int x = 0; x < 1; x++){
            UnitTemplate Ship = this.getAssignedController().getInitiativeController().getInitiativeOrder().get(x);
            switch(Ship.getType().getType()){
                case "Fighter":
                    Ship.setCurrentRange(1);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;

                case "Bomber":
                    Ship.setCurrentRange(1);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;


                case "Corvette":
                    Ship.setCurrentRange(2);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;

                case "Frigate": {
                    Ship.setCurrentRange(3);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;

                }
                case "Cruiser": {
                    Ship.setCurrentRange(3);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;

                }
                case "Battleship":{
                    Ship.setCurrentRange(4);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;

                }
                default: {
                    Ship.setCurrentRange(4);

                    //Debug
                    System.out.println(Ship.getName() + " set to Range " + Ship.getCurrentRange() );
                    break;
                }






            }

            TurnStart();
            TurnEnd();
        }


    }

    public void TurnStart(){

        //For loop for turns
        for(int x = 0; x < 1;x++) {
            int a = x;
            UnitTemplate ActingUnit = this.getAssignedController().getInitiativeController().getInitiativeOrder().get(x);
            BO_ZweiHandler TESTINGBOMBER = new BO_ZweiHandler("TB", "TestingBomber");
            this.getAssignedController().getCombatController().FireWeapon(ActingUnit.getWeapons()[0],TESTINGBOMBER );
        }
}

public void TurnEnd(){
    UnitTemplate a = this.getAssignedController().getInitiativeController().getInitiativeOrder().get(0);
    this.getAssignedController().getCombatController().setActor(a);
    this.getAssignedController().getMovementController().setActor(a);
    this.getAssignedController().getMovementController().MovementActionCommencement();
    this.getAssignedController().getCombatController().CombatActionCommences();
}
}
