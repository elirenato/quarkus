package io.quarkus.cache;

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public interface CacheManagerInfo {

    boolean supports(Context context);

    Supplier<Map<String, Cache>> get(Context context);

    interface Context {

        boolean cacheEnabled();

        Metrics metrics();

        String cacheType();

        Set<String> cacheNames();

        enum Metrics {
            NONE,
            MICROMETER
        }
    }
}
