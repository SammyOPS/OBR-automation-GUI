Set WshShell = WScript.CreateObject("WScript.Shell") 
wscript.sleep 5000

Dim objSHL : Set objSHL = CreateObject("WScript.Shell")
Dim strCurDir
strCurDir = WshShell.CurrentDirectory
If objSHL.AppActivate ("Open") = true Then 
wscript.sleep 145
wscript.sleep 3000
objSHL.sendkeys"{TAB}"
wscript.sleep 3000
objSHL.sendkeys"{TAB}"
wscript.sleep 3000
objSHL.sendkeys"{TAB}"
wscript.sleep 5000
objSHL.sendkeys"C:\workspace\onbis-e2e\src\main\resources\123_pdf-file.pdf"
wscript.sleep 3000
objSHL.sendkeys"~"

End If 
WScript.Quit