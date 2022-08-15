package _87_Map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SynchronizedMapDemo {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        Collections.synchronizedMap(map);
    }
}
