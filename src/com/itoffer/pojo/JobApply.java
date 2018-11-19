package com.itoffer.pojo;

/************************************************
 * @author		Lixd027
 * @date		2018-11-15 2:42:32 PM
 * @tags		职位申请实体
 ***********************************************/

public class JobApply {

	private		int	applyId;
	private		int jobId;
	private		int	applicantId;
	private		String	applyDate;
	private		int		state;		//1:申请 2：审核 3：通知
	private     Job job;
	public JobApply(){
		
	}
	/*
	 * 构造函数
	 * 
	 */
	public JobApply(int applicantId, int jobId){
		this.applicantId = applicantId;
		this.jobId = jobId;
	}
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}

	public int getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(int applicantId) {
		this.applicantId = applicantId;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJob(int jobId) {
		this.jobId = jobId;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	
}
