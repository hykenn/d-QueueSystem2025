package com.sys.queue.repository;

import com.sys.queue.model.QueueList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface QueueListRepository extends JpaRepository<QueueList, Integer> {

    // Get the latest quenum (if exists)
    @Query("SELECT MAX(q.quenum) FROM QueueList q")
    Integer getLatestQuenum();

    // Get all quenum values
    @Query("SELECT q.quenum FROM QueueList q")
    List<Integer> findAllQuenum();

    // Get all officeto values
    @Query("SELECT q.officeto FROM QueueList q")
    List<String> findAllOfficeto();
}
