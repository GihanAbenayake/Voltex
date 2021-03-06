package Controllers;

import Controllers.SubControllers.CSC;
import Controllers.SubControllers.ISC;
import Controllers.SubControllers.MSC;
import Controllers.SubControllers.TSC;
import Units.Fleet;

public class CombatController {

    private VisualController AssignedController;
    private ISC initiativeController;
    private TSC turnController;
    private MSC movementController;
    private CSC combatController;
    public CombatController(VisualController VISCON){
        this.setAssignedController(VISCON);
    }

    private Fleet AllyFleet;
    private Fleet EnemyFleet;

    //Used to generate an Initiative Sub Controller
    public void generateSubControllers(){
        initiativeController = new ISC(this);
        turnController = new TSC(this);
        movementController = new MSC(this);
        combatController = new CSC(this);
    }
    public Fleet getAllyFleet() {
        return AllyFleet;
    }

    public void setAllyFleet(Fleet allyFleet) {
        AllyFleet = allyFleet;
    }

    public Fleet getEnemyFleet() {
        return EnemyFleet;
    }

    public void setEnemyFleet(Fleet enemyFleet) {
        EnemyFleet = enemyFleet;
    }

    public VisualController getAssignedController() {
        return AssignedController;
    }

    public void setAssignedController(VisualController assignedController) {
        AssignedController = assignedController;
    }

    public ISC getInitiativeController() {
        return initiativeController;
    }

    public void setInitiativeController(ISC initiativeController) {
        this.initiativeController = initiativeController;
    }

    public TSC getTurnController() {
        return turnController;
    }

    public void setTurnController(TSC turnController) {
        this.turnController = turnController;
    }

    public MSC getMovementController() {
        return movementController;
    }

    public void setMovementController(MSC movementController) {
        this.movementController = movementController;
    }

    public CSC getCombatController() {
        return combatController;
    }

    public void setCombatController(CSC combatController) {
        this.combatController = combatController;
    }
}
