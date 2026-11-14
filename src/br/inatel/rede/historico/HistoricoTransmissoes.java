package br.inatel.rede.historico;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class HistoricoTransmissoes{

    private String nomeArquivo;

    public HistoricoTransmissoes(String nomeArquivo){
        this.nomeArquivo = nomeArquivo;
    }

    //Escrita em arquivo (o true acrescenta no final, sem apagar o que já existe)
    public void gravar(String linha){
        //Tratamento de exceção: gravar arquivo pode lançar IOException
        try{
            FileWriter escritor = new FileWriter(this.nomeArquivo, true);
            escritor.write(linha + "\n");
            escritor.close();
        }catch(IOException e){
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    //Leitura de arquivo
    public void mostrar(){
        System.out.println("=== Histórico de transmissões ===");
        //Tratamento de exceção: o arquivo pode não existir
        try{
            Scanner leitor = new Scanner(new File(this.nomeArquivo));
            while(leitor.hasNextLine()){
                System.out.println(leitor.nextLine());
            }
            leitor.close();
        }catch(FileNotFoundException e){
            System.out.println("O arquivo de histórico ainda não existe");
        }
    }
}
