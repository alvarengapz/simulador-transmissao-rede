package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;

public class TransmissorViaFibra extends Transmissor{

    public TransmissorViaFibra(Estacao origem, Estacao destino){
        super(origem, destino);
    }

    @Override
    public void enviarMensagem(String texto) throws MensagemExcecao{
        if(texto == null || texto.isEmpty()){
            throw new MensagemExcecao("Mensagem vazia, nada para enviar via fibra");
        }
        System.out.println("Enviando via pulso de luz: " + texto + " - Ultra velocidade");
        registrar("Fibra", texto);
    }
}