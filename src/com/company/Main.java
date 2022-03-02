package com.company;
import java.util.Scanner;
public class Main {
    Scanner input = new Scanner(System.in);
    String shift1Encrypt = "Z ABCDEFGHIJKLMNOPQRSTUVWXY";
    String shift2Encrypt = "YZ ABCDEFGHIJKLMNOPQRSTUVWX";
    String shift3Encrypt = "XYZ ABCDEFGHIJKLMNOPQRSTUVW";
    char[] shift1Decrypt = {'Z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y'};
    char[] shift2Decrypt = {'Y', 'Z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
    char[] shift3Decrypt = {'X', 'Y', 'Z', ' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W'};
    String encryptOrDecrypt;
    String stringInput;
    public static void main(String[] args) {
        Main main = new Main();
        main.encryptOrDecrypt();
        main.encrypt();
        main.decrypt();
        main.encryptOrDecrypt();
        main.encrypt();
        main.decrypt();
        main.terminate();
    }
    public void encryptOrDecrypt(){
        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?\n");
        encryptOrDecrypt = input.nextLine();
    }
    public void encrypt() {
        if (encryptOrDecrypt.equals("encrypt")) {
            System.out.println("What is your message?");
            stringInput = input.nextLine();
            stringInput = stringInput.toUpperCase();
            int[] arrayOfInput = new int[stringInput.length()];

            System.out.println("What key will you be using? 1 or 2?\n");
            int shiftKey = input.nextInt();
            input.nextLine(); //Scannerbug
            if (shiftKey == 1) {
                for (int i = 0; i < stringInput.length(); i++) {
                    arrayOfInput[i] = stringInput.charAt(i);
                    int number = shift1Encrypt.indexOf(arrayOfInput[i]);
                    System.out.println(number);
                }
            }
            if (shiftKey == 2) {
                for (int i = 0; i < stringInput.length(); i++) {
                    arrayOfInput[i] = stringInput.charAt(i);
                    int number = shift2Encrypt.indexOf(arrayOfInput[i]);
                    System.out.println(number);
                }
            }
        }
    }
    public void  decrypt(){
        if (encryptOrDecrypt.equals("decrypt")) {
            System.out.println("You have chosen to decrypt a message. What key will you be using?\n");
            int shiftKey = input.nextInt();
            System.out.println("Type in the encrypted message:");
            if (shiftKey == 1) {
                for (int i = 0; i < stringInput.length(); i++) {
                    int intInput = input.nextInt();
                    char letter = shift1Decrypt[intInput];
                    System.out.println(letter);
                }
            }
            if (shiftKey == 2) {
                for (int i = 0; i < stringInput.length(); i++) {
                    int intInput = input.nextInt();
                    char letter = shift2Decrypt[intInput];
                    System.out.println(letter);
                }
            }
        }
    }
    void terminate(){
        System.out.println("You have now encrypted and decrypted a basic message. You're like a spy or something.");
    }
}
