package com.dao;

import org.springframework.stereotype.Repository;
import java.util.*;
import com.model.*;


@Repository
public interface IncidentCentreDAO {
	public void addIncident(IncidentCentre centre);
	public IncidentCentre findIncident(int id);
	public List<IncidentCentre> findAllIncident();
	public boolean updateIncident(IncidentCentre centre);
	public boolean deleteIncident(int id);

}
