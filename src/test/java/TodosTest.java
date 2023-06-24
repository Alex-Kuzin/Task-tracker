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

       String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
       Epic epic = new Epic(55, "subtasks");

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
   }
    @Test
    public void searchAddElement() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
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

        todos.search("Молоко");
        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void searchNotAddElement() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
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

        todos.search("Хлеб");

        Task[] expected = todos.search("0");
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldShowThatTheElementIsNotAdded() {
        Todos todos = new Todos();
        todos.matches("Хлеб");

        boolean expected = false;
        boolean actual = todos.matches("Хлеб");
        Assertions.assertEquals(expected, actual);
    }
}
