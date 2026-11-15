package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;
import br.inatel.rede.historico.HistoricoTransmissoes;

public abstract class Transmissor{

    private static int totalMensagens = 0;

    private Estacao origem;
    private Estacao destino;
    private HistoricoTransmissoes historico;

    public Transmissor(Estacao origem, Estacao destino){
        this.origem = origem;
        this.destino = destino;
        this.historico = new HistoricoTransmissoes("historico_transmissoes.txt");
    }

    public abstract void enviarMensagem(String texto) throws MensagemExcecao;

    public void registrar(String meio, String texto){
        this.historico.gravar(meio + " | " + this.origem.getNome() + " -> " + this.destino.getNome() + " | " + texto);
        totalMensagens++;
    }

    public void mostrarHistorico(){
        this.historico.mostrar();
    }

    public Estacao getDestino(){
        return this.destino;
    }

    public void setDestino(Estacao destino){
        this.destino = destino;
    }

    public static int getTotalMensagens(){
        return totalMensagens;
    }
}