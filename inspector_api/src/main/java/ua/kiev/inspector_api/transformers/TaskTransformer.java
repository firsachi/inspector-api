package ua.kiev.inspector_api.transformers;

import org.springframework.stereotype.Component;

import ua.kiev.inspector.model.entity.InspectorTask;
import ua.kiev.inspector_api.model.TaskModel;

@Component
public class TaskTransformer {

	public TaskModel entityToTaskModel(InspectorTask entity) {
		TaskModel model = new TaskModel();
		model.setIdNumber(entity.getId());
		model.setStreet(entity.getStreet());
		model.setCreated(entity.getDateDoc().toString());
		model.setSummary(entity.getOpis());
		return model;
	}

}
