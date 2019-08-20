package com.cy.service;

import java.util.List;

import com.cy.entity.SysLog;

public interface SysLogService {
	


	int deleteObjects(Integer...ids);

	List<SysLog>dofindObject();
}
