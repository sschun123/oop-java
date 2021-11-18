public class StringOperations {
    public static void main(String[] args) {
        String name = "Samuel";
        System.out.println(name);

        name = name.replace("S", "A").replace("l", "Z");
        System.out.println(name);

        String gatech = "www.gatech.edu";
        System.out.println(gatech);

        int startIdx = 4;
        int endIdx = gatech.length() - 4;
        String domain = gatech.substring(startIdx, endIdx).concat("1331");
        System.out.println(domain);
    }
}
