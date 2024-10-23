Set WshShell = WScript.CreateObject("WScript.Shell") 
WScript.Sleep 10000

Dim objSHL : Set objSHL = CreateObject("WScript.Shell")

If objSHL.AppActivate ("Entrust Security Store Login") = true Then 
'If objSHL.AppActivate ("Entrust Security Store Unlock") = true Or objSHL.AppActivate ("Entrust Security Store Login") = true Then 

wscript.sleep 145
'wshshell.sendkeys"Ps1sCatalyst"
objSHL.sendkeys"Ps1sCatalyst"
objSHL.sendkeys"~"

End If 
Wscript.Quit