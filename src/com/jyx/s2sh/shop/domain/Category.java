package com.jyx.s2sh.shop.domain;

public class Category {
    private Integer id;
    private String name;
    private Boolean hot;
    
    private Account account;
    
    //ids获取
    private String ids;

	

	public Category(Integer id, String name, Boolean hot) {
		super();
		this.id = id;
		this.name = name;
		this.hot = hot;
	}
    
	public Category() {
		super();
	}

	@Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", hot=" + hot + "]";
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getHot() {
        return hot;
    }
    public void setHot(Boolean hot) {
        this.hot = hot;
    }
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
}
