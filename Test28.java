package com.nanjing.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Test28 {
	// 设计一个interface MyUtil，该接口有两个抽象方法
	// 创建一个类实现MyUtil接口并按以下要求实现两个抽象方法
	// public abstract void sort(ArrayList<Integer> list);
	// public abstract void filterChars(ArrayList<String> list);
	// a.ArrayList集合排序方法：将传入的ArrayList集合元素进行进行排序（不能直接用Collections.sort()方
	//
	// 法）
	// b.字符串过滤字母：将传入的ArrayList<String>集合中的每个元素中的字母过滤掉,比如（传入
	//
	// hello123java，返回123）

	public static void main(String[] args) {
		// 数组的排序
		int[] arr = { 5, 4, 3, 2, 1 };
		/*
		 * //冒泡排序 for(int i = 0;i<arr.length-1;i++) { for(int j =
		 * 0;j<arr.length-1-i;j++) {//j+1<arr.length if(arr[j]>arr[j+1]) { int
		 * temp = arr[j]; arr[j] = arr[j+1]; arr[j+1] = temp; } } }
		 */
		// 选择排序,5,4,3,2,1
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		MyUtil mu = new MyUtilImpl();
		mu.sort(list);
		System.out.println(list);

		ArrayList<String> strList = new ArrayList<String>();
		strList.add("a123bcd");
		strList.add("a3bcd");
		strList.add("e23bcd");
		strList.add("j09~!ubcd56");
		mu.filterChars(strList);
		System.out.println(strList);

	}
}

// 定义接口
interface MyUtil {
	public abstract void sort(ArrayList<Integer> list);

	public abstract void filterChars(ArrayList<String> list);
}

class MyUtilImpl implements MyUtil {

	// 将传入的ArrayList集合元素进行进行排序
	@Override
	public void sort(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = i + 1; j < list.size(); j++) {
				int temp1 = list.get(i);
				int temp2 = list.get(j);
				if (temp1 > temp2) {
					list.set(i, temp2);
					list.set(j, temp1);
				}
			}
		}
	}

	// 字符串过滤字母：将传入的ArrayList<String>集合中的每个元素中的字母过滤掉,比如（传入 hello123java，返回123）
	@Override
	public void filterChars(ArrayList<String> list) {
		// 先定义一个新集合
		ArrayList<String> newList = new ArrayList<>();
		// 1.遍历集合,拿到每个元素
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			String str = it.next();
			// str = str.replaceAll("\\D+", "");
			// System.out.println(str);
			// 将字符串变成字符数组
			char[] arr = str.toCharArray();

			// 遍历数组
			// 定义字符串缓冲区保存数字
			StringBuilder sb = new StringBuilder();
			for (char ch : arr) {
				if (ch >= '0' && ch <= '9') {
					sb.append(ch + "");
				}
			}
			// it.remove();
			newList.add(sb.toString());
		}
		// 清空源集合中的内容
		list.clear();
		// 将新集合中的内容添加到老集合中
		list.addAll(newList);
	}
}
