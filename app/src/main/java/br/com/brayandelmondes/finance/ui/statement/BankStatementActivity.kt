package br.com.brayandelmondes.finance.ui.statement

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.brayandelmondes.finance.R
import br.com.brayandelmondes.finance.databinding.ActivityBankStatementBinding
import br.com.brayandelmondes.finance.domain.Transaction
import br.com.brayandelmondes.finance.domain.TransactionType
import br.com.brayandelmondes.finance.domain.User

class BankStatementActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ACCOUNT_HOLDER = "br.com.brayandelmondes.finance.ui.statement"
    }
    private val binding by lazy{
        ActivityBankStatementBinding.inflate(layoutInflater)
    }
    private val accountHolder by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_ACCOUNT_HOLDER, User::class.java) ?: throw IllegalArgumentException()
        } else {
            intent.getParcelableExtra<User>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)
        findBankStatement()
    }

    private fun findBankStatement() {
        val dataSet = ArrayList<Transaction>()
        dataSet.add(Transaction(1,"13/05/2023 10:30:03","Lorem ipsum",2000.0,TransactionType.RECEITA, 1))
        dataSet.add(Transaction(2,"14/05/2023 13:10:03","Lorem ipsum",900.0,TransactionType.DESPESA, 1))
        dataSet.add(Transaction(3,"15/05/2023 12:40:03","Lorem ipsum",300.0,TransactionType.DESPESA, 1))
        dataSet.add(Transaction(4,"17/05/2023 12:20:03","Lorem ipsum",400.0,TransactionType.RECEITA, 1))
        dataSet.add(Transaction(5,"18/05/2023 11:50:03","Lorem ipsum",200.0,TransactionType.DESPESA, 1))
        binding.rvBankStatement.adapter = BankStatementAdapter(dataSet)
    }

}