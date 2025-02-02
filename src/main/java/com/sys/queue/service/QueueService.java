package com.sys.queue.service;

import com.sys.queue.model.QueueList;
import com.sys.queue.model.QueueOfficeList;
import com.sys.queue.repository.QueueListRepository;
import com.sys.queue.repository.QueueOfficeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QueueService {

    @Autowired
    private QueueListRepository queueListRepository;

    @Autowired
    private QueueOfficeListRepository queueOfficeListRepository;

    public void saveQueueAndQueueOfficeList(QueueOfficeList queueOfficeList) {
        Integer latestQuenum = queueListRepository.getLatestQuenum();
        Integer newQuenum = latestQuenum != null ? latestQuenum + 1 : 1;
    
        QueueList queueList = new QueueList();
        queueList.setQunem(newQuenum); 
        queueList.setOfficeto(queueOfficeList.getOfficeto());
        queueList.setPriority(queueOfficeList.getPriority());
        queueList.setCreatedat(LocalDateTime.now());
        queueList.setUpdatedat(null);  
        queueList.setDeletedat(null);  
        queueList = queueListRepository.save(queueList);
    
        // Set the queue list and other details
        queueOfficeList.setQunem(newQuenum);  
        queueOfficeList.setQueueList(queueList);
        queueOfficeList.setCreatedat(LocalDateTime.now());
        queueOfficeList.setUpdatedat(null);  
    
        // Ensure status is set to 1
        queueOfficeList.setStatus(1);  // Explicitly setting the status if desired
    
        // Save the QueueOfficeList with the status set to 1
        queueOfficeListRepository.save(queueOfficeList);
    }
    


        //update data from queuelist and old data in queueofficelist
        public void updateQueueAndInsertQueueOfficeList(Integer queueListId, QueueList updatedQueueList) {
            QueueList existingQueueList = queueListRepository.findById(queueListId)
            .orElseThrow(() -> new RuntimeException("QueueList not found"));
            Integer existingQuenum = existingQueueList.getQunem();
            LocalDateTime newUpdatedAt = LocalDateTime.now();
            existingQueueList.setOfficeto(updatedQueueList.getOfficeto());
            existingQueueList.setPriority(updatedQueueList.getPriority());
            existingQueueList.setUpdatedat(newUpdatedAt); 
            queueListRepository.save(existingQueueList);

            List<QueueOfficeList> queueOfficeLists = queueOfficeListRepository.findByQueueListId(queueListId);

            if (queueOfficeLists != null && !queueOfficeLists.isEmpty()) {
                QueueOfficeList lastQueueOfficeList = queueOfficeLists.get(queueOfficeLists.size() - 1);
                lastQueueOfficeList.setUpdatedat(newUpdatedAt);
                queueOfficeListRepository.save(lastQueueOfficeList); 
            } else {
                System.out.println("No existing QueueOfficeList found for QueueList ID: " + queueListId);
            }
            QueueOfficeList newQueueOfficeList = new QueueOfficeList(
                existingQuenum, 
                updatedQueueList.getOfficeto(),
                updatedQueueList.getPriority(),
                LocalDateTime.now(),
                null,
                null, 
                existingQueueList
        );
        queueOfficeListRepository.save(newQueueOfficeList);
        }

    
    
        // Soft delete method
        public void softDeleteQueue(Integer queueListId) {
            QueueList queueList = queueListRepository.findById(queueListId)
            .orElseThrow(() -> new RuntimeException("QueueList not found with id: " + queueListId));
            queueList.setDeletedat(LocalDateTime.now());
            queueListRepository.save(queueList);
            for (QueueOfficeList queueOffice : queueOfficeListRepository.findByQueueListId(queueListId)) {
                queueOffice.setUpdatedat(LocalDateTime.now()); 
                queueOfficeListRepository.save(queueOffice);
            }
        }
}
