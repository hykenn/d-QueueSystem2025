package com.sys.queue.controller;

import com.sys.queue.model.QueueList;
import com.sys.queue.model.QueueOfficeList;
import com.sys.queue.repository.QueueListRepository;
import com.sys.queue.repository.QueueOfficeListRepository;
import com.sys.queue.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @Autowired
    private QueueListRepository queueListRepository;

    @Autowired
    private QueueOfficeListRepository queueOfficeListRepository;


    // Add new QueueList and QueueOfficeList
    @PostMapping("/add")
    public String addQueue(@RequestBody QueueOfficeList queueOfficeList) {
        queueService.saveQueueAndQueueOfficeList(queueOfficeList);
        return "Data saved successfully!";
    }

    //Update QueueList and insert into QueueOfficeList
    @PutMapping("/update/{id}")
    public String updateQueue(@PathVariable Integer id, @RequestBody QueueList updatedQueueList) {
        try {
            queueService.updateQueueAndInsertQueueOfficeList(id, updatedQueueList);
            return "Queue updated successfully, and new QueueOfficeList record inserted!";
        } catch (RuntimeException e) {
            return "Error: " + e.getMessage();
        }
    }

    // New endpoint to get all quenum, officeto, and priority for the same officeto  // for reports queued
    @GetMapping("/que-office-reports/{officeto}")
    public List<Object[]> getQuenumAndOfficesAndPriorityByOfficeto(@PathVariable String officeto) {
        return queueOfficeListRepository.findQuenumAndOfficesAndPriorityByOfficeto(officeto);
    }


    // Soft delete endpoint for QueueList
    @DeleteMapping("/delete/{id}")
    public String softDeleteQueue(@PathVariable Integer id) {
        queueService.softDeleteQueue(id);
        return "Queue soft-deleted successfully!";
    }

    // Fetch all quenum values
    @GetMapping("/all-quenum")
    public List<Integer> getAllQuenum() {
        return queueListRepository.findAllQuenum();
    }

    // Fetch all officeto values
    @GetMapping("/all-officeto")
    public List<String> getAllOfficeto() {
        return queueListRepository.findAllOfficeto();
    }

    // Fetch all QueueList records
    @GetMapping("/all")
    public List<QueueList> getAllQueueList() {
        return queueListRepository.findAll();
    }






    // New endpoint to get all officeto for a given quenum
    //@GetMapping("/offices/{quenum}")
    //public List<String> getOfficesByQuenum(@PathVariable Integer quenum) {
      //  return queueOfficeListRepository.findOfficesByQuenum(quenum);
   // }
   
}
