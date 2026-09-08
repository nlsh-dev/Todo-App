package Todo.Controller;
import Todo.Model.Todo;
import Todo.Repository.TodoRepository;
import Todo.View.TodoView;

import java.util.List;

public class TodoController {

    private final TodoView view;
    private final TodoRepository repository;

    public TodoController(
            TodoView view,
            TodoRepository repository
    ) {

        this.view = view;
        this.repository = repository;

        registerEvents();

        refreshTasks();
    }

    //Event -- Handling

    private void registerEvents() {

        view.getAddButton()
                .addActionListener(
                        e -> addTask()
                );

        view.getTaskField()
                .addActionListener(
                        e -> addTask()
                );

        view.getCompleteButton()
                .addActionListener(
                        e -> completeTask()
                );

        view.getDeleteButton()
                .addActionListener(
                        e -> deleteTask()
                );

        view.getClearCompletedButton()
                .addActionListener(
                        e -> clearCompleted()
                );

        view.getClearAllButton()
                .addActionListener(
                        e -> clearAll()
                );
    }

   //ADD -Task

    private void addTask() {

        String title =
                view.getTaskField()
                        .getText()
                        .trim();

        if (title.isEmpty()) {

            view.showWarning(
                    "Please enter a task.",
                    "Empty Task"
            );

            return;
        }

        Todo todo =
                new Todo(
                        repository.getNextId(),
                        title
                );

        repository.add(todo);

        view.getTaskField().setText("");

        refreshTasks();

        view.getTaskField().requestFocus();
    }

    //Complete-Task


    private void completeTask() {

        Todo selectedTodo =
                view.getTodoList()
                        .getSelectedValue();

        if (selectedTodo == null) {

            view.showWarning(
                    "Please select a task first.",
                    "No Task Selected"
            );

            return;
        }

        selectedTodo.setCompleted(
                !selectedTodo.isCompleted()
        );

        refreshTasks();
    }

  //Delete-Task

    private void deleteTask() {

        Todo selectedTodo =
                view.getTodoList()
                        .getSelectedValue();

        if (selectedTodo == null) {

            view.showWarning(
                    "Please select a task first.",
                    "No Task Selected"
            );

            return;
        }

        repository.remove(selectedTodo);

        refreshTasks();
    }

   //Clear -Task

    private void clearCompleted() {

        List<Todo> todos =
                repository.getAll();

        for (Todo todo : todos) {

            if (todo.isCompleted()) {
                repository.remove(todo);
            }
        }

        refreshTasks();
    }
    //Clear All
    private void clearAll() {

        if (repository.getAll().isEmpty()) {

            view.showMessage(
                    "There are no tasks to clear.",
                    "To-Do List"
            );

            return;
        }

        boolean confirmed =
                view.confirmAction(
                        "Are you sure you want to delete all tasks?"
                );

        if (confirmed) {

            repository.clear();

            refreshTasks();
        }
    }

    //Referesh

    private void refreshTasks() {

        view.refreshList(
                repository.getAll()
        );
    }
}