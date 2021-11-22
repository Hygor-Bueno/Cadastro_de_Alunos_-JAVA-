package registerstudents;

import java.util.ArrayList;
import java.util.Scanner;

public class SettingStudents {

    Student student = new Student();
    View view = new View();
    Scanner sc = new Scanner(System.in);
    Validator validation = new Validator();

    public String inputData(String question) {
        String response = "";
        do {
            System.out.print(question);
            response = sc.nextLine().toUpperCase();
        } while (response.equals(""));
        return response;
    }

    public String inputDataNumber(String question) {
        String response = "";
        do {
            System.out.print(question);
            response = sc.nextLine().toUpperCase();

        } while (response.equals("") || validation.validationDouble(response));
        return response;
    }

    public void registerStudent() {
        Student registerStrundets = new Student();
        registerStrundets.userName = this.inputData("Digite o Nome de Usuário: ");

        System.out.println("SENHA: \n");
        int pass = this.passwordGenerator();
        System.out.println(" ****************************************** \n"
                + " Esta é a senha do aluno: " + pass + "\n"
                + " ****************************************** \n");
        registerStrundets.password = pass;
        registerStrundets.fullName = this.inputData("Digite o Nome completo do Estudante: ");
        registerStrundets.email = this.inputData("Digite o E-mail do Estudante: ");
        registerStrundets.genre = this.inputData("Digite o Gênero do Estudante: ");

        System.out.print("DATA DE NASCIMENTO: \n");
        registerStrundets.birth = this.createBirthDate();

        System.out.print("Digite o Endereço do Estudante: \n");
        registerStrundets.address = this.createAddress();

        registerStrundets.monthlyIncome = Double.parseDouble(this.inputDataNumber("Digite o valor da renda mensal do Estudante: "));

        registerStrundets.cpf = this.createCPF();
        view.studentRecord(registerStrundets);

        System.out.println("CONFIRMAR OS DADOS DO USUÁRIO? [S/N]: ");
        String confirm = sc.nextLine();

        if (confirm.equals("s") || confirm.equals("S")) {
            registerStrundets.createFile(true);
            System.out.println("CADASTRO DE USUÁRIO REALIZADO COM SUCESSO...");
        } else {
            System.out.println("CADASTRO DE USUÁRIO CANCELADO...");
        }
    }

    public int passwordGenerator() {
        int[] value = new int[3];
        String response;
        for (int index = 0; index < value.length; index++) {
            do {
                do {
                    System.out.print(" Digite o " + (index + 1) + "º Valor. \n ATEÇÃO: valor deve estar entre 1000 e 9999:");
                    response = sc.nextLine();
                } while (!validation.equalLength(response, 4) || response.equals("") || view.checkLetters(response, "Números"));
            } while (!validation.equalValue(value, Integer.parseInt(response)));
            value[index] = Integer.parseInt(response);
        }

        return validation.lowerValue(value);
    }

    public String createBirthDate() {
        String[][] date = {{"Dia (Digitar no máximo 2 números): ", "2"}, {"Mês (Digitar no máximo 2 números): ", "2"}, {"Ano Digitar apenas 4 numeros", "4"}};
        String[] response = new String[3];
        for (int index = 0; index < 3; index++) {
            do {
                System.out.println(date[index][0]);
                response[index] = sc.nextLine();
            } while (!validation.maxLength(response[index], Integer.parseInt(date[index][1])) || response[index].equals("") || view.checkLetters(response[index], "Números"));
        }
        return response[0] + "/" + response[1] + "/" + response[2];
    }

    public String createAddress() {
        String[] data = {"Nome da Rua: ", "Número da residência: ", "CEP: ", "Bairro: "};
        String[] response = new String[4];
        for (int index = 0; index < 4; index++) {
            do {
                System.out.println(data[index]);
                response[index] = sc.nextLine().toUpperCase();
            } while (response[index].equals(""));
        }
        return "Rua: " + response[0] + " Nº: " + response[1] + ". CEP: " + response[2] + " " + response[3];
    }

    public String createCPF() {
        String value;
        do {
            System.out.print("Digite o CPF do Estudante: ");
            value = sc.nextLine();
        } while (!validation.equalLength(value, 11));
        return value;
    }

    public void updateStudents() {
        String response;
        do {
            ArrayList<ArrayList<Object>> list = student.getFile();
            int index;
            do {
                index = view.compactRecord(list, "para Atualizar seu cadastro");
            } while (!validation.maxLength(index, list.size()));
            this.updateStudentsData(list, index);
            System.out.println("Deseja atualizar o cadastro de outro aluno? [S/N]: ");
            response = sc.nextLine().toUpperCase().charAt(0) + "";
            if (!response.equals("")) {
                response = "Não";
            }
            response = response.toUpperCase().charAt(0) + "";
        } while (response.equals("S") || response.equals(""));
    }

    public void updateStudentsData(ArrayList<ArrayList<Object>> list, int index) {
        String response;
        String[] titleData = {" CPF: ", " Usuário: ", " Senha: ", " Nome Completo: ", " E-Mail: ", " Gênero: ", " Data de Nascimento: ", " Endereço: ", " Renda Mensal: "};
        list = student.desmemberData(list);
        for (int cont = 0; cont < list.get(index - 1).size(); cont++) {
            do {
                System.out.println("Deseja alterar o " + titleData[cont] + list.get(index - 1).get(cont) + " ? [S/N]");
                response = sc.nextLine();
            } while (response.equals(""));
            response = response.toUpperCase().charAt(0) + "";
            if (response.equals("S")) {
                System.out.println(cont);
                if (cont == 2) {
                    list.get(index - 1).set(cont, this.passwordGenerator());
                } else {
                    System.out.println("Digite o novo valor: ");
                    String newValue;
                    newValue = sc.nextLine().toUpperCase();
                    list.get(index - 1).set(cont, newValue);
                }
            }
        }
        student.update(list);
        System.out.println(list.get(index - 1));
    }

    public void querryStudents() {
        String response;
        do {
            ArrayList<ArrayList<Object>> list = student.getFile();
            int index;
            do {
                index = view.compactRecord(list, "para mais informações");
            } while (!validation.maxLength(index, list.size()));
            view.studentRecord(student.createObj(student.desmemberData(student.selectUser(index - 1, list))));
            System.out.println("Deseja realizar uma nova Busaca? [S/N]: ");
            response = sc.nextLine();
            if (response.equals("")) {
                response = "n";
            } else {
                response = response.toUpperCase().charAt(0) + "";
            }
        } while (response.equals("S"));
    }

    public void deleteStudents() {
        String response;
        do {
            ArrayList<ArrayList<Object>> list = student.getFile();
            int index;
            do {
                index = view.compactRecord(list, "para exclusão");
            } while (!validation.maxLength(index, list.size()));
            student.delete(index, list);
            System.out.println("Deseja Excluír o cadastro de outro aluno? [S/N]: ");
            response = sc.nextLine().toUpperCase().charAt(0) + "";
        } while (response.equals("S") || response.equals(""));
    }
}
