package ua.kiev.inspector_api.transformers;

import org.springframework.stereotype.Component;

import ua.kiev.inspector.model.entity.InspectorTask;
import ua.kiev.inspector_api.model.CompleteTaskModel;
import ua.kiev.inspector_api.model.TaskModel;

@Component
public class TaskTransformer {
	
	private final String URL = "http://localhost:8080/inspector-api/api/images/";

	public TaskModel entityToTaskModel(InspectorTask entity) {
		TaskModel model = new TaskModel();
		return fiilTaskModel(model, entity);
	}
	
	public CompleteTaskModel entityToCompleteTaskModel(InspectorTask entity) {
		CompleteTaskModel model = fiilTaskModel(new CompleteTaskModel(), entity);
		model.setBuild(entity.getBuild());
		model.setLocation(entity.getLocAdd());
		model.setLat(entity.getY());
		model.setLng(entity.getX());
		model.setPhotoURL( URL + entity.getId());
		model.setPhoto(entity.getFotop());
		model.setUsrNotes(entity.getPrim());
		model.setAdmNotes(entity.getAnswer());
		return model;
	}
	
	private <T extends TaskModel> T fiilTaskModel(T model, InspectorTask entity) {
		model.setIdNumber(entity.getId());
		model.setStreet(entity.getStreet());
		model.setCreated(entity.getDateDoc().toString());
		model.setSummary(entity.getOpis());
		return model;
	}

}
