package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class IncidentCentre {
	
	@Id
	@GeneratedValue
	
	private int incidentId;
	
	@NotNull
    @Size(min=1,max=100)
	private String jobDescription;
	
	
    @Size(min=1,max=100)
	private String incidentName;
	
	
    @Size(min=3,max=4)
	private String anyInjuries;
	
	
    @Size(min=3,max=100)
	private String injuryDescription;
	
	public IncidentCentre ()
	{
		
	}

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getIncidentName() {
		return incidentName;
	}

	public void setIncidentName(String incidentName) {
		this.incidentName = incidentName;
	}

	public String getAnyInjuries() {
		return anyInjuries;
	}

	public void setAnyInjuries(String anyInjuries) {
		this.anyInjuries = anyInjuries;
	}

	public String getInjuryDescription() {
		return injuryDescription;
	}

	public void setInjuryDescription(String injuryDescription) {
		this.injuryDescription = injuryDescription;
	}

	
	
	
	
}
