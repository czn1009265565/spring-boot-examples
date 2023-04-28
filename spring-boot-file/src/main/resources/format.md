# IO基础

## 抽象类

1. File
2. FileInputStream、FileOutputStream
3. BufferedInputStream、BufferedOutputStream 字节缓冲流
4. FileReader、FileWriter
5. BufferedReader、BufferedWriter 字符缓冲流

### File与FileInputStream区别

File类实现的方法:getName,getParent,exists,isDirectory,isFilede,list等，关注的是文件在磁盘上的存储，File 不属于文件流，只能代表一个文件或是目录的路径名而已。

FileInputStream实现的方法:read,close等，关注的是文件内容

### FileInputStream与FileReader区别

FileInputStream：以字节流方式读取

FileReader：把文件转换为字符流读入

### 缓冲流的作用

IO 操作是很消耗性能的，缓冲流将数据加载至缓冲区，一次性读取/写入多个字节，从而避免频繁的 IO 操作，提高流的传输效率。

```java
public class FileUtils {
    public static void copy_pdf_to_another_pdf_buffer_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("深入理解计算机操作系统.pdf"));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("深入理解计算机操作系统-副本.pdf"))) {
            int content;
            while ((content = bis.read()) != -1) {
                bos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用缓冲流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }

    public static void copy_pdf_to_another_pdf_stream() {
        // 记录开始时间
        long start = System.currentTimeMillis();
        File file = new File("E:\\tomcat\\apache-tomcat-8.5.47\\temp\\FileStream");

        try (FileInputStream fis = new FileInputStream("深入理解计算机操作系统.pdf");
             FileOutputStream fos = new FileOutputStream("深入理解计算机操作系统-副本.pdf")) {
            int content;
            while ((content = fis.read()) != -1) {
                fos.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 记录结束时间
        long end = System.currentTimeMillis();
        System.out.println("使用普通流复制PDF文件总耗时:" + (end - start) + " 毫秒");
    }
}
```