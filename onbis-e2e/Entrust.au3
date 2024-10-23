#include <MsgBoxConstants.au3>

Local $timeout = 10 ; Maximum wait time in seconds
Local $windowTitles[2] = ["Entrust Security Store Unlock", "Entrust Security Store Login"]
Local $windowTitle = ""
Local $password = "Ps1sCatalyst"
Local $errorLogFile = @ScriptDir & "\src\main\resources\EntrustInfo.txt"

; Set transparency for the windows
For $i = 0 To UBound($windowTitles) - 1
    WinSetTrans($windowTitles[$i], "", 180)
Next

; Wait for any of the windows to appear with a timeout
For $i = 0 To UBound($windowTitles) - 1
    If WinWait($windowTitles[$i], "", $timeout) Then
        $windowTitle = $windowTitles[$i]
        ExitLoop
    EndIf
Next

; If none of the windows appeared within the timeout, exit
If $windowTitle = "" Then
    _WriteErrorLog("None of the windows appeared within " & $timeout & " seconds.")
    Exit
EndIf

; Get the handle of the edit field
$hWnd = WinGetHandle($windowTitle)
$hEdit = ControlGetHandle($hWnd, "", "[CLASS:Edit; INSTANCE:1]")

; Check if the edit field handle is valid
If $hEdit = 0 Then
    _WriteErrorLog("Edit field not found.")
    Exit
EndIf

; Type the password into the edit field
If Not ControlSetText($hWnd, "", $hEdit, $password) Then
    _WriteErrorLog("Failed to set text in edit control.")
    Exit
EndIf

; Click the OK button
If Not ControlClick($hWnd, "", "[CLASS:Button; TEXT:OK]") Then
    _WriteErrorLog("Failed to click the OK button.")
    Exit
EndIf

_WriteErrorLog("Entered password and clicked OK button.")

; Reset transparency for the windows
For $i = 0 To UBound($windowTitles) - 1
    WinSetTrans($windowTitles[$i], "", 255)
Next

Func _WriteErrorLog($errorMessage)
    Local $fileHandle = FileOpen($errorLogFile, 1) ; Open file for writing, create if does not exist
    If $fileHandle = -1 Then ; Check if file handle is valid
        MsgBox($MB_OK, "Error", "Failed to open error log file.")
        Exit
    EndIf
    FileWriteLine($fileHandle, @YEAR & "/" & @MON & "/" & @MDAY & " " & @HOUR & ":" & @MIN & ":" & @SEC & "-------: " & $errorMessage & " :-------") ; Write error message to file
    FileClose($fileHandle) ; Close file handle
EndFunc   ;==>_WriteErrorLog
