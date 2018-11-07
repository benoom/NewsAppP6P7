package com.example.android.newsappp6p7;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * An {@link NewsAdapter} knows how to create a list item layout for each news article
 * in the data source (a list of {@link News} objects).
 *
 * These list item layouts will be provided to an adapter view like ListView
 * to be displayed to the user.
 */
public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Tag for the log messages
     */
    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();
    /**
     * Constructs a new {@link NewsAdapter}.
     *
     * @param context of the app
     * @param news is the list of news articles, which is the data source of the adapter
     */
    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    /**
     * Returns a list item view that displays information about the news article at the given
     * position in the list of news articles.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        // Find the news article at the given position in the list of news articles
        News currentNews = getItem(position);

        // Find the TextView with the view ID section_id
        TextView sectionView = listItemView.findViewById(R.id.section_id);
        // Display the current news article section in that TextView
        sectionView.setText(currentNews.getNameofSection());

        // Find the TextView with the view ID section_id
        TextView contributorView = listItemView.findViewById(R.id.contributor);
        // Display the current news article section in that TextView
        contributorView.setText(currentNews.getContributor());

        // Find the TextView with view ID article_title
        TextView titleView = listItemView.findViewById(R.id.article_title);
        // Display the current news article title in that TextView
        titleView.setText(currentNews.getArticleTitle());

        // Create a new Date object from the time of the news article
        String dateString = new String(currentNews.getTimePublished());

        // Find the TextView with view ID date
        TextView dateView = listItemView.findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateString);
        // Display the date of the current news article in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = listItemView.findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateString);
        // Display the time of the current news article in that TextView
        timeView.setText(formattedTime);

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }


    /**
     * Return the formatted date string (i.e. "Mar 3, 1984")
     */
    private String formatDate(String input) {
        SimpleDateFormat formatInput =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat formatOutput =
                new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
        String output = null;
        try {
            Date dt = formatInput.parse(input);
            output = formatOutput.format(dt);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Error during formatting date", e);
        }

        return output;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984")
     */
    private String formatTime(String input) {
        SimpleDateFormat formatInput =
                new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        SimpleDateFormat formatOutput =
                new SimpleDateFormat("HH:mm", Locale.getDefault());
        String output = null;
        try {
            Date dt = formatInput.parse(input);
            output = formatOutput.format(dt);
        } catch (ParseException e) {
            Log.e(LOG_TAG, "Error during formatting time", e);
        }

        return output;
    }
}
