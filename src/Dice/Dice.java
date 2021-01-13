package Dice;

import java.util.Random;

public class Dice {
    private int faces;

    public Dice(){
    }

    public int Roll(){
        Random Rand = new Random();
        int x = Rand.nextInt(faces) + 1;
        System.out.println(x);
        return x;
    }

    public int RollMultipleResults(int[] NumberofDiceRolled){

        int TotalResult = 0;
        for(int x = 0; x < NumberofDiceRolled.length; x++){
            int rolled = x;
            TotalResult = TotalResult + rolled;
        }
        return TotalResult;
    }

    public int[] RollMultiple(int NumberofDiceRolled){
        Random Rand = new Random();
        int[] DiceArray = new int[NumberofDiceRolled];
        for(int x = 0; x < NumberofDiceRolled;x++){
            int roll = Rand.nextInt(faces) + 1;
            DiceArray[x] = roll;
        }
        //Debug for Multiple rolls
        for(int x = 0; 0 > DiceArray.length; x++){
            System.out.println("Dice " + (x+1) +":");
        }
        return DiceArray;
    }

    public int RollMultipleCombinedResults(int NumberofDiceRolled){
       return RollMultipleResults(RollMultiple(NumberofDiceRolled));

    }

    public void setFaces(int faces){
        this.faces = faces;
    }
}
