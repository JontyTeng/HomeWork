package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test22 {
//	研发部门有5个人，信息如下：（姓名-工资）【柳岩=2100, 张亮=1700, 诸葛亮=1800, 灭绝师太=2600, 东方不败=3800】
//			a.将以上员工的相关信息存放在适合的集合中
//			b.给柳岩涨工资300
//			c.将工资大于等于2000的员工名单写入D:\\info.txt中
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("柳岩", 2100);
		hm.put("张亮", 1700);
		hm.put("诸葛亮", 1800);
		hm.put("灭绝师太", 2600);
		hm.put("东方不败", 3800);
		System.out.println(hm);
		
		//第二问也可以直接获取，然后put
		Set<Entry<String, Integer>> entrySet = hm.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if(entry.getKey().equals("柳岩")){
				Integer value = entry.getValue();
				hm.put("柳岩", value + 300);
			}
		}
		System.out.println(hm);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\info.txt"));
		Set<String> keySet = hm.keySet();
		for (String string : keySet) {
			if(hm.get(string)>=2000){
				//System.out.println(string + hm.get(string));
				bw.write(string + hm.get(string));
				bw.newLine();
			}
		}
		bw.close();
		
	}
}
