package com.syaiful.moviecataloguejetpack.ui.home;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.rule.ActivityTestRule;

import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.MovieEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
import com.syaiful.moviecataloguejetpack.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MovieCatalogueTest {
    private ArrayList<MovieEntity> dummyMovies = DummyData.generateDummyMovies();
    private ArrayList<MovieEntity> dummyTvShows = DummyData.generateDummyTvShows();
    private MovieEntity dummyMovie = DummyData.getSelectedMovie("1");
    private MovieEntity dummyTvShow = DummyData.getSelectedTvShows("1");

    @Rule
    public ActivityTestRule activityRule = new ActivityTestRule(HomeActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition(dummyMovies.size()));
    }

    @Test
    public void loadTvShows() {
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition(dummyTvShows.size()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_name_detail)).check(matches(withText(dummyMovie.getTitle())));
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_description_detail)).check(matches(withText(dummyMovie.getDescription())));
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadDetailTvShow() {
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_name_detail)).check(matches(withText(dummyTvShow.getTitle())));
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_description_detail)).check(matches(withText(dummyTvShow.getDescription())));
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()));
    }
}