Dim fso, outFile
Set fso = CreateObject("Scripting.FileSystemObject")
Set outFile = fso.CreateTextFile("output.txt", True)

set rest = CreateObject("Chilkat_9_5_0.Rest")

' URL: https://example.com/rest/v10/oauth2/token
bTls = 1
port = 443
bAutoReconnect = 1
success = rest.Connect("example.com",port,bTls,bAutoReconnect)
If (success <> 1) Then
    outFile.WriteLine("ConnectFailReason: " & rest.ConnectFailReason)
    outFile.WriteLine(rest.LastErrorText)
    WScript.Quit
End If

' Note: The above code does not need to be repeatedly called for each REST request.
' The rest object can be setup once, and then many requests can be sent.  Chilkat will automatically
' reconnect within a FullRequest* method as needed.  It is only the very first connection that is explicitly
' made via the Connect method.

' Use this online tool to generate code from sample JSON: Generate Code to Create JSON

' The following JSON is sent in the request body.

' {
'   "grant_type": "password",
'   "client_id": "280045063461-qcdebmo0nr5opomedjoem9lc2cbouhtp.apps.googleusercontent.com",
'   "client_secret": "tQrn_GmEG7CaJaZfNRAO0yzy",
'   "username": "onbistestautomation@gmail.com",
'   "password": "TestAuto123!",
'   "platform": "custom"
' }

set json = CreateObject("Chilkat_9_5_0.JsonObject")
success = json.UpdateString("grant_type","password")
success = json.UpdateString("client_id","280045063461-qcdebmo0nr5opomedjoem9lc2cbouhtp.apps.googleusercontent.com")
success = json.UpdateString("client_secret","tQrn_GmEG7CaJaZfNRAO0yzy")
success = json.UpdateString("username","onbistestautomation@gmail.com")
success = json.UpdateString("password","TestAuto123!")
success = json.UpdateString("platform","custom")

success = rest.AddHeader("Cache-Control","no-cache")

set sbRequestBody = CreateObject("Chilkat_9_5_0.StringBuilder")
success = json.EmitSb(sbRequestBody)
set sbResponseBody = CreateObject("Chilkat_9_5_0.StringBuilder")
success = rest.FullRequestSb("POST","/rest/v10/oauth2/token",sbRequestBody,sbResponseBody)
If (success <> 1) Then
    outFile.WriteLine(rest.LastErrorText)
    WScript.Quit
End If

respStatusCode = rest.ResponseStatusCode
outFile.WriteLine("response status code = " & respStatusCode)
If (respStatusCode >= 400) Then
    outFile.WriteLine("Response Status Code = " & respStatusCode)
    outFile.WriteLine("Response Header:")
    outFile.WriteLine(rest.ResponseHeader)
    outFile.WriteLine("Response Body:")
    outFile.WriteLine(sbResponseBody.GetAsString())
    WScript.Quit
End If


outFile.Close