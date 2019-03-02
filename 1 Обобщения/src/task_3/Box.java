package task_3;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.List;

public class Box<E extends Fruit> {
    public List<E> list = new ArrayList<>();

    public void add(E aaa) {
        list.add(aaa);
        aaa.getWeight();
    }

    public double getWeight() {
        double weight = 0.0;
        for (E list : list) {
            weight += list.getWeight();
        }
        return weight;
    }

    public void compare(Box<?> box) {
        double box1 = this.getWeight();
        double box2 = box.getWeight();
        if (Math.abs(box1-box2)>0.00001){
            System.out.println("Вес коробок разный "+false);
        }else System.out.println("Коробки равны по весу "+true);

    }

    public void shift(Box<E> box){
        this.list.addAll(box.list);
        box.list.clear();
    }

}

