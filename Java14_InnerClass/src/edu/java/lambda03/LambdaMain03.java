package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaMain03 {

	public static void main(String[] args) {
		// Employee를 원소로 갖는 리스트를 선언, 초기화
		List<Employee> employees = Arrays.asList(
				new Employee(100, "이찬희", "개발1팀", "대리", 400.0),
				new Employee(101, "지대한", "개발2팀", "사원", 350.0),
				new Employee(200, "김다훈", "개발2팀", "과장", 380.0),
				new Employee(201, "유다한", "개발1팀", "부장", 500.0),
				new Employee(300, "강효남", "인사팀", "사원", 300.0),
				new Employee(301, "위태욱", "인사팀", "과장", 1000.0)
		);
		
		// 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
//		for(Employee e : employees) {
//			System.out.println(e.toString());
//		}
		// 선생님 풀이
		System.out.println("------Ex1.");
		employees.forEach(x -> System.out.println(x));
		// 람다 표현 (변화X 때 사용)
		employees.forEach(System.out::println);
		
		// 2. 개발1,2팀에서 일하는 직원들의 급여의 합계를 출력.
		double y = 0;
		for(Employee e : employees) {
			if(e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀")) {
				y = y+e.getSalary();
			}	
		}
		System.out.println("개발1,2팀 직원의 급여 합계 = " + y);
		// 선생님 풀이
		System.out.println("------Ex2.");
		double result = employees.stream()
				.filter(x -> x.getDept().contains("개발"))
				.mapToDouble(x -> x.getSalary())
				.sum();
		System.out.println();
		
		// 3. 개발1,2팀에서 일하는 직원들의 급여의 평균을 출력.
		int x =0;
		for(Employee e : employees) {
			if(e.getDept().equals("개발1팀") || e.getDept().equals("개발2팀")) {
				x++;
			}
		}
		System.out.println("개발1,2팀 직원의 급여 평균 = " + y/x);
		
		// 4. 직급이 사원인 직원들의 급여의 합계를 출력.
		double b=0;
		for(Employee e : employees) {
			if(e.getEmpTitle().equals("사원")) {
				b = b+e.getSalary();
			}
		}
		System.out.println("사원 직원의 급여 합계 = " + b);
		
		
		// 5. 직급이 사원인 직원들의 급여의 평균을 출력.
		int a =0;
		for(Employee e : employees) {
			if(e.getEmpTitle().equals("사원")) {
				a++;
			}
		}
		System.out.println("사원 직원의 급여 평균 = " + b/a);
		
		// 6. 급여가 400 이상인 직원들의 정보를 한 줄에 한 명씩 출력.
		List<Employee> employee = new ArrayList<>();
		for(Employee e : employees) {
			if(e.getSalary() >= 400.0) {
				System.out.println("급여 400이상 직원들 = " + e.toString());
			}
		}
		
		// 7. 개발1팀 직원들의 급여를 10% 인상하고, 그 직원들의 급여 평균을 계산하고 출력.
		int i = 0;
		double z =0;
		for(Employee e : employees) {
			if(e.getDept().equals("개발1팀")) {
				z = z + e.getSalary() + (e.getSalary()*0.1);
				i++;
			}
		}
		System.out.println("개발1팀 인상 급여 평균 = " + z/i);
			
		// 8. 직원 리스트에서 "사원"은 몇 명?
		int person = 0;
		for(Employee e : employees) {
			if(e.getEmpTitle().equals("사원")) {
				person++;
			}
		}
		System.out.println("사원 수 = " + person);
		

	}

}
