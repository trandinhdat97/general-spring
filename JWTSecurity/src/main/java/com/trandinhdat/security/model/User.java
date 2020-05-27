package com.trandinhdat.security.model;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
@Data
@Entity
@Table(name = "userforum")
public class User implements UserDetails {

	private static final long serialVersionUID = 1L;

	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotEmpty
	    @Column(unique = true)

	    private String username;

	    @NotEmpty
	    @Column(unique = true)
	    @Email

	    private String email;
	    @NotEmpty
	  
	    @Column(unique = true)
	    private String dislayname;

	    private String telephone;


	    @NotEmpty
	    private String password;



	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "date_of_registration")
	    private Date dateOfRegistration;
	    
	    @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	            name = "ROLE_ASSIGNMENTS",
	            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})

	    private Set<Role> roleforums;

	    public boolean getHasRoleById(Long roleId) {
	        for (Role roleforum : roleforums) {
	            if (roleforum.getId().equals(roleId)) {
	                return true;
	            }
	        }
	        return false;
	    }

	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return roleforums;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
	
		return true;
	}

}
