
import java.util.EmptyStackException;

public class StackArray {
    // Atributos
    private int count;
    private Integer pilha[];
      
    // Construtor
    public StackArray() {
        pilha = new Integer[10];
        count = 0;
    }
    
    // Insere o elemento no topo da pilha
    public void push(Integer element) {
        // Primeiro verifica se a pilha esta cheia
        if(count == pilha.length) {
            throw new FullStackException("Pilha esta cheia!");
        }
        
        pilha[count] = element;
        count++;
    } 
    
    // Remove e retorna o elemento do topo da pilha.
    // Erro se a pilha estiver vazia.
    public Integer pop() {
        // Primeiro verifica se a pilha esta vazia
        if(count == 0) {
            throw new EmptyStackException();
        }
        
        Integer e = pilha[count-1]; // Guarda o elemento do topo da pilha
        pilha[count-1] = null; // "Limpa" o topo da pilha
        count--;  // Atualiza count
        return e; // Retorna o elemento removido do topo
    } 
    
    // Retorna, mas não remove, o elemento do topo da pilha.
    // Erro se a pilha estiver vazia)
    public Integer top() {
         // Primeiro verifica se a pilha esta vazia
        if(count == 0) {
            throw new EmptyStackException();
        }
        return pilha[count-1];
    } 
    
    // Retorna o número de elementos da pilha
    public int size() {
        return count;
    } 
    
    // Retorna true se a pilha estiver vazia, 
    // e false caso contrário
    public boolean isEmpty() {
        return (count==0);
    }
    
    // Esvazia a pilha.
    public void clear() {
        pilha = new Integer[10];
        count = 0;       
    } 

}
