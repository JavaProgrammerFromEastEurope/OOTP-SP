package Dictionary;
/**
 * Список
 * @author Alex & Mari
 * Реализация одногосвязного списка.
 */
public class MyList {
    private Object   key;   //Ключ
    private Object value;   //Значение
    private int     hash;   //Хеш
    private MyList  next;   //Следующий элемент списка
    /**
     * Конструктор
     * @param key
     * @param value
     */
    MyList(Object key, Object value) {
        System.out.println(key.hashCode() + " " + key + " " + value );
        this.key = key;
        this.value = value;
        this.hash = key == null ? 0 : key.hashCode();
        this.next = null;
    }
    /**
     * Конструктор по умолчанию
     */
    public MyList() {
        this.key    = null;
        this.value  = null;
        this.next   = null;

    }
    Object getKey() {
        return key;
    }
    /**
     * Добавить элемент в список.
     * Если элемент с таким ключём уже есть, то перезаписать значение.
     * @param key
     * @param value
     */
    void add(Object key, Object value) {
        MyList el = this;
        while (el.next != null) {
            if (el.hash == key.hashCode() && el.key.toString().equals(key.toString())) {
                el.value = value;
                return;
            }
            el = el.next;
        }
        MyList list = new MyList(key, value);
        el.next = list;
    }
    /**
     * Удаление элемента по клюлчу.
     * @param key
     * @return
     */
    boolean delete(Object key) {
        int hash = key.hashCode();
        MyList el   = this;
        MyList back = null;
        while (el  != null) {
            if (el.hash == hash) {
                if (key.toString().equals(el.key.toString())) {
                    if (back != null) {
                        back.next = el.next;
                        return true;
                    }
                }
            }
            back = el;
            el   = el.next;
        }
        return false;
    }
    MyList getNext() {
        return this.next;
    }
    /**
     * Поиск элемента по ключу.
     * @param key
     * Если значение ключа и хеша совпадают, то вернуть элемент.
     * Если проход был совершён до конца списка, и не было найдено элементов, то вернуть null.
     * @return
     */
    Object search(Object key) {
        int hash   = key.hashCode();
        MyList el  = this;
        while (el != null) {
            if (el.hash == hash && this.key.toString().equals(key.toString()))
                return el.value;
            el = el.next;
        }
        return null;
    }
}