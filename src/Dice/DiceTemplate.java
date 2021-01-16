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


    public int RollMultipleCombinedResults(int NumberOfDiceRolled){
       int Result = 0;
       for(int x = 0; x < NumberOfDiceRolled; x++){
           Result = Result + this.Roll();
       }
       return Result;
    }

    public void setFaces(int faces){
        this.faces = faces;
    }

    public int getFaces() { return  faces;}
}
