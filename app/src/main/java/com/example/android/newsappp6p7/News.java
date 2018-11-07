package com.example.android.newsappp6p7;

/**
 * An {@link News} object contains information related to a single soccer news story.
 */
public class News {

    /** Title of the news article */
    private String mArticleTitle;

    /** Name of the section the article is categorized under */
    private String mNameofSection;

    /** Time of the article */
    private String mPublicationDate;

    /** Website URL of the news article */
    private String mUrl;

    /** Author or contributor for the news article */
    private  String mContributor;

    /**
     * Constructs a new {@link News} object.
     *
     * @param articleTitle is the title of the news article
     * @param nameOfSection is the section category that the article is categorized in
     * @param timePublished is the date the news article was published
     * @param url is the website URL to find more details about the news article
     * @param contributor is the author/contributor of the news article
     *
     */
    public News(String articleTitle, String nameOfSection, String timePublished, String url,
                String contributor) {
        mArticleTitle = articleTitle;
        mNameofSection = nameOfSection;
        mPublicationDate = timePublished;
        mUrl = url;
        mContributor = contributor;
    }

    /**
     * Returns the title of the article.
     */
    public String getArticleTitle() {
        return mArticleTitle;
    }

    /**
     * Returns the section of the article.
     */
    public String getNameofSection() {
        return mNameofSection;
    }

    /**
     * Returns the publishing date of the article.
     */
    public String getTimePublished() {
        return mPublicationDate;
    }

    /**
     * Returns the website URL to find more information about the news article.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the contributor of the news article
     */
    public String getContributor(){
        return mContributor;
    }

}