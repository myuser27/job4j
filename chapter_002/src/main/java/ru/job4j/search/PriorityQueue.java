package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            var count = 0;
            for (var t : this.tasks) {
                if (t.getPriority() > task.getPriority()) {
                    this.tasks.add(count, task);
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
