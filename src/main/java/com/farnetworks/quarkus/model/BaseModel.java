package com.farnetworks.quarkus.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class BaseModel implements Serializable{

	private static final long serialVersionUID = -4161580587940768314L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
}
