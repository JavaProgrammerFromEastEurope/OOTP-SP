package Elements;

public class PunctuationMark  implements Element{
	private Symbol symb;
	private static String str = ",?!.:;()«»";
	public static boolean isPunctuationMark(Symbol symb){		
		return str.contains(symb.toString());
	}
	public static boolean isEndPunctuatuionMark(Symbol symb){
		return "?!.".contains(symb.toString());		
	}
	public static boolean isSpace(Symbol symb){
		return symb.toString().contains(" ");
	}
	public PunctuationMark(Symbol symb){
		this.symb = symb;		
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
