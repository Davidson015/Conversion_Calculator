package convertor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
	    // Welcome Message to the User
        JOptionPane.showMessageDialog(null, "Welcome!\nAs you've guessed, this a CONVERTOR Program I have written with java.\nOver the next few lines, I'd discuss briefly about the scope of function of my Convertor.", "Conversion Calculator", JOptionPane.PLAIN_MESSAGE);

        // Description of how the program works
        JOptionPane.showMessageDialog(null, "Basically, This Convertor deals in:\n    \u2022 The Conversion between Binary & Decimal Numbers,\n    \u2022 The Conversion between Decimal & Hexadecimal Numbers,\n    \u2022 The Conversion between Binary & Hexadecimal Numbers,\n    \u2022 The Addition of two Binary Numbers,\n    \u2022 Also, the Display of any Number Base in Binary Format.", "Conversion Calculator", JOptionPane.INFORMATION_MESSAGE);

        // Asking User for the Conversion action to be performed
        Convertor.task();
    }
}