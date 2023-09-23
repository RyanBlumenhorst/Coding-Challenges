package com.Main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // Challenge: Write a program that will reverse the characters of a String
        // Example: Input of "abc123" would return "321cba"

        //COMPLETED: 11min

        //Prompt
        System.out.println("Challenge 1: Input a String to Reverse the Characters of: ");

        //Collect Integer
        Scanner scanner = new Scanner(System.in);
        String strInput = scanner.nextLine();

        //Call function
        ReverseString(strInput);

        //Challenge: Write a program to reverse the words of a String
        //Example: Input "My name is Ryan" returns "Ryan is name My"

        //COMPLETED:  29min

        //Prompt
        System.out.println("Challenge 2: Input a String to Reverse the Words of: ");

        //Collect Input
        String inputStr = scanner.nextLine();

        //Array Length
        int arrayLength = 20;

        //Store String in array, split by spaces
        String[] strArray = new String[arrayLength];
        strArray = inputStr.split(" ");

        //Call function
        ReverseStringWords(strArray);

        //Challenge: Pig Latin translator
        //First, take first letter to the end
        //Second, add "ay" to the end

        //COMPLETED: 17.5min

        //Prompt
        System.out.println("Challenge 3: Input a word to translate to Pig Latin:");

        //Collect Input
        String normalWord = scanner.next();

        //Call function
        PigLatinTranslator(normalWord);


        //Challenge: Write a guessing game program for numbers between 1 and 100

        //COMPLETED: 10 min

        //Prompt
        System.out.println("I'm thinking of a number between 1 and 10... What is your guess?");

        //Collect Guess
        int guess = 0;
        try {
            guess = scanner.nextInt();
        } catch (Exception e){
            System.out.println("Not an Integer:" + e);
        }

        int ComputerNumber = (int) (Math.random()*10 + 1);

        GuessingGame(guess, ComputerNumber);

     }

    public static void ReverseString(String strInput){
        //Variables
        int arrayLength = 0;
        String reversedStr = "";

        //Create Character Array
        arrayLength = strInput.length();
        char[] charArray = new char[arrayLength];

        //Reverse number and put into character array
        for(int i = 0; i < charArray.length; i++){
            charArray[i] = strInput.charAt(arrayLength - 1 - i);
        }

        //Create the reversed String
        for(int i = 0; i < charArray.length; i++){
            reversedStr = reversedStr + charArray[i];
        }

        //Print out the Reversed String
        System.out.println(reversedStr);
    }

    public static void ReverseStringWords(String[] strArray){
        //Variable for new Array Length
        int arrayLength = 0;

        //Getting exact count for array length based on input
        for(int i = strArray.length - 1; i >= 0 ; i--){
            if(!strArray[i].equals(null)){
                arrayLength += 1;
            }
        }

        //Creating reversed string array and the reversed String
        String[] reversedStr = new String[arrayLength];
        String reversed = "";

        //Reversing the String
        for(int i = 0; i < strArray.length; i++){
            reversedStr[i] = strArray[strArray.length - 1 - i];
        }

        //Adding a space in between all words of the String, except the last word, and combining them
        for(int i = 0; i < reversedStr.length; i++){
            if(i < reversedStr.length - 1) {
                reversed = reversed + reversedStr[i] + " ";
            } else {
                reversed = reversed + reversedStr[i];
            }
        }

        //Print Reversed String
        System.out.println(reversed);
    }

    public static void PigLatinTranslator(String normalWord){
        //Variables
        int arrayLength = 0;
        String pigLatinWord = "";

        //Create Char arrays
        arrayLength = normalWord.length() + 2;
        char[] charArray = new char[arrayLength];
        char[] charArrayCopy = new char[arrayLength];

        //Populate Arrays
        for(int i = 0; i < charArray.length - 2; i++){
            charArray[i] = normalWord.charAt(i);
            charArrayCopy[i] = normalWord.charAt(i);
        }

        //Shift Letters to front
        for(int i = 0; i < charArray.length - 2; i++){
            charArray[i] = charArrayCopy[i+1];
        }
        //First letter at the end, followed by 'ay'
        charArray[arrayLength - 3] = charArrayCopy[0];
        charArray[arrayLength - 2] = 'a';
        charArray[arrayLength - 1] = 'y';

        //Convert to String
        for(int i = 0; i < charArray.length; i++){
            pigLatinWord = pigLatinWord + charArray[i];
        }

        //Print result
        System.out.println(pigLatinWord);

    }

    public static void GuessingGame(int guess, int ComputerNumber){
        Scanner scanner = new Scanner(System.in);
        boolean correct = false;

        if(guess == ComputerNumber){
            System.out.println("CORRECT!!");
            correct = true;
        } else{
            System.out.println("INCORRECT, MY NUMBER WAS: " + ComputerNumber + ", TRY AGAIN");
        }

        if(!correct) {
            try {
                guess = scanner.nextInt();
                ComputerNumber = (int) (Math.random()*10 + 1);
            } catch (Exception e) {
                System.out.println("Not an Integer: " + e);
            }

            GuessingGame(guess, ComputerNumber);
        } else{
            return;
        }
    }
}