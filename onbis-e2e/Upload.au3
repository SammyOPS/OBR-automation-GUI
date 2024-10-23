Local $filePath = @ScriptDir & "\src\main\resources\123_pdf-file.pdf"
Local $editControl = "[CLASS:Edit; INSTANCE:1]"
Local $buttonControl = "[CLASS:Button; INSTANCE:1]"
Local $windowTitle = "Open"
Local $errorLogFile = @ScriptDir & "\src\main\resources\UploadInfo.txt"

; Wait for the Open window to appear with error handling
If Not WinWait($windowTitle, "", 10) Then
    _WriteErrorLog("Window 'Open' did not appear within 10 seconds.")
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
    _WriteErrorLog("Failed to set text in edit control.")
    Exit
EndIf

; Click the button
If Not ControlClick($windowTitle, "", $buttonControl) Then
    _WriteErrorLog("Failed to click the button.")
    Exit
EndIf
_WriteErrorLog("'123_pdf-file.pdf' file was successfully uploaded.")
Func _WriteErrorLog($errorMessage)
    Local $fileHandle = FileOpen($errorLogFile, 1) ; Open file for writing, create if does not exist
    If $fileHandle = -1 Then ; Check if file handle is valid
        MsgBox(0, "Error", "Failed to open error log file.")
        Exit
    EndIf
    FileWriteLine($fileHandle, @YEAR & "/" & @MON & "/" & @MDAY & " " & @HOUR & ":" & @MIN & ":" & @SEC & "-------: " & $errorMessage & " :-------") ; Write error message to file
    FileClose($fileHandle) ; Close file handle
EndFunc   ;==>_WriteErrorLog
