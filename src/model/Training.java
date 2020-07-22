package model;

public class Training {
	private String training_id;
	private String training_name;
	private int enrolled;
	private String training_sup_name;
	private String training_sup_id;
	private String trainer_name;
	private String start_date;
	private String status;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String end_date;

	public Training(String training_id, String training_name, int enrolled, String training_sup_name,
			String training_sup_id, String trainer_name, String start_date, String end_date, String status) {
		this.training_id = training_id;
		this.training_name = training_name;
		this.enrolled = enrolled;
		this.training_sup_name = training_sup_name;
		this.training_sup_id = training_sup_id;
		this.trainer_name = trainer_name;
		this.start_date = start_date;
		this.end_date = end_date;
		this.status=status;
	}
	public String getTraining_id() {
		return training_id;
	}
	public String getTraining_name() {
		return training_name;
	}
	public int getEnrolled() {
		return enrolled;
	}
	public String getTraining_sup_name() {
		return training_sup_name;
	}
	public String getTraining_sup_id() {
		return training_sup_id;
	}
	public String getTrainer_name() {
		return trainer_name;
	}
	public String getStart_date() {
		return start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setTraining_id(String training_id) {
		this.training_id = training_id;
	}
	public void setTraining_name(String training_name) {
		this.training_name = training_name;
	}
	public void setEnrolled(int enrolled) {
		this.enrolled = enrolled;
	}
	public void setTraining_sup_name(String training_sup_name) {
		this.training_sup_name = training_sup_name;
	}
	public void setTraining_sup_id(String training_sup_id) {
		this.training_sup_id = training_sup_id;
	}
	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}



}
