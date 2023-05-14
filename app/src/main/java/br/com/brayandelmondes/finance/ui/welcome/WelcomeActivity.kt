package br.com.brayandelmondes.finance.ui.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.brayandelmondes.finance.databinding.ActivityWelcomeBinding
import br.com.brayandelmondes.finance.domain.User
import br.com.brayandelmondes.finance.ui.statement.BankStatementActivity

class WelcomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonContinue.setOnClickListener {
            val accountHolderId = binding.editTextAccountNumber.text.toString().toInt()
            val accountHolder = User(accountHolderId)


            val intent = Intent(this, BankStatementActivity::class.java).apply {
                putExtra(BankStatementActivity.EXTRA_ACCOUNT_HOLDER, accountHolder)
            }
            startActivity(intent)
        }
    }
}