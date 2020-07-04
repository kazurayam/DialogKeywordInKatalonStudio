import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter
import java.nio.file.Path
import java.nio.file.Paths
import com.kms.katalon.core.configuration.RunConfiguration

/**
 * a sample Test Case script in Katalon Studio.
 * 
 * This script opens a javax.swing.JFileChooser dialog.
 * The dialog shows a list of sub-directories under the directory
 * 
 * "<projectDir>/Storage/CURA.chronose_capture/CURA_DevelopmentEnv"
 * 
 * and let you choose one.
 * The sub-directory name is supposed to be in the format of
 * 
 * "yyyyMMdd_hhmmss"
 * 
 * Once a sub-directory is chosen and approved and returned from the dialo,
 * this scprit just prints the path of the chosen subdirectory into the console.
 * 
 * In a real application your script will further process the chosen subdirectory
 * as you like.
 */

Path projectDir = Paths.get(RunConfiguration.getProjectDir())
Path storageDir = projectDir.resolve('Storage')
Path tSuiteNameDir = storageDir.resolve('CURA.chronos_capture')
Path tExecutionProfileDir = tSuiteNameDir.resolve('CURA_DevelopmentEnv')

def chooser = new JFileChooser(
	currentDirectory: tExecutionProfileDir.toFile(), 
	dialogTitle: "${projectDir.relativize(tExecutionProfileDir)}/",
	fileSelectionMode: JFileChooser.DIRECTORIES_ONLY,
	fileFilter: [
		getDescription: { ->
			"yyyyMMdd_hhmmss"
		},
		accept:{ f -
			 f ==~ /\d{8}_\d{6}/ && f.isDirectory()
		}
	] as FileFilter)

int ret = chooser.showOpenDialog(chooser)

if (ret == JFileChooser.APPROVE_OPTION) {
	File selectedFile = chooser.getSelectedFile()
	println "${selectedFile.toString()}"
}
