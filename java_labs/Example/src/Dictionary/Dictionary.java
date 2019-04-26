package Dictionary;
/**
 * Словарь.
 * @author Alex & Mari
 * Реализация словаря, на основе открытого хеширования
 * @param <K> Ключ
 * @param <V> Зачение
 */
class Dictionary<K, V> {
    // Массив значений
    private MyList[] array;
    /**
     * Конструктор.
     * По умолчанию все элементы массива null.
     */
    Dictionary() {
        array = new MyList[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }
    /**
     * Добавление элементов в массив.
     * Извлекаем хеш-код из ключа, и получаем индекс массива.
     * Если элемент массива пустой, то создаем новый список, если нет, то добавляем в конец списка.
     * @param key
     * @param value
     */
    void add(K key, V value) {
        int hash;
        if (key == null)
            hash = 0;
        else {
            hash = key.hashCode();
            hash %= array.length;
            hash = Math.abs(hash);
        }
        if (array[hash] == null) {
            array[hash] = new MyList(key, value);
        }
        else {
            array[hash].add(key, value);
        }
    }
    /**
     * Поиск элемента по ключу.
     * @param key
     * Извлечение хеша и определение позиции в массиве.
     * Поиск по элементам списка.
     * Если элемент не найден, вернуть null.
     * Если найден, вернуть элемент.
     * @return
     */
    V search(K key) {
        int hash;
        if (key != null) {
            hash = key.hashCode();
            hash %= array.length;
            hash = Math.abs(hash);
            try {
                @SuppressWarnings("unchecked")
                V result = (V) array[hash].search(key);
                return result;
            }
            catch (Exception ex) {
                return null;
            }
        }
        return null;
    }
    /**
     * Удаление элемента по ключу.
     * @param key
     * Извлечение хеша, определение позиции в массиве.
     * Сравнение с первым элементом списка, если он и есть этот элемент, то просто присваиваем следующий элемент списка.
     * Иначе ищем в самом списке.
     * @return Был ли элемент удалён.
     */
    boolean delete(K key) {
        int hash;
        if (key != null) {
            hash = key.hashCode();
            hash %= array.length;
            hash = Math.abs(hash);
            if (array[hash].getKey().toString().equals(key.toString())) {
                array[hash] = array[hash].getNext();
                return true;
            }
            return array[hash].delete(key);
        }
        return false;
    }
}