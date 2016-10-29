package com.newsat.platform.test;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

	public List students;
	public Test(){
		this.students = new ArrayList();
	}
	
	public void testAdd(){
		Student st1 = new Student("1", "张三");
		students.add(st1);
		
		Student temp = (Student)students.get(0);
		System.out.println("添加了学生：" + temp.id + ":" + temp.name);
		
		Student st2 = new Student("2", "李四");
		students.add(0, st2);
		Student temp2 = (Student)students.get(0);
		System.out.println("添加了学生：" + temp2.id + ":" + temp2.name);
		
		Student[] student = {new Student("3", "王五"), new Student("4", "马六")};
		students.addAll(Arrays.asList(student));
		Student temp3 = (Student)students.get(2);
		Student temp4 = (Student)students.get(3);
		System.out.println("添加了学生：" + temp3.id + ":" + temp3.name);
		System.out.println("添加了学生：" + temp4.id + ":" + temp4.name);
		
		Student[] student2 = {new Student("5", "周七"), new Student("6", "赵八")};
		students.addAll(2, Arrays.asList(student2));
		Student temp5 = (Student)students.get(2);
		Student temp6 = (Student)students.get(3);
		System.out.println("添加了学生：" + temp5.id + ":" + temp5.name);
		System.out.println("添加了学生：" + temp6.id + ":" + temp6.name);
	}
	public void testGet(){
		int size = students.size();
		for (int i = 0; i < size; ++i)
		{
			Student st = (Student)students.get(i);
			System.out.println("学生：" + st.id + ":" + st.name);
		}
	}
	
	public void testIterator(){
		Iterator it = students.iterator();
		System.out.println("有如下学生（通过迭代器访问）：");
		while (it.hasNext()){
			Student st = (Student)it.next();
			System.out.println("学生" + st.id + ":" + st.name);
		}
	}
	
	public void testForEach(){
		System.out.println("有如下学生（通过For Each）");
		for (Object obj: students)
		{
			Student st = (Student)obj;
			System.out.println("学生" + st.id + ":" + st.name);
		}
	}
	
	public void testModify(){
		students.set(4, new Student("3", "五九" ));
	}
	
	public void testRemove(){
		Student st = (Student)students.get(4);
		System.out.println("我是学生：" + st.id + ":"  + st.name + ", 我即将被删除");
		students.remove(st);
		System.out.println("成功删除学生！ ");
		testForEach();
	}
	
	public void testDemo(List<?> s){
		for(Object obj:s){
			System.out.println("我的类型是：" + obj.getClass().getName());
		}
	}
	
	public static void main(String[] args) throws  ClassNotFoundException{
		// TODO Auto-generated method stub
		Test test = new Test();
		Dog dog = new Dog();
		Animal a0 = new Animal();
		List<Animal> s = new ArrayList<Animal>();
		s.add(dog);
		s.add(a0);
		test.testDemo(s);
	}
}




