/**
 * Created by BF100 on 2018/3/19.
 */

/**
 * 待决中断
 * 一旦调用sleep（）方法，它就会注意到待决中断的存在
 */
public class PendingInterrupt extends Object{

    public static void main(String[] args){

        //如果输入了参数，则在mian线程中中断当前线程（亦即main线程）
        if( args.length > 0 ){
            Thread.currentThread().interrupt();
        }
        //获取当前时间
        long startTime = System.currentTimeMillis();
        try{
            System.out.println("Thread.currentThread().isInterrupted()="+ Thread.currentThread().isInterrupted());
            Thread.sleep(2000);
            System.out.println("was NOT interrupted");
        }catch(InterruptedException x){
            System.out.println("was interrupted");
        }
        //计算中间代码执行的时间
        System.out.println("elapsedTime=" + ( System.currentTimeMillis() - startTime));
    }

}
