package com.rajat.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.rajat.entity.CAATCWBTranslationInboxSetup;

@Repository
public interface CAATCWBTranslationInboxSetupRepo extends MongoRepository<CAATCWBTranslationInboxSetup, String>{
	
	@Query(value = "{projectCode:?0,product:?1}",sort = "{updatedDate : -1}")
	public List<CAATCWBTranslationInboxSetup> findByProjectCodeAndProduct(String projectCode, String product);
	@Query(value = "{project_UUID:?0}",sort = "{updatedDate : -1}")
	public List<CAATCWBTranslationInboxSetup> findByProject_UUID(String project_UUID);

	@Query(value = "{projectCode:?0,product:?1}", delete = true)
	public void deleteByProjectCodeAndProduct(String projectCode,String product);
	
	@Query(value = "{projectCode:?0}", delete = true)
	public void deleteByProjectCode(String projectCode);

	@Query("{projectCode:?0}")
	public List<CAATCWBTranslationInboxSetup> findByProjectCode(String projectCode);
	
	@Query("{caat_cwb_workflow_UUID:?0 }")
	CAATCWBTranslationInboxSetup findByWorkflowUUID(String caat_cwb_workflow_UUID);
	
	@Query("{ product:?0 , projectCode:?1 , locale:?2 }")
	public CAATCWBTranslationInboxSetup findByProductProjectCodeAndLocale(String product, String projectCode, String loc);
	@Query("{ project_UUID:?0 , locale:?1 }")
	public CAATCWBTranslationInboxSetup findByProject_UUIDAndLoc(String project_UUID, String loc);

	@Query("{caat_cwb_workflow_UUID:?0 }")
	public CAATCWBTranslationInboxSetup findByCaatCwbWorkflowUUID(String caat_cwb_workflow_UUID);
	
	@Query("{projectCode:?0 , product:?1, project_UUID:?2}")
	public List<CAATCWBTranslationInboxSetup> findAllByProjectCodeProductAndproject_UUID(String projectCode,
			String product, String project_UUID);

}
