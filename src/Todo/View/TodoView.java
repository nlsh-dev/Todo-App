package Todo.View;

import Todo.Model.Todo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TodoView extends JFrame {

    private final JTextField taskField;
    private final JButton addButton;

    private final JButton completeButton;
    private final JButton deleteButton;
    private final JButton clearCompletedButton;
    private final JButton clearAllButton;

    private final DefaultListModel<Todo> listModel;
    private final JList<Todo> todoList;

    private final JLabel taskCountLabel;

    public TodoView() {

        setTitle("My To-Do List");
        setSize(700, 550);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);



        JPanel mainPanel =
                new JPanel(new BorderLayout(15, 15));

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(
                        20, 20, 20, 20
                )
        );



        JLabel titleLabel =
                new JLabel("My To-Do List");

        titleLabel.setFont(
                new Font("Arial", Font.BOLD, 28)
        );

        JLabel subtitleLabel =
                new JLabel(
                        "Stay organized and get things done."
                );

        subtitleLabel.setFont(
                new Font("Arial", Font.PLAIN, 14)
        );

        JPanel headerPanel =
                new JPanel(new BorderLayout(5, 5));

        headerPanel.add(
                titleLabel,
                BorderLayout.NORTH
        );

        headerPanel.add(
                subtitleLabel,
                BorderLayout.SOUTH
        );

        //INPUT

        taskField = new JTextField();

        taskField.setFont(
                new Font("Arial", Font.PLAIN, 16)
        );

        taskField.setToolTipText(
                "Enter a task"
        );

        addButton =
                new JButton("Add Task");

        JPanel inputPanel =
                new JPanel(new BorderLayout(10, 10));

        inputPanel.add(
                taskField,
                BorderLayout.CENTER
        );

        inputPanel.add(
                addButton,
                BorderLayout.EAST
        );
        //PANEL
        JPanel topPanel =
                new JPanel(new BorderLayout(10, 10));

        topPanel.add(
                headerPanel,
                BorderLayout.NORTH
        );

        topPanel.add(
                inputPanel,
                BorderLayout.SOUTH
        );

       //TODO -LIST

        listModel =
                new DefaultListModel<>();

        todoList =
                new JList<>(listModel);

        todoList.setFont(
                new Font("Arial", Font.PLAIN, 17)
        );

        todoList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );

        todoList.setFixedCellHeight(40);

        JScrollPane scrollPane =
                new JScrollPane(todoList);

        scrollPane.setBorder(
                BorderFactory.createTitledBorder(
                        "Tasks"
                )
        );

        //BUTTONS

        completeButton =
                new JButton("Complete");

        deleteButton =
                new JButton("Delete");

        clearCompletedButton =
                new JButton("Clear Completed");

        clearAllButton =
                new JButton("Clear All");

        JPanel buttonPanel =
                new JPanel(
                        new FlowLayout(
                                FlowLayout.RIGHT,
                                8,
                                5
                        )
                );

        buttonPanel.add(completeButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.add(clearAllButton);



        taskCountLabel =
                new JLabel("Tasks: 0");

        taskCountLabel.setFont(
                new Font(
                        "Arial",
                        Font.PLAIN,
                        14
                )
        );

        JPanel footerPanel =
                new JPanel(new BorderLayout());

        footerPanel.add(
                taskCountLabel,
                BorderLayout.WEST
        );

        footerPanel.add(
                buttonPanel,
                BorderLayout.EAST
        );

        // =========================
        // ADD TO MAIN PANEL
        // =========================

        mainPanel.add(
                topPanel,
                BorderLayout.NORTH
        );

        mainPanel.add(
                scrollPane,
                BorderLayout.CENTER
        );

        mainPanel.add(
                footerPanel,
                BorderLayout.SOUTH
        );

        add(mainPanel);
    }

    // =========================
    // GETTERS
    // =========================

    public JTextField getTaskField() {
        return taskField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getCompleteButton() {
        return completeButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getClearCompletedButton() {
        return clearCompletedButton;
    }

    public JButton getClearAllButton() {
        return clearAllButton;
    }

    public JList<Todo> getTodoList() {
        return todoList;
    }

    // =========================
    // UPDATE LIST
    // =========================

    public void refreshList(List<Todo> todos) {

        listModel.clear();

        for (Todo todo : todos) {
            listModel.addElement(todo);
        }

        updateTaskCount(todos.size());
    }

    // =========================
    // UPDATE COUNTER
    // =========================

    public void updateTaskCount(int count) {

        taskCountLabel.setText(
                "Tasks: " + count
        );
    }

    // =========================
    // MESSAGE
    // =========================

    public void showMessage(
            String message,
            String title
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================
    // WARNING
    // =========================

    public void showWarning(
            String message,
            String title
    ) {

        JOptionPane.showMessageDialog(
                this,
                message,
                title,
                JOptionPane.WARNING_MESSAGE
        );
    }

    // =========================
    // CONFIRMATION
    // =========================

    public boolean confirmAction(
            String message
    ) {

        int result =
                JOptionPane.showConfirmDialog(
                        this,
                        message,
                        "Confirmation",
                        JOptionPane.YES_NO_OPTION
                );

        return result ==
                JOptionPane.YES_OPTION;
    }
}