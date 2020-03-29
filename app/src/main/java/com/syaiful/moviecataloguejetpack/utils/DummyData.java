package com.syaiful.moviecataloguejetpack.utils;

import com.syaiful.moviecataloguejetpack.data.source.local.entity.MovieEntity;
import com.syaiful.moviecataloguejetpack.data.source.local.entity.TvEntity;
import com.syaiful.moviecataloguejetpack.data.source.remote.response.MovieResponse;

import java.util.ArrayList;
import java.util.List;

public class DummyData {

    public static MovieEntity getSelectedMovie(String id) {
        List<MovieEntity> movies = generateDummyMovies();
        MovieEntity selectedMovie = null;
        for (MovieEntity movie : movies) {
            if (movie.getMovieId().equals(id)) {
                selectedMovie = movie;
                break;
            }
        }

        return selectedMovie;
    }

    public static MovieResponse getRemoteSelectedMovie(String id) {
        List<MovieResponse> movies = generateRemoteDummyMovies();
        MovieResponse selectedMovie = null;
        for (MovieResponse movie : movies) {
            if (movie.getId().equals(id)) {
                selectedMovie = movie;
                break;
            }
        }

        return selectedMovie;
    }

    public static TvEntity getSelectedTvShows(String id) {
        List<TvEntity> tvShows = generateDummyTvShows();
        TvEntity selectedTvShows = null;
        for (TvEntity tvShow : tvShows) {
            if (tvShow.getTvId().equals(id)) {
                selectedTvShows = tvShow;
                break;
            }
        }

        return selectedTvShows;
    }

    public static MovieResponse getRemoteSelectedTvShows(String id) {
        List<MovieResponse> tvShows = generateRemoteDummyTvShows();
        MovieResponse selectedTvShows = null;
        for (MovieResponse tvShow : tvShows) {
            if (tvShow.getId().equals(id)) {
                selectedTvShows = tvShow;
                break;
            }
        }

        return selectedTvShows;
    }

