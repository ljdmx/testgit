package com.ljd.account.util;

import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private int pageSize;
	private int currentPage;
	private int totalRecord; 
	private int totalPage;
	private List<T> datalist;
	public Pager(int currentPage,List<T> datalist) {
		this.pageSize =datalist.size()<6?datalist.size():6;
		this.totalRecord =datalist.size();
		this.currentPage = currentPage;
		if(datalist.size()<6){
			this.totalPage = 1;
		}else{
		this.totalPage =pageSize/6==0?datalist.size()/6:datalist.size()/6+1;
		}
		if(pageSize<6){
			this.datalist = datalist.subList(0, this.pageSize);
		}
		if(currentPage >= totalPage){
			int fromIndex=totalPage*6-6;
			int toIndex=totalPage*6-6+totalRecord%6;
			this.datalist = datalist.subList(fromIndex, toIndex); 
			this.currentPage=totalPage;
		}
		if(currentPage < totalPage){
			int fromIndex=currentPage*6-6;
			int toIndex=currentPage*6;
			this.datalist = datalist.subList(fromIndex, toIndex);
		}
		
		
		
	}
	public Pager(List<T> datalist) {
		this.pageSize = datalist.size()<6?datalist.size():6;
		this.currentPage =1 ;
		this.totalRecord =datalist.size();
		if(datalist.size()<6){
			this.totalPage = 1;
		}else{
		this.totalPage =pageSize/6==0?datalist.size()/6:datalist.size()/6+1;
		}
		int fromIndex=0;
		int toIndex=pageSize;
		this.datalist = datalist.subList(fromIndex, toIndex);
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getDatalist() {
		return datalist;
	}
	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	
	
}
