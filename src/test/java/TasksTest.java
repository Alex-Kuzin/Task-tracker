import Tasks.Epic;
import Tasks.Meeting;
import Tasks.SimpleTask;
import Tasks.Task;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {
    @Test
    public void equals() {
        Epic epic = new Epic(55, "Молоко");

        boolean expected = false;
        boolean actual = epic.equals(55);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals2() {
        Epic epic = new Epic(55, "Молоко");

        int expected = 86;
        int actual = epic.hashCode();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals3() {
        Epic epic = new Epic(55, "Молоко");
        boolean expected = true;
        boolean actual = epic.equals(epic);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals4() {
        Epic epic = new Epic(55, "Молоко");
        SimpleTask simpleTask = new SimpleTask(55, "Позвонить родителям");


        boolean expected = false;
        boolean actual = simpleTask.equals(epic);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals5() {
        ;
        Epic epic = new Epic(55, "Молоко");
        Epic epic2 = new Epic(58, "Молоко");
        boolean expected = false;
        boolean actual = epic.equals(epic2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals6() {
        ;
        Epic epic = new Epic(55, "Молоко");
        Epic epic2 = new Epic(55, "Молоко");
        boolean expected = true;
        boolean actual = epic.equals(epic2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equals7() {
        ;
        Todos epic = new Todos();
        Epic epic2 = new Epic(55, "Молоко");
        boolean expected = false;
        boolean actual = epic2.equals(null);
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void callGetterTask() {
        Epic epic = new Epic(55, "Молоко");

        int expected = 55;
        int actual = epic.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void callGetterEpic() {
        Epic epic = new Epic(55, "Молоко");

        String expected = "Молоко";
        String actual = epic.getSubtasks();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void callGetterSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String expected = "Позвонить родителям";
        String actual = simpleTask.getTitle();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void callGetterMeetingTopic() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Выкатка 3й версии приложения";
        String actual = meeting.getTopic();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void callGetterMeetingProject() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Приложение НетоБанка";
        String actual = meeting.getProject();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void callGetterMeetingStart() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        String expected = "Во вторник после обеда";
        String actual = meeting.getStart();
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void matchesAddElementSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить родителям");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void matchesNotAddElementSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Хлеб");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void matchesAddElementEpic() {
        Epic epic = new Epic(55, "Молоко");

        boolean expected = true;
        boolean actual = epic.matches("Молоко");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void matchesNotAddElementEpic() {
        Epic epic = new Epic(55, "Молоко");

        boolean expected = false;
        boolean actual = epic.matches("Хлеб");
        Assertions.assertEquals(expected, actual);


    }

    @Test
    public void matchesAddElementMeetingTopicSearch() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void matchesAddElementMeetingProjectSearch() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void matchesNotAddElementMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");

        boolean expected = false;
        boolean actual = meeting.matches("Хлеб");
        Assertions.assertEquals(expected, actual);

    }
}