    public static List<MovieEntity> generateDummyMovies() {
        List<MovieEntity> movies = new ArrayList<>();

        MovieEntity m1 = new MovieEntity(
                "1",
                "My Hero Academia: Two Heroes",
                "All Might and Deku accept an invitation to go abroad to a floating and mobile manmade city, called \'I Island\', where they research quirks as well as hero supplemental items at the special \'I Expo\' convention that is currently being held on the island. During that time, suddenly, despite an iron wall of security surrounding the island, the system is breached by a villain, and the only ones able to stop him are the students of Class 1-A.",
                "https://image.tmdb.org/t/p/w1280/5Ui54VS5oxmPzzdEGJEUkW0uESI.jpg",
                false
        );
        movies.add(m1);

        MovieEntity m2 = new MovieEntity(
                "2",
                "Flavors of Youth",
                "Three different stories of youth set in different cities of China. 1 Shanghai Love. 2 Sunny Breakfast. 3 Small Fashion Show. Directed by Zhenxing Yi, the plot revolves around a young man working in Beijing. He used to live with his grandma in his less developed hometown Hunan. While he is drown in his childhood reminiscence, he receives an unexpected call – Grandma is in critical condition.",
                "https://image.tmdb.org/t/p/w1280/ueHeH5ergeHx27L4SCI9qlmwczA.jpg",
                false
        );
        movies.add(m2);

        MovieEntity m3 = new MovieEntity(
                "3",
                "I Want to Eat Your Pancreas",
                "Spring time in April and the last of the cherry blossoms are still in bloom. The usually aloof bookworm with no interest in others comes across a book in a hospital waiting room. Handwritten on the cover are the words: \"Living with Dying.\" He soon discovers that it is a diary kept by his very popular and genuinely cheerful classmate, Sakura Yamauchi, who reveals to him that she is secretly suffering from a pancreatic illness and only has a limited time left. It is at this moment that she gains just one more person to share her secret. Trying to maintain a normal life as much as possible, Sakura is determined to live her life to the fullest until the very last day. As her free spirit and unpredictable actions throw him for a loop, his heart begins to gradually change.",
                "https://image.tmdb.org/t/p/w1280/vHdVU0HyyB6k6kuYt8qjwTz9one.jpg",
                false
        );
        movies.add(m3);

        MovieEntity m4 = new MovieEntity(
                "4",
                "Mirai",
                "The movie follows a 4-year old boy who is struggling to cope with the arrival of a little sister in the family until things turn magical. A mysterious garden in the backyard of the boy\'s home becomes a gateway allowing the child to travel back in time and encounter his mother as a little girl and his great-grandfather as a young man. These fantasy-filled adventures allow the child to change his perspective and help him become the big brother he was meant to be.",
                "https://image.tmdb.org/t/p/w1280/b9XvI4Nehzi0nXyNVD6DtT39P6l.jpg",
                false
        );
        movies.add(m4);

        MovieEntity m5 = new MovieEntity(
                "5",
                "Doraemon the Movie: Nobita\\'s Treasure Island",
                "The story is based on Robert Louis Stevenson\'s Treasure Island novel.",
                "https://image.tmdb.org/t/p/w1280/xiLRClQmKSVAbiu6rgCRzNQjcSX.jpg",
                false
        );
        movies.add(m5);

        MovieEntity m6 = new MovieEntity(
                "6",
                "Pokémon the Movie: The Power of Us",
                "Every year the citizens of Fura City celebrate a Wind Festival. Where people live together with the wind. Long Ago, on the final day of the festival the Legendary Pokemon Lugia and bestow the blessings of the wind upon the people. This Film Focuses on Everyone\'s Story. from Lisa, a high school girl who is just starting out as a Pokemon trainer, to Karachi, a guy who can\'t stop lying to Torito, a researcher who lacks confidence in himself, to Hisui, an old lady who hates touching Pokemon, and Rarugo, a mysterious young girl who watches over the forest by herself.",
                "https://image.tmdb.org/t/p/w1280/eakBFzG1dZn0uouBgv6kYtPXLkT.jpg",
                false
        );
        movies.add(m6);

        MovieEntity m7 = new MovieEntity(
                "7",
                "Detective Conan Zero the Enforcer",
                "After a sudden explosion at Edge of Ocean island in Tokyo, Tōru Amuro, codename Zero, begins to investigate. Meanwhile, private eye Kogorō is arrested as a suspect, so Conan Edogawa conducts his own investigation to prove his innocence, but Amuro stands in his way.",
                "https://image.tmdb.org/t/p/w1280/skJl9GXEXtKoPNtsgslS2swO3zp.jpg",
                false
        );
        movies.add(m7);

        MovieEntity m8 = new MovieEntity(
                "8",
                "Attack on Titan: The Roar of Awakening",
                "Eren Yeager and others of the 104th Training Corps have just begun to become full members of the Survey Corps. As they ready themselves to face the Titans once again, their preparations are interrupted by the invasion of Wall Rose—but all is not as it seems as more mysteries are unraveled. As the Survey Corps races to save the wall, they uncover more about the invading Titans and the dark secrets of their own members.",
                "https://image.tmdb.org/t/p/w1280/nLe47v3H04j5he8b4Jk2WTTUwjw.jpg",
                false
        );
        movies.add(m8);

        MovieEntity m9 = new MovieEntity(
                "9",
                "Digimon Adventure Tri. - Chapter 6: Future",
                "The world has begun to collapse. The rampaging Meicoomon absorbs Tailmon, who underwent a dark evolution, and changes form into the immensely powerful Ordinemon. In accordance with Yggdrasil\'s expectation, the real world is about to be engulfed by the Digital World. Meanwhile, Homeostasis considers Ordinemon to be out of control and puts into motion its final plan that will entangle the real world. Then the time comes for the DigiDestined to arrive at a final decision. What future do they choose for themselves?",
                "https://image.tmdb.org/t/p/w1280/85RWLY80P6NRcwl7CHmh0fAAGyQ.jpg",
                false
        );
        movies.add(m9);

        MovieEntity m10 = new MovieEntity(
                "10",
                "One Piece: Episode of Sky Island",
                "The special will be the first in the \"Episode of\" series to cover the Skypeia arc, and will feature a character who did not appear in the original Skypeia arc from the anime.",
                "https://image.tmdb.org/t/p/w1280/rlXwxRqZa0dMssgYLQeoNo4WiXg.jpg",
                false
        );
        movies.add(m10);

        return movies;
    }

