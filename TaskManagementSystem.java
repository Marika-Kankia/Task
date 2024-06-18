package TaskManagementSystem;

import BasicTask.BasicTask;
import LimitedTimeTask.LimitedTimeTask;
import RepeateableTask.RepeateableTask;
import Task.Task;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskManagementSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Task> tasks = new HashMap<>(); // Task-ების შენახვისთვის Map ობიექტი
    private static String currentUser;

    public static void main(String[] args) {
        System.out.print("Enter username: ");
        currentUser = scanner.nextLine();

        while (true) {
            System.out.println("Choose a command: add, get_all, get, update, delete");
            String command = scanner.nextLine().trim().toLowerCase();
            switch (command) {
                case "add":
                    addTask();
                    break;
                case "get_all":
                    getAllTasks();
                    break;
                case "get":
                    getTask();
                    break;
                case "update":
                    updateTask();
                    break;
                case "delete":
                    deleteTask();
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }


    // Task-ის დამატების მეთოდი

    private static void addTask() {
        System.out.print("Enter task type (LimitedTimeTask, RepeateableTask, BasicTask): ");
        String type = scanner.nextLine().trim();
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();
        if (tasks.containsKey(name)) {
            System.out.println("Task with this name already exists"); // Task-ის სახელის უნიკალურობის შემოწმება
            return;
        }
        System.out.print("Enter task description: ");
        String description = scanner.nextLine().trim();

        Task task = null;
        if ("LimitedTimeTask".equalsIgnoreCase(type)) {
            System.out.print("Enter deadline (yyyy-MM-ddTHH:mm): ");
            LocalDateTime deadline = LocalDateTime.parse(scanner.nextLine().trim());
            task = new LimitedTimeTask(name, description, currentUser, deadline);
        } else if ("RepeateableTask".equalsIgnoreCase(type)) {
            System.out.print("Enter repeat count: ");
            int repeatCount = Integer.parseInt(scanner.nextLine().trim());
            System.out.print("Enter repeat interval (yyyy-MM-ddTHH:mm): ");
            LocalDateTime repeatInterval = LocalDateTime.parse(scanner.nextLine().trim());
            task = new RepeateableTask(name, description, currentUser, repeatCount, repeatInterval);
        } else if ("BasicTask".equalsIgnoreCase(type)) {
            task = new BasicTask(name, description, currentUser);
        } else {
            System.out.println("Invalid task type");
            return;
        }

        tasks.put(name, task); // Task-ის შენახვა
        System.out.println("Task added successfully");
    }


    // ყველა Task-ის წამოღების მეთოდი

    private static void getAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available");
            return;
        }

        tasks.keySet().forEach(System.out::println); // Task-ების სახელების ამოღება
    }


    // კონკრეტული Task-ის წამოღების მეთოდი

    private static void getTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();
        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task does not exist"); // Task-ის არ არსებობის შეტყობინება
        } else {
            System.out.println(task.details()); // Task-ის დეტალების დაბრუნება
        }
    }


    // Task-ის განახლების მეთოდი

    private static void updateTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();
        Task task = tasks.get(name);
        if (task == null) {
            System.out.println("Task does not exist");
            return;
        }

        System.out.print("Enter new description: ");
        String description = scanner.nextLine().trim();
        LocalDateTime deadline = null;

        if (task instanceof LimitedTimeTask) {
            System.out.print("Enter new deadline (yyyy-MM-ddTHH:mm): ");
            deadline = LocalDateTime.parse(scanner.nextLine().trim());
        }

        task.update(description, deadline); // Task-ის განახლება
        System.out.println("Task updated successfully");
    }


    // Task-ის წაშლის მეთოდი
    private static void deleteTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine().trim();
        Task task = tasks.remove(name);  // Task-ის წაშლა
        if (task == null) {
            System.out.println("Task does not exist");
        } else {
            System.out.println("Task deleted successfully");
        }
    }
}



