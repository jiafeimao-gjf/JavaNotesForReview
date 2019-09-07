package code;

public class MyThreadByRunnable extends MyThreadByThread implements Runnable{

    public MyThreadByRunnable() {
        super("gujiafei");
    }

    @Override
    public void run() {
        System.out.println(getCustomName() + ": MyThreadByRunnable.run");
    }

    public static void main(String[] args) {
        MyThreadByRunnable myThreadByRunnable = new MyThreadByRunnable();
        Thread thread = new Thread(myThreadByRunnable);
        thread.start();   
    }
}
