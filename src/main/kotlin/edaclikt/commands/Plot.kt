package edaclikt.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import edaclikt.CSV_FILE
import edaclikt.utils.readCSV
import org.jetbrains.kotlinx.dataframe.AnyFrame
import org.jetbrains.kotlinx.dataframe.api.dataFrameOf
import org.jetbrains.kotlinx.dataframe.api.filter
import org.jetbrains.kotlinx.dataframe.api.select
import org.jetbrains.kotlinx.dataframe.api.values
import org.jetbrains.kotlinx.dataframe.get
import org.jetbrains.kotlinx.kandy.dsl.plot
import org.jetbrains.kotlinx.kandy.letsplot.export.save
import org.jetbrains.kotlinx.kandy.letsplot.feature.layout
import org.jetbrains.kotlinx.kandy.letsplot.layers.bars

class Plot : CliktCommand(name = "plot") {
    private val path: String by option("--path", help = "Path to the CSV file").default(CSV_FILE)
    private val country: String by option("--country", help = "Column for y-axis").default("Afghanistan")
    private val outPath: String by option("--out").help("Output path for the plot").default("life_expectancy_plot.png")

    override fun run() {
        val df = readCSV(path)
        val filteredDf = df.filter { it["Country Name"] == country }.select { "Country Name" and "1960".."2021" }

        val plotData: AnyFrame = dataFrameOf(
            "Year" to (1960..2021).toList(),
            "Life Expectancy" to filteredDf["1960".."2021"].values().toList(),
        )

        plotData.plot {
            bars {
                x("Year")
                y("Life Expectancy")
            }

            layout.title = "Life Expectancy in $country"

        }.save(outPath)

        println("Plot saved to $outPath")
    }
}
