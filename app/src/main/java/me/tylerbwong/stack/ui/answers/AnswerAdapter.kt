package me.tylerbwong.stack.ui.answers

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.tylerbwong.stack.R
import me.tylerbwong.stack.data.model.Answer
import me.tylerbwong.stack.ui.utils.inflateWithoutAttaching

class AnswerAdapter : RecyclerView.Adapter<AnswerHolder>() {
    internal var answers: List<Answer> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerHolder {
        val view = parent.inflateWithoutAttaching(R.layout.answer_holder)
        return AnswerHolder(view)
    }

    override fun onBindViewHolder(holder: AnswerHolder, position: Int) {
        holder.bind(answers[position])
    }

    override fun getItemCount() = answers.size
}