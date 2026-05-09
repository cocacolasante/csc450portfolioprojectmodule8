public class concurrency {

    public static void up() {
        for (int i = 1; i <= 20; i++) {
            System.out.println("t1 counting up: " + i);
        }
    }

    public static void down() {
        for (int i = 20; i >= 0; i--) {
            System.out.println("t2 counting down: " + i);
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            up();
        });

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            down();
        });

        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("done");
    }
}