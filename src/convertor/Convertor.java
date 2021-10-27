package convertor;

import javax.swing.*;

public class Convertor {
    // Calling the Conversion methods based on user's choice
    public static void task() {
        // Creating an array of choices for the user to choose from
        String[] choices = { "Display Binary Format of a number", "Binary <=> Decimal Conversion", "Decimal <=> Hexadecimal Conversion", "Binary <=> Hexadecimal Conversion", "Addition of Binary numbers" };

        // Getting choice from the User
        int choice = JOptionPane.showOptionDialog( null, "What would you like to do?", "Conversion Calculator", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choices, choices[0] );

        // Calling of Conversion methods based on users choice
        try{
            switch (choice) {
                case 0:
                    binaryDisplay();
                    break;
                case 1:
                    binaryDecimal();
                    break;
                case 2:
                    decimalHex();
                    break;
                case 3:
                    binaryHex();
                    break;
                case 4:
                    addBinary();
                    break;
            }
        }
        catch( Exception e ) {
            JOptionPane.showMessageDialog( null, "Invalid Input Type!!!", "Conversion Calculator", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Asking if user would like to continue
    public static void progress() {
        while (true) {
            task();

            int next = JOptionPane.showConfirmDialog( null, "Would you like to do any other thing?", "Conversion Calculator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );

            if ( (next == JOptionPane.NO_OPTION) || (next == JOptionPane.CLOSED_OPTION) ) {
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Alrighty.\n\nStay Safe!!!", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE);
    }

    /* Displaying the Binary format of a number */
    public static void binaryDisplay() {
        // Getting value from the User
        double value = Double.parseDouble(JOptionPane.showInputDialog( null, "What Number would you like to display in Binary Format?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE ));

        // Converting & Printing out value in Binary Format
        JOptionPane.showMessageDialog( null, "The Value of your number in Binary Format is: \"" + Integer.toBinaryString((int) value) + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    /* Conversion between Binary & Decimal numbers */
    public static void binaryDecimal() {
        // Getting the mode of conversion the user wants to perform( i.e. Binary to Decimal or Decimal to Binary )
        String[] modes = { "Binary to Decimal Conversion", "Decimal to Binary Conversion" };
        String mode = (String) JOptionPane.showInputDialog( null, "What Mode of Conversion do you want to perform?\n  ( i.e. Binary to Decimal or Decimal to Binary )", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE, null, modes, modes[0] );

        // Calling the respective Binary-Decimal Conversion as regards user's choice
        switch (mode){
            case "Binary to Decimal Conversion":
                binaryToDecimal();
                break;
            case "Decimal to Binary Conversion":
                decimalToBinary();
                break;
        }
    }

    // Binary to Decimal method
    public static void binaryToDecimal() {
        // Declaring & Initializing the Decimal Variable
        int decimal;

        // Getting Binary value from user
        String num = JOptionPane.showInputDialog( null, "What Binary value do you want to convert to Decimal?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );

        // Converting Binary value to Decimal
        decimal = Integer.parseInt( num, 2 );

        // Returning the Decimal value to the user
        JOptionPane.showMessageDialog( null, "The Decimal Equivalent of your Binary number is: \"" + decimal + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    // Decimal to Binary method
    public static void decimalToBinary() {
        // Declaring the Binary variable
        StringBuilder binary = new StringBuilder(40);

        //Getting Decimal value from user
        int num = Integer.parseInt(JOptionPane.showInputDialog( null, "What Decimal value do you want to convert to Binary?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE ));

        // Converting & Storing Decimal value to variable - binary
        while ( num > 0 ) {
            binary.append( num % 2 );
            num /= 2;
        }

        // Reversing the binary value
        binary.reverse();

        // Returning the Binary value to the user
        JOptionPane.showMessageDialog( null, "The Binary Equivalent of your Decimal number is: \"" + binary + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    /* Conversion between Decimal & Hexadecimal numbers */
    public static void decimalHex() {
        // Getting the mode of conversion the user wants to perform( i.e. Decimal to Hexadecimal or Hexadecimal to Decimal )
        String[] modes = { "Decimal to Hexadecimal Conversion", "Hexadecimal to Decimal Conversion" };
        String mode = (String) JOptionPane.showInputDialog( null, "What Mode of Conversion do you want to perform?\n  ( i.e. Decimal to Hexadecimal or Hexadecimal to Decimal )", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE, null, modes, modes[0] );

        // Calling the respective Decimal-Hexadecimal Conversion as regards user's choice
        switch (mode){
            case "Decimal to Hexadecimal Conversion":
                decimalToHexadecimal();
                break;
            case "Hexadecimal to Decimal Conversion":
                hexadecimalToDecimal();
                break;
        }
    }

    // Decimal to Hexadecimal method
    public static void decimalToHexadecimal() {
        // Declaring Hexadecimal variable
        StringBuilder hex = new StringBuilder();

        // Creating an array of characters for all Hexadecimal digits
        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        // Getting Decimal value from user
        int decimal = Integer.parseInt(JOptionPane.showInputDialog( null, "What Decimal value do you want to convert to Hexadecimal?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE ));

        // Converting user's input to Hexadecimal
        while( decimal > 0 ) {
            hex.append( hexDigits[ decimal % 16 ] );
            decimal /= 16;
        }

        // Reversing the Hexadecimal value
        hex.reverse();

        // Returning the Hexadecimal value to the user
        JOptionPane.showMessageDialog( null, "The Hexadecimal Equivalent of your Decimal number is: \"" + hex + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    // Hexadecimal to Decimal method
    public static void hexadecimalToDecimal() {
        // Declaring & initializing Decimal variable
        int decimal = 0;

        // Creating a String of all Hexadecimal digits
        String hexDigits = "0123456789ABCDEF";

        // Getting Hexadecimal value from user
        String hex = JOptionPane.showInputDialog( null, "What Hexadecimal value do you want to convert to Decimal?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );

        // Converting user's input to UpperCase
        hex = hex.toUpperCase();

        // Converting user's input to decimal
        for( int i = 0; i < hex.length(); i++ ) {
            char digit = hex.charAt(i);
            int corrDigit = hexDigits.indexOf( digit );
            decimal = 16*decimal + corrDigit;
        }

        // Returning the Decimal value to the user
        JOptionPane.showMessageDialog( null, "The Decimal Equivalent of your Hexadecimal number is: \"" + decimal + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    /* Conversion between Binary & Hexadecimal numbers */
    public static void binaryHex() {
        // Getting the mode of conversion the user wants to perform( i.e. Binary to Hexadecimal or Hexadecimal to Binary )
        String[] modes = { "Binary to Hexadecimal Conversion", "Hexadecimal to Binary Conversion" };
        String mode = (String) JOptionPane.showInputDialog( null, "What Mode of Conversion do you want to perform?\n  ( i.e. Binary to Hexadecimal or Hexadecimal to Binary )", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE, null, modes, modes[0] );

        // Calling the respective Binary-Hexadecimal Conversion as regards user's choice
        switch (mode){
            case "Binary to Hexadecimal Conversion":
                binaryToHexadecimal();
                break;
            case "Hexadecimal to Binary Conversion":
                hexadecimalToBinary();
                break;
        }
    }

    // Binary to Hexadecimal method
    public static void binaryToHexadecimal() {
        // Declaring Hexadecimal variable
        String hex;

        // Getting Binary value from user
        String binary = JOptionPane.showInputDialog( null, "What Binary value do you want to convert to Hexadecimal?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );

        /* Converting the Binary value to Hexadecimal Equivalent */
        // Converting Binary to decimal
        int number = Integer.parseInt( binary, 2 );
        // Converting Decimal Equivalent to Hexadecimal
        hex = Integer.toHexString( number );

        // Returning the Hexadecimal value to user
        JOptionPane.showMessageDialog( null, "The Hexadecimal Equivalent of your Binary number is: \"" + hex + "\"", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    // Hexadecimal to Binary method
    public static void hexadecimalToBinary() {
        // Declaring Binary variable
        String binary;

        // Getting Hexadecimal value from user
        String hex = JOptionPane.showInputDialog( null, "What Binary value do you want to convert to Hexadecimal?", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );

        /* Converting the Hexadecimal value to Binary Equivalent */
        // Converting Hexadecimal to decimal
        int number = Integer.parseInt( hex, 16 );
        // Converting Decimal Equivalent to Binary
        binary = Integer.toBinaryString( number );

        // Returning the Binary value to user
        JOptionPane.showMessageDialog( null, "The Hexadecimal Equivalent of your Binary number is: \"" + binary + "\"", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }

    /* Addition of two Binary numbers */
    public static void addBinary() {
        // Asking User for the Binary numbers to be summed up
        String num1 = JOptionPane.showInputDialog( null, "Input the First Binary Number:", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );
        String num2 = JOptionPane.showInputDialog( null, "Input the Second Binary Number:", "Conversion Calculator", JOptionPane.QUESTION_MESSAGE );

        // Converting the numbers to Decimal
        int digit1 = Integer.parseInt( num1, 2 );
        int digit2 = Integer.parseInt( num2, 2 );

        // Summing up the numbers
        int result = digit1 + digit2;

        // Converting & Returning the Sum of the Binary digits to the user
        JOptionPane.showMessageDialog( null, "The Sum of your Binary digits is: \"" + Integer.toBinaryString(result) + "\".", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE );
    }
}