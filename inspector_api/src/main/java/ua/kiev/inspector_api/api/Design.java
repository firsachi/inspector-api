package ua.kiev.inspector_api.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import ua.kiev.inspector_api.model.CompleteTaskModel;
import ua.kiev.inspector_api.model.UserPrincipalModel;
import ua.kiev.inspector_api.service.InspectorTaskService;

@RestController
@RequestMapping(value="/api/", produces="text/plain;charset=UTF-8")
public class Design {
	
	@Autowired
	private InspectorTaskService inspectorTaskService;
	
	@Autowired
	private Gson gson;
	
	@Resource(mappedName = "fileStorage/basePath")
	 private String basePath;
	
	@RequestMapping(value="objects")
	public String getObjects(){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		return gson.toJson(inspectorTaskService.fullTaskUser(username));
	}
	
	
	@RequestMapping(value = "images/{id}", method=RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE )
	public @ResponseBody byte[] getImage(@PathVariable("id") int id) throws IOException {
		UserPrincipalModel user = (UserPrincipalModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		CompleteTaskModel model = inspectorTaskService.getTask(id, user);
		File file = new File(basePath, model.getPhoto());
		byte array[];
		if (!file.exists()) {
		      throw new FileNotFoundException("File " + file + " does not exist");
		  };
		try (FileInputStream imageInFile = new FileInputStream(file)){
			array = new byte[(int) file.length()];
			imageInFile.read(array);
		}
		return array;
	}
	
	
	@GetMapping(value="objects/{id}")
	public String getObject(@PathVariable int id){
		UserPrincipalModel user = (UserPrincipalModel) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return gson.toJson(inspectorTaskService.getTask(id, user));
	}
}
