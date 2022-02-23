package com.web.exercise.test.vo;

public class OrderRequest {

	private String orderRequestNo;
	private String orderRequestDate;
	private String itemNm;

	public String getOrderRequestNo() {
		return orderRequestNo;
	}

	public void setOrderRequestNo(String orderRequestNo) {
		this.orderRequestNo = orderRequestNo;
	}

	public String getOrderRequestDate() {
		return orderRequestDate;
	}

	public void setOrderRequestDate(String orderRequestDate) {
		this.orderRequestDate = orderRequestDate;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	@Override
	public String toString() {
		return "OrderRequest [orderRequestNo=" + orderRequestNo + ", orderRequestDate=" + orderRequestDate + ", itemNm="
				+ itemNm + "]";
	}

}
