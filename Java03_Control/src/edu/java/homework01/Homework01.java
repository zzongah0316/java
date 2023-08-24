package edu.java.homework01;

import java.util.Random; //정수, 실수, 논리 타입 빼고 선언할 때 필요함.
import java.util.Scanner;

public class Homework01 {

	public static void main(String[] args) {
		// 가위바위보 게임
        // 가위-0, 바위-1, 보-2

        // 컴퓨터의 가위/바위/보는 (정수) 난수로 만듦.
        Random random = new Random(); 
        int computer = random.nextInt(3);

        // 사용자는 콘솔창에서 키보드로 가위/바위/보에 해당하는 정수를 입력.
        System.out.println("가위/바위/보 게임");
        System.out.println("-----------------");
        System.out.println("[0] 가위");
        System.out.println("[1] 바위");
        System.out.println("[2] 보");
        System.out.println("-----------------");
        System.out.print("선택>>>");

        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        // print(computer : user)
        // ctrl 누르고 변수를 누르면 링크처럼 되는데 그때 클릭하면 변수가 무엇인지 알 수 있음.
        System.out.println("computer(" + computer + ") : user(" + user + ")"); 

       // 내가 푼 것
        if (computer==user) {
        	System.out.println("비겼다");
        } else if (computer==0 && user==2) {
        	System.out.println("내가 졌다");
        } else if(computer==1 && user==0) {
        	System.out.println("내가 졌다");
        } else if(computer==2 && user==1) {
        	System.out.println("내가 졌다");
        } else {
        	System.out.println("내가 이겼다");
        }
	
        /* 선생님 풀이
         (1) 
         경우의 수 9개 if, else if문으로 만듦
        
         (2) 
         if (user==0) -> 사용자:가위 {
         if (computer==0) -> 컴퓨터:가위{ 
         System.out.println("비겼다")
         } else if (computer==1) -> 컴퓨터:바위{
         System.out.println("컴퓨터 승")
         } else -> 컴퓨터:보 {
         System.out.println("사용자 승")
         }
         } else if (user==1) -> 사용자:바위 {
           if (computer==0) -> 컴퓨터:가위{
            System.out.println("사용자 승")
         } else if (computer==1) -> 컴퓨터:바위{
          System.out.println("비겼다")
         } else -> 컴퓨터:보 {
          System.out.println("컴퓨터 승")
         }
         } else -> 사용자:보 {
           if (computer==0) -> 컴퓨터:가위{
            System.out.println("컴퓨터 승")
         } else if (computer==1) -> 컴퓨터:바위{
          System.out.println("사용자 승")
         } else -> 컴퓨터:보 {
          System.out.println("비겼다")
         }
         }
        
        (3) 
        if (computer==user) {
    	System.out.println("비겼다"); 
    	} else if (user==0) { 
    	if (computer==1) {
        System.out.println("컴퓨터 승")
    	} else {
    	System.out.println("사용자 승")
    	}
    	} else if (user==1) { 
    	if (computer==0) {
    	System.out.println("사용자 승")
    	} else {
    	System.out.println("컴퓨터 승")
    	}
    	} else {
    	if (computer==0) {
        System.out.println("컴퓨터 승")
        } if (computer==1) {
        System.out.println("사용자 승")
        }
        }
        
        (4) 
        if (computer==user) {
    	System.out.println("비겼다"); 
    	} else if ( user==0 && computer==2 || 
    	            user==1 && computer==0 ||
    	            user==2 && computer==1) {
    	 System.out.println("사용자 승")
    	} else {
    	 System.out.println("컴퓨터 승")
    	 }
    	        
    	(5)
    	int diff = user - computer;   
    	if (diff==0) {
    	System.out.println("비겼다"); 
    	} else if (diff==-2 || diff==1) {
    	System.out.println("사용자 승") 
    	} else {
    	 System.out.println("컴퓨터 승")
    	}
    	 
	
	*/      
        
      
	}
     
        
        
	}
