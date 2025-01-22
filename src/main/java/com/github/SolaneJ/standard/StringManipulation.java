package com.github.SolaneJ.standard;

/**
 * 字符串处理
 *
 * @author SolaneJ
 * @since 2025/1/22 12:00
 */
public class StringManipulation {
    public static void main(String[] args) {

        // String类的对象是不可变的，调用修改字符串的操作实际上是创建了一个新的String对象
        String s1 = "str";
        String s2 = new String("str");


        System.out.println("s1==s2 = " + (s1 == s2));   // false
        System.out.println("s1.equals(s2) = " + s1.equals(s2));  // true

        /*
            s1 == s2 输出 false
            s1 是通过字符串字面量 "str" 创建的，字面量在 Java 中会被存储在 字符串常量池 中。
            字符串常量池是 JVM 用来存储唯一的字符串对象的地方。对于相同内容的字符串字面量，JVM 会确保只有一份存在。

            s2 是通过 new String("str") 创建的，new 关键字创建了一个新的 String 对象，这个对象位于堆内存中，而不是字符串常量池中。
            尽管它的内容是 "str"，它与常量池中的 s1 并不是同一个对象。

            所以，s1 == s2 比较的是 引用的地址，
            由于 s1 和 s2 是两个不同的对象（一个是常量池中的对象，另一个是堆内存中的对象），因此它们的引用不同，所以结果是 false。

            s1.equals(s2) 输出 true
            equals 方法比较的是 字符串的内容，而不是引用的地址。s1 和 s2 都包含相同的字符串 "str"，所以 s1.equals(s2) 返回 true。
        */

        /**
            非线程安全：StringBuilder 的方法不是同步的，适用于单线程环境或不需要线程安全的场景。
            性能较高：由于不需要同步机制，StringBuilder 在单线程环境中通常比 StringBuffer 更高效。
            动态扩展：内部使用一个字符数组存储字符串，字符串内容会根据需要动态扩展。

            @see StringBuilderThreadSafetyDemo
         */
        StringBuilder s3 = new StringBuilder(5);
        s3.append("Hello, ");
        s3.append("World! ");
        System.out.println(s3);

        /**
            线程安全：StringBuffer 的方法是同步的，这意味着多个线程可以安全地访问同一个 StringBuffer 对象。
            性能较低：由于同步机制的存在，StringBuffer 在多线程环境下的性能较低，但在多线程环境中使用时，能保证数据的安全性。
            动态扩展：与 StringBuilder 类似，StringBuffer 也会根据需要动态扩展其内部字符数组。

            @see StringBufferThreadSafetyDemo
        */
        StringBuffer s4 = new StringBuffer();
        s4.append("Hello, ");
        s4.append("Java!  ");
        System.out.println(s4);
    }
}
