package controller;

import cache.Cache;

/**
 * Minimal SystemController that wraps the Cache and contains business logic.
 * Expand this with real use-cases (search, aggregates, CRUD operations) as needed.
 */
public class SystemController {
    private final Cache cache;

    public SystemController(Cache cache) {
        this.cache = cache;
    }

    public Cache getCache() { return cache; }

    // Example business methods can be added here
}
