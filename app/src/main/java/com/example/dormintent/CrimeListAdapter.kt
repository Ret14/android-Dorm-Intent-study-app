package com.example.dormintent

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.dormintent.databinding.ListItemCrimeBinding
import com.example.dormintent.databinding.ListItemSeriousCrimeBinding
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT
import com.google.android.material.snackbar.Snackbar

open class BaseHolder(
    binding: androidx.viewbinding.ViewBinding
): RecyclerView.ViewHolder(binding.root) {
    open fun bind(crime: Crime) {}
}

class CrimeHolder(
    private val binding: ListItemCrimeBinding
): BaseHolder(binding) {
    override fun bind(crime: Crime) {
        binding.tvCrimeTitle.text = crime.title
        val datePattern = "EEEE, MMM dd, yyyy"
        val currentDate = DateFormat.format(datePattern, crime.date)
        binding.tvCrimeDate.text = currentDate
        binding.ivSolvedPicture.isVisible = crime.isSolved

        binding.root.setOnClickListener { onClickListItem(crime) }
    }

    private fun onClickListItem(crime: Crime) {
        Snackbar.make(
            binding.root,
            "This is ${crime.title}",
            LENGTH_SHORT)
            .show()
    }
}

//class SeriousCrimeHolder(
//    private val binding: ListItemSeriousCrimeBinding
//): BaseHolder(binding) {
//    override fun bind(crime: Crime) {
//        val datePattern = "EEEE, MMMM dd, yyyy"
//        val currentDate = DateFormat.format(datePattern, crime.date)
//        binding.tvCrimeDate.text = currentDate
//        binding.tvCrimeTitle.text = crime.title
//    }
//}

class CrimeListAdapter(
    private val crimes: List<Crime>
    ): RecyclerView.Adapter<BaseHolder>() {

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        val crime = crimes[position]
        holder.bind(crime)
    }

    override fun getItemCount() = crimes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)

//        return when (viewType) {
//            R.string.regular_crime_view -> {
                val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
                return CrimeHolder(binding)
//            }
//            R.string.serious_crime_view -> {
//                val binding = ListItemSeriousCrimeBinding.inflate(inflater, parent, false)
//                SeriousCrimeHolder(binding)
//            }
//            else -> {
//                val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
//                BaseHolder(binding)
//            }
//        }
    }

//    override fun getItemViewType(position: Int): Int {
//        return if (crimes[position].requiresPolice) {
//            R.string.serious_crime_view
//        } else {
//            R.string.regular_crime_view
//        }
//    }
}