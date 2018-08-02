package com.qf.e_pare2;

import java.util.Comparator;

public class MyComparator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		//按年龄从小到大排序
		//第一个参数o1是要存储的对象元素,第二个参数o2为要比较的对象元素
		return o1.getAge()-o2.getAge();
	}

}
