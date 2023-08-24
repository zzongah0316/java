package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

	public static void main(String[] args) {
		// 문자열들을 원소로 갖는 리스트 생성과 동시에 초기화.
		// Arrays.asList(...) - 아규먼트로 전달된 값들을 원소로 갖는 리스트 객체를 생성.
		List<String> subjects = Arrays.asList("Java", "SQL", "HTML",
				"CSS", "JavaScript", "Servlet", "JSP", "Spring", "Python");
		System.out.println(subjects);
				
		// 리스트 subjects에서 5글자 이상인 문자열들만 저장하는 리스트를 만들고 출력.
		// ArrayList<String> list = new ArrayList<>();
		// 다형성: SuperType var = new SubType();
		
		List<String> longWords = new ArrayList<>();
		Iterator<String> itr = subjects.iterator();
		while (itr.hasNext()){
			String s = itr.next();
			if (s.length() >=5 ) {
				longWords.add(s);
			}
		}
		System.out.println(longWords);
		
		// 내가 푼 것
//		List<String> longWords = new ArrayList<>(); // -> 빈 리스트
//		for(int i =0; i<subjects.size(); i++) {
//			String word = subjects.get(i);
//			if(word.length()>=5) {
//				longWords.add(word);
//			}
//		}
//		System.out.println(longWords);
		
		// 선생님 풀이
//		for(String s : subjects) {
//			if(s.length() >= 5) {
//				longWords.add(s);
//			}
//		}
//		System.out.println(longWords);
				
		
		// 리스트 subjects의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
		List<Integer> wordLengths = new ArrayList<>();
		for(int i =0; i<subjects.size(); i++) {
			wordLengths.add(subjects.get(i).length());
		}
		System.out.println(wordLengths);
		//선생님 풀이
//		for(String s : subjects) {
//			wordLengths.add(s.length());
//		}
		
		
		
		
		// 정수(0, 1)을 저장하는 리스트를 생성.
		List<Integer> codes = Arrays.asList(0, 1, 0, 0, 1, 1);
		
		// 리스트 codes의 원소가 0이면 "Male", 1이면 "Female"을 원소로 갖는 리스트를 만들고 출력.
		List<String> genders = new ArrayList<>();
		for(int i=0; i<codes.size(); i++) {
			if(codes.get(i)==0) {
			genders.add("Male");
			} else {
				genders.add("Female");
			}
		}
		System.out.println(genders);
		//선생님 풀이
//		for(Integer c : codes) {
//			if(c==0) {
//				genders.add("Male");
//			} else {
//				genders.add("Female");  -> genders.add((c==0) ? "Male" : "Female"); 이렇게 사용해도 된다.
//			}
//		}
	}

}
