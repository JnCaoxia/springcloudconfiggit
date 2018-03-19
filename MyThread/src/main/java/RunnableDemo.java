/**
 * Created by BF100 on 2018/3/16.
 */

class MyThread2 implements Runnable{
    private int ticket = 5;
    public void run(){
        for (int i=0;i<10;i++)
        {
            if(ticket > 0){
                System.out.println("I am the "+ (i + 1) +"thread : "+"ticket = " + ticket--);
            }
        }
    }
}
public class RunnableDemo {
    public static void main(String[] args){
        MyThread2 my = new MyThread2();
        new Thread(my).start();
        new Thread(my).start();
        new Thread(my).start();
    }
}
