package com.project.SafetyManagementSystem;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.IncidentCentreService;
import com.model.*;


import junit.framework.Assert;
@SpringBootTest
class IncidentCentreTest {
	@Autowired
	IncidentCentreService service;

	@Test
	void testAddIncident() {
		IncidentCentre centre=new IncidentCentre();
		centre.setJobDescription("Developer");
		centre.setIncidentName("Impact");
		centre.setAnyInjuries("Yes");
		centre.setInjuryDescription("Impact on head");
	    service.addIncident(centre);
	IncidentCentre st=service.findCentre(centre.getIncidentId());
	Assert.assertEquals("Developer", st.getJobDescription());
	Assert.assertEquals("Impact",st.getIncidentName());
	Assert.assertEquals("Yes",st.getAnyInjuries());
	Assert.assertEquals("Impact on head", st.getInjuryDescription());
	
	
	}

	@Test
	void testFindCentre() {
		IncidentCentre centre=new IncidentCentre();
		centre.setInjuryDescription("Hand Fracture");
		try {
			service.addIncident(centre);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		IncidentCentre centre2=service.findCentre(centre.getIncidentId());
		Assert.assertNull(centre2);
		
	}

	@Test
	void testFindAllCentre() {
		IncidentCentre centre=new IncidentCentre();
		centre.setJobDescription("Tester");
		centre.setIncidentName("Headache");
		centre.setAnyInjuries("No");
		centre.setInjuryDescription("Headache");
		service.addIncident(centre);
		
		IncidentCentre centre1=new IncidentCentre();
		centre.setJobDescription("Bake");
		centre.setIncidentName("Toothache");
		centre.setAnyInjuries("No");
		centre.setInjuryDescription("Tooth Pain");
		service.addIncident(centre1);
		
		IncidentCentre centre2=new IncidentCentre();
		centre.setJobDescription("Coder");
		centre.setIncidentName("Leg pain");
		centre.setAnyInjuries("Yes");
		centre.setInjuryDescription("Fracture");
		service.addIncident(centre2);
		
		List<IncidentCentre> centrelist=service.findAllCentre();
		centrelist.get(0).getIncidentName();
		Assert.assertEquals(centrelist.get(0).getIncidentName(), "Impact");
		Assert.assertEquals(centrelist.get(1).getIncidentName(), "Headache");
		Assert.assertEquals(centrelist.get(2).getIncidentName(), "Toothache");
		Assert.assertEquals(centrelist.get(3).getIncidentName(), "Leg Pain");
	}

	@Test
	void testUpdateCentre() {
		IncidentCentre centre1=new IncidentCentre();
		centre1.setJobDescription("Analyst");
		centre1.setIncidentName("Head Injury");
		centre1.setAnyInjuries("Yes");
		centre1.setInjuryDescription("Impact on Head");
		service.addIncident(centre1);
		centre1.setAnyInjuries("No");
		service.updateCentre(centre1);
		Assert.assertEquals(true, service.updateCentre(centre1));
	}

	@Test
	void testDeleteCentre() {
		service.deleteCentre(2);
		IncidentCentre centre=service.findCentre(2);
		Assert.assertNull(centre);
		
	}

}
