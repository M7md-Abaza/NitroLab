package com.nitrolab.physics.Adapters

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.nitrolab.physics.FourthYearExperiments.BondPassChart
import com.nitrolab.physics.Models.PdfModel
import com.nitrolab.physics.Models.VideoModel
import com.nitrolab.physics.Models.YearExperimentModel
import com.nitrolab.physics.R
import com.nitrolab.physics.ThirdYearExperiments.NTC1
import com.nitrolab.physics.ThirdYearExperiments.SolarCellThird
import com.nitrolab.physics.ThirdYearExperiments.TransistorPart2
import java.util.*


class ThirdExperimentAdapter(
    private var ExpData: ArrayList<YearExperimentModel>,
    private var PdfData: ArrayList<PdfModel>,
    private var VideoData: ArrayList<VideoModel>,
    private val mContext: Activity) :
    RecyclerView.Adapter<ThirdExperimentAdapter.MyHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.experiments_item, parent, false)

        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return ExpData.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val expData: YearExperimentModel = ExpData[position]
        val pdfData: PdfModel = PdfData[position]
        val videoData: VideoModel = VideoData[position]


        holder.expTitle.text = expData.getExpTitle()

        holder.expTitle.setOnClickListener {

            if (holder.expandedView.visibility == View.GONE) {
                holder.expandedView.visibility = View.VISIBLE
            } else if (holder.expandedView.visibility == View.VISIBLE) {
                holder.expandedView.visibility = View.GONE
            }
        }

        holder.expPDF.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pdfData.getPdfData()))
            mContext.startActivity(intent)
        }

        holder.expVideo.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(videoData.getVideoData()))
            mContext.startActivity(intent)
        }

        holder.expLab.setOnClickListener {
            when (position) {
                0 -> {
                    val intent = Intent(mContext, NTC1::class.java)
                    mContext.startActivity(intent)
                }
                1 -> {
                    val intent = Intent(mContext, BondPassChart::class.java)
                    mContext.startActivity(intent)
                }
                2 -> {
                    val intent = Intent(mContext, BondPassChart::class.java)
                    mContext.startActivity(intent)
                }
                3 -> {
                    val intent = Intent(mContext, BondPassChart::class.java)
                    mContext.startActivity(intent)
                }
                4 -> {
                    val intent = Intent(mContext, TransistorPart2::class.java)
                    mContext.startActivity(intent)
                }
                5 -> {
                    val intent = Intent(mContext, BondPassChart::class.java)
                    mContext.startActivity(intent)
                }
                6 -> {
                    val intent = Intent(mContext, SolarCellThird::class.java)
                    mContext.startActivity(intent)
                }
            }
        }
    }

    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var expTitle: TextView = itemView.findViewById(R.id.experimentTitle)
        var expPDF: ImageView = itemView.findViewById(R.id.experimentPDF)
        var expVideo: ImageView = itemView.findViewById(R.id.experimentVideo)
        var expLab: ImageView = itemView.findViewById(R.id.experimentPractice)
        var expandedView: ConstraintLayout = itemView.findViewById(R.id.expandedView)

    }
}