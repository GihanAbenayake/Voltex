import Controllers.CombatController;
import Controllers.FleetController;
import Controllers.UnitController;
import Controllers.VisualController;

public class Main {
    public static void main(String args[]){
        VisualController VisCont = new VisualController();
        VisCont.Initialise();

        UnitController UniCont = new UnitController();
        UniCont.Initalise();

        FleetController FleCont = new FleetController();

        //Generate fleet of five rapiers
        FleCont.GenerateFighterFleet("AllyFleet",5);
        FleCont.getFleetList().get(0).setAlly();
        //Generate a fleet of five Zweihandlers
        FleCont.GenerateFighterFleet("Enemy Fleet",5);
        FleCont.getFleetList().get(1).setEnemy();

        CombatController ConCont = new CombatController(VisCont);

        ConCont.setAllyFleet(FleCont.getFleetList().get(0));

        ConCont.setEnemyFleet(FleCont.getFleetList().get(1));

        ConCont.generateSubControllers();

        //Init roll
        ConCont.getInitiativeController().rollInitiative();

        //Turn Start
        ConCont.getTurnController().CombatStart();

        FleCont.getFleetList().get(1).getSpecificTypeInFleet("Corvette");



    }
}
