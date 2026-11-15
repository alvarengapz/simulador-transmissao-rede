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

    public void gravar(String linha){
        try{
            FileWriter escritor = new FileWriter(this.nomeArquivo, true);
            escritor.write(linha + "\n");
            escritor.close();
        }catch(IOException e){
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    public void mostrar(){
        System.out.println("=== Histórico de transmissões ===");
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