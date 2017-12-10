import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class day4 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Puzzle Inputs/day4.txt"));
            String curr;
            int countPartOne = 0;
            int countPartTwo = 0;
            while((curr = br.readLine()) != null) {
                countPartOne += checkPhrasePartOne(curr);
                countPartTwo += checkPhrasePartTwo(curr);
            }
            System.out.println("There are " + countPartOne + " valid passphrases in the input according to Part One guidelines.");
            System.out.println("There are " + countPartTwo + " valid passphrases in the input according to Part Two guidelines.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try{
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Checks if the passphrase has any duplicate words.
     * @param pass           The passphrase to check
     * @return passCheck     1 - Valid passphrase; 0 - Invalid passphrase
     */
    public static int checkPhrasePartOne(String pass) {
        String[] strArr = pass.split(" ");
        Arrays.sort(strArr);
        return duplicateCheck(strArr);
    }

    /**
     * Checks if the passphrase follows the guidelines in Part Two
     * @param pass           The passphrase to check
     * @return passCheck     1 - Valid passphrase; 0 - Invalid passphrase
     */
    public static int checkPhrasePartTwo(String pass) {
        String[] strArr = pass.split(" ");
        for(int i = 0; i < strArr.length; i++) {
            char[] chars = strArr[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            strArr[i] = sorted;
        }
        Arrays.sort(strArr);
        return duplicateCheck(strArr);
    }

    /**
     * Checks an array of strings for any duplicates.
     * @param passArr       The array to check
     * @return check        1 if there are no duplicates; 0 if there are
     */
    public static int duplicateCheck(String[] passArr) {
        int check = 1; //Array is assumed to have no duplicates until proven otherwise.
        int i = 0;
        while(check == 1 && i < passArr.length - 1) {
            if(passArr[i].equals(passArr[i + 1])) {
                System.out.println("passphrase " + passArr[i] + " equals " + passArr[i + 1]);
                check = 0;
            }
            i++;
        }
        return check;
    }
}
