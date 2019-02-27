public class task_1 {
    public static void main(String[] args) {
        Object[] ints = {1, 4, 6, 8, 2, 3, 5, 7, 8, 4};
        int a = 2;
        int b = 5;
        Object a1, a2;
        if (a >= ints.length || b >= ints.length) {
            System.out.println("Указынны некорректные данные");
            return;
        }
        a1 = ints[a];
        a2 = ints[b];
        ints[a] = a2;
        ints[b] = a1;
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]+" ");
        }
    }
}
