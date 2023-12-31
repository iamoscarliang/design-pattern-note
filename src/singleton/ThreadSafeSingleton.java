package singleton;

public class ThreadSafeSingleton {

    private volatile static ThreadSafeSingleton INSTANCE;

    private ThreadSafeSingleton() {
    }

    public static ThreadSafeSingleton getInstance() {
        // Double-checking lock
        if (INSTANCE == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeSingleton();
                }
            }
        }

        return INSTANCE;
    }

}
