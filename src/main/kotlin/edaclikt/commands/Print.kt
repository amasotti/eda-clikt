package edaclikt.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.help
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.int
import edaclikt.utils.readCSV
import edaclikt.CSV_FILE
import org.jetbrains.kotlinx.dataframe.api.take

/**
 * Represents a CLI command for printing data from a CSV file.
 *
 * The `Print` class extends the `CliktCommand` class, which provides the functionality
 * for creating and executing command-line interface commands.
 *
 * @param name The name of the "print" command.
 */
class Print : CliktCommand(name="print") {
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
