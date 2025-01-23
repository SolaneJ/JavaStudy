package com.github.SolaneJ.standard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

public class FileManipulation {
    public static void main(String[] args) throws Exception {

        final String rPath = "docs/a.txt";

        // File类是Java中用于表示文件和目录路径的抽象表示。
        // 它可以用来创建、删除、重命名文件和目录，以及查询文件的属性。
        File file = new File(rPath);

        if (file.exists()) {
            System.out.println("文件存在，路径为：" + file.getAbsolutePath());
        }else {
            System.out.println("文件不存在");
            file.createNewFile();
        }

        // FileOutputStream是Java中用于将数据写入文件的输出流。
        // 它可以用来将数据写入文件，包括文本、二进制数据等。

        FileOutputStream fos = new FileOutputStream(rPath);
        byte[] data = { 0x48, 0x65, 0x6C, 0x6C, 0x6F, 0x20, 0x57, 0x6F, 0x72, 0x6C, 0x64 }; // 二进制数据
        fos.write(data);

        // BufferedReader和BufferedWriter用于读取和写入文件的字符流。
        // 它们通常用于处理文本文件，提供了更高效的读写操作。
        BufferedWriter bw = new BufferedWriter(new FileWriter(rPath));
        // 写入字符串
        bw.write("Hello Java");
        // 关闭流
        bw.close();

        // Files是Java 7中引入的一个新类，它提供了一组静态方法用于操作文件和目录。
        // 它可以用来创建、删除、复制、移动文件和目录，以及查询文件的属性。
        // Files类提供了一组静态方法，用于操作文件和目录。

        // 复制文件
        //Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);

        // 移动文件
        //Files.move(target, Paths.get("new_target.txt"), StandardCopyOption.REPLACE_EXISTING);

        // 删除文件
        //Files.deleteIfExists(Paths.get("new_target.txt"));
    }
}
