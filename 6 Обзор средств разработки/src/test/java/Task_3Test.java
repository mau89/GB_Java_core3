import org.junit.Test;
import task_2_3.Task_3;


public class Task_3Test {
    private Task_3 task_3;

    @Test()
    public void test3_1() {
        task_3 = new Task_3();

        task_3.check(new int[]{1,5,7,5});
    }
    @Test()
    public void test3_2() {
        task_3 = new Task_3();

        task_3.check(new int[]{3,5,7,5});
    }
    @Test()
    public void test3_3() {
        task_3 = new Task_3();

        task_3.check(new int[]{0});
    }
    @Test()
    public void test3_4() {
        task_3 = new Task_3();

        task_3.check(new int[]{1,1,1,4});
    }
}
