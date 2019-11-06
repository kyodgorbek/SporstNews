package yodgorbek.komilov.musobaqayangiliklari





import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions

import androidx.test.espresso.intent.rule.IntentsTestRule

import androidx.test.espresso.matcher.ViewMatchers.withId

import androidx.test.ext.junit.runners.AndroidJUnit4



import org.junit.Rule
import org.junit.runner.RunWith


import yodgorbek.komilov.musobaqayangiliklari.ui.detail.DetailActivity
import com.android21buttons.fragmenttestrule.FragmentTestRule
import org.junit.Test
import yodgorbek.komilov.musobaqayangiliklari.ui.BBCSportFragment



@RunWith(AndroidJUnit4::class)
class RecyclerViewTest {


    @Rule
    var fragmentTestRule: FragmentTestRule<*, BBCSportFragment> =
        FragmentTestRule.create(BBCSportFragment::class.java)

    @Rule
    @JvmField
    val intentRule = IntentsTestRule(DetailActivity::class.java)

    val screen = TestRecyclerScreen()

    @Rule
    @JvmField
    val rule = fragmentTestRule


    @Test
    fun testContentItemsRecyclerView() {
        screen {
            recycler {
                firstChild<TestRecyclerScreen.Item> {
                    topFlameImageView {
                        onView(withId(R.id.recycler_View)).perform(ViewActions.click())
                    }
                }
            }


        }
    }
}
