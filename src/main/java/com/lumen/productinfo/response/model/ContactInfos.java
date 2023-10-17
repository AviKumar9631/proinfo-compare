package com.lumen.productinfo.response.model;

public class ContactInfos {
	
	private String contactName;
	private String canBeReachedTN;
	private String note;
	
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getCanBeReachedTN() {
		return canBeReachedTN;
	}
	public void setCanBeReachedTN(String contactTN) {
		this.canBeReachedTN = contactTN;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	@Override
	public String toString() {
		return "ContactInfos : contactName "+this.contactName+" , canBeReachedTN : "+this.canBeReachedTN+" ,note : "+this.note;
	}
	
}
