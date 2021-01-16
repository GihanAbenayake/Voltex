package Controllers.SubControllers;

import Controllers.CombatController;
import Units.UnitTemplate;

//Movement sub controller
public class MSC extends CombatSubControllerTemplate {
    private UnitTemplate Actor;
    public MSC(CombatController Controller) {
        super(Controller);
    }

    public void Withdraw(){
        //What will happen
        //Sets action as planned, Will move one range away from the enemy
        this.getActor().setMovementAction("Withdraw");
    }

    public void Advance(){
        //What will happen
        //Sets action as planned, Will move one range towards the enemy
        this.getActor().setMovementAction("Advance");

    }

    public void Hold(){
        //What will happen
        // Sets action as planned, nothing happens
        this.getActor().setMovementAction("Holding Range");
    }

    public void MovementActionCommencement(){
        switch (this.getActor().getMovementAction()){
            case "Withdraw" : {
                this.getActor().setCurrentRange(this.getActor().getCurrentRange() + 1);
                this.getAssignedController().getAssignedController().DisplayText("\n\n" +this.getActor().getName() + " retreated to " + this.getActor().getCurrentRange());
                this.getActor().setMovementAction("");
                break;
            }
            case "Advance" : {
                this.getActor().setCurrentRange(this.getActor().getCurrentRange() - 1);
                this.getAssignedController().getAssignedController().DisplayText("\n\n" +this.getActor().getName() + " advanced to " + this.getActor().getCurrentRange());
                this.getActor().setMovementAction("");
                break;
            }
            case "Holding Range" : {
                this.getAssignedController().getAssignedController().DisplayText("\n\n" +this.getActor().getName() + " held range at " + this.getActor().getCurrentRange());
                this.getActor().setMovementAction("");
                break;
            }
        }
    }

    public UnitTemplate getActor() {
        return Actor;
    }

    public void setActor(UnitTemplate actor) {
        Actor = actor;
    }
}
