Dim fso, outFile
Set fso = CreateObject("Scripting.FileSystemObject")
Set outFile = fso.CreateTextFile("output.txt", True)

' This example requires the Chilkat API to have been previously unlocked.
' See Global Unlock Sample for sample code.

set oauth2 = CreateObject("Chilkat_9_5_0.OAuth2")

' For Google OAuth2, set the listen port equal to the port used
' in the Authorized Redirect URL for the Client ID.
' For example, in this case the Authorized Redirect URL would be http://localhost:55568/
' Your app should choose a port not likely not used by any other application.
oauth2.ListenPort = 55568

oauth2.AuthorizationEndpoint = "https://accounts.google.com/o/oauth2/v2/auth"
oauth2.TokenEndpoint = "https://www.googleapis.com/oauth2/v4/token"

' Replace these with actual values.
oauth2.ClientId = "280045063461-qcdebmo0nr5opomedjoem9lc2cbouhtp.apps.googleusercontent.com"
oauth2.ClientSecret = "tQrn_GmEG7CaJaZfNRAO0yzy"

oauth2.CodeChallenge = 1
oauth2.CodeChallengeMethod = "S256"

' See https://developers.google.com/gmail/api/auth/scopes for a list of GMail scopes.
' This is the full-permissions scope for GMail.
oauth2.Scope = "https://mail.google.com/"

' Important note about GMail scope for sending email:
' If the SMTP protocol is used for sending, then the full GMail scope is required: "https://mail.google.com/"
' Here is an example that sends GMail via the SMTP protocol:  Send GMail using SMTP
' If the GMail REST API is used, then the more restrictive Gmail scope can be used:  "https://www.googleapis.com/auth/gmail.send"
' Here is an example that sends GMail using the GMail REST API: Send GMail using REST API

' Begin the OAuth2 three-legged flow.  This returns a URL that should be loaded in a browser.
url = oauth2.StartAuth()
If (oauth2.LastMethodSuccess <> 1) Then
    outFile.WriteLine(oauth2.LastErrorText)
    WScript.Quit
End If

' At this point, your application should load the URL in a browser.
' For example, 
' in C#: System.Diagnostics.Process.Start(url);
' in Java: Desktop.getDesktop().browse(new URI(url));
' in VBScript: Set wsh=WScript.CreateObject("WScript.Shell")
'              wsh.Run url
' in Xojo: ShowURL(url)  (see http://docs.xojo.com/index.php/ShowURL)
' in Dataflex: Runprogram Background "c:\Program Files\Internet Explorer\iexplore.exe" sUrl        
' The QuickBooks account owner would interactively accept or deny the authorization request.

' Add the code to load the url in a web browser here...
' Add the code to load the url in a web browser here...
' Add the code to load the url in a web browser here...

' Now wait for the authorization.
' We'll wait for a max of 30 seconds.
numMsWaited = 0
Do While (numMsWaited < 30000) And (oauth2.AuthFlowState < 3)
    oauth2.SleepMs 100
    numMsWaited = numMsWaited + 100
Loop

' If there was no response from the browser within 30 seconds, then 
' the AuthFlowState will be equal to 1 or 2.
' 1: Waiting for Redirect. The OAuth2 background thread is waiting to receive the redirect HTTP request from the browser.
' 2: Waiting for Final Response. The OAuth2 background thread is waiting for the final access token response.
' In that case, cancel the background task started in the call to StartAuth.
If (oauth2.AuthFlowState < 3) Then
    success = oauth2.Cancel()
    outFile.WriteLine("No response from the browser!")
    WScript.Quit
End If

' Check the AuthFlowState to see if authorization was granted, denied, or if some error occurred
' The possible AuthFlowState values are:
' 3: Completed with Success. The OAuth2 flow has completed, the background thread exited, and the successful JSON response is available in AccessTokenResponse property.
' 4: Completed with Access Denied. The OAuth2 flow has completed, the background thread exited, and the error JSON is available in AccessTokenResponse property.
' 5: Failed Prior to Completion. The OAuth2 flow failed to complete, the background thread exited, and the error information is available in the FailureInfo property.
If (oauth2.AuthFlowState = 5) Then
    outFile.WriteLine("OAuth2 failed to complete.")
    outFile.WriteLine(oauth2.FailureInfo)
    WScript.Quit
End If

If (oauth2.AuthFlowState = 4) Then
    outFile.WriteLine("OAuth2 authorization was denied.")
    outFile.WriteLine(oauth2.AccessTokenResponse)
    WScript.Quit
End If

If (oauth2.AuthFlowState <> 3) Then
    outFile.WriteLine("Unexpected AuthFlowState:" & oauth2.AuthFlowState)
    WScript.Quit
End If

' Save the full JSON access token response to a file.
set sbJson = CreateObject("Chilkat_9_5_0.StringBuilder")
success = sbJson.Append(oauth2.AccessTokenResponse)
success = sbJson.WriteFile("qa_data/tokens/gmail.json","utf-8",0)

' The saved JSON response looks like this:

' 	{
' 	 "access_token": "ya39.Ci-XA_C5bGgRDC3UaD-h0_NeL-DVIQnI2gHtBBBHkZzrwlARkwX6R3O0PCDEzRlfaQ",
' 	 "token_type": "Bearer",
' 	 "expires_in": 3600,
' 	 "refresh_token": "1/r_2c_7jddspcdfesrrfKqfXtqo08D6Q-gUU0DsdfVMsx0c"
' 	}
' 
outFile.WriteLine("OAuth2 authorization granted!")
outFile.WriteLine("Access Token = " & oauth2.AccessToken)

outFile.Close