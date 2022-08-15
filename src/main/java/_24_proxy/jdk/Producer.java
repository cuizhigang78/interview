package _24_proxy.jdk;

/**
 * @ClassName Producer
 * @Author Maxwell
 * @Date 2021/9/2 8:31
 * @Description Producer
 * @Version 1.0
 */
public class Producer implements IProducer {
    /**
     * 销售产品方法
     * @param money
     */
    public void sell(float money) {
        System.out.println("销售产品，拿钱：" + money);
    }

    @Override
    public void afterSell(float money) {
        System.out.println("售后维护，拿钱：" + money);
    }
}
