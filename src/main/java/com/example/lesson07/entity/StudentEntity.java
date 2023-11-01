package com.example.lesson07.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString // (- extends Object) 객체를 출력할 때 모든 내용이 보여진다.
@AllArgsConstructor //파라미터가 모두 있는 생성자
@NoArgsConstructor //파라미터 없는 기본 생성 
@Getter
@Builder(toBuilder = true) //Setter의 대용, toBuilder true 수정 허용
@Entity(name = "new_student") // 이 객체는 엔티티다. (JPA와 DB 통신 사이에 위치!)
@Table(name="new_student") //엔티티의 이름이 클래스명이 DB의 테이블명으로 조회하게 되는데,이때 @Table로 DB의 table명을 알려줌
public class StudentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //id 가 자동적으로 번호가 붙여짐
	private int id;
	
	private String name;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	private String email;
	
	@Column(name = "dreamJob")
	private String dreamJob;
	
	@UpdateTimestamp //시간을 넣지 않아도 현재 시간으로 자동으로 들어감 NOW();
	@Column(name = "createdAt", updatable = false) //업데이트시 변경되지 않도록 설정 
	private ZonedDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name = "updatedAt")
	private ZonedDateTime updatedAt;
	
	
	
	
}
