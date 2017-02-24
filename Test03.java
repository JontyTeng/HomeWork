package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test03 {
	public static void main(String[] args) throws IOException {
		// 1.产生10个1-20的随机数,把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
		// (1)定义长度为10的int数组
		int[] arr = new int[10];
		// (2)创建产生随机数的对象
		Random r = new Random();
		// (3)产生随机数,并存入数组中
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(20) + 1;
		}
		System.out.println("产生的随机数是:" + Arrays.toString(arr));
		// (4)把数组中大于等于10的数字放到一个list集合中，并打印到控制台。
		// 定义List集合
		ArrayList<Integer> list = new ArrayList<>();
		// 遍历arr数组,将>=10的元素存入到list集合中
		for (Integer thisNum : arr) {
			if (thisNum >= 10)
				list.add(thisNum);
		}
		System.out.println(list);
		// 2.把数组中小于10的数字放到一个list集合中，并打印到控制台。
		//如果这里是要放到map集合中，也可以把数组中的索引做键，元素做值
		//因为数组的索引是不会重复的。
		ArrayList<Integer> list2 = new ArrayList<>();
		// 遍历arr数组,将>=10的元素存入到list集合中
		for (Integer thisNum : arr) {
			if (thisNum < 10)
				list2.add(thisNum);
		}
		System.out.println(list2);
		HashMap<Integer,Integer> hm = new HashMap<>();
		// 遍历arr数组,将>=10的元素存入到list集合中
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] < 10){
				hm.put(i, arr[i]);
			}
		}
		System.out.println(hm);
	}
}
