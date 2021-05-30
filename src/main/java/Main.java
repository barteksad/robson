public class Main {

    public static void main(String[] args) throws Exception {
        Robson robson = new Robson();
        robson.fromJSON("/home/bartek/Desktop/UW/PO/robson/src/programy/euclidian_algorithm.json");
        System.out.println(robson.wykonaj());
    }
}
