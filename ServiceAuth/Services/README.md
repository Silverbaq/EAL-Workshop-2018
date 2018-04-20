# Introduction
You will be able to find several services in different languages and frameworks.

## C#
Under C# you will find:

### BasicWebAPI (http://basicwebapi.azurewebsites.net)
A C# .NET Core Web API. This is a very simple solution, it can calc two numbers together by doing a GET request: 
* http://<path>/api/calc/add?a=2&b=4
* http://<path>/api/calc/sub?a=2&b=4
* http://<path>/api/calc/multi?a=2&b=4
* http://<path>/api/calc/div?a=12&b=4



### BasicAuthWebAPI (http://basicauthwebapi.azurewebsites.net)
A C# .NET Core Web API. This is solution uses "Basic Auth", it can add two numbers together by doing a GET request: 
* http://<path>/api/calc/add?a=2&b=4
* http://<path>/api/calc/sub?a=2&b=4
* http://<path>/api/calc/multi?a=2&b=4
* http://<path>/api/calc/div?a=12&b=4

For the implementation I used: https://github.com/msmolka/ZNetCS.AspNetCore.Authentication.Basic

The username is: userName
The password is: password


### BasicTokenWebAPI (http://basictokenwebapi.azurewebsites.net)
A C# .NET Core Web API. This is solution uses "Bearer Token Authentication". Request a token by POST request to:
* http://<path>/api/token/gettoken

Body:
{
	"username":"admin",
	"password":"password"
}

The service can add two numbers together by doing a GET request: 
* http://<path>/api/calc/add?a=2&b=4
* http://<path>/api/calc/sub?a=2&b=4
* http://<path>/api/calc/multi?a=2&b=4
* http://<path>/api/calc/div?a=12&b=4

## Scripts
In scripts, you will find a bash script that can be used to obtain the fingerprint for Certificate pinning.

### Usage example
```
sh ./certs.sh www.google.com
```
