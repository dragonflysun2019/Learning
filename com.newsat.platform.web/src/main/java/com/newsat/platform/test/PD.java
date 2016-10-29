package com.newsat.platform.test;
import java.util.*;
public class PD {
	public String id;
	public String name;
	
	public Set<Student> students;
	public PD(String id, String name){
		this.id = id;
		this.name = name;
		this.students = new HashSet<Student>();
	}
}
