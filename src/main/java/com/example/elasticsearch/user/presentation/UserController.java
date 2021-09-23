package com.example.elasticsearch.user.presentation;

import com.example.elasticsearch.user.application.UserRequestDto;
import com.example.elasticsearch.user.application.UserService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<Void> save(@RequestBody UserRequest userRequest) {
        UserRequestDto userRequestDto = new UserRequestDto(
            userRequest.getName(),
            userRequest.getDescription()
        );
        Long id = userService.save(userRequestDto);
        URI uri = URI.create(String.valueOf(id));
        return ResponseEntity.created(uri)
            .build();
    }

    @GetMapping("/users/{name}")
    public ResponseEntity<List<UserResponse>> search(@PathVariable String name) {
        List<UserResponse> userResponses = userService.searchByName(name)
            .stream()
            .map(UserResponse::from)
            .collect(Collectors.toList());
        return ResponseEntity.ok(userResponses);
    }
}
