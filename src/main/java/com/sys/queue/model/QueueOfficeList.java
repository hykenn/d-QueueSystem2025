package com.sys.queue.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class QueueOfficeList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // Primary key

    @Column(name = "quenum")
    private Integer quenum;  // Changed from String to Integer

    @Column(name = "officeto")
    private String officeto;

    @Column(name = "priority")
    private String priority;

    @Column(name = "createdat")
    private LocalDateTime createdat;

    @Column(name = "updatedat")
    private LocalDateTime updatedat;

    @Column(name = "deletedat")
    private LocalDateTime deletedat;

    @Column(name = "status")
    private Integer status = 1; // Added status with default value 1

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "queue_list_id", referencedColumnName = "id", nullable = false)
    private QueueList queueList;

    // Default constructor
    public QueueOfficeList() {}

    // Constructor with fields
    public QueueOfficeList(Integer quenum, String officeto, String priority, 
                           LocalDateTime createdat, LocalDateTime updatedat, LocalDateTime deletedat, 
                           QueueList queueList) {
        this.quenum = quenum;
        this.officeto = officeto;
        this.priority = priority;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.deletedat = deletedat;
        this.queueList = queueList;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQunem() {
        return quenum;
    }

    public void setQunem(Integer quenum) {
        this.quenum = quenum;
    }

    public String getOfficeto() {
        return officeto;
    }

    public void setOfficeto(String officeto) {
        this.officeto = officeto;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    public LocalDateTime getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(LocalDateTime updatedat) {
        this.updatedat = updatedat;
    }

    public LocalDateTime getDeletedat() {
        return deletedat;
    }

    public void setDeletedat(LocalDateTime deletedat) {
        this.deletedat = deletedat;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public QueueList getQueueList() {
        return queueList;
    }

    public void setQueueList(QueueList queueList) {
        this.queueList = queueList;
    }

    @Override
    public String toString() {
        return "QueueOfficeList{" +
                "id=" + id +
                ", quenum=" + quenum +
                ", officeto='" + officeto + '\'' +
                ", priority='" + priority + '\'' +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", deletedat=" + deletedat +
                ", status=" + status + // Added status to toString
                ", queueList=" + queueList +
                '}';
    }
}
