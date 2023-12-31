package Tasks;

public class Epic extends Task {
    protected String subtasks;

    public Epic(int id, String subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        String[] names = {subtasks};
        for (int i = 0; i < names.length; i++) {
            if (subtasks.contains(query)) {
                return true;
            }
        }
        return false;
    }
}


