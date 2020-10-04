package com.wrc.apiObjects;

public interface apiFields {

    // -----------------------------------------------------------------------------
    // Enum 'fields' to represent fields in responses(JSON) from OpenWeatherMap.org
    // -----------------------------------------------------------------------------
    enum fields {
        LATITUDE("latitude"),
        LONGITUDE("longitude");

        private String associatedText;

        fields(String associatedText) { this.associatedText = associatedText; }

        @Override
        public String toString() {
            return this.associatedText;
        }

    };
}
