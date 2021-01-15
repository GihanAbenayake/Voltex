package Controllers.SubControllers;

import Controllers.CombatController;
import Units.UnitTemplate;

//Turn Sub Controller
public class TSC extends CombatSubControllerTemplate {

    public TSC(CombatController Controller) {
        super(Controller);
    }

    public void CombatStart(){

        //Range Assignment
        for(int x = 0; x < this.getAssignedController().getInitiativeController().getInitiativeOrder().size(); x++){
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
        }


    }

    public void TurnStart(){

        //For loop for turns
        for(int x = 0; x < this.getAssignedController().getInitiativeController().getInitiativeOrder().size();x++){

        }

    }
}
