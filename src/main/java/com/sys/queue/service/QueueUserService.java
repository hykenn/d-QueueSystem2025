package com.sys.queue.service;

import com.sys.queue.model.QueueUser;
import com.sys.queue.repository.QueueUserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueueUserService {

    @Autowired
    private final QueueUserRepository queueUserRepository;

    public QueueUserService(QueueUserRepository queueUserRepository) {
        this.queueUserRepository = queueUserRepository;
    }

    // Save a QueueUser entity
    public QueueUser saveQueueUser(QueueUser queueUser) {
        return queueUserRepository.save(queueUser);
    }

    // Get all QueueUser entities
    public List<QueueUser> getAllQueueUsers() {
        return queueUserRepository.findAll();
    }
}
