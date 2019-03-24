package task_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_2 {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 6, 8, 3, 1, 3, 5, 3, 4, 5, 1, 2));
        ArrayList<Integer> resultarr = arr1(arr);
        System.out.println(resultarr);
    }

    public static ArrayList<Integer> arr1(ArrayList<Integer> array) {
        ArrayList<Integer> resultsarr = new ArrayList<>();
        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i) == 4) {
                for (int j = i+1; j <= array.size()-1; j++) {
                    //System.arraycopy(array, 0, resultsarr, 0, array.size());
                    resultsarr.add(array.get(j));
                }
                return resultsarr;
            }
        }
        throw new RuntimeException();
    }
}
