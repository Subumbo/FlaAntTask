var folderURI = 'file:///Macintosh%20HD/Users/pwolleb/WORK/FlaAntTask/support/fla';


var folderContents = FLfile.listFolder(folderURI);
for (var i=0; i<folderContents.length; i++) {
   var fileURL = folderURI + '/' + folderContents[i];
   //Added by www.reyco1.com
   var theFile = fileURL.substr(fileURL.length-4, 4);
   if(theFile == '.fla'){
         fl.openDocument(fileURL);
   }
}

//Publishes each fla one at a time.
while (fl.getDocumentDOM() != null) {
   //Publish the SWF - Uses current publish settings without dialog. Be sure the publish settings are correct for each file before batch processing!
   fl.getDocumentDOM().publish();

   //Saves and closes the file
   fl.saveDocument(fl.getDocumentDOM());
   fl.closeDocument(fl.getDocumentDOM());
}
