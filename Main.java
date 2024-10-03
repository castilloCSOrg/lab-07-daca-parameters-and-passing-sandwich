// YOUR NAME: 
// COLLABORATORS: 
// DATE: 

public class Main 
{
        public static void main(String[] args) 
        {
            String surname = "CHAPETON-LAMAS";
            String givenName = "NERY";
            String category = "C09";
            String cardNum = "SRC9876543210";
            String birthCountry = "Guatemala";
            String termsAndConditions = "None";
            char sex = 'M';
            
            int uscisNum1 = 12;
            int uscisNum2 = 4;
            int uscisNum3 = 789;
            String uscisNum = String.format("%03d-%03d-%03d", uscisNum1, uscisNum2, uscisNum3);
            
            String dateOfBirth = formatDate(1, "JAN", 1970);
            
            String validDate = formatDate(2, 2, 2020);
            
            String expireDate = formatDate(2, 2, 2022);
            
            String formattedCard = formatCard(surname, givenName, category, cardNum, birthCountry,
                                              termsAndConditions, sex, uscisNum, dateOfBirth, validDate, expireDate);
            System.out.println(formattedCard);
        }
    
        public static String formatDate(int day, int month, int year) 
        {
            return String.format("%02d/%02d/%04d", day, month, year);
        }
    
        public static String formatDate(int day, String month, int year) 
        {
            return String.format("%02d %s %04d", day, month, year);
        }
    
        public static String formatCard(String surname, String givenName, String category, String cardNum,
                                        String birthCountry, String termsAndConditions, char sex, 
                                        String uscisNum, String dateOfBirth, String validDate, String expireDate) 
        {
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