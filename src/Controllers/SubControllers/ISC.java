package Controllers.SubControllers;

import Controllers.CombatController;
import Dice.D20;
import Units.UnitTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//THE INITIATIVE SUB CONTROLLER
public class ISC extends CombatSubControllerTemplate {

    private List<UnitTemplate> initiativeOrder = new ArrayList<>();
    public ISC(CombatController Controller) {
        super(Controller);
    }

    public void rollInitiative() {

        D20 initiativeDice = new D20();

        //Initial Init assignment and addition to Initiative Order
        //Ally Fleet (Roll 1 D20)
        for (int x = 0; x < this.getAllyFleet().length; x++) {
            int initiative = initiativeDice.Roll();
            this.getAllyFleet()[x].setCombatInitiative(initiative);
            initiativeOrder.add(this.getAllyFleet()[x]);
        }

        //Enemy Fleet
        //Ally Fleet (Roll 1 D20)
        for (int x = 0; x < this.getEnemyFleet().length; x++) {
            int initiative = initiativeDice.Roll();
            this.getEnemyFleet()[x].setCombatInitiative(initiative);
            initiativeOrder.add(this.getEnemyFleet()[x]);
        }

        //Unsorted List Debug listing
        /*
        System.out.println("\nUnsorted Rolled Initiative order");
        initiativeOrder.forEach(ship -> System.out.println(ship.getName() + " " + ship.getCombatInitiative()));
        */

        //Sorting
        Collections.sort(initiativeOrder,Comparator.comparingInt(UnitTemplate::getCombatInitiative));
        Collections.reverse(initiativeOrder);

        //Sorted ListDebug Listing
        /*
        System.out.println("\nSorted Rolled Initiative order");
        initiativeOrder.forEach(ship -> System.out.println(ship.getName() + " " + ship.getCombatInitiative()));
         */
    }

    public List<UnitTemplate> getInitiativeOrder(){
        return initiativeOrder;
    }

}

