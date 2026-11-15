package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;

public class TransmissorViaRadio extends Transmissor implements Criptoface{

    public TransmissorViaRadio(Estacao origem, Estacao destino){
        super(origem, destino);
    }

    @Override
    public void enviarMensagem(String texto) throws MensagemExcecao{
        if(texto == null || texto.isEmpty()){
            throw new MensagemExcecao("Mensagem vazia, nada para enviar via rádio");
        }
        String cifrada = criptografar(texto);
        System.out.println("Enviando via ondas de rádio: " + cifrada + " - Latência média");
        registrar("Rádio", cifrada);
    }

    @Override
    public String criptografar(String texto){
        return "[CRIPTO] " + texto;
    }
}