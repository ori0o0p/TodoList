package com.dsm.todolist.external.web.rest;

import com.dsm.todolist.external.web.docs.TodoListDocs;
import com.dsm.todolist.external.web.rest.request.TodoListElementSaveRequest;
import com.dsm.todolist.external.web.rest.response.TodoListElementResponse;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import com.dsm.todolist.internal.core.usecase.TodoListUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/todo")
class TodoListRestController implements TodoListDocs {

    private final TodoListUseCase todoListUseCase;

    @PostMapping
    public void add(final TodoListElementSaveRequest request) {
        todoListUseCase.add(request.todo());
    }

    @DeleteMapping("/{key}")
    public void remove(@PathVariable final Key key) {
        todoListUseCase.remove(key);
    }

    @PutMapping("/init")
    public void init() {
        todoListUseCase.init();
    }

    @GetMapping
    public List<TodoListElementResponse> getAll() {
        return todoListUseCase.getAll()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

    @GetMapping("/successful")
    public List<TodoListElementResponse> getSuccessfulTodoList() {
        return todoListUseCase.getSuccessfulTodoList()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

    @GetMapping("/unsuccessful")
    public List<TodoListElementResponse> getUnSuccessfulTodoList() {
        return todoListUseCase.getUnSuccessfulTodoList()
                .stream()
                .map(TodoListElementResponse::fromDTO)
                .toList();
    }

}
