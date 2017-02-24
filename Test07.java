package com.nanjing.three;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test07 {
	// 从控制台获取输入的文件目录然后将指定目录下的.java文件复制到D:/java文件夹中
	public static void main(String[] args) throws IOException {
		File f1 = getDir();
		File f2 = new File("D:\\java");
		copy(f1,f2);
	//本题做到这里已经算完了，但是有一个小问题，如果多级目录下面没有java文件，那么文件夹还是会创建的
		//所以可以再写一个删除的方法
		delete(f2);
	}

	private static void delete(File f2) {
		File[] files = f2.listFiles();
		if(files != null){
			for (File file : files) {
				if(file.isDirectory()){
					delete(file);
					file.delete();//如果一个文件夹中没有java文件，那么这个文件夹也是会被创建出来的，所以追求完美的兄弟可以再加一个递归删除
					//但是不加也不算错
				}
			}
		}
	}

	private static void copy(File f1, File f2) throws IOException {
		//f1是数据源
		//f2是拷贝目的地
		f2.mkdirs();
		File[] files = f1.listFiles();
		if(files != null){
			for (File file : files) {
				if(file.isFile()&&file.getName().endsWith(".java")){
					BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
					BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(f2,file.getName())));
					int b;
					while((b = bis.read())!= -1){
						bos.write(b);
					}
					bis.close();
					bos.close();
				}else if(file.isDirectory()){
					copy(file,new File(f2,file.getName()));
				}
			}
		}
		
	}

	public static File getDir() {
		// 1,创建键盘录入对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径:");
		// 2,定义一个无限循环
		while (true) {
			// 3,将键盘录入的结果存储并封装成File对象
			String line = sc.nextLine();
			File dir = new File(line);
			// 4,对File对象判断
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在,请输入一个文件夹路径:");
			} else if (dir.isFile()) {
				System.out.println("您录入的是文件路径,请输入一个文件夹路径:");
			} else {
				// 5,将文件夹路径对象返回
				return dir;
			}
		}

	}
}
