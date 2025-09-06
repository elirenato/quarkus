package io.quarkus.cache.runtime.noop;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

import io.quarkus.cache.Cache;

public class NoOpCacheManagerBuilder {

    public static Supplier<Map<String, Cache>> build(Set<String> cacheNames) {
        Objects.requireNonNull(cacheNames);
        return new Supplier<Map<String, Cache>>() {
            @Override
            public Map<String, Cache> get() {
                if (cacheNames.isEmpty()) {
                    return Collections.emptyMap();
                } else {
                    // The number of caches is known at build time so we can use fixed initialCapacity and loadFactor for the caches map.
                    Map<String, Cache> caches = new HashMap<>(cacheNames.size() + 1, 1.0F);
                    NoOpCache cache = new NoOpCache();
                    for (String cacheName : cacheNames) {
                        caches.put(cacheName, cache);
                    }
                    return caches;
                }
            }
        };
    }
}
