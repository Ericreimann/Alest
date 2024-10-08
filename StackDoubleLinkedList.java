
import java.util.EmptyStackException;


public class StackDoubleLinkedList {
    
    // Atributo
    private DoubleLinkedListOfInteger pilha;
    
    // Construtor
    public StackDoubleLinkedList() {
        pilha = new DoubleLinkedListOfInteger();
        // Topo da pilha será o final
    }
    
    // Insere o elemento no topo da pilha
    public void push(Integer element) {
        pilha.add(element);
    } 
    
    // Remove e retorna o elemento do topo da pilha.
    // Erro se a pilha estiver vazia.
    public Integer pop() {
        // Primeiro verifica se a pilha esta vazia
        if(pilha.size() == 0) {
            throw new EmptyStackException();
        }
      
        return pilha.removeByIndex(pilha.size()-1);
    } 
    
    // Retorna, mas não remove, o elemento do topo da pilha.
    // Erro se a pilha estiver vazia)
    public Integer top() {
         // Primeiro verifica se a pilha esta vazia
        if(pilha.size() == 0) {
            throw new EmptyStackException();
        }
        
        return pilha.get(pilha.size()-1);
    } 
    
    // Retorna o número de elementos da pilha
    public int size() {
        return pilha.size();
    } 
    
    // Retorna true se a pilha estiver vazia, 
    // e false caso contrário
    public boolean isEmpty() {
        return (pilha.isEmpty());
    }
    
    // Esvazia a pilha.
    public void clear() {
        pilha.clear();
    }     
    
}
