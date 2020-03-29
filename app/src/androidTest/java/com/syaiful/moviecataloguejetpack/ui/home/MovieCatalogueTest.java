package com.syaiful.moviecataloguejetpack.ui.home;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import com.syaiful.moviecataloguejetpack.R;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.utils.DummyData;
import com.syaiful.moviecataloguejetpack.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MovieCatalogueTest {
    private List<MovieEntity> dummyMovies = DummyData.generateDummyMovies();
    private List<TvEntity> dummyTvShows = DummyData.generateDummyTvShows();
    private MovieEntity dummyMovie = DummyData.getSelectedMovie("1");
    private TvEntity dummyTvShow = DummyData.getSelectedTvShows("1");

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
        onView(withId(R.id.navigation_tv)).perform(ViewActions.click());
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
        onView(ViewMatchers.withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_name_detail)).check(matches(withText(dummyTvShow.getTitle())));
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_description_detail)).check(matches(withText(dummyTvShow.getDescription())));
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()));
    }

    @Test
    public void loadFavMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.action_fav)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.navigation_fav)).perform(ViewActions.click());
        onView(withText("MOVIES")).perform(click());
        onView(withId(R.id.rv_fav_movies)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_movies)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()));
        onView(isRoot()).perform(ViewActions.pressBack());
    }

    @Test
    public void loadFavTvShows(){
        onView(ViewMatchers.withId(R.id.navigation_tv)).perform(click());
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.action_fav)).perform(click());
        onView(isRoot()).perform(ViewActions.pressBack());
        onView(withId(R.id.navigation_fav)).perform(ViewActions.click());
        onView(withText("TV SHOWS")).perform(click());
        onView(withId(R.id.rv_fav_tv_shows)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_fav_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.txt_name_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.txt_description_detail)).check(matches(isDisplayed()));
        onView(withId(R.id.img_poster_detail)).check(matches(isDisplayed()));
        onView(isRoot()).perform(ViewActions.pressBack());
    }
}