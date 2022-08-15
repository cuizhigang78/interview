package _24_proxy.jdk;

/**
 * @ClassName IProducer
 * @Author Maxwell
 * @Date 2021/9/2 8:34
 * @Description IProducer
 * @Version 1.0
 */
public interface IProducer {
    /**
     * 销售产品方法
     * @param money
     */
    public void sell(float money);

    public void afterSell(float money);
}
