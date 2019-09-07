package code;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


class MyCallable<V> implements Callable<V> {
    V var;
    public  MyCallable(V var){
        this.var = var;
    }
    public V call() throws Exception{
        return var;
    }
}
public class ExecutorServiceTest{
    public static void main(String[] args) {
        ExecutorService executorPool = Executors.newFixedThreadPool(10);
        List<Future> list = new ArrayList<>();

        for (int i = 0;i < 10; i++) {
            Callable c = new MyCallable<String>("gujaifei-" + i);

            Future f = executorPool.submit(c);
            list.add(f);
        }

        executorPool.shutdown();

        for (Future f : list) {
            try{
                System.out.println("res: "+f.get().toString());
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
