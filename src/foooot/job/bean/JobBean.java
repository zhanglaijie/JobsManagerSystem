package foooot.job.bean;

public class JobBean { 
	
	private int jobId;
	private String jobTitle;
	private double minSalary;
	private double maxSalary;
	public void setJobId(int i){
		jobId=i;
	}
	public void setJobTitle(String t){
		jobTitle=t;
	}
	public void setMinSalary(double min){
		minSalary=min;
	}
	public void setMaxSalary(double max){
		maxSalary=max;
	}
	public int getJobId(){
		return jobId;
	}
	public String getJobTitle(){
		return jobTitle;
	}
	public double getMinSalary()
	{
		return minSalary;
	}
	public double getMaxSalary(){
		return maxSalary;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
