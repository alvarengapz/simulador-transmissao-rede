package br.inatel.rede.transmissor;

import br.inatel.rede.estacao.Estacao;
import br.inatel.rede.historico.HistoricoTransmissoes;

//Classe abstrata: não pode ser instanciada, serve de base para as subclasses
public abstract class Transmissor{

    //static: o contador pertence à classe e é compartilhado por todos os objetos
    private static int totalMensagens = 0;

    //Encapsulamento: atributos private, acesso por get e set
    private Estacao origem;
    private Estacao destino;
    private HistoricoTransmissoes historico;

    public Transmissor(Estacao origem, Estacao destino){
        //Agregação: as estações já existem fora do transmissor, ele só guarda a referência
        this.origem = origem;
        this.destino = destino;
        //Composição: o histórico é criado pelo transmissor e só existe dentro dele
        this.historico = new HistoricoTransmissoes("historico_transmissoes.txt");
    }

    //Método abstrato: cada subclasse é obrigada a implementar
    public abstract void enviarMensagem(String texto) throws MensagemExcecao;

    //Método comum: as subclasses herdam e usam para gravar no arquivo
    public void registrar(String meio, String texto){
        this.historico.gravar(meio + " | " + this.origem.getNome() + " -> " + this.destino.getNome() + " | " + texto);
        totalMensagens++;
    }

    public void mostrarHistorico(){
        this.historico.mostrar();
    }

    //Getters e Setters
    public Estacao getDestino(){
        return this.destino;
    }

    public void setDestino(Estacao destino){
        this.destino = destino;
    }

    //Método static: chamado pela classe, sem precisar de objeto
    public static int getTotalMensagens(){
        return totalMensagens;
    }
}
