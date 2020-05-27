package com.trandinhdat.security.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trandinhdat.security.model.Section;
@Repository
public interface SectionRepository extends JpaRepository<Section, Long>{
Set<Section> findByParent_id(Section section);
}
