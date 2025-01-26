package com.sys.queue.controller;

import com.sys.queue.model.QueueUser;
import com.sys.queue.service.QueueUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/queue")  // Base URL for the REST API
public class QueueUserController {

    @Autowired
    private final QueueUserService queueUserService;

    public QueueUserController(QueueUserService queueUserService) {
        this.queueUserService = queueUserService;
    }

    // Endpoint to save a QueueUser
    @PostMapping("/createuser")
    public ResponseEntity<QueueUser> saveQueueUser(@RequestBody QueueUser queueUser) {
        QueueUser savedQueueUser = queueUserService.saveQueueUser(queueUser);
        return new ResponseEntity<>(savedQueueUser, HttpStatus.CREATED);
    }

    // Endpoint to get all QueueUser entities
    @GetMapping("/allusers")
    public ResponseEntity<List<QueueUser>> getAllQueueUsers() {
        List<QueueUser> queueUsers = queueUserService.getAllQueueUsers();
        return ResponseEntity.ok(queueUsers);
    }
}
