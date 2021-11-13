package registerstudents;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Student {
    /*
    userName= nome de usuário, fullName = nome completo, email=e-amil,genre=gênero, birth=nascimento, address=endereço
    monthlyIncome = renda mensal, cpf;
    */
    String userName,fullName, email,genre, birth, address,cpf;
    double monthlyIncome;
    int password;
    public Student(String userName,int password,String fullName,String email,String genre,String birth,String address,double monthlyIncome,String cpf){
        this.userName= userName;
        this.password=password;
        this.fullName = fullName;
        this.email= email;
        this.genre= genre;
        this.birth= birth;
        this.address= address;
        this.monthlyIncome = monthlyIncome;
        this.cpf= cpf;
    }
    public Student(int i,String b){}
    
    public void createFile(){
        try {
            FileWriter fw = new FileWriter("record.txt",true);
            PrintWriter pw = new PrintWriter(fw);
            // Cabeçalho do Arquivo
            pw.println();
            pw.print("{ id:"+this.cpf+",");            
            //Corpo do Arquivo:
            pw.print("data:{");
            pw.print("Nome de Usuário: "+this.userName+";");
            pw.print("Senha: "+this.password+";");
            pw.print("Nome Completo: "+this.fullName+";");
            pw.print("E-mail: "+this.email+";");
            pw.print("Gênero: "+this.genre+";");
            pw.print("Data de Nascimento: "+this.birth+";");
            pw.print("Endereço: "+this.address+";");
            pw.print("Renda Mensal: R$"+this.monthlyIncome+";");
            pw.print("CPF: "+this.cpf+";");
            pw.print("}");
            pw.print("}");
            
            pw.flush();
            pw.close();
            fw.close();
        } catch (IOException error) {
            System.out.println("Falha ao Gerar Arquivo:"+ error);
        }   
    }
    public void getFile(){
        String path = "record.txt";
        try(BufferedReader br=new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            int cont = 0;
            String[] as = new String[9];
            while(line !=null){
                System.out.println(line);
                line = br.readLine();
                as[cont] =line;
                cont++;
            }
            for(String sa:as){                
                System.out.println(sa);
            }
        }catch(IOException error) {
            System.out.println("Falha ao ler Arquivo:"+ error);
        }   
    }
    
    
}
