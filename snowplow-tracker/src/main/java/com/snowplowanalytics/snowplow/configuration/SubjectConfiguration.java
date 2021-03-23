package com.snowplowanalytics.snowplow.configuration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.snowplowanalytics.snowplow.util.Size;

/**
 * This class represents the configuration of the subject.
 * The SubjectConfiguration can be used to setup the tracker with the basic information about the
 * user and the app which will be attached on all the events as contexts.
 * The contexts to track can be enabled in the {@link TrackerConfiguration} class.
 */
public class SubjectConfiguration implements Configuration {

    /**
     * @see #userId(String) 
     */ 
    @Nullable
    public String userId;
    /**
     * @see #networkUserId(String) 
     */
    @Nullable
    public String networkUserId;
    /**
     * @see #domainUserId(String) 
     */
    @Nullable
    public String domainUserId;
    /**
     * @see #useragent(String) 
     */
    @Nullable
    public String useragent;
    /**
     * @see #ipAddress(String) 
     */
    @Nullable
    public String ipAddress;

    /**
     * @see #timezone(String) 
     */
    @Nullable
    public String timezone;
    /**
     * @see #language(String) 
     */
    @Nullable
    public String language;

    /**
     * @see #screenResolution(Size) 
     */
    @Nullable
    public Size screenResolution;
    /**
     * @see #screenViewPort(Size) 
     */
    @Nullable
    public Size screenViewPort;
    /**
     * @see #colorDepth(Integer) 
     */
    @Nullable
    public Integer colorDepth;

    // Builder methods

    /**
     * The custom UserID.
     */
    @NonNull
    public SubjectConfiguration userId(@Nullable String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * The network UserID.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration networkUserId(@Nullable String networkUserId) {
        this.networkUserId = networkUserId;
        return this;
    }

    /**
     * The domain UserID.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration domainUserId(@Nullable String domainUserId) {
        this.domainUserId = domainUserId;
        return this;
    }

    /**
     * The user-agent.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration useragent(@Nullable String useragent) {
        this.useragent = useragent;
        return this;
    }

    /**
     * The IP address.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration ipAddress(@Nullable String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    /**
     * The current timezone.
     */
    @NonNull
    public SubjectConfiguration timezone(@Nullable String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * The language set in the device.
     */
    @NonNull
    public SubjectConfiguration language(@Nullable String language) {
        this.language = language;
        return this;
    }

    /**
     * The screen resolution.
     */
    @NonNull
    public SubjectConfiguration screenResolution(@Nullable Size screenResolution) {
        this.screenResolution = screenResolution;
        return this;
    }

    /**
     * The screen viewport.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration screenViewPort(@Nullable Size screenViewPort) {
        this.screenViewPort = screenViewPort;
        return this;
    }

    /**
     * The color depth.
     * @apiNote It's not generated by the tracker, it needs to be filled by the developer when instrumenting the tracker.
     */
    @NonNull
    public SubjectConfiguration colorDepth(@Nullable Integer colorDepth) {
        this.colorDepth = colorDepth;
        return this;
    }

    // Copyable

    @Override
    @NonNull
    public SubjectConfiguration copy() {
        SubjectConfiguration copy = new SubjectConfiguration();
        copy.userId = userId;
        copy.networkUserId = networkUserId;
        copy.domainUserId = domainUserId;
        copy.useragent = useragent;
        copy.ipAddress = ipAddress;
        copy.timezone = timezone;
        copy.language = language;
        copy.screenResolution = screenResolution;
        copy.screenViewPort = screenViewPort;
        copy.colorDepth = colorDepth;
        return copy;
    }
}
