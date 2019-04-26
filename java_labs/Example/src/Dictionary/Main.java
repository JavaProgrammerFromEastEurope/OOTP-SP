package Dictionary;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Dictionary<Key, String> el = new Dictionary<Key, String>();
        String keys[] =
                { "таракан", "рюкзак", "антилопа", "переезд", "кенгуру", "обезъяна", "директор", "капуста", "жвачка",
                        "эклипс", "проезд", "типография", "певец", "гарь" };
        for (int i = 0; i < keys.length; i++) {
            el.add(new Key(keys[i]), "Value" + i + keys[i]);
        }
        // el.add(new Key("таракан"),"Value0");
        // el.add(new Key("рюкзак"),"Value1");
        // el.add(new Key("антилопа"),"Value2");
        // el.add(new Key("переезд"),"Value3");
        // el.add(new Key("кенгуру"),"Value4");
        // el.add(new Key("обезъяна"),"Value5");
        // el.add(new Key("директор"),"Value6");
        // el.add(new Key("капуста"),"Value7");
        // el.add(new Key("жвачка"),"Value8");
        // el.add(new Key("эклипс"),"Value9");
        // el.add(new Key("проезд"),"Value10");
        // el.add(new Key("типография"),"Value11");
        // el.add(new Key("певец"),"Value12");
        // el.add(new Key("гарь"),"Value13");
        el.add(new Key("жвачка"), "жвачка");

        System.out.println(
                el.search(new Key("жвачка"))+el.hashCode());
        if (el.delete(new Key("жвачка"))) {
            System.out.println("Элемент удалён");
        }
        System.out.println(el.search(new Key("жвачка"))+el.hashCode());
    }
}