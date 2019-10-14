package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if(tasks.isEmpty()) {
            tasks.add(task);
        } else {
            for(Task t : tasks) {
                if(t.getPriority() > task.getPriority()) {
                    tasks.add(tasks.indexOf(t), task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
