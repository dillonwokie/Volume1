import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> collatzSeq(int num) {
        ArrayList<Integer> numList = new ArrayList<Integer>(num);
        numList.add(num);

        if (num < 1) {
            throw new IllegalArgumentException("Input integer cannot be less than 0");
        }

        while (num != 1) {
            num = (num % 2 == 0) ? (num / 2) : (3 * num + 1);
            numList.add(num);
        }
        return numList;
    }

    static int maxCycle(int start, int end) {
        int maxLength = 0;
        for (int i = start; i <= end; i++) {
            int seqLength = collatzSeq(i).size();
            if (seqLength > maxLength) {
                maxLength = seqLength;
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine().trim();
        String[] parts = input.split("\\s+");

        if (parts.length != 2) {
            throw new IllegalArgumentException("Input should contain only 2 integers separated by space");
        }

        int start = Integer.parseInt(parts[0]);
        int end = Integer.parseInt(parts[1]);

        if (start > end) {
            throw new IllegalArgumentException("The 1st integer cannot be greater than the 2nd integer");
        }

        int maxCycleLength = maxCycle(start, end);
        System.out.printf("%d %d %d", start, end, maxCycleLength);
    }
}