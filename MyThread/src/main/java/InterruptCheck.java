/**
 * Created by BF100 on 2018/3/19.
 * 这里需要注意：线程一旦被中断，isInterrupted（）方法便会返回true，
 * 而一旦sleep（）方法抛出异常，它将清空中断标志，此时isInterrupted（）方法将返回false。
 * 下面的代码演示了isInterrupted（）方法的使用：
 */
public class InterruptCheck {
    public static void main(String[] args){
        Thread t = Thread.currentThread();
        System.out.println("Point A: t.isInterrupted()=" + t.isInterrupted());
        //待决中断，中断自身
        t.interrupt();
        System.out.println("Point B: t.isInterrupted()=" + t.isInterrupted());
        System.out.println("Point C: t.isInterrupted()=" + t.isInterrupted());

        try{
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch( InterruptedException x){
            System.out.println("was interrupted");
        }
        //抛出异常后，会清除中断标志，这里会返回false
        System.out.println("Point D: t.isInterrupted()=" + t.isInterrupted());
    }
}
