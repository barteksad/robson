public class Main {

    public static void main(String[] args) throws Exception {
        Robson robson = new Robson();
        robson.fromJSON("/home/bartek/Desktop/UW/PO/robson/src/main/java/programy/przyklad2.json");
        robson.toJSON("nic.json");
        System.out.println(robson.wykonaj());
    }
}
