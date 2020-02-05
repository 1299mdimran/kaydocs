 package com.project.kaydocs.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.kaydocs.entities.Document;

public interface UploadDocumentRepository extends JpaRepository<Document , Long> {
	
	Optional<Document> findById(Long id);

	//UploadDocument findById(Long id);

	
}
