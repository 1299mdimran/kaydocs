package com.project.kaydocs.config;
import com.project.kaydocs.entities.Document;
import com.project.kaydocs.entities.Folder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KayDocAppConfig<ByteArrayResource> {


		public Object callKayDocRestApi(String url, String credintials) {
		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<String> request = new HttpEntity<String>(headers);
		// String url
		// ="http://localhost:8090/services/rest/folder/listChildren?folderId=4";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}

	public Object callKayDocRestApiPost(String url, String credintials, Folder create) {
		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);

		// HttpHeaders headers= new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		map.add("parentId", "4");
		map.add("name", create.getFolderName());
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		//@SuppressWarnings("rawtypes")

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST, request, Object.class);
		System.out.println("response == " + response);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}

	
	public Object callKayDocRestApiPostUploadDocument(String url, String credintials, Document u) {

		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		System.out.println("call api ");
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);

		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

		File convFile = new File(u.getFiledata().getOriginalFilename());
		try {
			convFile.createNewFile();
		} catch (IOException e) { // TODO Auto-generated
			e.printStackTrace();
		}
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(convFile);
			fos.write(u.getFiledata().getBytes());
			fos.close();
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

		map.add("folderId", u.getFolderId());
		map.add("filedata",convFile);

		map.add("filename", u.getFilename());

		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("restTemplate==" + restTemplate);

		@SuppressWarnings("rawtypes")
		ResponseEntity response = restTemplate.exchange(url, HttpMethod.POST, request, Integer.class);
		System.out.println("response == " + response);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));

		} catch (JsonProcessingException e) {

			e.printStackTrace();
		}
		return account;
	}
        
	
	public Object callKayDocListDoc(String url, String credintials,Document udt ) {
		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.setContentType(MediaType.APPLICATION_JSON);
		//MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
		//map.add("folderId", udt.getFolderId());
		
		//HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>>(map, headers);
		HttpEntity<Object> request = new HttpEntity<Object>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.GET, request, Object.class);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}
	
	
	public Object deleteKayDocFolder(String url, String credintials,Folder cf ) {
		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> request = new HttpEntity<Object>(headers);
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("rawtypes")
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.DELETE, request, Object.class);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}
	
	public Object renameKayDocFolder(String url, String credintials,Folder cf ) {
		String plainCreds = credintials; // "admin:admin";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> request = new HttpEntity<Object>(headers);
		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("rawtypes")
		ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT, request, Object.class);
		Object account = response.getBody();
		try {
			System.out.println("res == " + new ObjectMapper().writeValueAsString(response));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return account;

	}
	
	
	

}


