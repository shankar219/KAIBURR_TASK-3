package com.example.taskapi.models;

import org.springframework.data.annotation.Id;

public class TaskExecution {
    @Id
    private String id;
    private long startTime;
    private long endTime;
    private String output;

    public TaskExecution() {}

    public TaskExecution(long startTime, long endTime, String output) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.output = output;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public long getStartTime() { return startTime; }
    public void setStartTime(long startTime) { this.startTime = startTime; }
    public long getEndTime() { return endTime; }
    public void setEndTime(long endTime) { this.endTime = endTime; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
}