package com.sys.queue.repository;

import com.sys.queue.model.QueueOfficeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QueueOfficeListRepository extends JpaRepository<QueueOfficeList, Integer> {

    // Custom query to fetch all officeto for a specific quenum
    @Query("SELECT q.officeto FROM QueueOfficeList q WHERE q.quenum = :quenum")
    List<String> findOfficesByQuenum(Integer quenum);


    // Custom query to fetch all quenum, officeto, and priority for a specific officeto
    @Query("SELECT q.quenum, q.officeto, q.priority FROM QueueOfficeList q WHERE q.officeto = :officeto AND q.updatedat IS NULL")
    List<Object[]> findQuenumAndOfficesAndPriorityByOfficeto(String officeto);
    

    // Find QueueOfficeList by foreign key (QueueList ID)
    List<QueueOfficeList> findByQueueListId(Integer queueListId);
}
