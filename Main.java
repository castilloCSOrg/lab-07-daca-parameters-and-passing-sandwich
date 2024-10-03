// YOUR NAME: 
// COLLABORATORS: 
// DATE: 

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Replace hardcoded values with user input from UtilityBelt
        String surname = UtilityBelt.readString("Enter surname (2-45 characters): ", 2, 45);
        String givenName = UtilityBelt.readString("Enter given name (2-45 characters): ", 2, 45);
        String category = UtilityBelt.readString("Enter category (C00-C99): ", 2, 3);
        String cardNum = UtilityBelt.readString("Enter card number (SRCXXXXXXXX): ", 15, 15);
        String birthCountry = UtilityBelt.readString("Enter country of birth (2-45 characters): ", 2, 45);
        String termsAndConditions = UtilityBelt.readString("Enter terms and conditions (2-45 characters): ", 2, 45);
        char sex = UtilityBelt.readChar("Enter sex (M/F): ", "MF");
        
        // USCIS number parts and formatting
        int uscisNum1 = UtilityBelt.readInt("Enter USCIS number part 1 (3 digits): ", 0, 999);
        int uscisNum2 = UtilityBelt.readInt("Enter USCIS number part 2 (3 digits): ", 0, 999);
        int uscisNum3 = UtilityBelt.readInt("Enter USCIS number part 3 (3 digits): ", 0, 999);
        String uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
        
        // Date of birth (formatted with the new formatDate method)
        int dobDay = UtilityBelt.readInt("Enter date of birth (day): ", 1, 31);
        int dobMonth = UtilityBelt.readInt("Enter date of birth (month): ", 1, 12);
        int dobYear = UtilityBelt.readInt("Enter date of birth (year): ", 1900, 2023); // Adjust upper limit as needed
        String dateOfBirth = formatDate(dobDay, dobMonth, dobYear);
        
        // Valid date (formatted with the new formatDate method)
        int validDay = UtilityBelt.readInt("Enter valid from date (day): ", 1, 31);
        int validMonth = UtilityBelt.readInt("Enter valid from date (month): ", 1, 12);
        int validYear = UtilityBelt.readInt("Enter valid from date (year): ", 1900, 2023); // Adjust upper limit as needed
        String validDate = formatDate(validDay, validMonth, validYear);
        
        // Expiration date (formatted with the new formatDate method)
        int expireDay = UtilityBelt.readInt("Enter expiration date (day): ", 1, 31);
        int expireMonth = UtilityBelt.readInt("Enter expiration date (month): ", 1, 12);
        int expireYear = UtilityBelt.readInt("Enter expiration date (year): ", 1900, 2023); // Adjust upper limit as needed
        String expireDate = formatDate(expireDay, expireMonth, expireYear);
        
        // Output the formatted card
        String formattedCard = formatCard(surname, givenName, category, cardNum, birthCountry,
                                          termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate);
        System.out.println(formattedCard);
    }

    // Method to format a date with day, month, and year (DD/MM/YYYY)
    public static String formatDate(int day, int month, int year) {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    // Overloaded method to format a date with day, month (String), and year
    public static String formatDate(int day, String month, int year) {
        return String.format("%02d %s %04d", day, month, year);
    }

    public static String formatCard(String surname, String givenName, String category, String cardNum,
                                    String birthCountry, String termsAndConditions, char sex, 
                                    String uscisNum, String dateOfBirth, String validDate, String expireDate) {
        // Build the formatted card string
        StringBuilder card = new StringBuilder();
        
        card.append(String.format("╔══════════════════════════════════════════════════════════════════════╗%n"));
        card.append(String.format("║           UNITED STATES OF AMERICA                                   ║%n"));
        card.append(String.format("║                               EMPLOYMENT AUTHORIZATION CARD          ║%n"));
        card.append(String.format("║                         Surname                                      ║%n"));
        card.append(String.format("║                         %-45s║%n", surname));
        card.append(String.format("║    .----.    .----.     Given Name                                   ║%n"));
        card.append(String.format("║   (  --  \\  /  --  )    %-45s║%n", givenName));
        card.append(String.format("║          |  |           USCIS#         Category       Card#          ║%n"));
        card.append(String.format("║         _/  \\_          %-15s%-15s%-15s║%n", uscisNum, category, cardNum));
        card.append(String.format("║        (_    _)         Country of Birth                             ║%n"));
        card.append(String.format("║     ,    `--`    ,      %-45s║%n", birthCountry));
        card.append(String.format("║     \\'-.______.-'/      Terms and Conditions                         ║%n"));
        card.append(String.format("║      \\          /       %-45s║%n", termsAndConditions));
        card.append(String.format("║       '.--..--.'        Date of Birth  Sex                           ║%n"));
        card.append(String.format("║         `\"\"\"\"\"`         %-15s%-30s║%n", dateOfBirth, sex));
        card.append(String.format("║                         Valid From:    %-30s║%n", validDate));
        card.append(String.format("║                         Card Expires:  %-30s║%n", expireDate));
        card.append(String.format("║   ascii art by: jgs     NOT VALID FOR REENTRY TO U.S.                ║%n"));
        card.append(String.format("╚══════════════════════════════════════════════════════════════════════╝"));
        
        return card.toString();
    }
}