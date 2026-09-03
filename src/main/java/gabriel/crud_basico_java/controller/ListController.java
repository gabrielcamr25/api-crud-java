package gabriel.crud_basico_java.controller;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ListController {
    private List<String> tsks = new ArrayList<>();
    private ObjectMapper  objectMapper;
    public ListController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @GetMapping(path="tasks/list")
    public ResponseEntity<String> listTasks() throws JsonProcessingException{
        System.out.println("Tarefas listadas com sucesso ");
        return ResponseEntity.ok(objectMapper.writeValueAsString(tsks));
    }
    @PostMapping(path="tasks/create")
    public ResponseEntity<Void> createTasks(@RequestBody String toDo){
        tsks.add(toDo);
        System.out.println("Tarefas adicionadas com sucesso");
        return ResponseEntity.ok().build();

    }
    @DeleteMapping(path="tasks/delete")
    public ResponseEntity<Void> clearTasks(){
        tsks =  new ArrayList<>();
        System.out.println("Tarefas removidas com sucesso");
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="tasks/edit")
    public ResponseEntity<Void> editTasks(){
        System.out.println("Tarefas editadas com sucesso");
        return ResponseEntity.ok().build();
    }
}