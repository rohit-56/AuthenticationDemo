# AuthenticationDemo

# Tech Stack

 - JAVA
 - SPRING BOOT
 - GRADLE
 - SPRING SECURITY
 - JWT AUTHENTICATION
 
 
 # Step 1
 
  - Create spting boot project using Spring initialzr
  - Create an endpoint - Get Hello message
  - Now adding spring security dependency which provides by default form-based authentication 
  - So we create custom username and password which we validate and get access to an endpoint
  - Create class SecurityConfig which extends WebSecurityConfigurerAdapter and configure it
  - Create custom UserDetailService as MyUserDetailsService which implements an spring interface UserDetailsService and override method loadUserByUsername
   and give custom username and password.
   
# Step 2

Now to authenticate based on token adding jwt dependency in build.gradle file.

- Now create an endpoint to /authenticate which accepts username and password.
- Returns JWT as response

  - Create JWTUtil class for all methods regarding token-expiry , getusername,etc.
  - Create AuthenticationRequest and AuthenticationResponse classes
   
   
