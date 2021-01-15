package Controllers;

import Controllers.SubControllers.ISC;
import Units.Fleet;

public class CombatController {

    private VisualController AssignedController;
    private ISC initiativeController;
    public CombatController(VisualController VISCON){
        this.setAssignedController(VISCON);
    }

    private Fleet AllyFleet;
    private Fleet EnemyFleet;

    //Used to generate an Initiative Sub Controller
    public void generateISC(){
        initiativeController = new ISC(this);
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
}
