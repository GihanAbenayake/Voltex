package Controllers.SubControllers;

import Controllers.CombatController;
import Units.Fleet;
import Units.UnitTemplate;

public class CombatSubControllerTemplate {
    private CombatController assignedController;
    private UnitTemplate[] AllyFleet;
    private UnitTemplate[] EnemyFleet;

    public CombatSubControllerTemplate(CombatController Controller) {
        this.setAssignedController(Controller);
        this.setAllyFleet(Controller.getAllyFleet().getFleetMakeup());
        this.setEnemyFleet(Controller.getEnemyFleet().getFleetMakeup());

    }

    public CombatController getAssignedController() {
        return assignedController;
    }

    public void setAssignedController(CombatController assignedController) {
        this.assignedController = assignedController;
    }

    public UnitTemplate[] getAllyFleet() {
        return AllyFleet;
    }

    public void setAllyFleet(UnitTemplate[] allyFleet) {
        AllyFleet = allyFleet;
    }

    public UnitTemplate[] getEnemyFleet() {
        return EnemyFleet;
    }

    public void setEnemyFleet(UnitTemplate[] enemyFleet) {
        EnemyFleet = enemyFleet;
    }
}
