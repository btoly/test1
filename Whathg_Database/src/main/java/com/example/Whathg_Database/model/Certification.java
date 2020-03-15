package com.example.Whathg_Database.model;



import java.io.Serializable;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.Whathg_Database.model.Individual.IndividualBuilder;

import lombok.Builder;
 
  @Entity
  @Table(name = "Certification")
  public class Certification implements Serializable {

	
	  @Id
	  @Column(name = "CERT_id")
		 private String CERT_id;
	  
	   @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
      @JoinColumn(name="NationalID",nullable=false)
      private Individual NationalID; 
	  
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "UNI_NAME")
	  private String UNI_NAME;
	  @NotNull(message = " cannot be Empty ")
	  
	  @Column(name = "ADDBY")
	  private String ADDBY; 
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "CERT_DATE")
	 private Timestamp   CERT_DATE;
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "GPA")
		 private int GPA ;
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "DEGREE")
		 private String DEGREE;
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "MAJOR")
		 private String MAJOR;
	  @NotNull(message = " cannot be Empty ")
	  @Column(name = "ATTACH")
		 private String ATTACH;

	  
	  
	  
	  
	  @Builder
		public Certification(String cERT_id, Individual nationalID, @NotNull(message = " cannot be Empty ") String uNI_NAME,
				@NotNull(message = " cannot be Empty ") String aDDBY,
				@NotNull(message = " cannot be Empty ") Timestamp cERT_DATE,
				@NotNull(message = " cannot be Empty ") int gPA, @NotNull(message = " cannot be Empty ") String dEGREE,
				@NotNull(message = " cannot be Empty ") String mAJOR,
				@NotNull(message = " cannot be Empty ") String aTTACH) {
			super();
			CERT_id = cERT_id;
			NationalID = nationalID;
			UNI_NAME = uNI_NAME;
			ADDBY = aDDBY;
			CERT_DATE = cERT_DATE;
			GPA = gPA;
			DEGREE = dEGREE;
			MAJOR = mAJOR;
			ATTACH = aTTACH;
		}

	public String getCert_id() {
		return CERT_id;
	}

	public void setCert_id(String cert_id) {
		this.CERT_id = CERT_id;
	}

	public Individual getNationalID() {
		return NationalID;
	}

	public void setNationalID(Individual nationalID) {
		NationalID = nationalID;
	}

	public String getUNI_NAME() {
		return UNI_NAME;
	}

	public void setUNI_NAME(String uNI_NAME) {
		UNI_NAME = uNI_NAME;
	}

	public String getADDBY() {
		return ADDBY;
	}

	public void setADDBY(String aDDBY) {
		ADDBY = aDDBY;
	}

	public Timestamp getCERT_DATE() {
		return CERT_DATE;
	}

	public void setCERT_DATE(Timestamp cERT_DATE) {
		CERT_DATE = cERT_DATE;
	}

	public int getGPA() {
		return GPA;
	}

	public void setGPA(int gPA) {
		GPA = gPA;
	}

	public String getDEGREE() {
		return DEGREE;
	}

	public void setDEGREE(String dEGREE) {
		DEGREE = dEGREE;
	}

	public String getMAJOR() {
		return MAJOR;
	}

	public void setMAJOR(String mAJOR) {
		MAJOR = mAJOR;
	}

	public String getATTACH() {
		return ATTACH;
	}

	public void setATTACH(String aTTACH) {
		ATTACH = aTTACH;
	}




	
	
	}