package br.inatel.rede.transmissor;

//Exceção personalizada: herda de Exception
public class MensagemExcecao extends Exception{

    public MensagemExcecao(String mensagem){
        super(mensagem);
    }
}
