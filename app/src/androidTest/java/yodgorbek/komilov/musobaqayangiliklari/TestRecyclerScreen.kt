package yodgorbek.komilov.musobaqayangiliklari

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.agoda.kakao.image.KImageView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import org.hamcrest.Matcher

open class TestRecyclerScreen : Screen<TestRecyclerScreen>() {
    val recycler: KRecyclerView = KRecyclerView({
        withId(R.id.recycler_View)
    }, itemTypeBuilder = {
        itemType(::Item)
    })

    class Item(parent: Matcher<View>) : KRecyclerItem<Item>(parent) {
        val topFlameImageView = KImageView(parent) { withId(R.id.topFlameImageView) }
        val topTitleTextView = KTextView(parent) { withId(R.id.topTitleTextView) }
        val bottomTitleTextView = KTextView(parent) { withId(R.id.bottomTitleTextView) }
        val bigImage = KImageView(parent) { withId(R.id.bigImage) }
        val titleTmageView = KImageView(parent) { withId(R.id.titleImageView) }
        val titleTextView = KTextView(parent) { withId(R.id.bottomTitleTextView) }
        val userAvatarImageView = KImageView(parent) { withId(R.id.userAvatarImageView) }
        val userNameTextView = KTextView(parent) { withId(R.id.userNameTextView) }
        val timestampTextView = KTextView(parent) { withId(R.id.userNameTextView) }
        val imageView = KImageView(parent) { withId(R.id.imageView) }
        val articleTitle = KTextView(parent) { withId(R.id.articleTitle) }
        val imageCategory = KImageView(parent) { withId(R.id.imageCategory) }
        val articleSourceName = KTextView(parent) { withId(R.id.articleSourceName) }
        val articleTime = KTextView(parent) { withId(R.id.articleTime) }
    }
}