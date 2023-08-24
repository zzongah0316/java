package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class FileMain07 {

	public static void main(String[] args) {
		// TODO 
		// 1. ArrayList<Student> 객체 생성
		ArrayList<Student> students = new ArrayList<>();
		
		// 2. 1,000,000개의 Student 객체를 리스트에 저장 - Random(시험 점수)
		Random random = new Random();
//		random.nextInt(101);
//		for(int i=0; i<1_000_000; i++) {
//			Student s = new Student(i, "NAME_" + i, new Score(random.nextInt(101),random.nextInt(101),random.nextInt(101)));
//			students.add(s);
//		}
		
		for(int i= 0; i<1_000_000; i++) {
			Score score = new Score(random.nextInt(101), random.nextInt(101), random.nextInt(101));
			Student student = new Student(i, "NAME_"+i , score);
			students.add(student);
		}
		
		// 3. 리스트를 students.dat 파일에 (직렬화해서) 씀.
		// 4. 파일에서 데이터를 읽어서 역직렬화 -> 읽은 데이터 확인. 
		
		
		
		System.out.println("size = " + students.size());
		System.out.println(students.get(10));
		
		String file = "data/students.dat";
		
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		try {
		out = new FileOutputStream(file);
		bout = new BufferedOutputStream(out);
		oout = new ObjectOutputStream(bout);
		
		long start = System.currentTimeMillis();
		
		oout.writeObject(students); // 직렬화(serialize)
		
		long end = System.currentTimeMillis();
		System.out.println("경과 시간 = " + (end-start) + "ms");
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
			oout.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		try (
				FileInputStream in = new FileInputStream(file);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream oin = new ObjectInputStream(bin);
		){
			
			long start = System.currentTimeMillis();
			ArrayList<Student> result = (ArrayList<Student>) oin.readObject();
			long end = System.currentTimeMillis();
			System.out.println("경과 시간 = " + (end-start) + "ms");
			
			System.out.println(students.get(10));
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
