package collection;

import java.util.Arrays;
import java.util.List;

public class reversedmanually {

    public static int[] reversedList(List<Integer> normallist) {
        int[] reversed = new int[normallist.size()];
        for (int i = normallist.size() - 1, j = 0; i >= 0; i--, j++) {
            reversed[j] = normallist.get(i);
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> normallist = Arrays.asList(10, 5, 7, 5, 7, 9, 8, 15);
        int[] reversedArray = reversedList(normallist);
        System.out.println(Arrays.toString(reversedArray));
    }
}