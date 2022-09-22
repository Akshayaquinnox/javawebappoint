package com.akshaya.appoint;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class appointment {
	private String doctor;
	private String patient;
	private String status;

	public appointment(String doctor, String patient, String status) {
		
		this.doctor = doctor;
		this.patient = patient;
		this.status = status;
	}
public appointment() {
		
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getPatient() {
		return patient;
	}

	public void setPatient(String patient) {
		this.patient = patient;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "appointment [doctor=" + doctor + ", patient=" + patient + ", status=" + status + "]";
	}
	
}
