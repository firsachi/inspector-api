package ua.kiev.inspector_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorTaskDao;
import ua.kiev.inspector_api.model.CompleteTaskModel;
import ua.kiev.inspector_api.model.TaskModel;
import ua.kiev.inspector_api.model.UserPrincipalModel;
import ua.kiev.inspector_api.transformers.TaskTransformer;

@Service
public class InspectorTaskService {

	@Autowired
	private DaoFactory daoFactory;
	
	@Autowired
	private TaskTransformer taskTransformer;
	
	public List<TaskModel> fullTaskUser(String email){
		InspectorTaskDao taskDao = daoFactory.createInspectorTaskDao();
		List<TaskModel> resultLisr = taskDao.getListTask(email).stream()
				.map(elment -> taskTransformer.entityToTaskModel(elment))
				.collect(Collectors.toList());
		return resultLisr;
	}
	
	public CompleteTaskModel getTask(int taskId, UserPrincipalModel user) {
		InspectorTaskDao taskDao = daoFactory.createInspectorTaskDao();
		CompleteTaskModel model = taskTransformer.entityToCompleteTaskModel(taskDao.byTask(taskId, user.getUsername()));
		return model;
	}
}
