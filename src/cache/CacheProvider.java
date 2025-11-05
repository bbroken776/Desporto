package cache;

/**
 * Small provider for a singleton Cache instance used by the UI.
 * Kept minimal to avoid modifying the existing Cache implementation.
 */
public final class CacheProvider {
    private static Cache instance = null;

    private CacheProvider() {}

    public static synchronized Cache get() {
        if (instance == null) instance = new Cache();
        return instance;
    }

    public static synchronized void set(Cache c) { instance = c; }
}
