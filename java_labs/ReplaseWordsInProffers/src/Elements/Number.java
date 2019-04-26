package Elements;

import java.util.ArrayList;
import java.util.List;

public class Number implements Element{
	private List<Numeral> numerals = new ArrayList<>();
	public Number(List<Numeral> numerals) {
		this.numerals = numerals;
	}
	public Number(){}
	public void addNumeral(Numeral num){
		numerals.add(num);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print(toString());
		
	}
	public String toString(){
		String str = "";
		for(Numeral num : numerals){
			str+= num;
		}
		return str;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.getClass().getName();
	}

}
