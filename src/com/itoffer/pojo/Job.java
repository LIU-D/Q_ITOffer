package com.itoffer.pojo;

public class Job {
		// 职位编号
		private int id;
		// 所属企业
		private Company company;
		// 职位名称
		private String name;
		// 招聘人数
		private int hiringNum;
		// 职位薪资
		private String salary;
		// 工作地区
		private String area;
		// 职位描述
		private String desc;
		// 结束日期
		private String endTime;
		// 招聘状态:1招聘中 2已暂停 3已结束
		private int state;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Company getCompany() {
			return company;
		}
		public void setCompany(Company company) {
			this.company = company;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getHiringNum() {
			return hiringNum;
		}
		public void setHiringNum(int hiringNum) {
			this.hiringNum = hiringNum;
		}
		public String getSalary() {
			return salary;
		}
		public void setSalary(String salary) {
			this.salary = salary;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		
		
		
		
}
