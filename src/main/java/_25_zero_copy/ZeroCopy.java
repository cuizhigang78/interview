package _25_zero_copy;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @ClassName ZeroCopy
 * @Author Maxwell
 * @Date 2021/9/28 0:20
 * @Description ZeroCopy
 * @Version 1.0
 */
public class ZeroCopy {

    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        // mmap方式：映射为2K，生成的文件也就是2K
        final RandomAccessFile rw = new RandomAccessFile(file, "rw");
        final MappedByteBuffer map = rw.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 2048);
        // map.put("mmap content".getBytes());
        rw.close();

        try (FileInputStream fileInputStream  = new FileInputStream(file)) {

            FileChannel channel = fileInputStream.getChannel();

            FileOutputStream out = new FileOutputStream("test_copy.txt");

            FileChannel outChannel = out.getChannel();
            // transferTo方式，核心从一个管道直接到另一个管道
            channel.transferTo(0, file.length(), outChannel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
