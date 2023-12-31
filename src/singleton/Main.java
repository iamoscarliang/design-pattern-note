package singleton;

public class Main {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                System.out.println("Singleton: " + singleton);

                ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
                System.out.println("ThreadSafeSingleton: " + threadSafeSingleton);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Singleton singleton = Singleton.getInstance();
                System.out.println("Singleton: " + singleton);

                ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
                System.out.println("ThreadSafeSingleton: " + threadSafeSingleton);
            }
        }).start();
    }

}
