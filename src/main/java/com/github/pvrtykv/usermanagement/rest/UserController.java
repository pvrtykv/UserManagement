package com.github.pvrtykv.usermanagement.rest;

import com.github.pvrtykv.usermanagement.model.User;
import com.github.pvrtykv.usermanagement.entity.UserEntity;
import com.github.pvrtykv.usermanagement.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    UserService userService;

    @Operation(summary = "Creates new user")
    @ApiResponse(responseCode = "201", description = "Successfully created new user.")
    @PostMapping
    public ResponseEntity<UserEntity> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @Operation(summary = "Retrieves user by uuid")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved user.")
    @GetMapping("/{uuid}")
    public ResponseEntity<UserEntity> getUserByUuid(@PathVariable("uuid") String uuid) {
        return new ResponseEntity<>(userService.findByUuid(uuid), HttpStatus.OK);
    }

    @Operation(summary = "Retrieves all users")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved users.")
    @GetMapping()
    public ResponseEntity<List<UserEntity>> getUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Deletes user by uuid")
    @ApiResponse(responseCode = "204", description = "Successfully deleted user.")
    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable("uuid") String uuid) {
       userService.deleteByUuid(uuid);
    }

    @Operation(summary = "Deleted all users")
    @ApiResponse(responseCode = "204", description = "Successfully deleted users.")
    @DeleteMapping()
    public void deleteUsers() {
       userService.deleteAll();
    }

}
