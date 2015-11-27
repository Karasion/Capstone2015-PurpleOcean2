package kr.ac.kookmin.cs.BSA;

public class BSAModel {
	private String alertType;

	public BSAModel()
	{
		this.alertType = "safe";
	}

	public String getAlertType() { return alertType; }

	public void setAlertType(String alertType) { this.alertType = alertType; }
}
