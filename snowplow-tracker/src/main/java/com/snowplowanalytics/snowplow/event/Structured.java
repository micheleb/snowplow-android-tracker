/*
 * Copyright (c) 2015-2020 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

package com.snowplowanalytics.snowplow.event;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.snowplowanalytics.snowplow.internal.constants.Parameters;
import com.snowplowanalytics.snowplow.internal.constants.TrackerConstants;
import com.snowplowanalytics.snowplow.internal.utils.Preconditions;

import java.util.HashMap;
import java.util.Map;

/**
 * Constructs a Structured event object.
 */
public class Structured extends AbstractPrimitive {

    @NonNull
    public final String category;
    @NonNull
    public final String action;
    @Nullable
    public String label;
    @Nullable
    public String property;
    @Nullable
    public Double value;
    @Nullable
    public String pageUrl;
    @Nullable
    private String referrer;

    public static abstract class Builder<T extends Builder<T>> extends AbstractEvent.Builder<T> {

        private String category;
        private String action;
        private String label;
        private String property;
        private Double value;
        private String pageUrl;
        private String referrer;

        /**
         * @param category Category of the event
         * @return itself
         */
        @NonNull
        public T category(@NonNull String category) {
            this.category = category;
            return self();
        }

        /**
         * @param action The event itself
         * @return itself
         */
        @NonNull
        public T action(@NonNull String action) {
            this.action = action;
            return self();
        }

        /**
         * @param label Refer to the object the action is performed on
         * @return itself
         */
        @NonNull
        public T label(@NonNull String label) {
            this.label = label;
            return self();
        }

        /**
         * @param property Property associated with either the action or the object
         * @return itself
         */
        @NonNull
        public T property(@NonNull String property) {
            this.property = property;
            return self();
        }

        /**
         * @param value A value associated with the user action
         * @return itself
         */
        @NonNull
        public T value(@NonNull Double value) {
            this.value = value;
            return self();
        }

        /**
         * @param pageUrl the current page URL
         * @return itself
         */
        @NonNull
        public T pageUrl(@NonNull String pageUrl) {
            this.pageUrl = pageUrl;
            return self();
        }

        /**
         * @param referrer the page URL from which we're coming
         * @return itself
         */
        @NonNull
        public T referrer(@NonNull String referrer) {
            this.referrer = referrer;
            return self();
        }

        @NonNull
        public Structured build() {
            return new Structured(this);
        }
    }

    private static class Builder2 extends Builder<Builder2> {
        @NonNull
        @Override
        protected Builder2 self() {
            return this;
        }
    }

    @NonNull
    public static Builder<?> builder() {
        return new Builder2();
    }

    protected Structured(@NonNull Builder<?> builder) {
        super(builder);

        // Precondition checks
        Preconditions.checkNotNull(builder.category);
        Preconditions.checkNotNull(builder.action);
        Preconditions.checkArgument(!builder.category.isEmpty(), "category cannot be empty");
        Preconditions.checkArgument(!builder.action.isEmpty(), "action cannot be empty");

        this.category = builder.category;
        this.action = builder.action;
        this.label = builder.label;
        this.property = builder.property;
        this.value = builder.value;
        this.pageUrl = builder.pageUrl;
        this.referrer = builder.referrer;
    }

    public Structured(@NonNull String category, @NonNull String action) {
        Preconditions.checkNotNull(category);
        Preconditions.checkNotNull(action);
        Preconditions.checkArgument(!category.isEmpty(), "category cannot be empty");
        Preconditions.checkArgument(!action.isEmpty(), "action cannot be empty");
        this.category = category;
        this.action = action;
    }

    // Builder methods

    @NonNull
    public Structured label(@Nullable String label) {
        this.label = label;
        return this;
    }

    @NonNull
    public Structured property(@Nullable String property) {
        this.property = property;
        return this;
    }

    @NonNull
    public Structured value(@Nullable Double value) {
        this.value = value;
        return this;
    }

    // Public methods

    @NonNull
    @Override
    public Map<String, Object> getDataPayload() {
        HashMap<String, Object> payload = new HashMap<>(6);
        payload.put(Parameters.SE_CATEGORY, category);
        payload.put(Parameters.SE_ACTION, action);
        if (label != null) payload.put(Parameters.SE_LABEL, label);
        if (property != null) payload.put(Parameters.SE_PROPERTY, property);
        if (value != null) payload.put(Parameters.SE_VALUE, Double.toString(value));
        if (pageUrl != null) payload.put(Parameters.PAGE_URL, pageUrl);
        if (referrer != null) payload.put(Parameters.PAGE_REFR, referrer);
        return payload;
    }

    @NonNull
    @Override
    public String getName() {
        return TrackerConstants.EVENT_STRUCTURED;
    }
}
