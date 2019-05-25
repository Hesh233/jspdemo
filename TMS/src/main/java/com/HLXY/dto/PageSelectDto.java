package com.HLXY.dto;

public class PageSelectDto {
	public String searchKey;
	public String searchVal;
	public String sortKey;
	//0-asc,1-desc,默认0
	public int ascOrDesc;
	public Integer page;
	public Integer limit;
	
	public String getSortKey() {
		return sortKey;
	}
	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getLimit() {
		return limit;
	}
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public String getSearchVal() {
		return searchVal;
	}
	public void setSearchVal(String searchVal) {
		this.searchVal = searchVal;
	}
	public int getAscOrDesc() {
		return ascOrDesc;
	}
	public void setAscOrDesc(int ascOrDesc) {
		this.ascOrDesc = ascOrDesc;
	}
	@Override
	public String toString() {
		return "PageSelectDto [searchKey=" + searchKey + ", searchVal=" + searchVal + ", ascOrDesc=" + ascOrDesc
				+ ", currPage=" + page + ", size=" + limit + "]";
	}
	
}
