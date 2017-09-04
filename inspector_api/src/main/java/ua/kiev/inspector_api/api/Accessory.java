package ua.kiev.inspector_api.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorRegionDao;

import ua.kiev.inspector.model.dao.InspectorTypeObjectDao;
import ua.kiev.inspector.model.entity.InspectorRegion;
import ua.kiev.inspector.model.entity.InspectorTypeObject;

@RestController
@RequestMapping(value="/api/", produces="text/plain;charset=UTF-8")
@Transactional
public class Accessory {
	
	@Autowired
	private DaoFactory daoFactory;
	
	@RequestMapping(value = "districs")
	private String getAllDistrics() {
		InspectorRegionDao inspectorRegionDao = daoFactory.createInspectorRegionDao();
		JSONArray array = new JSONArray();
		for (InspectorRegion region : inspectorRegionDao.allInspectorRegion()) {
			JSONObject resultJson = new JSONObject();
			try {
				resultJson.put("id", region.getRegionId());
				resultJson.put("name", region.getName());
				array.put(resultJson);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array.toString();
	}
	
	@RequestMapping(value = "typeObject")
	private String getLitTypeObjects() {
		InspectorTypeObjectDao inspectorTypeObjectDao = daoFactory.createInspectorTypeObjectDao();
		JSONArray array = new JSONArray();
		for (InspectorTypeObject value : inspectorTypeObjectDao.allTypeObject()) {
			JSONObject resultJson = new JSONObject();
			try {
				resultJson.put("id", value.getTypeobjectId());
				resultJson.put("name", value.getName());
				array.put(resultJson);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		return array.toString();
	}

}
