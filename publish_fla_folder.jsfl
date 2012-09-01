var folderURI = 'file:///Macintosh%20HD/Users/pwolleb/WORK/FlaAntTask/fla';


var folderContents = FLfile.listFolder(folderURI);
for (var i=0; i<folderContents.length; i++) {
   var fileURL = folderURI + '/' + folderContents[i];
   //Added by www.reyco1.com
   var theFile = fileURL.substr(fileURL.length-4, 4);
   if(theFile == '.fla'){
         fl.publishDocument(fileURL);
   }
}