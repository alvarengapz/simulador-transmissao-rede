package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;

//Herança (extends)
public class TransmissorViaFibra extends Transmissor{

    public TransmissorViaFibra(Estacao origem, Estacao destino){
        //super: chama o construtor da superclasse
        super(origem, destino);
    }

    //Polimorfismo: implementação própria do método abstrato
    public void enviarMensagem(String texto) throws MensagemExcecao {
        if(texto == null || texto.isEmpty()){
            //throw: lança a exceção personalizada
            throw new MensagemExcecao("Mensagem vazia, nada para enviar via fibra");
        }
        System.out.println("Enviando via pulso de luz: " + texto + " - Ultra velocidade");
        registrar("Fibra", texto);
    }
}
