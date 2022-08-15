package _26_xor;

/**
 * @ClassName Demo
 * @Author Maxwell
 * @Date 2022/3/18 14:35
 * @Description Demo
 * @Version 1.0
 */
public class Demo {

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        swap(i, i);
        swap(new int[]{1, 2}, i, j);
    }

    /**
     * 使用异或交换两个变量的值，可以不占用额外空间完成
     *
     * @param i
     * @param j
     */
    public static void swap(int i, int j) {
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }

    /**
     * 需要注意的使用，被交换的两个变量需要不能是同一个对象，否则就会异或为0
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
        System.out.println("array[i] = " + array[i]);
        System.out.println("array[j] = " + array[j]);
    }
}
