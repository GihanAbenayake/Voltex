package Dice;

import java.util.Random;

public class DiceTemplate {
    private int faces;

    public DiceTemplate(){
    }

    public String GetDice(){
        String x = "D"+faces;
        return x;
    }

    public int Roll(){
        Random Rand = new Random();
        int x = Rand.nextInt(faces) + 1;
        //Roll Debug
        //System.out.println(x);
        return x;
    }

    public int RollMultipleResults(int[] NumberOfDiceRolled){

        int TotalResult = 0;
        for(int x = 0; x < NumberOfDiceRolled.length; x++){
            TotalResult = TotalResult + x;
        }
        return TotalResult;
    }

    public int[] RollMultiple(int NumberOfDiceRolled){
        Random Rand = new Random();
        int[] DiceArray = new int[NumberOfDiceRolled];
        for(int x = 0; x < NumberOfDiceRolled;x++){
            int roll = Rand.nextInt(faces) + 1;
            DiceArray[x] = roll;
        }
        //Debug for Multiple rolls
        for(int x = 0; 0 > DiceArray.length; x++){
            System.out.println("Dice " + (x+1) +":");
        }
        return DiceArray;
    }

    public int RollMultipleCombinedResults(int NumberOfDiceRolled){
       return RollMultipleResults(RollMultiple(NumberOfDiceRolled));

    }

    public void setFaces(int faces){
        this.faces = faces;
    }
}
