import Tasks.SimpleTask;
import Tasks.Epic;
import Tasks.Meeting;
import Tasks.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {
    /* @Test
     public void shouldAddThreeTasksOfDifferentType() {
         SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        // String subtasks = { "Молоко", "Яйца", "Хлеб" };
         Epic epic = new Epic(55, "Молоко");

         Meeting meeting = new Meeting(
                 555,
                 "Выкатка 3й версии приложения",
                 "Приложение НетоБанка",
                 "Во вторник после обеда"
         );

         Todos todos = new Todos();

         todos.add(simpleTask);
         todos.add(epic);
         todos.add(meeting);

         Task[] expected = { simpleTask, epic, meeting };
         Task[] actual = todos.findAll();
         Assertions.assertArrayEquals(expected, actual);
     }*/
    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, "subtasks");

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchOneAddElement() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, "Молоко");

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneAddElement2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, "Молоко");

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneAddElement3() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, "Молоко");

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchNotAddElement() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(55, "Молоко");

        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {};
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowThatTheElementIsNotAdded() {
        Todos todos = new Todos();

        boolean expected = false;
        boolean actual = todos.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void searchSomeElements() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Epic epic = new Epic(5, "Позвонить родителям");

        Meeting meeting = new Meeting(5, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);


        Task[] expected = {simpleTask,epic,meeting};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchElementsSameTypeEpic() {
        Epic epic1 = new Epic(5, "Позвонить родителям");
        Epic epic2 = new Epic(12, "Позвонить родителям");
        Epic epic3= new Epic(887, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {epic1,epic2,epic3};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneElementSameTypeEpic() {
        Epic epic1 = new Epic(5, "Позвонить родителям");
        Epic epic2 = new Epic(12, "Позвонить родителям");
        Epic epic3= new Epic(887, "Позвонить друзьям");

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {epic3};
        Task[] actual = todos.search("Позвонить друзьям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneNoAddElementSameTypeEpic() {
        Epic epic1 = new Epic(5, "Позвонить родителям");
        Epic epic2 = new Epic(12, "Позвонить родителям");
        Epic epic3= new Epic(887, "Позвонить друзьям");

        Todos todos = new Todos();

        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        Task[] expected = {};
        Task[] actual = todos.search("Позвонить на работу");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchElementsSameTypeSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(123, "Позвонить родителям");
        SimpleTask simpleTask3= new SimpleTask(33, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);


        Task[] expected = {simpleTask1,simpleTask2,simpleTask3};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneElementsSameTypeSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(123, "Позвонить друзьям");
        SimpleTask simpleTask3= new SimpleTask(33, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);


        Task[] expected = {simpleTask2};
        Task[] actual = todos.search("Позвонить друзьям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneNoAddElementSameTypeSimpleTask() {
        SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(123, "Позвонить друзьям");
        SimpleTask simpleTask3= new SimpleTask(33, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(simpleTask3);


        Task[] expected = {};
        Task[] actual = todos.search("Позвонить на работу");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchElementsSameTypeMeeting() {
        Meeting meeting1 = new Meeting(5, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(12, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting3 = new Meeting(33, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);


        Task[] expected = {meeting1,meeting2,meeting3};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneElementsSameTypeMeeting() {
        Meeting meeting1 = new Meeting(5, "Позвонить друзьям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(12, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting3 = new Meeting(33, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);


        Task[] expected = {meeting1};
        Task[] actual = todos.search("Позвонить друзьям");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchOneNoAddElementSameTypeMeeting() {
        Meeting meeting1 = new Meeting(5, "Позвонить друзьям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting2 = new Meeting(12, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");
        Meeting meeting3 = new Meeting(33, "Позвонить родителям", "Приложение НетоБанка", "Во вторник после обеда");

        Todos todos = new Todos();

        todos.add(meeting1);
        todos.add(meeting2);
        todos.add(meeting3);


        Task[] expected = {};
        Task[] actual = todos.search("Позвонить на работу");
        Assertions.assertArrayEquals(expected, actual);
    }
}
