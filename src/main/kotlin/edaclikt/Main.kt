package learning.toni.edaclikt

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.api.take
import org.jetbrains.kotlinx.dataframe.io.readCSV

const val CSV_FILE = "src/main/resources/global-life-expt-2022.csv"

fun readCSV(path: String): DataFrame<*> = DataFrame.readCSV(path)

class PrintCommand : CliktCommand(name="print") {
    private val path : String by option("--path")
        .help { "Path to CSV file" }
        .default(CSV_FILE)
    private val rows: Int by option("--rows")
        .int()
        .help { "Number of rows to print" }
        .default(10)

    override fun run() {
        val df = readCSV(path)
        println(df.take(rows))
    }
}

fun main(args: Array<String>) {
    PrintCommand().main(args)
}
