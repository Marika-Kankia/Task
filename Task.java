package Task;

import java.time.LocalDateTime;
// აბსტრაქტული Task კლასი, რომელიც წარმოდგენილია საერთო ატრიბუტებით და მეთოდებით

public abstract class Task {
    protected String name;
    protected String description;
    protected String creator;

    // კონსტრუქტორი Task-ის ველების დასაყენებლად

    public Task(String name, String description, String creator) {
        this.name = name;
        this.description = description;
        this.creator = creator;
    }


    // აბსტრაქტული მეთოდი Task-ის განახლებისთვის

    public abstract void update(String description, LocalDateTime deadline);

    // აბსტრაქტული მეთოდი Task-ის დეტალების მისაღებად

    public abstract String details();

}
