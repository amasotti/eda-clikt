package edaclikt.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.boolean
import com.github.ajalt.clikt.parameters.types.int
import edaclikt.CSV_FILE
import edaclikt.utils.readCSV
import org.jetbrains.kotlinx.dataframe.api.*

class Sort : CliktCommand(name = "sort") {
    private val path: String by option("--path", help = "Path to the CSV file")
        .default(CSV_FILE)

    private val year: String by option("--year", help = "Year column to sort by")
        .default("2020")

    private val rows: Int by option("--rows", help = "Number of rows to print")
        .int()
        .default(10)

    private val order: Boolean by option("--order")
        .help { "Sort order (true for ascending, false for descending)"}
        .boolean()
        .default(true)

    override fun run() {
        val df = readCSV(path)
        val sortedDf = df.select("Country Name", year).dropNulls().sortBy(year)
        if (!order) {
            println(sortedDf.take(rows).reverse())
        } else {
            println(sortedDf.take(rows))
        }
    }
}
