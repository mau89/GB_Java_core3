package task_2_3;

public class Task_3 {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3,4,7,7}));

    }

    public static boolean check(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1 || arr[i]==4){
                return true;
            }

        }
        return false;
    }
}
