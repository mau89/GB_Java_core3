import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class task_2 {
    public static void main(String[] args) {
        Integer[] ints = {1, 4, 6, 8, 2, 3, 5, 7, 8, 4};
        String[] strings = {"a","b","v","i","r","d"};
        Replace(ints);
        Replace(strings);
    }

    private static <T> void Replace(T[] myArray){
        List<T> myArrayList=new ArrayList<>();
        Collections.addAll(myArrayList,myArray);
    }
}
