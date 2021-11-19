package registerstudents;

public class RegisterStudents {
    public static void main(String[] args) {
        int value;
        View view = new View();
        Router router = new Router();
        do {
            value = view.systemMenu();
            router.main(value);
        } while (value != 5);
    }
    
}
