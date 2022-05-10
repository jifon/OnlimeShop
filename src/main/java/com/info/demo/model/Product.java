package com.info.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column
	private String productName;
	
	private String productDescription;
	
	@Column
	private int productPrice;
	
	@Column
	private int productUnit;
	
	private String image;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id")
	private Category category = new Category();

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetailList;

//	@ManyToMany(mappedBy = "productList",fetch = FetchType.EAGER)
//	private List<User> userList;
	
	public Product() {
		this.productName = "";
		this.productDescription = "";
	}
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

//	public List<User> getUserList() {
//		return userList;
//	}
//
//	public void setUserList(List<User> userList) {
//		this.userList = userList;
//	}


	public List<OrderDetail> getOrderDetailList() {
		return orderDetailList;
	}

	public void setOrderDetailList(List<OrderDetail> orderDetailList) {
		this.orderDetailList = orderDetailList;
	}

	public int getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(int productUnit) {
		this.productUnit = productUnit;
	}
	
	
}
