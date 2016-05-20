package com.psl.beans;

public class Student implements Comparable{
	private int rollno;
	private String studentName;
	private int age;
	private Address address;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int rollno, String studentName, int age, Address address) {
		super();
		this.rollno = rollno;
		this.studentName = studentName;
		this.age = age;
		this.address = address;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

    @Override
    public int compareTo(Object t) {
        
        Student student = (Student) t;
        
        if ( (this.getStudentName().compareToIgnoreCase(student.getStudentName())) > 0 ) {
            return 1;
        } else if ( (this.getStudentName().compareToIgnoreCase(student.getStudentName())) < 0 ) {
            return -1;
        } else if (this.getAge() > student.getAge()) {
            return 1;
        } else if (this.getAge() < student.getAge()) {
            return -1;
        } else if (this.getRollno() > student.getRollno()) {
            return 1;
        } else if (this.getRollno() < student.getRollno()) {
            return -1;
        } else {
            return 0;
        }
    }
	
}
