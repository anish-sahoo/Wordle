package Wordle;

import java.util.Random;

public class WordleLogic {
    private String word;

    WordleLogic(){
        String[] words = new String[]{"Abuse", "Adult", "Agent", "Anger", "Apple", "Award", "Basis", "Beach", "Birth", "Block", "Blood", "Board",
                "Brain", "Bread", "Break", "Brown", "Buyer", "Cause", "Chain", "Chair", "Chest", "Chief", "Child", "China", "Claim",
                "Class", "Clock", "Coach", "Coast", "Court", "Cover", "Cream", "Crime", "Cross",
                "Crowd", "Crown", "Cycle", "Dance", "Death", "Depth", "Doubt", "Draft", "Drama",
                "Dream", "Dress", "Drink", "Drive", "Earth", "Enemy", "Field", "Fight", "Final",
                "Floor", "Focus", "Force", "Frame", "Frank", "Front", "Fruit", "Glass", "Grant",
                "Grass", "Green", "Group", "Range", "Ratio", "Reply", "Right", "River", "Train",
                "Trend", "Trial", "Trust", "Truth", "Uncle", "Union", "World", "Youth", "Azure", "Adieu","Noble"};
        word = words[new Random().nextInt(words.length)].toUpperCase();
    }
    public void changeWord(){
        String[] words = new String[]{"Abuse", "Adult", "Agent", "Anger", "Apple", "Award", "Basis", "Beach", "Birth", "Block", "Blood", "Board",
                "Brain", "Bread", "Break", "Brown", "Buyer", "Cause", "Chain", "Chair", "Chest", "Chief", "Child", "China", "Claim",
                "Class", "Clock", "Coach", "Coast", "Court", "Cover", "Cream", "Crime", "Cross",
                "Crowd", "Crown", "Cycle", "Dance", "Death", "Depth", "Doubt", "Draft", "Drama",
                "Dream", "Dress", "Drink", "Drive", "Earth", "Enemy", "Field", "Fight", "Final",
                "Floor", "Focus", "Force", "Frame", "Frank", "Front", "Fruit", "Glass", "Grant",
                "Grass", "Green", "Group", "Range", "Ratio", "Reply", "Right", "River", "Train",
                "Trend", "Trial", "Trust", "Truth", "Uncle", "Union", "World", "Youth","Azure", "Adieu","Noble"};
        word = words[new Random().nextInt(words.length)].toUpperCase();
    }

    public String enter(String guess){
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == guess.charAt(i)){
                result+=guess.charAt(i);
            }
            else if(word.indexOf(guess.charAt(i))>-1 && guess.charAt(i)!=word.charAt(i)){
                result+=Character.toLowerCase(guess.charAt(i));
            }
            else result+="+";
        }
        return result;
    }
    public String getWord(){
        return word;
    }
}