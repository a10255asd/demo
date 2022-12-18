package com.example.designParttern.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

//�ͻ���
public class Demeter1 {

	public static void main(String[] args) {
		System.out.println("~~~使用迪米特法则的改进~~~");
		//������һ�� SchoolManager ����
		SchoolManager schoolManager = new SchoolManager();
		//���ѧԺ��Ա��id ��  ѧУ�ܲ���Ա����Ϣ
		schoolManager.printAllEmployee(new CollegeManager());

	}

}


//ѧУ�ܲ�Ա����
class Employee {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}


//ѧԺ��Ա����
class CollegeEmployee {
	private String id;

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
}


//管理学院员工的管理类
class CollegeManager {
	//返回学院的所有员工
	public List<CollegeEmployee> getAllEmployee() {
		List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
		for (int i = 0; i < 10; i++) { //这里我们增加了10个员工到list
			CollegeEmployee emp = new CollegeEmployee();
			emp.setId("ѧԺԱ��id= " + i);
			list.add(emp);
		}
		return list;
	}
	//输出学院员工的信息
	public void printEmployee() {
		//��ȡ��ѧԺԱ��
		List<CollegeEmployee> list1 = getAllEmployee();
		System.out.println("------------ѧԺԱ��------------");
		for (CollegeEmployee e : list1) {
			System.out.println(e.getId());
		}
	}
}

//ѧУ������

//���� SchoolManager ���ֱ������������Щ Employee��CollegeManager
//CollegeEmployee ���� ֱ������ ����һ��İ���࣬����Υ���� �����ط��� 
class SchoolManager {
	//����ѧУ�ܲ���Ա��
	public List<Employee> getAllEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		
		for (int i = 0; i < 5; i++) { //��������������5��Ա���� list
			Employee emp = new Employee();
			emp.setId("ѧУ�ܲ�Ա��id= " + i);
			list.add(emp);
		}
		return list;
	}

	//�÷���������ѧУ�ܲ���ѧԺԱ����Ϣ(id)
	void printAllEmployee(CollegeManager sub) {
		/**
		 * 分析问题：
		 * 1、将输出学院的员工方法，封装到CollegeManager
		 */
		sub.printEmployee();
		List<Employee> list2 = this.getAllEmployee();
		System.out.println("------------ѧУ�ܲ�Ա��------------");
		for (Employee e : list2) {
			System.out.println(e.getId());
		}
	}
}
