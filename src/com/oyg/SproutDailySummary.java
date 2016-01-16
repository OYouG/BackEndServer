package com.oyg;

import java.util.Date;

/**
 * Created by msllavore on 1/15/16.
 */
public class SproutDailySummary {
    private Date day;
    private int tweets;
    private int clicks;
    private int mentions;
    private int retweets;
    private int uniqueUsers;
    private int followers;
    private int newFollowers;
    private int following;
    private int storiesCreated;
    private int storyCreators;
    private int pageImpressions;
    private int impressionsPaid;
    private int impressionsOrganic;

    public SproutDailySummary(Date day, int tweets, int clicks, int mentions, int retweets, int uniqueUsers, int followers, int newFollowers, int following, int storiesCreated, int storyCreators, int pageImpressions, int impressionsPaid, int impressionsOrganic) {
        this.day = day;
        this.tweets = tweets;
        this.clicks = clicks;
        this.mentions = mentions;
        this.retweets = retweets;
        this.uniqueUsers = uniqueUsers;
        this.followers = followers;
        this.newFollowers = newFollowers;
        this.following = following;
        this.storiesCreated = storiesCreated;
        this.storyCreators = storyCreators;
        this.pageImpressions = pageImpressions;
        this.impressionsPaid = impressionsPaid;
        this.impressionsOrganic = impressionsOrganic;
    }

    public String toString() {
        return "Day: " + this.day + "\nTweets: " + this.tweets +
                "\nClicks: " + this.clicks + "\nMentions: " + this.mentions +
                "\nRetweets: " + this.retweets + "\nUnique Users: " + this.uniqueUsers +
                "\nFollowers: " + this.followers + "\nNew Followers: " + this.newFollowers +
                "\nFollowing: " + this.following + "\nStories Created: " + this.storiesCreated +
                "\nStory Creators: " + this.storyCreators + "\nPage Impressions: " + this.pageImpressions +
                "\nImpressions Paid: " + this.impressionsPaid + "\nImpressions Organic: " + this.impressionsOrganic + "\n\n";
    }

    public Date getDay() { return day; }

    public void setDay(Date day) { this.day = day; }

    public int getTweets() { return tweets; }

    public void setTweets(int tweets) { this.tweets = tweets; }

    public int getClicks() { return clicks; }

    public void setClicks(int clicks) { this.clicks = clicks; }

    public int getMentions() { return mentions; }

    public void setMentions(int mentions){ this.mentions = mentions; }

    public int getRetweets() { return retweets; }

    public void setRetweets(int retweets){ this.retweets = retweets; }

    public int getUniqueUsers() { return uniqueUsers; }

    public void setUniqueUsers(int uniqueUsers){ this.uniqueUsers = uniqueUsers; }

    public int getFollowers() { return followers; }

    public void setFollowers(int followers){ this.followers = followers; }

    public int getNewFollowers() { return newFollowers; }

    public void setNewFollowers(int newFollowers) { this.newFollowers = newFollowers; }

    public int getFollowing() { return following; }

    public void setFollowing (int following) { this.following = following; }

    public int getStoriesCreated() { return storiesCreated; }

    public void setStoriesCreated(int storiesCreated) { this.storiesCreated = storiesCreated; }

    public int getStoryCreators() { return storyCreators; }

    public void setStoryCreators(int storyCreators) { this.storyCreators = storyCreators; }

    public int getPageImpressions() { return pageImpressions; }

    public void setPageImpressions(int pageImpressions) { this.pageImpressions = pageImpressions; }

    public int getImpressionsPaid() { return impressionsPaid; }

    public void setImpressionsPaid(int impressionsPaid) { this.impressionsPaid = impressionsPaid; }

    public int getImpressionsOrganic() { return impressionsOrganic; }

    public void setImpressionsOrganic(int impressionsOrganic) { this.impressionsOrganic = impressionsOrganic; }


}
