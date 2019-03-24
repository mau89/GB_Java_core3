public class Tests {
    @BeforeSuite
    public static void BeforeSuite(){
        System.out.println("BeforeSuite");
    }
    @AfterSuite
    public static void AfterSuite(){
        System.out.println("AfterSuite");
    }
//    @AfterSuite
//    public static void AfterSuite1(){
//        System.out.println("AfterSuite");
//    }
    @Test(priority = 1)
    public static void start1(){
        System.out.println("Тест 1");
    }
    @Test(priority = 10)
    public static void start2(){
        System.out.println("Тест 2");
    }
    @Test(priority = 5)
    public static void start3(){
        System.out.println("Тест 3");
    }
    @Test(priority = 2)
    public static void start4(){
        System.out.println("Тест 4");
    }
}
