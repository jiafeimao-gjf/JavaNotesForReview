package code;

public class ThreadDemo{
    public static void main(String[] args) {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

class Producer implements Runnable {
    private Message message;
    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int x = 0;x < 100;x++) {
            
            if (x % 2 == 0) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.message.set("王健","宇宙大帅哥。");
            } else {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.message.set("小高","猥琐第一人，常态保持。");

            }
        }
    }
}

class Consumer implements Runnable {
    private Message message;
    public Consumer(Message message) {
        this.message = message;
    }
    @Override
    public void run() {
        for (int x = 0;x < 100;x++) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(this.message.get());
        }
    }
}

class Message{
    private String title;
    private String content;

    private boolean flag;// 同步变量，同步等待
    public synchronized void set(String title,String content) {
        if (this.flag == false) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.content = content;
        this.flag = false;
        super.notifyAll();

    }

    public synchronized String get() {
        if (this.flag == true) {
            try {
                super.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String res = this.title +" - "+this.content;
        this.flag = true;
        super.notifyAll();
        return res;
    }

}