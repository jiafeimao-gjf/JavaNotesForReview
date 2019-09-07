package code;

public class MyThreadByThread extends Thread{

    private String name;
    public MyThreadByThread(String name){
        this.name = name;
    }
    public static void main(String[] args) {
        MyThreadByThread myThread = new MyThreadByThread("gujaifei");
        myThread.start();
    }

    @Override
    public void run() {
        System.out.println("MyThreadByThread().run(): "+name);
    }

    /**
     * @return the name
     */
    public String getCustomName() {
        return name;
    }
}