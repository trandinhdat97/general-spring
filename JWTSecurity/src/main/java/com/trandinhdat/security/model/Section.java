package com.trandinhdat.security.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Data
@Table(name = "section")
public class Section implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@DateTimeFormat
	private Date date_of_publication;
	
	private String text;
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Section parent_id;
	
	@OneToMany(mappedBy = "parent_id",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	private Set<Section> subsection = new HashSet<>();
	
	public boolean getIsParent() {
        return (Objects.nonNull(subsection) && subsection.size() > 0);
    }
}
