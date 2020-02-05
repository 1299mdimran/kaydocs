package com.project.kaydocs.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "createfolder")
public class Folder {
	@Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	// @SequenceGenerator(sequenceName = "dept_seq", allocationSize = 1, name =
	// "dept_seq")

	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Long id;
	private Long folderId;
	
	public Long getFolderId() {
		return folderId;
	}
	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}
	@Column(name = "foldername")
    private String folderName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String foldername) {
		this.folderName = foldername;
	}
	
}
