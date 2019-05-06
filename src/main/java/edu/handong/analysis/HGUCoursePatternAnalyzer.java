package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.ArrayList;
import java.util.List;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		System.out.println("Number of All Students: " + numOfStudents);
		//System.out.print(students.length);
		for(Student student: students) { //3번만 돌아가게 하고 싶다
			System.out.println(student.getName());
		}
		
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		//name이랑 course의 이름만 받아ㅏ와야 함 //name은 [1]이고
		int namelen = lines.length; 
		String [] names = new String[namelen];
		Student [] studentNames = new Student[namelen];
		
		int j=0, i=0;
		for( i= 0; i < namelen; i++){       
			names[i] = lines[i].trim().split(",")[1];				
			Student student= new Student(names[i]);	
			if(i>0) {
				if(studentExist(studentNames, student)==false) {//같은이름이 아닐경우  
			 		studentNames[j] = new Student(names[i]); //새로운 instance 생성
			 		j++;
				}
			}
			else {
				studentNames[j] = new Student(names[i]);
				j++;
			}
		}		
		Student [] oneStudent = new Student[j]; //필요할까?
		for(i=0;i<j;i++) {
			oneStudent[i] = new Student(names[i]);
			oneStudent[i] = studentNames[i];
		}
		return oneStudent;
	}
	
	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		//중복제거하는거
		int i = 0;
		
		while(students[i]!=null) {			
			if(students[i].getName().equals(student.getName()) == true)//같지 않으면 false를  return
				return true;				
			else i++; //while문 업데이트
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		//Course courseName = new Course (line);
		int namelen = lines.length; 
		String[] course = new String [namelen];
		Course[] courseNames = new Course [namelen];
				
		int j=0, i=0;
		for( i= 0; i < namelen; i++){       
			course[i] = lines[i].trim().split(",")[2];				
			Course cour= new Course (course[i]);	
			if(i>0) {
				if(courseExist(courseNames, cour)==false) {//같은이름이 아닐경우  
					courseNames[j] = new Course(course[i]); //새로운 instance 생성
			 		j++;
				}
			}
			else {
				courseNames[j] = new Course(course[i]);
				j++;
			}
		}		
		Course [] a = new Course[j]; 
		for(i=0;i<j;i++) {
			a[i] = new Course(course[i]);
			a[i] = courseNames[i];
		}
		return a;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		int i = 0;
		
		while(courses[i]!=null) {			
			if(courses[i].getCourseName().equals(course.getCourseName()) == true)//같지 않으면 false를  return
				return true;				
			else i++; //while문 업데이트
		}
		return false;
	
	}

}
