package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;

//Herança (extends) e implementação de interface (implements)
public class TransmissorViaRadio extends Transmissor implements Criptoface {

    public TransmissorViaRadio(Estacao origem, Estacao destino){
        //super: chama o construtor da superclasse
        super(origem, destino);
    }

    //Polimorfismo: implementação própria do método abstrato
    public void enviarMensagem(String texto) throws MensagemExcecao {
        if(texto == null || texto.isEmpty()){
            //throw: lança a exceção personalizada
            throw new MensagemExcecao("Mensagem vazia, nada para enviar via rádio");
        }
        String cifrada = criptografar(texto);
        System.out.println("Enviando via ondas de rádio: " + cifrada + " - Latência média");
        registrar("Rádio", cifrada);
    }

    //Método da interface Criptografavel
    public String criptografar(String texto){
        return "[CRIPTO] " + texto;
    }
}
