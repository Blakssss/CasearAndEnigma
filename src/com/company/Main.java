package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    Scanner input = new Scanner(System.in);
    String alphabet1 = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String shift1Encrypt = "Z ABCDEFGHIJKLMNOPQRSTUVWXY";
    String shift2Encrypt = "YZ ABCDEFGHIJKLMNOPQRSTUVWX";

    char[] alphabet = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W','X', 'Y', 'Z'};
    char[] shift1Decrypt = {'Z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
    char[] shift2Decrypt = {'Y', 'Z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
    String encryptOrDecrypt;
    String stringInput;
    public static void main(String[] args) {
        Main main = new Main();
        main.enigmaType();
    }

    public void enigmaType(){
        System.out.println("Welcome to the Enigma program. what type of encryption program would you like to run?\n1)Caesar?\n2)Vigenère?\n3)Numbers?\nType the number of your desired program. Or type 4)Exit to terminate the program:");
        int number= input.nextInt();
        input.nextLine(); //Scannerbug
        System.out.println("You chose nr." + number);
        if (number == 1){
            encryptOrDecryptCaesar();
            encrypt();
            decrypt();
            encryptOrDecryptCaesar();
            encrypt();
            decrypt();
            terminate();
        }
        if(number == 2){
            System.out.println("We're sorry, the services you desired have not been implemented. Have a nice day.");
        }
        if(number == 3){
            System.out.println("We're sorry, the services you desired have not been implemented. Have a nice day.");
        }
        if (number == 4){
            terminate();
        }
    }

    public void encryptOrDecryptCaesar(){
        System.out.println("\nWould you like to \"encrypt\" or \"decrypt\" a message?");
        encryptOrDecrypt = input.nextLine();
    }
    public void encrypt() {
        if (encryptOrDecrypt.equals("encrypt")) {
            System.out.println("What is your message?");
            stringInput = input.nextLine();
            stringInput = stringInput.toUpperCase();
            int[] arrayOfInput = new int[stringInput.length()];

            System.out.println("What key will you be using? 1 or 2?");
            int shiftKey = input.nextInt();
            input.nextLine(); //Scannerbug
            if (shiftKey == 1) {
                for (int i = 0; i < stringInput.length(); i++) {
                    arrayOfInput[i] = stringInput.charAt(i);
                    arrayOfInput[i] = shift1Encrypt.indexOf(arrayOfInput[i]);
                    if(i == stringInput.length()-1){
                        System.out.println(Arrays.toString(arrayOfInput));

                    }
                }
            }
            if (shiftKey == 2) {
                for (int i = 0; i < stringInput.length(); i++) {
                    arrayOfInput[i] = stringInput.charAt(i);
                    arrayOfInput[i] = shift2Encrypt.indexOf(arrayOfInput[i]);
                    if(i == stringInput.length()-1){
                        System.out.println(Arrays.toString(arrayOfInput));
                    }
                }
            }
        }
    }
    public void  decrypt(){
        if (encryptOrDecrypt.equals("decrypt")) {
            System.out.println("You have chosen to decrypt a message. What key will you be using?");
            int shiftKey = input.nextInt();
            System.out.println("Type in the encrypted message:");
            if (shiftKey == 1) {
                for (int i = 0; i < stringInput.length(); i++) {
                    int intInput = input.nextInt();
                    System.out.println(shift1Decrypt[intInput]);
                }
            }
            if (shiftKey == 2) {
                for (int i = 0; i < stringInput.length(); i++) {
                    int intInput = input.nextInt();
                    System.out.println(shift2Decrypt[intInput]);
                }
            }
        }
    }
    void terminate(){
        System.out.println("You have now encrypted and decrypted a basic message. You're like a spy or something. If you chose to simply exit the program however you're not like a spy.");
    }
}
