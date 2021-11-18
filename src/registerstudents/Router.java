package registerstudents;

public class Router {

    Student student = new Student();

    public void main(int index) {
        switch (index) {
            case 1:
                student.registerStudent();
                break;
            case 2:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            case 3:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
                break;
            case 4:
                System.out.println(" Opção Nº " + index + ".\n Foi Selecionada!");
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
