// package code;

// /**
//  * 生产者消费者模型：以电脑的生产和销售为例。
//  * 要求：
//  *      1、两个线程，一个生产、一个消费
//  *      2、生产的电脑被取走才能生产下一台电脑，否则就进入阻塞等待
//  */
// public class CPModel{
//     public static void main(String[] args) {
//         Resource resource = new Resource();
//         new Thread(new Productor(resource)).start();
//         new Thread(new Consumer(resource)).start();
//     }
// }
// class Computer{
//     private static int count = 0;// 给电脑编号

//     private String name;
//     private double price;
//     Computer(String name,double price) {
//         this.name = name;
//         this.price = price;
//         count++;
//     }

//     @Override
//     public String toString() {
//         return "「第"+count+"台电脑」："+"电脑名字："+this.name+"，价值："+this.price;
//     }
// }

// class Resource {
//     private Computer computer;
//     public synchronized void make() throws Exception{
//         if(this.computer != null){// 电脑还没有被取走
//             super.wait();// 阻塞等待
//         }
//         Thread.sleep(100);
//         this.computer = new Computer("GJF牌电脑", 1.1);
//         System.out.println("「生产了一台电脑」"+this.computer);
//         super.notifyAll();// 唤醒所有线程， 包括消费线程，消费电脑
//     }

//     public synchronized void get() throws Exception{
//         if (this.computer == null) {// 没有电脑生产出来
//             super.wait();// 阻塞等待
//         }
//         Thread.sleep(10);
//         System.out.println(this.computer);
//         System.out.println("「卖出了一台电脑」"+this.computer);
//         this.computer = null;
//         super.notifyAll();// 唤醒所有线程， 包括生产线程，生产电脑
//     }
// }

// /**
//  * 生产线程，不断的生产电脑
//  */
// class Productor implements Runnable{
//     private Resource resource;
//     Productor(Resource resource){
//         this.resource = resource;
//     }

//     @Override
//     public void run() {
//          for (int x = 0;x < 50;x++){
//             try{
//                 this.resource.make();
//             }catch(Exception e) {
//                 e.printStackTrace();
//             }
//          }
//     }
// }
// /**
//  * 消费线程，不断的消费线程
//  */
// class Consumer implements Runnable{
//     private Resource resource;
//     Consumer(Resource resource){
//         this.resource = resource;
//     }

//     @Override
//     public void run() {
//          for (int x = 0;x < 50;x++){
//             try{
//                 this.resource.get();
//             }catch(Exception e) {
//                 e.printStackTrace();
//             }
//          }
//     }
// }