package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DAO.TrainingOperations;
import model.Training;

public class TrainingFetcher {
Training train=null;
TrainingOperations training=new TrainingOperations();
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public void trainingHandle() throws Exception {
	System.out.println("Hi what would you like to do?");
	System.out.println("1. ADD NEW TRAINING");
	System.out.println("2. CHANGE TRAINING SUPERVISOR DETAILS");
	System.out.println("3. CHANGE TRAINER DETAILS");
	System.out.println("4. CHANGE START DATE OF TRAINING");
	System.out.println("5. CHANGE END DATE OF TRAINING");
	System.out.println("6. DELETE TRAINING");
	System.out.println("7. GET ALL TRAININGS WITHIN A YEAR");
	System.out.println("8. GET ALL TRAININGS WITHIN A MONTH");
	System.out.println("9. GET ALL TRAINING DETAILS");
	
	int x=Integer.parseInt(br.readLine());
	switch(x) {
	case 1:
		System.out.println("Enter training id");
		String id=br.readLine();
		System.out.println("Enter training name");
		String name=br.readLine();
		System.out.println("Enter number of people enrolled");
		int num=Integer.parseInt(br.readLine());
		System.out.println("Enter supervisor name");
		String sup_name=br.readLine();
		System.out.println("Enter supervisor id");
		String sup_id=br.readLine();
		System.out.println("Enter trainer name");
		String trainer=br.readLine();
		System.out.println("Enter starting date");
		String start_date=br.readLine();
		System.out.println("Enter end date");
		String end_date=br.readLine();
		System.out.println("Enter status");
		String status=br.readLine();
		
		
		train=new Training(id,name,num,sup_name,sup_id,trainer,start_date,end_date,status);
		
		try {
			training.addTraining(train);
		}
		catch(Exception e) {
			e.getMessage();
		}
		System.out.println("Added Successfully");
		break;
		
	case 2:
		System.out.println("Enter the training id to change supervisor details");
		String id1=br.readLine();
		training.changeSupervisor(id1);
		break;
		
	case 3:
		System.out.println("Enter the training id to change trainer details");
		String id2=br.readLine();
		training.changeTrainer(id2);
		break;
		
	case 4:	
		System.out.println("Enter the training id to change start date");
		String id3=br.readLine();
		training.changeStartDate(id3);
		break;
		
	case 5:	
		System.out.println("Enter the training id to change end date");
		String id4=br.readLine();
		training.changeEndDate(id4);
		break;
	
	case 6:
		System.out.println("Enter the training id to delete the training");
		String id5=br.readLine();
		training.deleteTraining(id5);
		break;
		
	case 7:
		System.out.println("Enter year");
		String year=br.readLine();
		training.getByYear(year);
		break;
		
	case 8:
		System.out.println("Enter month");
		String month=br.readLine();
		training.getByMonth(month);
		break;
		
	case 9:
		System.out.println("Training Records");
		training.getAllTraining();
		break;	
	
	}
	
}


}
