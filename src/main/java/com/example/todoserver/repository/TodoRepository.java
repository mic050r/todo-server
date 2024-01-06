package com.example.todoserver.repository;

import com.example.todoserver.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 레포지토리 : 데이터 베이스랑 데이터를 주고 받기 위한 인터페이스를 정의한 부분
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    /* 따라서 데이터베이스 테이블과 연결된 객체인 엔티티를 넣어주고 해당 객체의 ID에 해당하는 필드 타입을 넣어준다
    데이터 베이스에 엔티티 만 저장해주면 됨(리퀘스트나 리스폰스는 응답을 내려주기 위한 모델 즉, 그 데이터 들을 데이터베이스에 저장할 필요x) */
}