    public static List<MovieResponse> generateRemoteDummyMovies() {
        List<MovieResponse> movies = new ArrayList<>();

        MovieResponse m1 = new MovieResponse(
                "1",
                "My Hero Academia: Two Heroes",
                "All Might and Deku accept an invitation to go abroad to a floating and mobile manmade city, called \'I Island\', where they research quirks as well as hero supplemental items at the special \'I Expo\' convention that is currently being held on the island. During that time, suddenly, despite an iron wall of security surrounding the island, the system is breached by a villain, and the only ones able to stop him are the students of Class 1-A.",
                "https://image.tmdb.org/t/p/w1280/5Ui54VS5oxmPzzdEGJEUkW0uESI.jpg"
        );
        movies.add(m1);

        MovieResponse m2 = new MovieResponse(
                "2",
                "Flavors of Youth",
                "Three different stories of youth set in different cities of China. 1 Shanghai Love. 2 Sunny Breakfast. 3 Small Fashion Show. Directed by Zhenxing Yi, the plot revolves around a young man working in Beijing. He used to live with his grandma in his less developed hometown Hunan. While he is drown in his childhood reminiscence, he receives an unexpected call – Grandma is in critical condition.",
                "https://image.tmdb.org/t/p/w1280/ueHeH5ergeHx27L4SCI9qlmwczA.jpg"
        );
        movies.add(m2);

        MovieResponse m3 = new MovieResponse(
                "3",
                "I Want to Eat Your Pancreas",
                "Spring time in April and the last of the cherry blossoms are still in bloom. The usually aloof bookworm with no interest in others comes across a book in a hospital waiting room. Handwritten on the cover are the words: \"Living with Dying.\" He soon discovers that it is a diary kept by his very popular and genuinely cheerful classmate, Sakura Yamauchi, who reveals to him that she is secretly suffering from a pancreatic illness and only has a limited time left. It is at this moment that she gains just one more person to share her secret. Trying to maintain a normal life as much as possible, Sakura is determined to live her life to the fullest until the very last day. As her free spirit and unpredictable actions throw him for a loop, his heart begins to gradually change.",
                "https://image.tmdb.org/t/p/w1280/vHdVU0HyyB6k6kuYt8qjwTz9one.jpg"
        );
        movies.add(m3);

        MovieResponse m4 = new MovieResponse(
                "4",
                "Mirai",
                "The movie follows a 4-year old boy who is struggling to cope with the arrival of a little sister in the family until things turn magical. A mysterious garden in the backyard of the boy\'s home becomes a gateway allowing the child to travel back in time and encounter his mother as a little girl and his great-grandfather as a young man. These fantasy-filled adventures allow the child to change his perspective and help him become the big brother he was meant to be.",
                "https://image.tmdb.org/t/p/w1280/b9XvI4Nehzi0nXyNVD6DtT39P6l.jpg"
        );
        movies.add(m4);

        MovieResponse m5 = new MovieResponse(
                "5",
                "Doraemon the Movie: Nobita\\'s Treasure Island",
                "The story is based on Robert Louis Stevenson\'s Treasure Island novel.",
                "https://image.tmdb.org/t/p/w1280/xiLRClQmKSVAbiu6rgCRzNQjcSX.jpg"
        );
        movies.add(m5);

        MovieResponse m6 = new MovieResponse(
                "6",
                "Pokémon the Movie: The Power of Us",
                "Every year the citizens of Fura City celebrate a Wind Festival. Where people live together with the wind. Long Ago, on the final day of the festival the Legendary Pokemon Lugia and bestow the blessings of the wind upon the people. This Film Focuses on Everyone\'s Story. from Lisa, a high school girl who is just starting out as a Pokemon trainer, to Karachi, a guy who can\'t stop lying to Torito, a researcher who lacks confidence in himself, to Hisui, an old lady who hates touching Pokemon, and Rarugo, a mysterious young girl who watches over the forest by herself.",
                "https://image.tmdb.org/t/p/w1280/eakBFzG1dZn0uouBgv6kYtPXLkT.jpg"
        );
        movies.add(m6);

        MovieResponse m7 = new MovieResponse(
                "7",
                "Detective Conan Zero the Enforcer",
                "After a sudden explosion at Edge of Ocean island in Tokyo, Tōru Amuro, codename Zero, begins to investigate. Meanwhile, private eye Kogorō is arrested as a suspect, so Conan Edogawa conducts his own investigation to prove his innocence, but Amuro stands in his way.",
                "https://image.tmdb.org/t/p/w1280/skJl9GXEXtKoPNtsgslS2swO3zp.jpg"
        );
        movies.add(m7);

        MovieResponse m8 = new MovieResponse(
                "8",
                "Attack on Titan: The Roar of Awakening",
                "Eren Yeager and others of the 104th Training Corps have just begun to become full members of the Survey Corps. As they ready themselves to face the Titans once again, their preparations are interrupted by the invasion of Wall Rose—but all is not as it seems as more mysteries are unraveled. As the Survey Corps races to save the wall, they uncover more about the invading Titans and the dark secrets of their own members.",
                "https://image.tmdb.org/t/p/w1280/nLe47v3H04j5he8b4Jk2WTTUwjw.jpg"
        );
        movies.add(m8);

        MovieResponse m9 = new MovieResponse(
                "9",
                "Digimon Adventure Tri. - Chapter 6: Future",
                "The world has begun to collapse. The rampaging Meicoomon absorbs Tailmon, who underwent a dark evolution, and changes form into the immensely powerful Ordinemon. In accordance with Yggdrasil\'s expectation, the real world is about to be engulfed by the Digital World. Meanwhile, Homeostasis considers Ordinemon to be out of control and puts into motion its final plan that will entangle the real world. Then the time comes for the DigiDestined to arrive at a final decision. What future do they choose for themselves?",
                "https://image.tmdb.org/t/p/w1280/85RWLY80P6NRcwl7CHmh0fAAGyQ.jpg"
        );
        movies.add(m9);

        MovieResponse m10 = new MovieResponse(
                "10",
                "One Piece: Episode of Sky Island",
                "The special will be the first in the \"Episode of\" series to cover the Skypeia arc, and will feature a character who did not appear in the original Skypeia arc from the anime.",
                "https://image.tmdb.org/t/p/w1280/rlXwxRqZa0dMssgYLQeoNo4WiXg.jpg"
        );
        movies.add(m10);

        return movies;
    }

