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
	// �ӿ���̨��ȡ������ļ�Ŀ¼Ȼ��ָ��Ŀ¼�µ�.java�ļ����Ƶ�D:/java�ļ�����
	public static void main(String[] args) throws IOException {
		File f1 = getDir();
		File f2 = new File("D:\\java");
		copy(f1,f2);
	//�������������Ѿ������ˣ�������һ��С���⣬����༶Ŀ¼����û��java�ļ�����ô�ļ��л��ǻᴴ����
		//���Կ�����дһ��ɾ���ķ���
		delete(f2);
	}

	private static void delete(File f2) {
		File[] files = f2.listFiles();
		if(files != null){
			for (File file : files) {
				if(file.isDirectory()){
					delete(file);
					file.delete();//���һ���ļ�����û��java�ļ�����ô����ļ���Ҳ�ǻᱻ���������ģ�����׷���������ֵܿ����ټ�һ���ݹ�ɾ��
					//���ǲ���Ҳ�����
				}
			}
		}
	}

	private static void copy(File f1, File f2) throws IOException {
		//f1������Դ
		//f2�ǿ���Ŀ�ĵ�
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
		// 1,��������¼�����
		Scanner sc = new Scanner(System.in);
		System.out.println("������һ���ļ���·��:");
		// 2,����һ������ѭ��
		while (true) {
			// 3,������¼��Ľ���洢����װ��File����
			String line = sc.nextLine();
			File dir = new File(line);
			// 4,��File�����ж�
			if (!dir.exists()) {
				System.out.println("��¼����ļ���·��������,������һ���ļ���·��:");
			} else if (dir.isFile()) {
				System.out.println("��¼������ļ�·��,������һ���ļ���·��:");
			} else {
				// 5,���ļ���·�����󷵻�
				return dir;
			}
		}

	}
}
