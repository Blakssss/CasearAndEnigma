package com.company;
import java.util.Arrays;
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
       // main.password();
        main.encryptOrDecrypt();
        main.encrypt();
        main.decrypt();
        main.encryptOrDecrypt();
        main.encrypt();
        main.decrypt();
        main.terminate();
    }
    public void password(){
        Scanner input2 = new Scanner(System.in);
        int number= input2.nextInt();
        int[] array = new int[number];
        for(int i=0; i<number; i++)
        {
            array[i]=input2.nextInt();
            System.out.println(Arrays.toString(array));
        }
    }
    public void encryptOrDecrypt(){
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
        System.out.println("You have now encrypted and decrypted a basic message. You're like a spy or something.");
    }
}
