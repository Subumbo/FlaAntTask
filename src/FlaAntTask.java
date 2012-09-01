import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
public class FlaAntTask extends Task{
	
	
	String _folder;
	
	public void execute() throws BuildException {
		
		if(_folder==null) throw new BuildException("Folder attribute missing.");
		
		log(_folder);
		
		String jsfl = "var folderURI = 'file:///Macintosh%20HD" + _folder + "'; var folderContents = FLfile.listFolder(folderURI); for (var i=0; i<folderContents.length; i++) { var fileURL = folderURI + '/' + folderContents[i]; var theFile = fileURL.substr(fileURL.length-4, 4); if(theFile == '.fla'){ fl.openDocument(fileURL);}}while (fl.getDocumentDOM() != null) {fl.getDocumentDOM().publish();fl.saveDocument(fl.getDocumentDOM());fl.closeDocument(fl.getDocumentDOM());}";
		log("------> BUILDING");
		
		
		 
  	  
		
		try {
		    // Create temp file.
		    File temp = File.createTempFile("file", ".jsfl");
		    System.out.println("Temp file : " + temp.getAbsolutePath());
		    // Delete temp file when program exits.
		    //temp.deleteOnExit();

		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write(jsfl);
		    out.close();
		    
		    try {
				Runtime.getRuntime().exec("open " + temp.getAbsolutePath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log("!!!!! FAIL !!!!");
				e.printStackTrace();
			}
		    
		} catch (IOException e) {
		}
		
		
		
	}
	
	public void setFolder(String folder) {
		_folder = folder;
	}
	
}
