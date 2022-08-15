package _99_common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * create by 携山超 on 2020/5/15
 */
public class LineSelector {
    /**
     * 获取地铁线路
     * 先随机生成20条路线，再从20条中选中一条
     * @return
     */
    public int getLine() {
        int count = 20;
        List<Integer> lineList = new ArrayList<>(count);
        // 地铁线路
        int line;
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            line = random.nextInt(17) + 1;
            lineList.add(line);
        }
        System.out.println(lineList);
        int index = random.nextInt(20);
        return index;
    }

    /**
     * 获取具体站点
     * @param stationAmount 该线路总站数
     * @return
     */
    public int getStation(int stationAmount) {
        // 地铁线路
        int station;
        Random random = new Random();
        station = random.nextInt(stationAmount) + 1;
        return station % 2;
    }
}
