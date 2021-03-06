package structure.timewheel;

/**
 * Created by Anur IjuoKaruKas on 2018/10/16
 *
 * 需要延迟执行的任务，放在槽 {@link Bucket} 里面
 */
public class TimedTask {

    private Class<?> fromClazz;

    /** 延迟多久执行时间 */
    private long delayMs;

    /** 过期时间戳 */
    private long expireTimestamp;

    /** 任务 */
    private Runnable task;

    /** 是否取消 */
    private volatile boolean cancle;

    //bucket:桶
    protected Bucket bucket;

    //下一个 timedTask
    protected TimedTask next;

    //上一个 timedTask
    protected TimedTask pre;

    public String desc;

    public TimedTask(long delayMs, Runnable task) {
        this.delayMs = delayMs;
        this.task = task;
        this.bucket = null;
        this.next = null;
        this.pre = null;
        this.expireTimestamp = System.currentTimeMillis() + delayMs;
        this.cancle = false;
    }

    public void cancle() {
        cancle = true;
    }

    public boolean isCancle() {
        return cancle;
    }

    public Runnable getTask() {
        return task;
    }

    public long getDelayMs() {
        return delayMs;
    }

    public long getExpireTimestamp() {
        return expireTimestamp;
    }

    @Override
    public String toString() {
        return desc;
    }
}
