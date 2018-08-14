package chat.rocket.android.about.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import chat.rocket.android.BuildConfig
import chat.rocket.android.R
import chat.rocket.android.main.ui.MainActivity
import chat.rocket.android.util.helper.AnswersEvent
import kotlinx.android.synthetic.main.app_bar.*
import kotlinx.android.synthetic.main.fragment_about.*

internal const val TAG_ABOUT_FRAGMENT = "AboutFragment"

class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_about, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        setupViews()
        AnswersEvent.logScreenView(TAG_ABOUT_FRAGMENT)
    }

    private fun setupViews() {
        text_version_name.text = BuildConfig.VERSION_NAME
        text_build_number.text = getString(R.string.msg_build, BuildConfig.VERSION_CODE,
                BuildConfig.GIT_SHA, BuildConfig.FLAVOR)
    }

    private fun setupToolbar() {
        with((activity as MainActivity).toolbar) {
            title = getString(R.string.title_about)
            setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
            setNavigationOnClickListener { activity?.onBackPressed() }
        }
    }

    companion object {
        fun newInstance() = AboutFragment()
    }
}
