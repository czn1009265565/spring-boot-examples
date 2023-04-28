package com.example.springbootfile.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;

@Slf4j
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

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File("input.txt"), "rw");
        randomAccessFile.write(new byte[] {'H', 'E', 'L', 'L', 'O', ' '}, 0, 6);
        randomAccessFile.write(new byte[] {'W', 'O', 'R', 'L', 'D'}, 0, 5);
        randomAccessFile.close();
    }


    private static final int DOWNLOAD_BATCH_SIZE = 100;
    public static final String FILE_TEMP_SUFFIX = "-";

    public boolean merge(String fileName) throws IOException{
        byte[] buffer = new byte[1024 * 10];
        int len = -1;
        try(RandomAccessFile saveFile = new RandomAccessFile(fileName, "rw")) {
            for (int i=0; i < DOWNLOAD_BATCH_SIZE; i++) {
                try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName + FILE_TEMP_SUFFIX + i))) {
                    // 读到文件末尾则返回-1
                    while ((len = bufferedInputStream.read(buffer)) != -1) {
                        // 追加
                        saveFile.write(buffer, 0, len);
                    }
                }
            }
            log.info("文件合并完成 {}", fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
