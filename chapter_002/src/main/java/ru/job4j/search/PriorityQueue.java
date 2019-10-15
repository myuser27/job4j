package ru.job4j.search;

import java.util.LinkedList;
import java.util.List;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            int count = 0;
            for (Task t : this.tasks) {
                if (t.getPriority() > task.getPriority()) {
                    this.tasks.add(this.tasks.indexOf(t), task);
                    break;
                }
                count++;
            }
            if (count == this.tasks.size()) {
                this.tasks.addLast(task);
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
