package ua.kiev.inspector_api.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ua.kiev.inspector.model.dao.DaoFactory;
import ua.kiev.inspector.model.dao.InspectorRegionDao;
import ua.kiev.inspector.model.dao.InspectorStatusDao;
import ua.kiev.inspector.model.dao.InspectorStatusObjectDao;
import ua.kiev.inspector.model.dao.InspectorTypeObjectDao;

@RestController
@RequestMapping(value="/api/", produces="text/plain;charset=UTF-8")
@Transactional
public class Accessory {
	
	@Autowired
	private DaoFactory daoFactory;
	
	@Autowired
	private Gson gson;
	
	@RequestMapping(value = "districs")
	private String getAllDistrics() {
		InspectorRegionDao inspectorRegionDao = daoFactory.createInspectorRegionDao();
		return gson.toJson(inspectorRegionDao.allInspectorRegion());
	}
	
	@RequestMapping(value = "typeObject")
	private String getLitTypeObjects() {
		InspectorTypeObjectDao inspectorTypeObjectDao = daoFactory.createInspectorTypeObjectDao();
		String jsonResult = gson.toJson(inspectorTypeObjectDao.allTypeObject());
		return jsonResult;
	}
	
	@RequestMapping(value = "statys")
	private String putInspectorStatys() {
		InspectorStatusDao inspectorStatysDao = daoFactory.createInspectorStatusDao();
		return gson.toJson(inspectorStatysDao.getListStatys());
	}
	
	@RequestMapping(value = "statysObject")
	private String putInspectorStaysObject() {
		InspectorStatusObjectDao statysObject = daoFactory.createInspectorStatusObjectDao();
		return gson.toJson(statysObject.allInspectorStatusObject());
	}

}
