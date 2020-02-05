package com.project.kaydocs.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.kaydocs.config.KayDocAppConfig;
import com.project.kaydocs.entities.Folder;
import com.project.kaydocs.entities.Document;

@Service
public class KayDocService<HttpPost, builder, MultipartEntityBuilder, CloseableHttpClient> {

	@SuppressWarnings("rawtypes")
	@Autowired
	KayDocAppConfig kayDocAppConfig;
	

	public Object getkayDocDirectorList() {

		Object obj = kayDocAppConfig.callKayDocRestApi(
				"http://180.179.206.28:8080/services/rest/folder/listChildren?folderId=4", "admin:admin");

		return obj;
	}

	public void createFolder(String folderName) {
		System.out.println("create folder == " + folderName);
		Folder cr = new Folder();
		/*
		 * httpsession autowired get httpsession.getuser User
		 * user=(User)httpSession.getAttribute("user"); 
		 * String userpas="user.getusernam+":"+"user.getpassowrd";
		 */
		cr.setFolderName(folderName);
		kayDocAppConfig.callKayDocRestApiPost("http://180.179.206.28:8080/services/rest/folder/createFolder",
				"admin:admin", cr);

		// return obj;
	}
	    public void uploadDocument(MultipartFile filedata,String filename,Long folderId) {
		Document ud= new Document();
		ud.setFileData(filedata);
		ud.setFilename(filename);
		ud.setFolderId(folderId);
		kayDocAppConfig.callKayDocRestApiPostUploadDocument("http://180.179.206.28:8080/services/rest/document/upload", "admin:admin", ud);

	}
	    public Object documentList(Long folderId) {
	    	Document ud= new Document();
	    	ud.setFolderId(folderId);
	   
	    	
	    
	    	

		Object obj=   kayDocAppConfig.callKayDocListDoc("http://180.179.206.28:8080/services/rest/document/list?folderId="+folderId, "admin:admin",ud);
			return obj;
	   
			
	    }
	    
	    public void deleteFolder(Long folderId) {
	    	Folder ud= new Folder();
	    	ud.setFolderId(folderId);
	        kayDocAppConfig.deleteKayDocFolder("http://180.179.206.28:8080/services/rest/folder/delete?folderId="+folderId, "admin:admin",ud);
	    }
	    
	    public void renameFolder(Long folderId,String name) {
	    	Folder ud= new Folder();
	    	ud.setFolderId(folderId);
	    	ud.setName(name);
	        kayDocAppConfig.renameKayDocFolder("http://180.179.206.28:8080//services/rest/folder/rename?folderId="+folderId+"&name="+name, "admin:admin",ud);
	    }
			
	   
}

