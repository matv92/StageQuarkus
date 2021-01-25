package com.farnetworks.quarkus.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Person", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "fiscalCode"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
@Getter
@Setter 
@NoArgsConstructor @AllArgsConstructor 
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "fiscalCode")
	private String fiscalCode;
	
	private String email;
	
	private String gender;
	
	private String name;
	
	private String surname;
	
	private String address;

	
}
