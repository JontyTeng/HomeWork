package com.nanjing.three;

import java.util.Map;
import java.util.TreeMap;

public class Test14 {
	//ȡ��һ���ַ�������ĸ���ֵĴ������磺�ַ�����"abcdekka27qoq" ��
	 //* �����ʽΪ��a(2)b(1)k(2)...
	public static void main(String[] args) {
		String str = "abcdekka27qoq";
		char[] arr = str.toCharArray();
		//����TreeMap���ϣ��������ַ�����Ӧ���ֵĴ���
		TreeMap<Character,Integer> hs = new TreeMap<>();
		for (char c : arr) {
			/*Integer num = hs.get(c);
			if(num==null) {
				hs.put(c, 1);
			} else {
				hs.put(c, num+1);
			}*/	
			hs.put(c, (hs.get(c)==null?1:hs.get(c)+1));
		}
		System.out.println(hs);
		//��HashMap�����е����ݷ�װ��a(2)b(1)k(2)...
		//����StringBuilder����ַ�����ƴװ
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<Character,Integer> entry : hs.entrySet()) {
			//����ĸ��ʱ���ƴ��
			if(entry.getKey()>='a' && entry.getKey() <='z' || entry.getKey() >='A' && entry.getKey() <='Z'){
				sb.append(entry.getKey()).append("(").append(entry.getValue()).append(")");
			}
		}
		System.out.println(sb.toString());		
	}
}
