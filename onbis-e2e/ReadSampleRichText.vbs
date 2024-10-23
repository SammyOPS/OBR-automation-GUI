Set oWord = CreateObject("Word.Application")
oWord.Visible = true
oWord.Documents.Open "C:\workspace\onbis-e2e\src\main\resources\SampleRichText.doc"

Set wshShell = WScript.CreateObject("WScript.Shell")
WScript.Sleep 10000
wshshell.AppActivate "SampleRichText  -  Compatibility Mode"
WScript.Sleep 3000
wshShell.SendKeys "^(a)"
WScript.Sleep 3000
wshShell.SendKeys "^(c)"
WScript.Sleep 3000
wshShell.SendKeys "%{F4}"
WScript.Sleep 4000
wshShell.SendKeys "{ENTER}"
'oWord.Quit
'WScript.Quit