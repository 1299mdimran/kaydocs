  package com.project.kaydocs.controllers;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.kaydocs.entities.Folder;
import com.project.kaydocs.entities.Document;
import com.project.kaydocs.repository.CreateFolderRepository;
import com.project.kaydocs.services.KayDocService;



@Controller
public class KayDocController {
	@Autowired
	CreateFolderRepository cfr;
	@SuppressWarnings("rawtypes")
	@Autowired
	KayDocService kayDocService;

	@GetMapping("/kaydoc-directory")
	public String root(Model model) {
		Object obj = kayDocService.getkayDocDirectorList();
		model.addAttribute("docList", obj) ;
		return "directoryList";
	}

	@GetMapping("/kaydoc-createFolder")
	public String createFolder() {
		kayDocService.createFolder("testing");
		return "directoryList";
	}

	@GetMapping("/createFolder")
	public String openCreateFolderPage(Model model) {
		// kayDocService.createFolder("testing");
		model.addAttribute("createFolder", new Folder());
		return "createFolder";
	}

	@RequestMapping(value = "/createFolder", method = RequestMethod.POST)
	public String createFolderInLogicalDoc(@RequestParam("folderName") String folderName) {
		try {
			System.out.println("obj=== " + new ObjectMapper().writeValueAsString(folderName));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		kayDocService.createFolder(folderName);
		return "directoryList";
	}

	@GetMapping("/uploadDocument")
	public String uploadDocument(Model model) {
		// kayDocService.uploadDocument("testing");
		model.addAttribute("uploadDocument", new Document());
		return "uploadDocument";
	}

    @RequestMapping(value ="/uploadDocument",method = RequestMethod.POST)
	public String uploadDocumentInLogicalDoc(@RequestParam("filename") String filename,
			@RequestParam("filedata") MultipartFile filedata,
			@RequestParam("folderId") Long folderId) /* , @RequestParam("documentName") String documentName) */ {

				kayDocService.uploadDocument(filedata, filename, folderId);

		return "directoryList";
	}
    @GetMapping("/DocumentList")
	public String DocOfLogicalDoc(Model model) {
    	model.addAttribute("listDocument", new Document());
		return "documentList";
	}
        @RequestMapping(value="/documentList", method = RequestMethod.POST)
        	public String listDocOfLogicalDoc(@RequestParam("folderId") Long folderId,Model model,Object obj) {
        	obj=kayDocService.documentList(folderId);
        	
    	model.addAttribute("document",obj);
        
    	return "listOfDocument";  
    }
        
        @GetMapping("/delete")
    	public String deleteFolder(Model model) {
        	model.addAttribute("createFolder",new Folder());
        	return "deleteFolder";
        	
        }

	/*
	 * @RequestMapping(value="/deleted", method = RequestMethod.POST) public String
	 * deleteFolderInLogicalDoc(@RequestParam("folderId") Long folderId,Model model)
	 * { model.addAttribute("createFolder",new Folder());
	 * System.err.println(folderId); //kayDocService.deleteFolder(folderId); return
	 * "folderdelete";
	 * 
	 * }
	 */
        @RequestMapping(value="/deleted", method = RequestMethod.POST)
    	public String deletedFolderInLogicalDoc(@PathParam("folderId") Long folderId)  {
        	
        	//return folderId;
//               Long obj=Long.parseLong(folderId);
        	System.err.println(folderId);
        	
            kayDocService.deleteFolder(folderId);
   		return "directoryList";

    	}
        
        @GetMapping("/renameFolder")
    	public String renameFolder(Model model) {
    		// kayDocService.uploadDocument("testing");
    		model.addAttribute("uploadDocument", new Folder());
    		return "renameFolder";
        }
        
        @RequestMapping(value = "/renamedFolder" , method = RequestMethod.POST)
        public String renamedFolder(@PathParam("folderId")Long folderId,@PathParam("name")String name) {
        	
        	System.err.println("folderId:"+folderId+"name="+name);
        	kayDocService.renameFolder(folderId, name);
        	
        	return "directoryList";
        	
        }

    
}
