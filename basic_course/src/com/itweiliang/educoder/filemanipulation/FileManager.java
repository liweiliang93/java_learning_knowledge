package com.itweiliang.educoder.filemanipulation;
import java.io.File;
import java.util.Scanner;

public class FileManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.指定关键字检索文件");
        System.out.println("2.指定后缀名检索文件");
        System.out.println("3.删除文件夹及内部文件");
        System.out.print("请输入指令：");
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                System.out.print("请输入目录：");
                String directory1 = scanner.next();
                System.out.print("请输入关键字：");
                String keyword1 = scanner.next();
                searchByKeyword(directory1, keyword1);
                break;
            case 2:
                System.out.println("请输入目录和后缀名：");
                String directory2 = scanner.next();
                String suffix = scanner.next();
                searchBySuffix(directory2, suffix);
                break;
            case 3:
                System.out.println("请输入需要删除的文件目录：");
                String directory3 = scanner.next();
                deleteDirectory(directory3);
                break;
            default:
                System.out.println("无效指令");
                break;
        }
    }

    public static void searchByKeyword(String directory, String keyword) {
        File dir = new File(directory);
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("不是目录");
            return;
        }
        File[] files = dir.listFiles();
        boolean found = false;
        System.out.println("开始查询：");
        for (File file : files) {
            if (file.getName().contains(keyword)) {
                System.out.println("   "+file.getAbsolutePath());
                found = true;
            }
        }
        if (!found) {
            System.out.println("没有包含关键字的文件");
        }
    }

    public static void searchBySuffix(String directory, String suffix) {
        File dir = new File(directory);
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("不是目录");
            return;
        }
        String[] suffixes = suffix.split(",");
        File[] files = dir.listFiles();
        for (File file : files) {
            for (String s : suffixes) {
                if (file.getName().endsWith(s)) {
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    public static void deleteDirectory(String directory) {
        File dir = new File(directory);
        if (!dir.exists()) {
            System.out.println("目录不存在");
            return;
        }
        if (!dir.isDirectory()) {
            System.out.println("不是目录");
            return;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                deleteDirectory(file.getAbsolutePath());
            } else {
                file.delete();
                System.out.println(file.getName()+"删除成功！");
            }
        }
        dir.delete();
        System.out.println("文件目录删除成功!");
    }
}
