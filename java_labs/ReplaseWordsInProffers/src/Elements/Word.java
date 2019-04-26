package Elements;

import java.util.List;

public class Word implements Element{
	List<Symbol> word;// = new ArrayList<Symbol>();
	
	public Word(List<Symbol> symbols){
		this.word = symbols;
	}
	@Override
	public String toString(){
		String str = "";
		for(Symbol symb : word){
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

