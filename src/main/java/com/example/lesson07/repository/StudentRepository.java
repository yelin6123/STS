package com.example.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.lesson07.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer>{
	//String DATA JPA : JpaRepository => JPA와 다른 종류, 추가한 순간부터 메소드를 자동으로 맞추어줌
	//StudentRepositroy 로 불렀을 때 어느 Entity로 연결시켜 줄 것인지를 제네릭에 넣어줌
	//JpaRepository<StudentEntity, Integer>를 추가한 순간부터 creat, update, delete,  가 된다. 
	//<> : 제네릭
	// <우리가 셀렉한 데이터명, tk가 어떤 타입인가? -> id : int 이지만, JPA에서는 integer로>
	
	//기본적으로 있는 것
	//save() - id가 없으면 insert id가 있으면 update
	//findById() - 조회, select 
	//delete(객체-entity) - 삭제 , delete
	//findAll - 전체조회
	
	//JPQL 문법 (기본적으로 없는 메소드를 만들 경우)
	//예제 ex02-1
	public List<StudentEntity> findAllByOrderByIdDesc();
	
	public List<StudentEntity> findTop3ByOrderByIdDesc();
	
	public List<StudentEntity> findByName(String name);
	
	public List<StudentEntity> findByNameIn(List<String> names);

	public List<StudentEntity> findByNameAndDreamJob(String name, String dreamJob);
	
	public List<StudentEntity> findByEmailContaining(String email);
	
	public List<StudentEntity> findByNameStartingWith(String name);

	public List<StudentEntity> findByIdBetween(int start, int end);
	
	
	//예제 ex02-2
	//JPQL 문법 사용 이란 ? -> DB에 직접 접근하지 않고 Entity로 조회함
	//1) JPQL 엔티티로 조회 
	//@Query(value = "select st from new_student st where st.dreamJob = :dreamJob") //st : 별칭, entity
	//public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob); //임포트 시 mybatis가 아니라 Repository로 하기!
	
	//2) native query로 조회  (native : 순수한, 날것) - 레파짓토리가 직접 DB에 연결 
	@Query(value="select * from `new_student` where dreamJob = :dreamJob", nativeQuery = true) //단점 : 복잡한걸로 할때 보기 어려움 -> 이럴땐 마이바티스에서 해라!
	public List<StudentEntity> findByDreamJob(@Param("dreamJob") String dreamJob);
	
}
