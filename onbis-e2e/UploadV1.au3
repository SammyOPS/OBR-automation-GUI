Local $filePath = @ScriptDir & "\src\main\resources\123_pdf-file.pdf"
Local $editControl = "[CLASS:Edit; INSTANCE:1]"
Local $buttonControl = "[CLASS:Button; INSTANCE:1]"
Local $windowTitle = "Open"

; Wait for the Open window to appear with error handling
If Not WinWait($windowTitle, "", 10) Then
    MsgBox(0, "Error", "Window 'Open' did not appear within 10 seconds.")
    Exit
EndIf

; Highlight the edit control
For $i = 1 To 3
    WinSetTrans($windowTitle, "", 180) ; Set transparency for the window
    ControlFocus($windowTitle, "", $editControl) ; Focus on the edit control
    Sleep(200) ; Wait for a short duration
    WinSetTrans($windowTitle, "", 255) ; Reset transparency for the window
    Sleep(200) ; Wait for a short duration
Next

; Highlight the button control
For $i = 1 To 3
    WinSetTrans($windowTitle, "", 180) ; Set transparency for the window
    ControlFocus($windowTitle, "", $buttonControl) ; Focus on the button control
    Sleep(200) ; Wait for a short duration
    WinSetTrans($windowTitle, "", 255) ; Reset transparency for the window
    Sleep(200) ; Wait for a short duration
Next

; Set text in the edit control
If Not ControlSetText($windowTitle, "", $editControl, $filePath) Then
    MsgBox(0, "Error", "Failed to set text in edit control.")
    Exit
EndIf

; Click the button
If Not ControlClick($windowTitle, "", $buttonControl) Then
    MsgBox(0, "Error", "Failed to click the button.")
    Exit
EndIf
