package com.example.todoserver.service;

import com.example.todoserver.model.TodoEntity;
import com.example.todoserver.model.TodoRequest;
import com.example.todoserver.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }
//1. todo 리스트 목록에 아이템을 추가
//2. todo 리스트 목록 중 특정 아이템을 조회
//3. todo 리스트 전체 목록을 조회
//4. todo 리스트 목록 중 특정 아이템을 수정
//5. todo 리스트 목록 중 특정 아이템을 삭제
//6. todo 리스트 전체 목록을 삭제

    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if(request.getTitle() != null){
            todoEntity.setTitle(request.getTitle());
        }
        if(request.getOrder() != null) {
            todoEntity.setOrder(request.getOrder());
        }
        if(request.getCompleted() != null) {
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id); // 반환값 없는 메소드임

    }
    public void deleteAll() {
        this.todoRepository.deleteAll();
    }
}
