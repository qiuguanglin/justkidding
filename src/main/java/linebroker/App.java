package linebroker;

class App {


    public static void main(String[] args) throws InvalidLineException {
        App app = new App();
        String[] words = {"i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man", "go", "mango", "and"};
        LineBreaker lb = new LineBreaker();

        System.out.println(lb.brokenLines("ihateiclikee", new String[]{"i", "like", "ice", "hat", "eic",}));
    }




}