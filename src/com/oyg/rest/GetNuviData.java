package com.oyg.rest;

/**
 * Created by msllavore on 1/22/16.
 */
public class GetNuviData {
    public static void main(String[] args) {
        GetNuviTrendsHashtags hashtagData = new GetNuviTrendsHashtags();
        //System.out.println(hashtagData.returningNuviTrendHashtag());

        GetNuviTrendsKeywords keywordsData = new GetNuviTrendsKeywords();
        //System.out.println(keywordsData.returningNuviTrendsKeywords());

        GetNuviTrendsNegativeTerms negativeTerms = new GetNuviTrendsNegativeTerms();
        //System.out.println(negativeTerms.returningNuviTrendsNegativeTerms());

        GetNuviTrendsPositiveTerms positiveTerms = new GetNuviTrendsPositiveTerms();
        //System.out.println(positiveTerms.returningNuviTrendsPositiveTerms());

        //GetNuviTrendsRelations relations = new GetNuviTrendsRelations();
        //System.out.println(relations.returningNuviTrendsRelations());

        //GetNuviTrendsTopicFrequency topicFrequency = new GetNuviTrendsTopicFrequency();
        //System.out.println(topicFrequency.returningNuviTrendsTopicFrequency());
    }

}
