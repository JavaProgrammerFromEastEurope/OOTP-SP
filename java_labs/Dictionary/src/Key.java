
/**
 * Ключ.
 * @author Vladislav
 * Переопределение методов hashCode() (без использования рандома, по переданному значению) и toString();
 */
public class Key extends Object{
	//Ключ
	private String key;
	/**
	 * Конструктор.
	 * @param key
	 */
	public Key(String key){
		this.key = key;
		
	}
	/**
	 * Расчёт хеша по ключу.
	 * @return хеш
	 */
	@Override
	public int hashCode(){
		char[] array = key.toCharArray();
		int result = 0;
		for(int i = 0; i < array.length; i++){
			result+= Math.abs(((int)array[i]+i)+(int)array[i]);
		}
		return result;
		
	}
	@Override
	public String toString(){
		return key;
	}

}
