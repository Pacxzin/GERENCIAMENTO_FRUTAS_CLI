// Interface que define as operações de gerenciamento de frutas
public interface GerenciamentoFrutas {
    void adicionarFruta(String fruta);  // Método para adicionar uma fruta
    void removerFruta(String fruta);   // Método para remover uma fruta
    void listarFrutas();               // Método para listar todas as frutas
}

import java.util.ArrayList;
import java.util.List;

// Classe que implementa a interface GerenciamentoFrutas
public class GerenciamentoFrutasImpl implements GerenciamentoFrutas {
    
    // Utilizando uma lista para armazenar as frutas, poderia ser um array também
    private List<String> frutas;

    // Construtor que inicializa a lista de frutas
    public GerenciamentoFrutasImpl() {
        this.frutas = new ArrayList<>();
    }

    // Implementação do método adicionarFruta
    @Override
    public void adicionarFruta(String fruta) {
        // Adiciona a fruta na lista
        frutas.add(fruta);
        System.out.println("Fruta " + fruta + " adicionada com sucesso.");
    }

    // Implementação do método removerFruta
    @Override
    public void removerFruta(String fruta) {
        // Verifica se a fruta existe na lista antes de remover
        if (frutas.contains(fruta)) {
            frutas.remove(fruta);
            System.out.println("Fruta " + fruta + " removida com sucesso.");
        } else {
            System.out.println("Fruta " + fruta + " não encontrada.");
        }
    }

    // Implementação do método listarFrutas
    @Override
    public void listarFrutas() {
        if (frutas.isEmpty()) {
            System.out.println("Não há frutas no sistema.");
        } else {
            System.out.println("Frutas no sistema:");
            for (String fruta : frutas) {
                System.out.println("- " + fruta);
            }
        }
    }
}

// Classe principal que testa as funcionalidades de gerenciamento de frutas
public class Main {
    public static void main(String[] args) {
        
        // Criando um objeto do tipo GerenciamentoFrutas usando a implementação
        GerenciamentoFrutas gerenciamento = new GerenciamentoFrutasImpl();

        // Testando as operações
        gerenciamento.adicionarFruta("Maçã");
        gerenciamento.adicionarFruta("Banana");
        gerenciamento.adicionarFruta("Laranja");

        // Listando as frutas
        gerenciamento.listarFrutas();
        
        // Removendo uma fruta
        gerenciamento.removerFruta("Banana");

        // Listando novamente as frutas após a remoção
        gerenciamento.listarFrutas();
        
        // Tentando remover uma fruta que não existe
        gerenciamento.removerFruta("Manga");
    }
}
