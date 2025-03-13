package com.dsm.todolist.internal.data.repository;

import com.dsm.todolist.external.web.rest.response.TodoListElementKeyResponse;
import com.dsm.todolist.internal.common.random.RandomStringUtils;
import com.dsm.todolist.internal.core.domain.model.dto.TodoListElementDTO;
import com.dsm.todolist.internal.core.domain.model.primitive.IsSuccess;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.domain.model.primitive.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Repository
class TodoListRepositoryImpl implements TodoListRepository {

    private final ConcurrentHashMap<String, TodoListElementEntity> database = new ConcurrentHashMap<>();

    @Override
    public Key save(final Todo todo) {
        final String key = RandomStringUtils.generate(12);
        database.put(
                key,
                new TodoListElementEntity(todo)
        );

        return new Key(key);
    }

    @Override
    public void save(final TodoListElementDTO dto) {
        database.put(
                dto.key().value(),
                new TodoListElementEntity(
                        dto.todo().value(),
                        dto.isSuccess().value()
                )
        );
    }

    @Override
    public List<TodoListElementDTO> findAll() {
        return database.entrySet()
                .stream()
                .map(element -> new TodoListElementDTO(
                        new Key(element.getKey()),
                        new Todo(element.getValue().todo()),
                        IsSuccess.getInstance(element.getValue().isSuccess())
                ))
                .toList();
    }

    @Override
    public List<TodoListElementDTO> findSuccessfulTodoList() {
        return database.entrySet()
                .stream()
                .filter(element -> element.getValue().isSuccess())
                .map(element -> new TodoListElementDTO(
                        new Key(element.getKey()),
                        new Todo(element.getValue().todo()),
                        IsSuccess.getTrueInstance()
                ))
                .toList();
    }

    @Override
    public List<TodoListElementDTO> findUnSuccessfulTodoList() {
        return database.entrySet()
                .stream()
                .filter(element -> !element.getValue().isSuccess())
                .map(element -> new TodoListElementDTO(
                        new Key(element.getKey()),
                        new Todo(element.getValue().todo()),
                        IsSuccess.getFalseInstance()
                ))
                .toList();
    }

    @Override
    public void delete(final Key key) {
        database.remove(key.value());
    }

    @Override
    public void deleteAll() {
        database.clear();
    }

    @Override
    public TodoListElementDTO findById(final Key key) {
        final TodoListElementEntity element = database.get(key.value());

        return new TodoListElementDTO(
                key,
                new Todo(element.todo()),
                IsSuccess.getInstance(element.isSuccess())
        );
    }

}
