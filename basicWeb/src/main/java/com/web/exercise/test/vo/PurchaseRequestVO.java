package com.web.exercise.test.vo;

public class PurchaseRequestVO {

	private String purchaseRequestNo;
	private String purchaseRequestDate;
	private String purchaseRequestItem;

	public String getPurchaseRequestNo() {
		return purchaseRequestNo;
	}

	public void setPurchaseRequestNo(String purchaseRequestNo) {
		this.purchaseRequestNo = purchaseRequestNo;
	}

	public String getPurchaseRequestDate() {
		return purchaseRequestDate;
	}

	public void setPurchaseRequestDate(String purchaseRequestDate) {
		this.purchaseRequestDate = purchaseRequestDate;
	}

	public String getPurchaseRequestItem() {
		return purchaseRequestItem;
	}

	public void setPurchaseRequestItem(String purchaseRequestItem) {
		this.purchaseRequestItem = purchaseRequestItem;
	}

	@Override
	public String toString() {
		return "PurchaseRequestVO [purchaseRequestNo=" + purchaseRequestNo + ", purchaseRequestDate="
				+ purchaseRequestDate + ", purchaseRequestItem=" + purchaseRequestItem + "]";
	}

}
