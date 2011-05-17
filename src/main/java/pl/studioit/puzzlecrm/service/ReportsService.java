package pl.studioit.puzzlecrm.service;


import java.util.List;

import pl.studioit.puzzlecrm.domain.Reports;

public interface ReportsService {
	public void initReports(int maxNumbers);
	public List<Reports> getReports();

}
