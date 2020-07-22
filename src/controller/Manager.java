package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Manager {
	
	EmployeeFetcher ef=new EmployeeFetcher();
	DepartmentFetcher df=new DepartmentFetcher();
	TrainingFetcher tf=new TrainingFetcher();
public void admin() throws Exception {
	System.out.println("HEY! WHAT RECORDS WOULD YOU LIKE TO ACCESS?");
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("1. EMPLOYEE");
	System.out.println("2. DEPARTMENT");
	System.out.println("3. TRAINING");
	int x=Integer.parseInt(br.readLine());
	switch(x) {
	case 1:
		ef.employeeHandle();
		break;
	case 2:
		df.departmentHandle();
		break;
	case  3:
		tf.trainingHandle();
		break;
	}
}
}
