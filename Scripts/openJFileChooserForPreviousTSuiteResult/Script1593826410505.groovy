import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

/**
 * https://stackoverflow.com/questions/7096290/groovy-swing-buider-filechooser
 * 
 * @author kazuakiurayama
 *
 */

def openExcelDialog = new JFileChooser(
	dialogTitle: "Choose a timestamp",
	fileSelectionMode: JFileChooser.DIRECTORIES_ONLY,
	//the file filter must show also directories, in order to be able to look into them
	fileFilter: [getDescription: {-> "*.xlsx"}, accept:{file-> file ==~ /.*?\.xlsx/ || file.isDirectory() }] as FileFilter)

openExcelDialog.showOpenDialog()