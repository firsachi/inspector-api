package ua.kiev.inspector_api.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorTaskDao;
import ua.kiev.inspector.model.entity.InspectorTask;
import ua.kiev.inspector_api.model.UserPrincipalModel;

@RestController
@RequestMapping(value="/api/", produces="text/plain;charset=UTF-8")
public class Design {
	
	@Autowired
	private DaoFactory daoFactory;
	
	@RequestMapping(value="objects")
	public String getObjects(){
		InspectorTaskDao inspectorTaskDao = daoFactory.createInspectorTaskDao();
		JSONArray array = new JSONArray();	
		UserPrincipalModel user = (UserPrincipalModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (InspectorTask inspectorTask : inspectorTaskDao.getAllRisoDoc(user.getUserId())){
			JSONObject resultJson = new JSONObject();
			try {
				resultJson.put("idNumber", inspectorTask.getId());
				resultJson.put("street", inspectorTask.getStreet());
				resultJson.put("summary", inspectorTask);
				resultJson.put("created", inspectorTask.getDateDoc());
				array.put(resultJson);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array.toString();
	}
	/*
	@GetMapping(value="objects/{id}")
	public String getObject(@PathVariable int id){
		UserModel user = (UserModel)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		taskService.setUserEmail(user.getUserId());
		TaskModel taskModel = taskService.byId(id);
		JSONObject resultJson = new JSONObject();
		try {
			resultJson.put("idNumber", taskModel.getIdNumber());
			resultJson.put("district", "");
			resultJson.put("street", taskModel.getStreet());
			resultJson.put("bldg", taskModel.getBuild());
			resultJson.put("location", taskModel.getLocation());
			resultJson.put("lat", taskModel.getLat());
			resultJson.put("lng", taskModel.getLng());
			resultJson.put("photoURL", taskModel.getPhotoURL());
			resultJson.put("summary", taskModel.getSummary());
			resultJson.put("usrNotes", taskModel.getUsrNotes());
			resultJson.put("admNotes", taskModel.getAdmNotes());
			resultJson.put("created", taskModel.getCreated());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return resultJson.toString();
	}*/
}
