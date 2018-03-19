/**
 * Created by BF100 on 2018/3/19.
 */

/**
 * 可以使用Thread.interrupted（）方法来检查当前线程的中断状态（并隐式重置为false）。
 * 又由于它是静态方法，因此不能在特定的线程上使用，而只能报告调用它的线程的中断状态，
 * 如果线程被中断，而且中断状态尚不清楚，那么，这个方法返回true。
 * 与isInterrupted（）不同，它将自动重置中断状态为false，第二次调用Thread.interrupted（）方法，总是返回false，除非中断了线程。
 */
public class InterruptReset {
    public static void main(String[] args) {
        System.out.println(
                "Point X: Thread.interrupted()=" + Thread.interrupted());
        Thread.currentThread().interrupt();
        System.out.println(
                "Point Y: Thread.interrupted()=" + Thread.interrupted());
        System.out.println(
                "Point Z: Thread.interrupted()=" + Thread.interrupted());
    }
}
