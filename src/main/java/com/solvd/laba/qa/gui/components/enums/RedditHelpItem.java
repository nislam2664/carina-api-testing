package com.solvd.laba.qa.gui.components.enums;

public enum RedditHelpItem {
    ACCOUNT_STATUS ("Account Status"),
    REDDIT_101 ("Reddit 101"),
    FEATURES_EXPERIENCES ("Reddit Features & Experiences"),
    RULES_REPORTING ("Rules & Reporting"),
    PRIVACY_SECURITY ("Privacy & Security"),
    REDDIT_APPS ("Reddit Apps");

    private final String title;

    RedditHelpItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
