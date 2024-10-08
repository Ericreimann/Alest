
public class AppPilha {
    public static void main(String[] args) {
        StackDoubleLinkedList pilha = new StackDoubleLinkedList();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        
        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
        
//        int tam = pilha.size();
//        for(int i=0; i<tam; i++) {
//            System.out.println(pilha.pop());
//        }
    }
    
    // Inverte o conteudo do vet usando uma pilha
    public static void inverte(Integer vet[]) {
        
    }
    
    // Retorna uma copia da pilha recebida por parametro.
    // Mas, no final a pilha recebida por parametro nao
    // pode ficar vazia.
    public static StackArray getClone(StackArray p) {
        return null;
    }
    
    // Copia os elementos da pilha na lista.
    // Mas, no final a pilha recebida por parametro nao
    // pode ficar vazia.    
    public static void addAll(StackArray p, DoubleLinkedListOfInteger l) {
        
    }
}