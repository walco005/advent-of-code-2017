public class day3 {
    //My puzzle input is 361527

    //These notes are a bit hap-hazard, since this is a daily exercise I will not be refining them.
    public static void main(String[] args) {
        //Definitions: Side Length (SL): The length between two corners NOT including the corners.
        //Statement: Each ring is increased by (4 * SL) + 12.
        // The 12 being the 3 values that "come out" of the previous corner, for each corner.
        int j = 9;
        int side = 1;
        int ring = 1;
        //This loop uses the previous equation to find the max value for the next consecutive ring until it is past the given input.
        while (j < 361527) {
            j += (side * 4 + 12);
            side += 2;
            ring++;
            System.out.println("You are at ring " + ring + " ending with " + j + ". This ring has a SL of " + side);
        }
        System.out.println("You are at ring 300 ending with 361201. This ring has a SL of 599");
        //Side length = s, current ring = r
        //half = r - 1
        //Given: The value 1 is ring 0. Side length does not count corners.
        //Proof:
        //		Side length goes up by 2 for each ring. This is obvious, since it expands out like a triangle. (Clearly I'm not the best at elaborating these things. But this phenomenon is observable)
        //		At ring 1 the "half" point is 0, 1 - 1.
        //		For each further ring, s is increased by 2. Thus, the half is increased by 1 for each ring going outwards.
        // QED

        //Given the above proof, the halfway point (where there's a straight line to 1) is 299.
        //The data has to hit 299, then move 300 rings inward.
        System.out.println(361527 - 361202); //The given input is the 325th value in the ring. 325 - 299 = 26; 26 + 300 = 326
        //326 is the amount of steps away to the center value, 1.
    }

}
