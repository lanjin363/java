package com.qf.sysmanage;

import java.util.ArrayList;
import java.util.List;

import com.qf.db.DBCenter;
import com.qf.entity.Student;
import com.qf.istutinterface.IStudentInterface;
import com.qf.stutype.StuType;

/**
 * SysManage :  在系统管理类中去操作增、删、改、查
 *
 */

public final class SysManage implements IStudentInterface {

	/**
	 * 添加过程中，要确保学号唯一
	 * 1.合理学生信息
	 * 2.学生对象中带有null信息
	 * 3.其他判读-- 学号重复
	 */
	@Override
	public boolean add(Student st) {
		//判断传入的学生对象的正确性
		int ret = checkStudent(st);
		if(ret == StuType.ST_SUCCESS){  //学生信息正确且没重复---添加
			DBCenter.list.add(st);
			return true;
		}else if(ret == StuType.ST_NULL){  //为空值
			System.out.println("学生信息中有null值");
		}else{
			System.out.println("学员信息不合适");  //其他信息错误
		}
		
		return false;
	}

	private int checkStudent(Student st) {
		//判断是否为null
		if(st.getAge()==null||st.getClassNum()==null||st.getName()==null||st.getNum()==null){
			return StuType.ST_NULL;
		}
		//判断学生信息合理性
		if(Integer.parseInt(st.getAge())>60 || Integer.parseInt(st.getAge())<3){
			return StuType.ST_OTHER;
		}
		
		//判断学号是否在集合中是否存在
		return isExistNum(st.getNum());
	}

	private int isExistNum(String num) {
		
		for(Student st : DBCenter.list){
			if(num.equals(st.getNum())){
				return StuType.ST_OTHER;
			}
		}
		return StuType.ST_SUCCESS;
	}
	
	
	@Override   //查找所有
	public List<Student> queryAll() {
		return DBCenter.list;
	}

	@Override   //查找匹配类型的学生
	public List<Student> queryForType(int type, String string) {
		//用于返回满足条件的集合
		List<Student> list = new ArrayList<>();
		for(Student st: DBCenter.list){ //循环遍历存储数据的元素
			switch (type) {
				case StuType.ST_NAME:
					if(string.equals(st.getName())){  //如果判断姓名相等，则添加到新集合中
						list.add(st);
					}
					break;
				case StuType.ST_AGE:
					if(string.equals(st.getAge())){  //如果判断年龄相等，则添加到新集合中
						list.add(st);
					}
					break;
				case StuType.ST_NUM:
					if(string.equals(st.getNum())){  //如果判断学号相等，则添加到新集合中
						list.add(st);
					}
					break;
				case StuType.ST_CLASS_NUM:
					if(string.equals(st.getClassNum())){  //如果判断班号相等，则添加到新集合中
						list.add(st);
					}
					break;
				default:
					break;
			}
		}
		
		return list;
	}

	@Override  //移除指定班号与学号的学员
	public boolean deleteStudent(String classNum, String num) {
		Student st;
		for(int i = 0 ; i <DBCenter.list.size();i++){
			st = DBCenter.list.get(i);
			if(classNum.equals(st.getClassNum()) && num.equals(st.getNum())){
				DBCenter.list.remove(st);
				return true;
			}
		}
		
		return false;
	}

	@Override  //修改匹配班号和学号的指定学生属性
	public boolean updateStudent(String classNum, String num, int type, String string) {
		//判断集合中是否有等于classNum和num的属性信息
		for(Student st : DBCenter.list){
			if(classNum.equals(st.getClassNum()) && num.equals(st.getNum())){
				switch(type){
					case StuType.ST_NAME:
						st.setName(string);
						return true;
					case StuType.ST_AGE:
						st.setAge(string);
						return true;
					case StuType.ST_NUM:  //学号要唯一
						if(StuType.ST_SUCCESS == isExistNum(string)){
							st.setNum(string);
							return true;
						}
						break;
					case StuType.ST_CLASS_NUM:
						st.setClassNum(string);
						return true;
				}
			}
		}
		return false;
	}

}
