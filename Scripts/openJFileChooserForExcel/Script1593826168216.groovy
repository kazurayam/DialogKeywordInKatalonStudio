import javax.swing.JFileChooser
import javax.swing.filechooser.FileFilter

def openExcelDialog = new JFileChooser(
							dialogTitle: "Choose an excel file",
							fileSelectionMode: JFileChooser.FILES_ONLY,
							//the file filter must show also directories, in order to be able to look into them
							fileFilter: [getDescription: {-> "*.xlsx"}, accept:{file-> file ==~ /.*?\.xlsx/ || file.isDirectory() }] as FileFilter)

openExcelDialog.showOpenDialog()