package ua.kiev.inspector_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ua.kiev.inspector_api.service.InspectorTaskService;

@RestController
@RequestMapping(value="/api/", produces="text/plain;charset=UTF-8")
public class Design {
	
	@Autowired
	private InspectorTaskService inspectorTaskService;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(value="objects")
	public String getObjects(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return gson.toJson(inspectorTaskService.fullTaskUser(username));
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