    public static List<TvEntity> generateDummyTvShows() {
        List<TvEntity> tvShows = new ArrayList<>();

        TvEntity tv1 = new TvEntity(
                "1",
                "Death Note",
                "Light Yagami is an ace student with great prospects—and he’s bored out of his mind. But all that changes when he finds the Death Note, a notebook dropped by a rogue Shinigami death god. Any human whose name is written in the notebook dies, and Light has vowed to use the power of the Death Note to rid the world of evil. But will Light succeed in his noble goal, or will the Death Note turn him into the very thing he fights against?",
                "https://image.tmdb.org/t/p/w1280/g8hHbsRmHYoWYizhWCk87vpkrmy.jpg",
                false
        );
        tvShows.add(tv1);

        TvEntity tv2 = new TvEntity(
                "2",
                "Fullmetal Alchemist: Brotherhood",
                "Edward and Alphonse Elric\'s reckless disregard for alchemy\'s fun­damental laws ripped half of Ed\'s limbs from his body and left Al\'s soul clinging to a cold suit of armor. To restore what was lost, the brothers scour a war-torn land for the Philosopher\'s Sto­ne, a fabled relic which grants the ability to perform alchemy in impossible ways. The Elrics are not alone in their search; the corrupt State Military is also eager to harness the artifact\'s power. So too are the strange Homunculi and their shadowy creator. The mythical gem lures exotic alchemists from distant kingdoms, scarring some deeply enough to inspire murder. As the Elrics find their course altered by these enemies and allies, their purpose remains unchanged – and their bond unbreakable.",
                "https://image.tmdb.org/t/p/w1280/aYVBoq5MEtOBLlivSzDSpteZfXV.jpg",
                false
        );
        tvShows.add(tv2);

        TvEntity tv3 = new TvEntity(
                "3",
                "Steins;Gate",
                "A group of friends have customized their microwave so that it can send text messages to the past. As they perform different experiments, an organization named SERN who has been doing their own research on time travel tracks them down and now the characters have to find a way to avoid being captured by them.",
                "https://image.tmdb.org/t/p/w1280/6iysgZr6Upm5RlAlVFo5f4D9euu.jpg",
                false
        );
        tvShows.add(tv3);

        TvEntity tv4 = new TvEntity(
                "4",
                "Psycho-Pass",
                "Psycho-Pass is a Japanese anime television series that takes place in the future where it is possible to instantaneously measure a person\'s mental state, personality, and the probability that a person will commit crimes with a device installed on each citizen\'s body called the Psycho-Pass. It follows members of Unit One of the Public Safety Bureau\'s Criminal Investigation Division and the crimes they investigate.",
                "https://image.tmdb.org/t/p/w1280/aX6S3P8xiz9nJwXjaka5e9kT6f4.jpg",
                false
        );
        tvShows.add(tv4);

        TvEntity tv5 = new TvEntity(
                "5",
                "Parasyte -the maxim-",
                "Shinichi Izumi is a normal high school boy whose right hand has become infected with an alien parasite that names itself migi. Migi is the first parasite to develop a symbiotic relationship with its host, as he and Shinichi slowly develop a grudging friendship. Migi isn\'t the only Parasite on earth, however, and as cases of Parasites killing humans begin to emerge, humans seek to kill off Parasites. Shinichi and Migi find themselves caught in between these two sides of the struggle over planet earth.",
                "https://image.tmdb.org/t/p/w1280/nLuWoomsag1s5wX2SSamHTnk348.jpg",
                false
        );
        tvShows.add(tv5);

        TvEntity tv6 = new TvEntity(
                "6",
                "ERASED",
                "Satoru Fujinuma is a struggling manga artist who has the ability to turn back time and prevent deaths. When his mother is killed he turns back time to solve the mystery, but ends up back in elementary school, just before the disappearance of his classmate Kayo.",
                "https://image.tmdb.org/t/p/w1280/d4IEwPH9VY3R8LuWHXhsb1iScdz.jpg",
                false
        );
        tvShows.add(tv6);

        TvEntity tv7 = new TvEntity(
                "7",
                "Terror in Resonance",
                "In an alternate version of the present, Tokyo has been decimated by a shocking terrorist attack, and the only hint to the identity of the culprit is a bizarre video uploaded to the internet. The police, baffled by this cryptic clue, are powerless to stop the paranoia spreading across the population. While the world searches for a criminal mastermind to blame for this tragedy, two mysterious children - children who shouldn\'t even exist - masterfully carry out their heinous plan. Cursed to walk through this world with the names Nine and Twelve, the two combine to form Sphinx, a clandestine entity determine to wake the people from their slumber - and pull the trigger on this world.",
                "https://image.tmdb.org/t/p/w1280/cUmUF9DEgbNCsbEbgmDP6bg8ZOF.jpg",
                false
        );
        tvShows.add(tv7);

        TvEntity tv8 = new TvEntity(
                "8",
                "Noragami",
                "Hiyori Iki is a normal middle school student until she was involved in a bus accident while trying to protect a stranger. This incident causes her soul to frequently slip out of her body, and she becomes aware of the existence of two parallel worlds. Through her soul, she meets the strange, nameless god without a shrine, Yato. Yato is determined to make a name for himself out there by accepting any wishes for 5 yen, including Hiyori\'s to fix her body.",
                "https://image.tmdb.org/t/p/w1280/ac4qpPgSbK5kf5yhQHNmtzJdfCF.jpg",
                false
        );
        tvShows.add(tv8);

        TvEntity tv9 = new TvEntity(
                "9",
                "Assassination Classroom",
                "The students of class 3-E have a mission: kill their teacher before graduation. He has already destroyed the moon, and has promised to destroy the Earth if he can not be killed within a year. But how can this class of misfits kill a tentacled monster, capable of reaching Mach 20 speed, who may be the best teacher any of them have ever had?",
                "https://image.tmdb.org/t/p/w1280/aE6DssarIB4g1vFs8uW0rjuL7Ux.jpg",
                false

        );
        tvShows.add(tv9);

        TvEntity tv10 = new TvEntity(
                "10",
                "Blue Exorcist",
                "Humans live in the world of Assiah, demons in Gehenna. The two dimensions are not meant to interfere with each other, but demons still possess creatures in Assiah in spite of this. The humans who can fight these demons are known as exorcists. Rin Okumura is a boy who bears the curse of being Satan\'s illegitimate son. His foster father sacrificed himself to save him from demons. To avenge his foster father\'s death as well as to prove himself, Rin decides to follow the path of an exorcist and defeat his own father, Satan. To hone his raw skills, Rin enters True Cross Academy to train with other exorcist candidates.",
                "https://image.tmdb.org/t/p/w1280/6awFumOfwyh3IEIY0SWLKTygXM9.jpg",
                false
        );
        tvShows.add(tv10);

        return tvShows;
    }

