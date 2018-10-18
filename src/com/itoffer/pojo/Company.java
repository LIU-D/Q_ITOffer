package com.itoffer.pojo;

import java.util.HashSet;
import java.util.Set;

public class Company {
	// 企业标识
		private int 	id;
		// 企业名称
		private String name;
		// 企业所在地区
		private String area;
		// 企业规模
		private String size;
		// 企业性质
		private String type;
		// 企业简介
		private String brief;
		// 招聘状态:1招聘中 2已暂停 3已结束
		private int state;
		// 排序序号
		private int sort;
		// 浏览数
		private int viewNum;
		// 宣传图片
		private String pic;
		// 职位
		private Set<Job> jobs = new HashSet<Job>();

		public Company() {
			super();
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String area) {
			this.area = area;
		}

		public String getSize() {
			return size;
		}

		public void setSize(String size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getBrief() {
			return brief;
		}

		public void setBrief(String brief) {
			this.brief = brief;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public int getSort() {
			return sort;
		}

		public void setSort(int sort) {
			this.sort = sort;
		}

		public int getViewNum() {
			return viewNum;
		}

		public void setViewNum(int viewNum) {
			this.viewNum = viewNum;
		}

		public String getPic() {
			return pic;
		}

		public void setPic(String pic) {
			this.pic = pic;
		}

		public Set<Job> getJobs() {
			return jobs;
		}

		public void setJobs(Set<Job> jobs) {
			this.jobs = jobs;
		}
		
		
		
}
