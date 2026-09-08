package Todo;


import Todo.Controller.TodoController;
import Todo.Repository.TodoRepository;
import Todo.View.TodoView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            TodoView view =
                    new TodoView();

            TodoRepository repository =
                    new TodoRepository();

            new TodoController(
                    view,
                    repository
            );

            view.setVisible(true);
        });
    }
}