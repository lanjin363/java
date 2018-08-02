package com.qf.e_pare2;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		//多态  Comparator comparator = new MyComparator()
		Set<Student> set = new TreeSet<>(new MyComparator());
		
		//回调接口--作业
		
		set.add(new Student("zs",18));
		set.add(new Student("ls",8));
		set.add(new Student("ww",58));
		set.add(new Student("zs",58));
		Iterator<Student> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
