package com.project.kaydocs.entities;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "uploadDocument")
public class Document {
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	// @SequenceGenerator(sequenceName = "dept_seq", allocationSize = 1, name =
	// "dept_seq")

	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Long docId;
	private String filename;
	private Long folderId;
	
	@Lob
	private MultipartFile filedata;
	private File file;
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public MultipartFile getFiledata() {
		return filedata;
	}

	public void setFileData(MultipartFile filedata) {
		this.filedata = filedata;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	@Column(name = "documentname")
    private String documentName;
	
	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long id) {
		this.folderId = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	
}
