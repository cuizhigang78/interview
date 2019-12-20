package com.cui._08_thread_pool;

/**
 * 四种拒绝策略
 * 1. AbortPolicy（默认）：直接抛出RejectedExecutionException异常阻止系统正常运行；
 * 2. CallerRunsPolicy：“调用者运行”，一种调节机制，该策略既不会抛弃任务，也不会抛出
 *                      异常，而是将某些任务回退到调用者，从而降低新的任务的流量；
 * 3. DiscardOldestPolicy：抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试再
 *                         次提交当前任务；
 * 4. DiscardPolicy：直接丢弃任务，不予任何处理也不抛出异常。如果允许任务丢失，这是
 *                   最好的一种方案。
 *     总结：以上四种拒绝策略，均为RejectedExecutionHandler接口的实现类，所以在实际生产中，
 * 针对不同的业务情况，可以自定义拒绝策略来满足多样的业务条件。
 */
public class RejectedExecutionHandlerDemo {
}
