package core;

import Elements.*;
import Elements.Number;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	
	private static String readFile(String patch) {
		String str = "";
		try {
			FileReader reader = new FileReader(patch);
			int c;
			while ((c = reader.read()) != -1) {
				str += (char) c;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void main(String[] args) {
		List<Proffer> proffers = new ArrayList<Proffer>();
		Proffer prof = new Proffer();
		List<Symbol> list = new ArrayList<Symbol>();
		String fileText = readFile("file.txt");
		fileText = fileText.replaceAll("\t", " ");
		fileText = fileText.replaceAll("\r\n", " ");
		int quote = 0;
		int bracket = 0;
		for (char s : fileText.toCharArray()) {
			Symbol symb = new Symbol(s);
			if (s == ')' || s == '(')
				bracket++;
			if (s == '"' || s == '\'' || s == '�' || s == '�')
				quote++;
			if (PunctuationMark.isPunctuationMark(symb)
					|| PunctuationMark.isSpace(symb)) {
				if (list.size() != 0)
					if (Numeral.isNumeral(list.get(0))) {
						Number num = new Number();
						for (Symbol sym : list) {
							if (Numeral.isNumeral(sym))
								num.addNumeral(new Numeral(sym));
						}
						prof.addElement(num);
					} else
						prof.addElement(new Word(list));
				if (PunctuationMark.isPunctuationMark(symb))
					prof.addElement(symb);
				list = new ArrayList<Symbol>();
			} else if (!PunctuationMark.isSpace(symb))
				list.add(symb);
			if (quote % 2 == 0 && bracket % 2 == 0)
				if (PunctuationMark.isEndPunctuatuionMark(symb)) {
					proffers.add(prof);
					prof = new Proffer();
				}

		}
		for (Proffer proffer : proffers) {
			System.out.println("============================");
			proffer.replaceWords();
			proffer.show();
			System.out.println("\n============================");
		}

	}

}
