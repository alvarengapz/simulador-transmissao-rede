package br.inatel.rede;

import br.inatel.rede.estacao.Estacao;
import br.inatel.rede.transmissor.MensagemExcecao;
import br.inatel.rede.transmissor.Transmissor;
import br.inatel.rede.transmissor.TransmissorViaFibra;
import br.inatel.rede.transmissor.TransmissorViaRadio;

public class Main{

    public static void main(String args[]){

        // Criando estações
        Estacao matriz = new Estacao("Matriz");
        Estacao filial = new Estacao("Filial");
        Estacao deposito = new Estacao("Depósito");

        //Criando transmissores
        Transmissor radio = new TransmissorViaRadio(matriz, filial);
        Transmissor fibra = new TransmissorViaFibra(matriz, filial);

        fibra.setDestino(deposito);
        System.out.println("Destino da fibra: " + fibra.getDestino().getNome());

        try{
            radio.enviarMensagem("Olá, equipe!");
            fibra.enviarMensagem("Olá, equipe!");
            fibra.enviarMensagem("");
        }catch(MensagemExcecao e){
            System.out.println("Erro: " + e.getMessage());
        }

        radio.mostrarHistorico();

        System.out.println("Mensagens enviadas: " + Transmissor.getTotalMensagens());
    }
}