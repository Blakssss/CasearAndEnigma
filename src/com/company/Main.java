package com.company;
import java.util.Scanner;
public class Main {
    Scanner input = new Scanner(System.in);
    String encryptOrDecrypt;
    String stringInput;
    int shiftKey;
    int length;
    static boolean exit = false;

    public static void main(String[] args) {
        while (!exit) {
            Main main = new Main();
            main.enigmaType();
        }
    }

    public void enigmaType() {
        System.out.println("Welcome to the Enigma program. what type of encryption program would you like to run?\n1)Caesar?\n2)Vigenère?\n3)Numbers?\nType the number of your desired program. Or type 4)Exit to terminate the program:");
        int number = input.nextInt();
        input.nextLine(); //Scannerbug
        System.out.println("You chose nr." + number);
        if (number == 1) {
            encryptOrDecrypt();
            encrypt();
            decrypt();
        }
        if (number == 2) {
            System.out.println("We're sorry, the services you desired have not been implemented. Have a nice day.");
            exit = true;
        }
        if (number == 3) {
            encryptOrDecrypt();
            encryptNumber();
            decryptNumber();
        }
        if (number == 4) {
            terminate();
        }
    }

    public void encryptOrDecrypt() {
        System.out.println("\nWould you like to \"encrypt\" or \"decrypt\" a message?");
        encryptOrDecrypt = input.nextLine();
    }

    public void encrypt() {
        if (encryptOrDecrypt.equals("encrypt")) {
            System.out.println("What is your message?");
            stringInput = input.nextLine();
            stringInput = stringInput.toUpperCase();
            System.out.println("What shift-key will you be using?");
            shiftKey = input.nextInt();
            for (int i = 0; i < stringInput.length(); i++) {
                int stringInputIndex = stringInput.charAt(i) + shiftKey;
                if (stringInputIndex > 90) stringInputIndex = stringInputIndex - 26;
                char encryptedMessage = (char) stringInputIndex;
                System.out.print(encryptedMessage);
            }
            System.out.println("\n");
        }
    }

    public void decrypt() {
        if (encryptOrDecrypt.equals("decrypt")) {
            System.out.println("You have chosen to decrypt a message. What shift-key will you be using?");
            shiftKey = input.nextInt();
            System.out.println("Type in the encrypted message:");
            input.nextLine();//Scanner-bug
            stringInput = input.nextLine();
            stringInput = stringInput.toUpperCase();
            for (int i = 0; i < stringInput.length(); i++) {
                int stringInputIndex = stringInput.charAt(i) - shiftKey;
                if (stringInputIndex > 90) stringInputIndex = stringInputIndex - 26;
                char decryptedMessage = (char) stringInputIndex;
                System.out.print(decryptedMessage);
            }
            System.out.println("\n");
        }
    }
    // NUMBER PROGRAM
    public void encryptNumber() {
        if (encryptOrDecrypt.equals("encrypt")) {
            System.out.println("What is your message?");
            stringInput = input.nextLine();
            stringInput = stringInput.toUpperCase();
            System.out.println("What shift-key will you be using?");
            shiftKey = input.nextInt();
            for (int i = 0; i < stringInput.length(); i++) {
                int stringInputIndex = stringInput.charAt(i) + shiftKey;
                if (stringInputIndex > 90) stringInputIndex = stringInputIndex - 26;

                System.out.print(stringInputIndex + ",");
            }
            System.out.println("\n");
        }
    }
    public void decryptNumber() {
        if (encryptOrDecrypt.equals("decrypt")) {
            System.out.println("You have chosen to decrypt a message. What shift-key will you be using?");
            shiftKey = input.nextInt();
            System.out.println("How long is your message?");
            length = input.nextInt();
            System.out.println("Type in the encrypted number:");
            for (int i = 0; i < length; i++) {
                int encryptedNumber = input.nextInt();
                encryptedNumber = encryptedNumber - shiftKey;
                char decryptedMessage = (char) encryptedNumber;
                System.out.println(decryptedMessage);
            }
            System.out.println("\n");
        }
    }
        // NUMBER PROGRAM

        void terminate () {
            System.out.println("You have now encrypted and decrypted a basic message. You're like a spy or something. \nIf you chose to simply exit the program however you're not like a spy.");
            exit = true;
    }
}


