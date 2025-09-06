package io.quarkus.cache.runtime;

import io.quarkus.runtime.annotations.ConfigPhase;
import io.quarkus.runtime.annotations.ConfigRoot;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * Allow customization of a different provider for a cache name
 */
@ConfigRoot(phase = ConfigPhase.BUILD_AND_RUN_TIME_FIXED)
@ConfigMapping(prefix = "quarkus.cache")
public interface CacheTypeBuildConfig {

    /**
     * Custom cache type (provider).
     */
    @WithDefault("")
    String type();
}