    public static List<MovieResponse> generateRemoteDummyTvShows() {
        List<MovieResponse> tvShows = new ArrayList<>();

        MovieResponse tv1 = new MovieResponse(
                "1",
                "Death Note",
                "Light Yagami is an ace student with great prospects—and he’s bored out of his mind. But all that changes when he finds the Death Note, a notebook dropped by a rogue Shinigami death god. Any human whose name is written in the notebook dies, and Light has vowed to use the power of the Death Note to rid the world of evil. But will Light succeed in his noble goal, or will the Death Note turn him into the very thing he fights against?",
                "https://image.tmdb.org/t/p/w1280/g8hHbsRmHYoWYizhWCk87vpkrmy.jpg"
        );
        tvShows.add(tv1);

        MovieResponse tv2 = new MovieResponse(
                "2",
                "Fullmetal Alchemist: Brotherhood",
                "Edward and Alphonse Elric\'s reckless disregard for alchemy\'s fun­damental laws ripped half of Ed\'s limbs from his body and left Al\'s soul clinging to a cold suit of armor. To restore what was lost, the brothers scour a war-torn land for the Philosopher\'s Sto­ne, a fabled relic which grants the ability to perform alchemy in impossible ways. The Elrics are not alone in their search; the corrupt State Military is also eager to harness the artifact\'s power. So too are the strange Homunculi and their shadowy creator. The mythical gem lures exotic alchemists from distant kingdoms, scarring some deeply enough to inspire murder. As the Elrics find their course altered by these enemies and allies, their purpose remains unchanged – and their bond unbreakable.",
                "https://image.tmdb.org/t/p/w1280/aYVBoq5MEtOBLlivSzDSpteZfXV.jpg"
        );
        tvShows.add(tv2);

        MovieResponse tv3 = new MovieResponse(
                "3",
                "Steins;Gate",
                "A group of friends have customized their microwave so that it can send text messages to the past. As they perform different experiments, an organization named SERN who has been doing their own research on time travel tracks them down and now the characters have to find a way to avoid being captured by them.",
                "https://image.tmdb.org/t/p/w1280/6iysgZr6Upm5RlAlVFo5f4D9euu.jpg"
        );
        tvShows.add(tv3);

        MovieResponse tv4 = new MovieResponse(
                "4",
                "Psycho-Pass",
                "Psycho-Pass is a Japanese anime television series that takes place in the future where it is possible to instantaneously measure a person\'s mental state, personality, and the probability that a person will commit crimes with a device installed on each citizen\'s body called the Psycho-Pass. It follows members of Unit One of the Public Safety Bureau\'s Criminal Investigation Division and the crimes they investigate.",
                "https://image.tmdb.org/t/p/w1280/aX6S3P8xiz9nJwXjaka5e9kT6f4.jpg"
        );
        tvShows.add(tv4);

        MovieResponse tv5 = new MovieResponse(
                "5",
                "Parasyte -the maxim-",
                "Shinichi Izumi is a normal high school boy whose right hand has become infected with an alien parasite that names itself migi. Migi is the first parasite to develop a symbiotic relationship with its host, as he and Shinichi slowly develop a grudging friendship. Migi isn\'t the only Parasite on earth, however, and as cases of Parasites killing humans begin to emerge, humans seek to kill off Parasites. Shinichi and Migi find themselves caught in between these two sides of the struggle over planet earth.",
                "https://image.tmdb.org/t/p/w1280/nLuWoomsag1s5wX2SSamHTnk348.jpg"
        );
        tvShows.add(tv5);

        MovieResponse tv6 = new MovieResponse(
                "6",
                "ERASED",
                "Satoru Fujinuma is a struggling manga artist who has the ability to turn back time and prevent deaths. When his mother is killed he turns back time to solve the mystery, but ends up back in elementary school, just before the disappearance of his classmate Kayo.",
                "https://image.tmdb.org/t/p/w1280/d4IEwPH9VY3R8LuWHXhsb1iScdz.jpg"
        );
        tvShows.add(tv6);

        MovieResponse tv7 = new MovieResponse(
                "7",
                "Terror in Resonance",
                "In an alternate version of the present, Tokyo has been decimated by a shocking terrorist attack, and the only hint to the identity of the culprit is a bizarre video uploaded to the internet. The police, baffled by this cryptic clue, are powerless to stop the paranoia spreading across the population. While the world searches for a criminal mastermind to blame for this tragedy, two mysterious children - children who shouldn\'t even exist - masterfully carry out their heinous plan. Cursed to walk through this world with the names Nine and Twelve, the two combine to form Sphinx, a clandestine entity determine to wake the people from their slumber - and pull the trigger on this world.",
                "https://image.tmdb.org/t/p/w1280/cUmUF9DEgbNCsbEbgmDP6bg8ZOF.jpg"
        );
        tvShows.add(tv7);

        MovieResponse tv8 = new MovieResponse(
                "8",
                "Noragami",
                "Hiyori Iki is a normal middle school student until she was involved in a bus accident while trying to protect a stranger. This incident causes her soul to frequently slip out of her body, and she becomes aware of the existence of two parallel worlds. Through her soul, she meets the strange, nameless god without a shrine, Yato. Yato is determined to make a name for himself out there by accepting any wishes for 5 yen, including Hiyori\'s to fix her body.",
                "https://image.tmdb.org/t/p/w1280/ac4qpPgSbK5kf5yhQHNmtzJdfCF.jpg"
        );
        tvShows.add(tv8);

        MovieResponse tv9 = new MovieResponse(
                "9",
                "Assassination Classroom",
                "The students of class 3-E have a mission: kill their teacher before graduation. He has already destroyed the moon, and has promised to destroy the Earth if he can not be killed within a year. But how can this class of misfits kill a tentacled monster, capable of reaching Mach 20 speed, who may be the best teacher any of them have ever had?",
                "https://image.tmdb.org/t/p/w1280/aE6DssarIB4g1vFs8uW0rjuL7Ux.jpg"
        );
        tvShows.add(tv9);

        MovieResponse tv10 = new MovieResponse(
                "10",
                "Blue Exorcist",
                "Humans live in the world of Assiah, demons in Gehenna. The two dimensions are not meant to interfere with each other, but demons still possess creatures in Assiah in spite of this. The humans who can fight these demons are known as exorcists. Rin Okumura is a boy who bears the curse of being Satan\'s illegitimate son. His foster father sacrificed himself to save him from demons. To avenge his foster father\'s death as well as to prove himself, Rin decides to follow the path of an exorcist and defeat his own father, Satan. To hone his raw skills, Rin enters True Cross Academy to train with other exorcist candidates.",
                "https://image.tmdb.org/t/p/w1280/6awFumOfwyh3IEIY0SWLKTygXM9.jpg"
        );
        tvShows.add(tv10);

        return tvShows;
    }
}
