package Elements;

import java.util.ArrayList;
import java.util.List;

public class Proffer implements Element {
	private List<Element> list = new ArrayList<Element>();

	public void addElement(Element symb) {
		list.add(symb);
	}

	public void addElements(List<Element> symb) {
		list.addAll(symb);
	}
	
	public void addWords(List<Word> words) {
		list.addAll(words);

	}

	public int getCountWords() {
		int count = 0;
		for (Element el : list)
			if (el.getType().contains("Word"))
				count++;
		return count;
	}
	
	
	public List<Word> getWords(){
		List<Word> list = new ArrayList<Word>();
		for(Element el : this.list){
			if(el.getType().contains("Word")){
				list.add((Word)el);
			}
		}
		return list;
	}
	
	public void replaceWords(){
		Word[] words = new Word[getWords().toArray().length];
		Object[] objects = getWords().toArray();
		for(int i = 0; i < words.length; i++){
			words[i] = (Word)objects[i];
		}
		for(int i = 0, j = words.length-1; i < j; i++, j--){
			Word word = words[i];
			words[i] = words[j];
			words[j] = word;			
		}
		int j = 0;
		for(int i = 0; i < list.size(); i++){
			Element el = list.get(i);
			if(el.getType().contains("Word")){
				list.set(i, words[j]);
				j++;
			}
		};
	}
	

	@Override
	public String toString() {
		String str = "";
		for (Element symb : list) {
			if (!symb.getType().contains("Symbol"))
				str += " ";

			str += symb;
		}
		return str;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print(this.toString());

	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub

		return this.getClass().getTypeName();
	}
}
