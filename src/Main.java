import Controllers.CombatController;
import Controllers.FleetController;
import Controllers.UnitController;
import Controllers.VisualController;
import Units.Humanity.Bombers.BO_ZweiHandler;
import Units.Humanity.Fighters.FI_Rapier;
import Units.Weapons.Light_AutoCannon;
import Units.Weapons.Swordfish_Light_Bomb;

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
        FleCont.GenerateBomberFleet("Enemy Fleet",5);
        FleCont.getFleetList().get(1).setEnemy();

        CombatController ConCont = new CombatController(VisCont);

        ConCont.setAllyFleet(FleCont.getFleetList().get(0));

        ConCont.setEnemyFleet(FleCont.getFleetList().get(1));

        ConCont.generateISC();

        //Init roll
        ConCont.getInitiativeController().rollInitiative();



    }
}
