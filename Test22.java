package com.nanjing.three;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test22 {
//	�з�������5���ˣ���Ϣ���£�������-���ʣ�������=2100, ����=1700, �����=1800, ���ʦ̫=2600, ��������=3800��
//			a.������Ա���������Ϣ������ʺϵļ�����
//			b.�������ǹ���300
//			c.�����ʴ��ڵ���2000��Ա������д��D:\\info.txt��
	public static void main(String[] args) throws IOException {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("����", 2100);
		hm.put("����", 1700);
		hm.put("�����", 1800);
		hm.put("���ʦ̫", 2600);
		hm.put("��������", 3800);
		System.out.println(hm);
		
		//�ڶ���Ҳ����ֱ�ӻ�ȡ��Ȼ��put
		Set<Entry<String, Integer>> entrySet = hm.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if(entry.getKey().equals("����")){
				Integer value = entry.getValue();
				hm.put("����", value + 300);
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
