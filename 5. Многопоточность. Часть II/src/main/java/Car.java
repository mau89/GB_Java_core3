import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static volatile boolean win=false;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch countDownLatch,countDownLatch1;
    private CyclicBarrier cyclicBarrier;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatch, CountDownLatch countDownLatch1,CyclicBarrier cyclicBarrier) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.countDownLatch = countDownLatch;
        this.countDownLatch1 = countDownLatch1;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {


        try {

            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));

            System.out.println(this.name + " готов");

        } catch (Exception e) {
            e.printStackTrace();
        }
        countDownLatch1.countDown();
        try {
            cyclicBarrier.await();
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        if (win==false){
        System.out.println(this.name+" WIN!");
        win=true;
        }

        countDownLatch.countDown();
    }
}