public class task_1 {
    public static void main(String[] args) {
        Integer[] ints = {1, 4, 6, 8, 2, 3, 5, 7, 8, 4};
        String[] strings = {"a","b","v","i","r","d"};
        int a = 0;
        int b = 5;
        if (a >= ints.length || b >= ints.length || a <0 || b <0) {
            System.out.println("Указанны некорректные данные");
            return;
        }
        Replace(strings,3,5);
        System.out.println("\n");
        Replace(ints, a, b);
    }

    private static <T> void Replace(T[] ints, int a, int b) {
        T a1;
        T a2;
        a1 = ints[a];
        a2 = ints[b];
        ints[a] = a2;
        ints[b] = a1;
        for (T t :ints) {
            System.out.print(t+" ");
        }
    }
}
