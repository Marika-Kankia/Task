package BasicTask;

import Task.Task;

import java.time.LocalDateTime;

// Task-ის ქვეტიპი: BasicTask, რომელსაც არ აქვს დამატებითი ველები

public class BasicTask extends Task {

    // კონსტრუქტორი BasicTask-ის ველების დასაყენებლად

    public BasicTask(String name, String description, String creator) {
        super(name, description, creator);
    }


    // Task-ის განახლების მეთოდი

    @Override
    public void update(String description, LocalDateTime deadline) {
        this.description = description;
    }


    // Task-ის დეტალების მისაღები მეთოდი

    @Override
    public String details() {
        return "Name: " + name + ", Description: " + description + ", Creator: " + creator;
    }
}
