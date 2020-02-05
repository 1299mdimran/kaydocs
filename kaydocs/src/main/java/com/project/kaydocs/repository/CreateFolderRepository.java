package com.project.kaydocs.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.kaydocs.entities.Folder;



public interface CreateFolderRepository extends JpaRepository< Folder , Long > {
	
	Optional<Folder> findById(Long id);
	//CreateFolder findById(Long id);
 void deleteById(Long folderId);

	
}
