package RepeateableTask;

import Task.Task;

import java.time.LocalDateTime;


// Task-ის ქვეტიპი: RepeateableTask, რომელიც დამატებით მოიცავს რამდენჯერ უნდა შესრულდეს და როდის

public class RepeateableTask extends Task {
    private int repeatCount;  // რამდენჯერ უნდა შესრულდეს Task
    private LocalDateTime repeatInterval; // Task-ის შესრულების ინტერვალი


    // კონსტრუქტორი RepeateableTask-ის ველების დასაყენებლად

    public RepeateableTask(String name, String description, String creator, int repeatCount, LocalDateTime repeatInterval) {
        super(name, description, creator);
        this.repeatCount = repeatCount;
        this.repeatInterval = repeatInterval;
    }

    // Task-ის განახლების მეთოდი
    @Override
    public void update(String description, LocalDateTime deadline) {
        this.description = description;
    }


    // Task-ის დეტალების მისაღები მეთოდი

    @Override
    public String details() {
        return "Name: " + name + ", Description: " + description + ", Creator: " + creator + ", Repeat Count: " + repeatCount + ", Repeat Interval: " + repeatInterval;
    }
}
