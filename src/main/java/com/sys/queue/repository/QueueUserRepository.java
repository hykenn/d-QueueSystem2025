package com.sys.queue.repository;

import com.sys.queue.model.QueueUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueueUserRepository extends JpaRepository<QueueUser, Integer> {
    // No need for any custom methods here unless needed
}
