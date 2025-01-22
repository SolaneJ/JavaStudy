package com.github.SolaneJ.standard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Scanner工具类使用
 * Scanner 是一个文本扫描类，它可以用来从文件、字符串、控制台等输入流中读取和解析数据。
 *
 * @author SolaneJ
 * @since 2025/1/22 15:51
 */
public class ScannerManipulation {
    public static void main(String[] args) throws FileNotFoundException {
        // 创建一个sc1对象用于接收控制台输入
        Scanner sc1 = new Scanner(System.in);

        // 也可以从文件来读取
        Scanner sc2 = new Scanner(new File("users.txt"));

        // 还可以直接读取字符串的内容
        Scanner sc3 = new Scanner("str");

//        while (sc2.hasNext()) {
//            System.out.println(sc2.next());
//        }

        // 手动释放资源
        sc1.close();
        sc2.close();
        sc3.close();
    }
}
