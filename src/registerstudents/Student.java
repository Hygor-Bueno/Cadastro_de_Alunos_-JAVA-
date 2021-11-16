package registerstudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Student {

    /*
    userName= nome de usuário, fullName = nome completo, email=e-amil,genre=gênero, birth=nascimento, address=endereço
    monthlyIncome = renda mensal, cpf;
     */
    String userName, fullName, email, genre, birth, address, cpf;
    double monthlyIncome;
    int password;

    public Student(String userName, int password, String fullName, String email, String genre, String birth, String address, double monthlyIncome, String cpf) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.genre = genre;
        this.birth = birth;
        this.address = address;
        this.monthlyIncome = monthlyIncome;
        this.cpf = cpf;
    }

    public Student(String cpf, String userName, int password, String fullName, String email, String genre, String birth, String address, double monthlyIncome) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.genre = genre;
        this.birth = birth;
        this.address = address;
        this.monthlyIncome = monthlyIncome;
        this.cpf = cpf;
    }

    public void createFile(boolean value) {
        try {
            FileWriter fw = new FileWriter("record.txt", value);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("User: "
                    + this.cpf + ","
                    + this.userName + ","
                    + this.password + ","
                    + this.fullName + ","
                    + this.email + ","
                    + this.genre + ","
                    + this.birth + ","
                    + this.address + ","
                    + this.monthlyIncome
            );
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException error) {
            System.out.println("Falha ao Gerar Arquivo:" + error);
        }
    }
    
    public void delete(int value, ArrayList arrayList){
        
    }

    public ArrayList getFile() {
        String path = "record.txt";
        ArrayList<String> list = new ArrayList();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while (line != null) {
                list.add(line);
                line = br.readLine();
            }
        } catch (IOException error) {
            System.out.println("Falha ao ler Arquivo:" + error);
        }
        return list;
    }

    public ArrayList selectUser(int value, ArrayList arrayList) {
        ArrayList<Object> list = new ArrayList();
        for (int index = 0; index < arrayList.size(); index++) {
            if (index != value) {
                list.add(arrayList.get(index));
            }
        }
        this.desmemberData(list);
        //System.out.println(list);
        return list;
    }

    public ArrayList desmemberData(ArrayList arrayList) {
        ArrayList<ArrayList<Object>> listUser = new ArrayList<>();
        for (int index = 0; index < arrayList.size(); index++) {
            ArrayList<Object> list = new ArrayList();
            String[] value = arrayList.get(index).toString().replaceAll("User: ", "").split(",");
            list.addAll(Arrays.asList(value));
            listUser.add(list);
        }
        System.out.println(listUser.get(2));
        return listUser;
    }

}
