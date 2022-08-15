package _12_String.stringBuffer;

/**
 * 1.StringBuffer()的初始容量可以容纳16个字符，当该对象的实体存放的字符的长度大于16时，实体容量就自动增加。
 * StringBuffer对象可以通过length()方法获取实体中存放的字符序列长度，通过capacity()方法来获取当前实体的实际容量。
 *      public StringBuffer() { super(16); }
 *
 * 2.StringBuffer(int size)可以指定分配给该对象的实体的初始容量参数为参数size指定的字符个数。
 * 当该对象的实体存放的字符序列的长度大于size个字符时，实体的容量就自动的增加。以便存放所增加的字符。
 *      public StringBuffer(int capacity) { super(capacity); }
 *
 *
 * 3.StringBuffer(String s)可以指定给对象的实体的初始容量为参数字符串s的长度额外再加16个字符。
 * 当该对象的实体存放的字符序列长度大于size个字符时，实体的容量自动的增加，以便存放所增加的字符。
 *      public StringBuffer(String str) {
 *         super(str.length() + 16);
 *         append(str);
 *     }
 *
 * 扩容算法：
 * 使用append()方法在字符串后面追加东西的时候，如果长度超过了该字符串存储空间大小了就需要进行扩容：
 * 构建新的存储空间更大的字符串，将旧的复制过去；
 *  
 * 再进行字符串append添加的时候，会先计算添加后字符串大小，传入一个方法：ensureCapacityInternal
 * 这个方法进行是否扩容的判断，需要扩容就调用expandCapacity方法进行扩容：
 *
 *      void expandCapacity(int minimumCapacity) {
 *         int newCapacity = value.length * 2 + 2;
 *         if (newCapacity - minimumCapacity < 0)
 *             newCapacity = minimumCapacity;
 *         if (newCapacity < 0) {
 *             if (minimumCapacity < 0) // overflow
 *                 throw new OutOfMemoryError();
 *             newCapacity = Integer.MAX_VALUE;
 *         }
 *         value = Arrays.copyOf(value, newCapacity);
 *     }
 *
 * 尝试将新容量扩为大小变成2倍+2   if 判断一下 容量如果不够，直接扩充到需要的容量大小。
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
    }
}
