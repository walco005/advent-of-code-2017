import java.io.*;

public class day9 {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("Puzzle Inputs/day9.txt"));
            int i;
            int depth = 0;
            int count = 0;
            boolean garbage = false;
            int garbAmount = 0; //Part Two
            while ((i = br.read()) != -1) {
                char c = (char) i;
                if(garbage) {
                    //The reader is currently in garbage, the only things relevant are ! and >, to try to get out.
                    switch (c) {
                        case '>':
                            garbage = false;
                            break;
                        case '!':
                            br.skip(1);
                            break;
                        default: //Part Two
                            garbAmount++;
                            break;
                    }
                } else {
                    //The reader is counting groups here, keeping track of how deep groups are and once they are closed,
                    //  adds that to the score.
                    switch (c) {
                        case '<':
                            garbage = true;
                            break;
                        case '{':
                            depth++;
                            break;
                        case '}':
                            count += depth--;
                            break;
                        case '!':
                            br.skip(1);
                            break;
                        default:
                            break;
                    }
                }
            }
            //Part One
            System.out.println("The total score is: " + count);
            //Part Two
            System.out.println("The amount of non-canceled garbage characters is: " + garbAmount);
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
}
