package edaclikt.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import edaclikt.CSV_FILE
import edaclikt.utils.readCSV
import org.jetbrains.kotlinx.dataframe.api.describe

class Describe : CliktCommand(name = "describe") {
    private val path: String by option("--path", help = "Path to the CSV file").default(CSV_FILE)

    override fun run() {
        val df = readCSV(path)
        println(df.describe())
    }
}
