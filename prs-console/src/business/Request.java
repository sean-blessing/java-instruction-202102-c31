package business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Request {
	private int id;
	private int userID;
	private String description;
	private String justification;
	private LocalDate dateNeeded;
	private String deliveryMode;
	private int statusID;
	private double total;
	private LocalDateTime submittedDate;
	
	public Request() {
		id = 0;
		userID = 0;
		description = "";
		justification = "";
		dateNeeded = LocalDate.now();
		deliveryMode = "";
		statusID = 1;
		total = 0.0;
		submittedDate = null;	
	}
	
	public Request(int inID, int inUserID, String inDescription, String inJustification, 
							LocalDate inLD, String inDlvMode, int inStatusID, double inTotal,
							LocalDateTime inSubmitDate) {
		id = inID;
		userID = inUserID;
		description = inDescription;
		justification = inJustification;
		dateNeeded = inLD;
		deliveryMode = inDlvMode;
		statusID = inStatusID;
		total = inTotal;
		submittedDate = inSubmitDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}
	public LocalDate getDateNeeded() {
		return dateNeeded;
	}
	public void setDateNeeded(LocalDate dateNeeded) {
		this.dateNeeded = dateNeeded;
	}
	public String getDeliveryMode() {
		return deliveryMode;
	}
	public void setDeliveryMode(String deliveryMode) {
		this.deliveryMode = deliveryMode;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public LocalDateTime getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(LocalDateTime submittedDate) {
		this.submittedDate = submittedDate;
	}
	
	@Override
	public String toString() {
		return "Request [id=" + id + ", userID=" + userID + ", description=" + description + ", justification="
				+ justification + ", dateNeeded=" + dateNeeded + ", deliveryMode=" + deliveryMode + ", statusID="
				+ statusID + ", total=" + total + ", submittedDate=" + submittedDate
				+ "]";
	}
	
}