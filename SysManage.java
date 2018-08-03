package com.qf.sysmanage;

import java.util.ArrayList;
import java.util.List;

import com.qf.db.DBCenter;
import com.qf.entity.Student;
import com.qf.istutinterface.IStudentInterface;
import com.qf.stutype.StuType;

/**
 * SysManage :  ��ϵͳ��������ȥ��������ɾ���ġ���
 *
 */

public final class SysManage implements IStudentInterface {

	/**
	 * ��ӹ����У�Ҫȷ��ѧ��Ψһ
	 * 1.����ѧ����Ϣ
	 * 2.ѧ�������д���null��Ϣ
	 * 3.�����ж�-- ѧ���ظ�
	 */
	@Override
	public boolean add(Student st) {
		//�жϴ����ѧ���������ȷ��
		int ret = checkStudent(st);
		if(ret == StuType.ST_SUCCESS){  //ѧ����Ϣ��ȷ��û�ظ�---���
			DBCenter.list.add(st);
			return true;
		}else if(ret == StuType.ST_NULL){  //Ϊ��ֵ
			System.out.println("ѧ����Ϣ����nullֵ");
		}else{
			System.out.println("ѧԱ��Ϣ������");  //������Ϣ����
		}
		
		return false;
	}

	private int checkStudent(Student st) {
		//�ж��Ƿ�Ϊnull
		if(st.getAge()==null||st.getClassNum()==null||st.getName()==null||st.getNum()==null){
			return StuType.ST_NULL;
		}
		//�ж�ѧ����Ϣ������
		if(Integer.parseInt(st.getAge())>60 || Integer.parseInt(st.getAge())<3){
			return StuType.ST_OTHER;
		}
		
		//�ж�ѧ���Ƿ��ڼ������Ƿ����
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
	
	
	@Override   //��������
	public List<Student> queryAll() {
		return DBCenter.list;
	}

	@Override   //����ƥ�����͵�ѧ��
	public List<Student> queryForType(int type, String string) {
		//���ڷ������������ļ���
		List<Student> list = new ArrayList<>();
		for(Student st: DBCenter.list){ //ѭ�������洢���ݵ�Ԫ��
			switch (type) {
				case StuType.ST_NAME:
					if(string.equals(st.getName())){  //����ж�������ȣ�����ӵ��¼�����
						list.add(st);
					}
					break;
				case StuType.ST_AGE:
					if(string.equals(st.getAge())){  //����ж�������ȣ�����ӵ��¼�����
						list.add(st);
					}
					break;
				case StuType.ST_NUM:
					if(string.equals(st.getNum())){  //����ж�ѧ����ȣ�����ӵ��¼�����
						list.add(st);
					}
					break;
				case StuType.ST_CLASS_NUM:
					if(string.equals(st.getClassNum())){  //����жϰ����ȣ�����ӵ��¼�����
						list.add(st);
					}
					break;
				default:
					break;
			}
		}
		
		return list;
	}

	@Override  //�Ƴ�ָ�������ѧ�ŵ�ѧԱ
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

	@Override  //�޸�ƥ���ź�ѧ�ŵ�ָ��ѧ������
	public boolean updateStudent(String classNum, String num, int type, String string) {
		//�жϼ������Ƿ��е���classNum��num��������Ϣ
		for(Student st : DBCenter.list){
			if(classNum.equals(st.getClassNum()) && num.equals(st.getNum())){
				switch(type){
					case StuType.ST_NAME:
						st.setName(string);
						return true;
					case StuType.ST_AGE:
						st.setAge(string);
						return true;
					case StuType.ST_NUM:  //ѧ��ҪΨһ
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
