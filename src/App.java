import cache.Cache;

public class App {
    private static Cache cache;
    //private static Storage storage;
    
    public static void main(String[] args) throws Exception {
        cache = new Cache();
    }

    public static Cache getCache() { return cache; }
}
