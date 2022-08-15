package _19_snowFlake.uuid;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * create by 携山超 on 2020/6/9
 */
public class Test {
    public static void main(String[] args) {

        System.currentTimeMillis();

        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        System.out.println(snowflake.nextIdStr());
        System.out.println(snowflake.nextId());
    }
}
