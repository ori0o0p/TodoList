package com.dsm.todolist.external.web.docs;

import com.dsm.todolist.external.web.rest.request.TodoListElementSaveRequest;
import com.dsm.todolist.external.web.rest.response.TodoListElementKeyResponse;
import com.dsm.todolist.external.web.rest.response.TodoListElementResponse;
import com.dsm.todolist.internal.core.domain.model.primitive.Key;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(
        name = "TodoList API Spec",
        description = "TodoList 관리를 위한 API"
)
public interface TodoListDocs {

    @Operation(summary = "Todo 추가", description = "새로운 Todo를 TodoList에 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "추가 성공"),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    TodoListElementKeyResponse add(
            @Parameter(description = "추가할 Todo 정보", required = true, schema = @Schema(implementation = TodoListElementSaveRequest.class))
            TodoListElementSaveRequest request
    );

    @Operation(summary = "Todo 삭제", description = "키를 기준으로 Todo를 삭제합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "삭제 성공"),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    void remove(
            @Parameter(description = "삭제할 Todo의 고유 키", required = true, schema = @Schema(implementation = Key.class))
            Key key
    );

    @Operation(summary = "TodoList 초기화", description = "모든 Todo를 삭제하고 TodoList를 초기화합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "초기화 성공"),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    void init();

    @Operation(summary = "Todo 완료", description = "Todo를 완료합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "완료 성공"),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content)
    })
    void success(Key key);

    @Operation(summary = "TodoList 조회", description = "등록된 TodoList를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TodoListElementResponse.class)))
    })
    List<TodoListElementResponse> getAll();

    @Operation(summary = "완료된 Todo 조회", description = "완료 처리된 TodoList를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TodoListElementResponse.class)))
    })
    List<TodoListElementResponse> getSuccessfulTodoList();

    @Operation(summary = "미완료된 Todo 조회", description = "아직 완료되지 않은 TodoList를 조회합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "조회 성공",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = TodoListElementResponse.class)))
    })
    List<TodoListElementResponse> getUnSuccessfulTodoList();

}