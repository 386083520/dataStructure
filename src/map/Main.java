package map;

public class Main {
    public static void main(String[] args) {
        Map map = new BSTreeMap();
        map.add("a", "a");
        map.add("b", "b");
        map.add("c", "c");
        System.out.println(map.toString());
        System.out.println(map.get("b") + "," + map.contains("b"));
        map.remove("b");
        System.out.println(map.toString());
        System.out.println(map.getSize() + "," +map.isEmpty());
        map.set("c", "d");
        System.out.println(map.toString());
        map.set("f", "f");
    }
}
