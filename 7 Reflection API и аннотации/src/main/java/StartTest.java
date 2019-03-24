import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class StartTest {
    public static void main(String[] args) {
        Tests tests = new Tests();
        testsRun(tests);
    }

    public static void testsRun(Tests tests) {
        final int MIN_PRIORITY = 1;
        final int MAX_PRIORITY = 10;
        final int MAX_BeforeSuite = 1;
        int BeforeSuite = 1;
        final int MAX_AfterSuite = 1;
        int AfterSuite = 1;
        Map<Integer, Method> map = new TreeMap<>();

        for (Method method : tests.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                if (MAX_BeforeSuite >= BeforeSuite) {
                    map.put(MIN_PRIORITY - 1, method);
                } else {
                    throw new RuntimeException();
                }
                BeforeSuite += 1;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                if (MAX_AfterSuite >= AfterSuite) {
                    map.put(MAX_PRIORITY + 1, method);
                } else {
                    throw new RuntimeException();
                }
                AfterSuite += 1;
            }
            if (method.getAnnotation(Test.class) != null) {
                Test test = method.getAnnotation(Test.class);
                map.put(test.priority(), method); // сортировка автоматом
            }
        }

        for (Integer key : map.keySet()) {
            try {
                map.get(key).invoke(tests.getClass().getDeclaredMethods());

            } catch (IllegalAccessException |
                    InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}