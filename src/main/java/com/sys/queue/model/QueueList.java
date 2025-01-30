package com.sys.queue.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class QueueList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    @Column(name = "quenum")
    private Integer quenum; 
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


    public QueueList() {}
    public QueueList(Integer quenum, String officeto, String priority, 
                     LocalDateTime createdat, LocalDateTime updatedat, LocalDateTime deletedat) {
        this.quenum = quenum;
        this.officeto = officeto;
        this.priority = priority;
        this.createdat = createdat;
        this.updatedat = updatedat;
        this.deletedat = deletedat;
    }
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
    @Override
    public String toString() {
        return "QueueList{" +
                "id=" + id +
                ", quenum=" + quenum + 
                ", officeto='" + officeto + '\'' +
                ", priority='" + priority + '\'' +
                ", createdat=" + createdat +
                ", updatedat=" + updatedat +
                ", deletedat=" + deletedat +
                '}';
    }
}
