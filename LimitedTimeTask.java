package LimitedTimeTask;

import Task.Task;

import java.time.LocalDateTime;


public class LimitedTimeTask extends Task {
    // Task-ის დასრულების თარიღი
    private LocalDateTime deadline;


    // კონსტრუქტორი LimitedTimeTask-ის ველების დასაყენებლად

    public LimitedTimeTask(String name, String description, String creator, LocalDateTime deadline) {
        super(name, description, creator);
        this.deadline = deadline;
    }


    // Task-ის განახლების მეთოდი

    @Override
    public void update(String description, LocalDateTime deadline) {
        this.description = description;
        this.deadline = deadline;
    }


    // Task-ის დეტალების მისაღები მეთოდი

    @Override
    public String details() {
        return "Name: " + name + ", Description: " + description + ", Creator: " + creator + ", Deadline: " + deadline;
    }
}
