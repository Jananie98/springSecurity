Outsourcing Authentication with OAuth2 and OpenID

In the old basic authentication and authorization process a particular user was validated by matching the hash values stored in our database and then creating a session with the authenticated user. 
But with the high volume of user requests this authentication and authorization process has become more complex and difficult to handle. Here comes the OAuth2 and OpenID Connect. 

OAuth2 or Open Authorization 2.0 is a standard designed to allow an application to access resources hosted by other web apps. 
These resource-hosted web apps which are called resource servers could be Google, Facebook, Github, Twitter, etc. OpenID Connect is an identity protocol that is an extension of OAuth2. 

OAuth2 Journey

The user request is redirected to the authorization server to authenticate the user. 
If the user is not already logged in with the relevant server, needs to do so. 
Once the user is authenticated authorization server use the client id and scope to access the relevant user details. 
With the user's agreement requested user details are shared with the application.
![OAuth2 process]()

Configurations for OAuth2

For a maven build file add the following two dependencies in your pom.xml file
Spring security oauth2 client
Spring security oauth2 Jose


Add the client id, client secret, and other relevant properties to your application.properties file.

For Google, the client id and secret can be generated from Google Cloud Console (https://console.cloud.google.com/)


Override the existing security filter chain with the following code component.

Start the application. (http://localhost:<<your port>>

You will have a UI as follows,





    
