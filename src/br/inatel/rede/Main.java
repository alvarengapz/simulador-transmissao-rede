package br.inatel.rede;

import br.inatel.rede.estacao.Estacao;
import br.inatel.rede.transmissor.MensagemExcecao;
import br.inatel.rede.transmissor.Transmissor;
import br.inatel.rede.transmissor.TransmissorViaFibra;
import br.inatel.rede.transmissor.TransmissorViaRadio;

public class Main{

    public static void main(String args[]){

        Estacao matriz = new Estacao("Matriz");
        Estacao filial = new Estacao("Filial");
        Estacao deposito = new Estacao("Depósito");

        //Polimorfismo: variável da superclasse guardando objeto da subclasse
        Transmissor radio = new TransmissorViaRadio(matriz, filial);
        Transmissor fibra = new TransmissorViaFibra(matriz, filial);

        //Set e get: a fibra passa a enviar para outro destino
        fibra.setDestino(deposito);
        System.out.println("Destino da fibra: " + fibra.getDestino().getNome());

        //Tratamento de exceção: a última mensagem é vazia e lança MensagemVaziaException
        try{
            radio.enviarMensagem("Olá, equipe!");
            fibra.enviarMensagem("Olá, equipe!");
            fibra.enviarMensagem("");
        }catch(MensagemExcecao e){
            System.out.println("Erro: " + e.getMessage());
        }

        radio.mostrarHistorico();

        //static: chamado pela própria classe, sem criar objeto
        System.out.println("Mensagens enviadas: " + Transmissor.getTotalMensagens());
    }
}
