import java.util.ArrayList;

public class day6 {
    public static void main(String[] args) {
        //Modified input in Notepad++
        int[] input = {5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6};
        //Part One
        ArrayList<String> previous = new ArrayList<>();
        String currentArr = "";
        int count = 0;

        while(!previous.contains(currentArr)) {
            previous.add(arrToString(input));
            redistributeTheWealth(input);
            currentArr = arrToString(input);
            count++;
            System.out.println("We're still stuck in here after cycle " + count);
        }
        System.out.println("It took " + count + " redistribution cycles to create a repeat configuration!!");
        System.out.println("The repeated configuration is: " + currentArr);

        //Part Two
        System.out.println(previous.indexOf(currentArr));
        System.out.println(count - previous.indexOf(currentArr));
    }

    public static void redistributeTheWealth(int[] nums) {
        int index = findMaxIndex(nums);
        int count = nums[index];
        nums[index] = 0;
        while(count > 0) {
            if(index < nums.length - 1) {
                nums[++index]++;
            } else {
                index = 0;
                nums[index]++;
            }
            count--;
        }
    }

    public static int findMaxIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }

    public static String arrToString(int[] nums) {
        String out = "";
        for(int i = 0; i < nums.length; i++) {
            out += Integer.toString(nums[i]) + " ";
        }
        return out;
    }
}


