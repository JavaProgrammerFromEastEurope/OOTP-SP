package Elements;

public class Symbol implements Element {
	
	private char symb;
	
	public Symbol(char symb){
		this.symb = symb;
	}
	@Override
	public String toString(){
		return String.valueOf(symb);
	}
	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.print(symb);
		
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return this.getClass().getTypeName();
	}

}
