package task_3;

public class task_3 {
    public static void main(String[] args) {

        Box<Apple> appleBox = new Box();
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Box<Orange> orangeBox = new Box();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        appleBox.add(new Apple());
        System.out.println("Вес коробки с orange "+orangeBox.getWeight());
        System.out.println("Вес коробки с apple "+appleBox.getWeight());
        System.out.println("Сравнение коробки apple с orange");
        appleBox.compare(orangeBox);
        Box<Apple> appleBox1=new Box();
//        System.out.println(appleBox.list);
        appleBox1.shift(appleBox);
//        System.out.println(appleBox.list);
//        System.out.println(appleBox1.list);
        appleBox1.add(new Apple());
        System.out.println("Вес новой коробки с apple "+appleBox1.getWeight());
        System.out.println("Сравнение новой коробки apple с orange");
        appleBox1.compare(orangeBox);
    }
}


