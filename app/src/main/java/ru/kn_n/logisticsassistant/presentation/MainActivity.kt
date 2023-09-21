package ru.kn_n.logisticsassistant.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.firebase.database.FirebaseDatabase
import ru.kn_n.core.utils.EMPTY
import ru.kn_n.logisticsassistant.R
import ru.kn_n.core.base.ViewModelFactory
import ru.kn_n.logisticsassistant.databinding.ActivityMainBinding
import ru.kn_n.core.base.Scopes
import ru.kn_n.core.utils.gone
import ru.kn_n.profile.domain.ProfileEntity
import ru.kn_n.profile.domain.SickLeave
import ru.kn_n.profile.domain.SickLeaveStatus
import ru.kn_n.tasks.domain.StatusJob
import ru.kn_n.tasks.domain.TaskEntity
import toothpick.Toothpick
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: ActivityMainBinding? = null
    val binding get() = _binding!!

    private val navHostFragment by lazy {
        binding.container.getFragment<NavHostFragment>()
    }

    private val navController by lazy {
        navHostFragment.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModelFactory()

        setupToolBarAndBottomNav()
    }

    private fun setupViewModelFactory() {
        viewModelFactory = Toothpick.openScope(Scopes.APP_SCOPE).getInstance(ViewModelFactory::class.java)
    }

    private fun setupToolBarAndBottomNav(){

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.tasksFragment,
                R.id.chartFragment,
                R.id.chatFragment,
                R.id.profileFragment,
                R.id.authorizationFragment
            )
        )
        binding.bottomNavigation.setupWithNavController(navController)

        setSupportActionBar(binding.topAppBar)
        supportActionBar?.setLogo(ru.kn_n.core.R.drawable.logo_short)
        supportActionBar?.title= String.EMPTY
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        binding.bottomNavigation.gone()
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


    companion object {
        private const val NODE_USER = "Users"
        private const val NODE_TASKS = "Tasks"
    }
}