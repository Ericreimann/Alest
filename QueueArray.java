/**
 * Implementacao de uma fila que usa um array para armazenar 
 * os elementos.
 * @author Isabel
 */
public class QueueArray {
    // Atributos
    private Integer fila[];
    private int count; // guarda o total de elem da fila
    private int primeiro; // indice do primeiro da fila
    private int ultimo; // indice do ultimo da fila
    
    // Construtor
    public QueueArray() {
        fila = new Integer[10];
    }

    // Construtor
    public QueueArray(int n) {
        if (n>1)
            fila = new Integer[n];
        else
            fila = new Integer[10];
    }    
    
    // Insere o elemento no final da fila
    public void enqueue(Integer element) {
        // Primeiro verifica se a fila nao esta cheia
        if (count == fila.length) {
            throw new FullQueueException("A fila esta cheia");
        }
        fila[ultimo] = element;
        // Passar o ultimo para a proxima posicao
        ultimo = (ultimo+1) % fila.length;
       // Por exemplo num vetor de 5 posicoes (indices 0 a 4):
       // - Se ultimo estava na posicao 2: (2+1)/5, resto eh 5
       // - Se ultimo estava na posicao 4: (4+1)/5, resto eh 0 
       count++;
    }

    // Remove e retorna o elemento removido do inicio da fila, 
    // e dá erro se a fila estiver vazia
    public Integer dequeue() {
        // Primeiro verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException("A fila esta vazia!");
        }
        Integer elemRemovido = fila[primeiro]; // guarda o elem removido
        fila[primeiro] = null; // opcional
        primeiro = (primeiro+1) % fila.length;
        count--; // atualiza count
        return elemRemovido; // retorna o elem removido
    }

    // Retorna, mas não remove, o primeiro elemento da fila, 
    // e dá erro se a fila estiver vazia
    public Integer head()  {
         // Primeiro verifica se a fila nao esta vazia
        if (count == 0) {
            throw new EmptyQueueException("A fila esta vazia!");
        }
        return fila[primeiro];
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
        fila = new Integer[10];
        count = 0;
        primeiro = 0;
        ultimo = 0;
    }       
    
}
