package io.github.droidkaigi.confsched2022.feature.sessions

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidTest
import io.github.droidkaigi.confsched2022.testing.RobotTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class SessionsScreenTest {

    @get:Rule val robotTestRule = RobotTestRule(this)
    @Inject lateinit var sessionScreenRobot: SessionScreenRobot

    @Test
    fun visibleTimetable() {
        sessionScreenRobot(robotTestRule) {
            checkTimetableVisible()
        }
    }

    // currently there are not favorite buttons
    @Test
    fun isNotFavoritedAtFirst() {
        sessionScreenRobot(robotTestRule) {
            clickToggleTimetable()
            checkTimetableVisible()
            checkFavoritedAt(index = 0, isFavorited = false)
        }
    }

    @Test
    fun canToggleFavorite() {
        sessionScreenRobot(robotTestRule) {
            clickToggleTimetable()
            clickFavoriteAt(0)
            checkFavoritedAt(index = 0, isFavorited = true)
            checkFavoriteIsSavedAt(0)
        }
    }
}
