package com.snowplowanalytics.snowplow.configuration;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import com.snowplowanalytics.snowplow.internal.session.SessionConfigurationInterface;
import com.snowplowanalytics.snowplow.util.TimeMeasure;

/**
 * This class represents the configuration of the applications session.
 * The SessionConfiguration can be used to setup the behaviour of sessions.
 *
 * A session is a context which is appended to each event sent.
 * The values it brings can change based on:
 * - the timeout set for the inactivity of app when in foreground;
 * - the timeout set for the inactivity of app when in background.
 *
 * Session data is maintained for the life of the application being installed on a device.
 * A new session will be created if the session information is not accessed within a configurable timeout.
 */
public class SessionConfiguration implements SessionConfigurationInterface, Configuration {

    /**
     * The amount of time that can elapse before the
     * session id is updated while the app is in the
     * foreground.
     */
    @NonNull
    public TimeMeasure foregroundTimeout;

    /**
     * The amount of time that can elapse before the
     * session id is updated while the app is in the
     * background.
     */
    @NonNull
    public TimeMeasure backgroundTimeout;

    // Constructors

    /**
     * This will setup the session behaviour of the tracker.
     * @param foregroundTimeout The timeout set for the inactivity of app when in foreground.
     * @param backgroundTimeout The timeout set for the inactivity of app when in background.
     */
    public SessionConfiguration(@NonNull TimeMeasure foregroundTimeout, @NonNull TimeMeasure backgroundTimeout) {
        this.foregroundTimeout = foregroundTimeout;
        this.backgroundTimeout = backgroundTimeout;
    }

    // Getters and Setters

    /**
     * @see #foregroundTimeout
     */
    @Override
    @NonNull
    public TimeMeasure getForegroundTimeout() {
        return foregroundTimeout;
    }

    /**
     * @see #foregroundTimeout
     */
    @Override
    public void setForegroundTimeout(@NonNull TimeMeasure foregroundTimeout) {
        this.foregroundTimeout = foregroundTimeout;
    }

    /**
     * @see #backgroundTimeout
     */
    @Override
    @NonNull
    public TimeMeasure getBackgroundTimeout() {
        return backgroundTimeout;
    }

    /**
     * @see #backgroundTimeout
     */
    @Override
    public void setBackgroundTimeout(@NonNull TimeMeasure backgroundTimeout) {
        this.backgroundTimeout = backgroundTimeout;
    }

    // Copyable

    @Override
    @NonNull
    public Configuration copy() {
        return new SessionConfiguration(foregroundTimeout, backgroundTimeout);
    }
}
