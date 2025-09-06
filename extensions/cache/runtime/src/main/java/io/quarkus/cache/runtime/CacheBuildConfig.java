package io.quarkus.cache.runtime;

import static io.quarkus.runtime.annotations.ConfigPhase.BUILD_AND_RUN_TIME_FIXED;

import java.util.Map;

import io.quarkus.runtime.annotations.ConfigDocMapKey;
import io.quarkus.runtime.annotations.ConfigDocSection;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithParentName;

@ConfigRoot(phase = BUILD_AND_RUN_TIME_FIXED)
@ConfigMapping(prefix = "quarkus.cache")
public interface CacheBuildConfig {

    String CAFFEINE_CACHE_TYPE = "caffeine";

    /**
     * Cache type.
     */
    @WithDefault(CAFFEINE_CACHE_TYPE)
    String type();

    @ConfigDocMapKey("cache-name")
    @ConfigDocSection
    @WithParentName
    Map<String, CacheTypeBuildConfig> cacheTypeByName();
}
