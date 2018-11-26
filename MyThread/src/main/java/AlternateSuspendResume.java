/**
 * Created by BF100 on 2018/3/19.
 */

/**
 * 由结果可以看出，输出的所有结果均为true。首先，针对情况1（线程挂起的位置不确定），这里确定了线程挂起的位置，不会出现线程在stepOne操作和stepTwo操作之间挂* 起的情况；
 * 针对情况2（main线程中执行asr.areValuesEqual（）进行比较时，恰逢stepOne操作执行完，而stepTwo操作还没执行），
 * 在发出挂起请求后，还没有执行asr.areValuesEqual（）操作前，让main线程休眠450ms（>300ms），如果挂起请求发出时，
 * 新线程正执行到或即将执行到stepOne操作（如果在其前面的话，就会响应挂起请求，从而挂起线程），那么在stepTwo操作执行前，main线程的休眠还没结束，
 * 从而main线程休眠结束后执行asr.areValuesEqual（）操作进行比较时，stepTwo操作已经执行完，因此也不会出现输出结果为false的情况。
 */
public class AlternateSuspendResume extends Object implements Runnable {

    private volatile int firstVal;
    private volatile int secondVal;
    //增加标志位，用来实现线程的挂起和恢复
    private volatile boolean suspended;

    public boolean areValuesEqual() {
        return ( firstVal == secondVal );
    }

    public void run() {
        try {
            suspended = false;
            firstVal = 0;
            secondVal = 0;
            workMethod();
        } catch ( InterruptedException x ) {
            System.out.println("interrupted while in workMethod()");
        }
    }

    private void workMethod() throws InterruptedException {
        int val = 1;

        while ( true ) {
            //仅当线程挂起时，才运行这行代码
            waitWhileSuspended();

            stepOne(val);
            stepTwo(val);
            val++;

            //仅当线程挂起时，才运行这行代码
            waitWhileSuspended();

            Thread.sleep(200);
        }
    }

    private void stepOne(int newVal)
            throws InterruptedException {

        firstVal = newVal;
        Thread.sleep(300);
    }

    private void stepTwo(int newVal) {
        secondVal = newVal;
    }

    public void suspendRequest() {
        suspended = true;
    }

    public void resumeRequest() {
        suspended = false;
    }

    private void waitWhileSuspended()
            throws InterruptedException {

        //这是一个“繁忙等待”技术的示例。
        //它是非等待条件改变的最佳途径，因为它会不断请求处理器周期地执行检查，
        //更佳的技术是：使用Java的内置“通知-等待”机制
        while ( suspended ) {
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        AlternateSuspendResume asr =
                new AlternateSuspendResume();

        Thread t = new Thread(asr);
        t.start();

        //休眠1秒，让其他线程有机会获得执行
        try { Thread.sleep(1000); }
        catch ( InterruptedException x ) { }

        for ( int i = 0; i < 10; i++ ) {
            asr.suspendRequest();

            //让线程有机会注意到挂起请求
            //注意：这里休眠时间一定要大于
            //stepOne操作对firstVal赋值后的休眠时间，即300ms，
            //目的是为了防止在执行asr.areValuesEqual（）进行比较时,
            //恰逢stepOne操作执行完，而stepTwo操作还没执行
            try { Thread.sleep(350); }
            catch ( InterruptedException x ) { }
            System.out.println("param firstVal="+ asr.firstVal +" ,secondVal=" + asr.secondVal);
            System.out.println("dsr.areValuesEqual()=" +
                    asr.areValuesEqual());

            asr.resumeRequest();

            try {
                //线程随机休眠0~2秒
                Thread.sleep(
                        ( long ) (Math.random() * 2000.0) );
            } catch ( InterruptedException x ) {
                //略
            }
        }

        System.exit(0); //退出应用程序
    }
}

/**
 * 当调用Thread的start（）方法，执行完run（）方法后，或在run（）方法中return，线程便会自然消亡
 */

