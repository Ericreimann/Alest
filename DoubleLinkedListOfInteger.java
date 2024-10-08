
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;    
    // Contador do numero de elementos da lista.
    private int count;

     private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Cria o nodo
        Node n = new Node(element);
        
        // Primeiro conecta o novo nodo na lista
        n.next = trailer;
        n.prev = trailer.prev; 
        
        // Depois atualiza os encadeamentos
        Node ant = trailer.prev;// \ trailer.prev.next = n
        ant.next = n;           // / Em um comando só
        trailer.prev = n;
        
        // Atualiza o count
        count++;  
    }
    
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        // Primeiro verifica se index eh valido 
        if (index < 0 || index > count ) 
        	throw new IndexOutOfBoundsException();
        
        // Verifica se eh o caso de insercao no final
        if (index == count) {
            add(element);
        }
        else { // Se insercao no inicio ou no meio
            // Primeiro cria o nodo
            Node n = new Node(element);
            // Pega a referencia para o nodo da posicao index
            Node aux = getNodeIndex(index);
            // Conecta o novo nodo na lista
            n.next = aux;
            n.prev = aux.prev;
            // Atualizar as referencias para apontarem para o novo nodo
            aux.prev.next = n;
            aux.prev = n;
            // Atualizar o count
            count++;
        }
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if(aux.element.equals(element)) { // Se achou element
                // Faz a remocao
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next; // Se nao achou, passa para a proxima posicao
        }
        return false;	
    }
    
    /**
     * Retorna uma referencia para o nodo da posicao index 
     */
    private Node getNodeIndex(int index) {
        Node aux = null;
        
        // Faz aux "caminhar" ate a posicao index
        if (index < count/2) { // Se esta na primeira metade,
            // percorre do inicio para o meio.
            aux = header.next; // aponta para o primeiro da lista
            for (int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // Se esta na segunda metade,
            // percorre do fim para o meio.
            aux = trailer.prev; // aponta para o ultimo da lista
            for (int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }
        
        return aux; // referencia para o nodo da posicao index
    }
    
    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
 
        // "Caminhar" ate a posicao index
        Node aux = getNodeIndex(index);
        
        // Atualiza as referencias para fazer a remocao
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        
        // Atualiza o count
        count--;
        
        // Retorna o elemento removido
        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        // "Caminhar" ate a posicao index
        Node aux = getNodeIndex(index);
        Integer num = aux.element; // guarda o elemento da posicao index
        aux.element = element; // coloca o novo elemento na posicao index
        return num; // retorna o elemento "antigo" da posicao index
    }    
   
    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        // Primeiro verifica se os indices sao validos
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();    
        
        // Cria o array
        Integer a[] = new Integer[toIndex-fromIndex];
        
        // Caminha ate a posicao fromIndex
        Node aux = getNodeIndex(fromIndex);
        
        // Caminha de fromIndex ate toIndex copiando os elem para o array
        for(int i=0; i<a.length; i++) {
            a[i] = aux.element;
            aux = aux.next; // faz o aux apontar para a proxima posicao
        }
        // Retorna o array
        return a;
    }  
    
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }
    
    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }    
        
    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }
    
    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }
        
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }    
    
    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }  

    public void reverse() {
        // Aponta para o primeiro da lista
        Node aux1 = header.next;
        // Aponta para o ultimo da lista
        Node aux2 = trailer.prev;
        
        // "Caminha" ate a metade da lista
        for (int i=0; i<(count/2); i++) {
            // Troca os elementos
            Integer num = aux1.element;
            aux1.element = aux2.element;
            aux2.element = num;
            // Atualizar os "aux"
            aux1 = aux1.next;
            aux2 = aux2.prev;
        }
    }
    
    public boolean equals (DoubleLinkedListOfInteger outra) {
         if (count != outra.count) { // se as listas possuem tamanhos diferentes
            return false; // retorna false
        }
        Node aux = header.next; // referencia auxiliar para "caminhar" na lista
        Node auxOutra = outra.header.next; // referencia auxiliar para "caminhar" na outra lista
        for (int i=0; i<count; i++) {
            if (! aux.element.equals(auxOutra.element))  { // se os elementos forem diferentes
                return false; // retorna false
            }
            aux = aux.next;
            auxOutra = auxOutra.next;
        }
        // Se chegou aqui, todos elementos sao iguais e retorna true
        return true;       
    }
    
    public int countOccurrences(Integer element) {
        Node aux = header.next;
        int c = 0;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                c++;
            }
            aux = aux.next;
        }
        return c;        
    }
    
    /**
     * Percorre a lista e retira elementos repetidos, deixando 
     * apenas uma ocorrência de cada elemento. Não pode chamar
     * outros métodos. Use os atributos da classe.
     */
    public void unique() {
        Node aux1, aux2;
        aux1 = header.next;
        while (aux1 != trailer) {
            aux2 = aux1.next;
            while (aux2 != trailer) {
                if (aux1.element.equals(aux2.element)) { // se forem iguais
                    // faz a remocao
                    aux2.prev.next = aux2.next;
                    aux2.next.prev = aux2.prev;
                    count--;
                }
                aux2 = aux2.next;
            }
            aux1 = aux1.next;
        }        
    }
}
