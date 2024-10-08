
import java.util.LinkedList;


public class App {
    public static void main(String[] args) {
        QueueArray fila = new QueueArray();
        fila.enqueue(10);
        fila.enqueue(20);
        fila.enqueue(30);
        
        // Percorre a fila sem deixar ela vazia
        for(int i=0; i<fila.size(); i++) {
            Integer elem = fila.dequeue();
            System.out.println(elem);
            fila.enqueue(elem);
        }
        System.out.println("Tamanho da fila: " + fila.size());
        
        // Percorre a fila deixando ela vazia
        while(!fila.isEmpty()) {
            System.out.println(fila.dequeue());
        }
        System.out.println("Tamanho da fila: " + fila.size());
    }
    
    /**
     * Recebe uma lista e uma fila de inteiros por parâmetro. 
     * Ele deve copiar o conteúdo da fila no final da lista, 
     * mas no final a fila deve estar com o seu conteúdo original, 
     * isto é, ela não deve ser alterada. 
     */
    public static void copia(LinkedList<Integer> lista, QueueArray fila) {
        
    }

    /**
     * Recebe duas filas de inteiros por parâmetro e deve retornar 
     * uma lista concatenando o conteúdo das duas filas. No final
     * as filas devem estar com o seu conteúdo original, isto é, 
     * elas não devem ser alteradas.
     */
    public static LinkedList<Integer> concatena(QueueArray fila1, QueueArray fila2) {
        LinkedList<Integer> l = new LinkedList<>();
        // Concatena os elementos das filas na lista
        return l;
    }
    
}
