package com.example.thymeleafpagination;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MyEntityController {

    private final MyEntityRepository myEntityRepository;

    public MyEntityController(MyEntityRepository myEntityRepository) {
        this.myEntityRepository = myEntityRepository;
    }

    @GetMapping("/simple-pagination")
    public String getPage(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        final var entities = myEntityRepository.findAll(pageable);
        model.addAttribute("page", entities);
        return "simple-pagination";
    }

    @GetMapping("/")
    public ResponseEntity<List<MyEntity>> getAll() {
        final var entities = myEntityRepository.findAll();
        return ResponseEntity.ok().body(entities);
    }

    @EventListener
    public void on(ApplicationStartedEvent event) {
        for (var i = 0; i < 200; i++) {
            var entity = new MyEntity();
            entity.setField(String.valueOf(i).repeat(10));
            myEntityRepository.save(entity);
        }
    }
}
