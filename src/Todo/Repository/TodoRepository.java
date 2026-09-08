package Todo.Repository;


import Todo.Model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {

    private final List<Todo> todos = new ArrayList<>();

    private int nextId = 1;

    public void add(Todo todo) {
        todos.add(todo);
    }

    public void remove(Todo todo) {
        todos.remove(todo);
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

    public void clear() {
        todos.clear();
    }

    public int getNextId() {
        return nextId++;
    }
}