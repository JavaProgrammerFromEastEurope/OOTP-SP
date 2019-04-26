package Elements;

public class Numeral extends Symbol{
	public static boolean isNumeral(Symbol symb){

		String str = "0123456789";
		return str.contains(symb.toString());
	}
	public Numeral(char symb) {
		super(symb);
	}
	public Numeral(Symbol symb){
		super(symb.toString().charAt(0));
		
	}
	

}
