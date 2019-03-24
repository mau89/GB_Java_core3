import org.junit.Test;
import task_2_3.Task_2;

import java.util.ArrayList;
import java.util.Arrays;

public class Task_2Test {
    private Task_2 task_2;

    @Test(expected = RuntimeException.class)
    public void test2_1() {
        task_2 = new Task_2();

        task_2.arr1(new ArrayList<>(Arrays.asList(1, 6, 8, 5, 4, 5, 1, 2)));
    }

    @Test(expected = RuntimeException.class)
    public void test2_2() {
        task_2 = new Task_2();

        task_2.arr1(new ArrayList<>(Arrays.asList(1,7,5,5)));
    }

    @Test(expected = RuntimeException.class)
    public void test2_3() {
        task_2 = new Task_2();

        task_2.arr1(new ArrayList<>(Arrays.asList(1, 6, 8, 5, 4, 5, 1, 4)));
    }

    @Test(expected = RuntimeException.class)
    public void test2_4() {
        task_2 = new Task_2();

        task_2.arr1(new ArrayList<>(Arrays.asList(1, 6, 8, 5, 4, 5, 1, 2)));
    }

}
