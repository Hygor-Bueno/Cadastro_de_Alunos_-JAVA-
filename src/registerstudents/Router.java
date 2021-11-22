package registerstudents;

public class Router {

    public void main(int index) {
        switch (index) {
            case 1:  
                SettingStudents register = new SettingStudents();
                register.registerStudent();
                break;
            case 2:
                SettingStudents upRegister = new SettingStudents();
                upRegister.updateStudents();
                break;
            case 3:
                SettingStudents querry = new SettingStudents();
                querry.querryStudents();
                break;
            case 4:
                SettingStudents delete = new SettingStudents();
                delete.deleteStudents();
                break;
            case 5:
                System.out.println("Fim do Algoritimo");
                break;
            default:
                System.out.println("Desculpe Opção inválida!");
                break;
        }
    }

}
