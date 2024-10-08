
public class QueueLinked {
    
    private class Node {
        public Integer element;
        public Node next;
        public Node(Integer e) {
            element = e;
        }
    }
    
    // Atributos
    private Node head;
    private Node tail;
    int count;
    
    // Insere o elemento no final da fila
    public void enqueue(Integer element) {
        // Cria o nodo e coloca no final da fila
    }

    // Remove e retorna o elemento removido do inicio da fila, 
    // e dá erro se a fila estiver vazia
    public Integer dequeue() {
        // Primeiro verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException("A fila esta vazia!");
        }
        return 0;
        // Faz a remocao do ultimo da fila
    }

    // Retorna, mas não remove, o primeiro elemento da fila, 
    // e dá erro se a fila estiver vazia
    public Integer head()  {
         // Primeiro verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException("A fila esta vazia!");
        }
        return head.element;
    }

    // retorna o número de elementos da fila
    public int size() {
        return count;
    }

    // retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return (count == 0);
    }

    // esvazia a fila
    public void clear()  {
        head = null;
        tail = null;
        count = 0;
    }      
}
