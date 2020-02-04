# Alohomora
A microservice which authenticates a login.

# About Project
Login pages are always the first thing we make when we start a project. meh! 😪<br> Honestly, it consumes unnecessary time and repetitive effort. To get rid of this I present you, <b>Alohomora</b> - A small microservice which just needs your DB credentials to start validating your logins for you.

# Just an api call. That's all you need 😍
```
/login/table/{tableName}
```
# About API 🙌
```
🤙 Type : POST
🤙 Consumes : application/json

🤙 Example Json to send:
    {
      "username" : "aman",
      "password" : "password"
    }
    
🤙  Return Type : Boolean
                  True  => if username and password is present in database
                  False => otherwise
```

# How to use? 🤔

### REQUIRED ヽ(´ー｀)ﾉ
 ```
 * Java 7 or Above
 * Maven
 ```
 
 ### Steps ⊂二二二（　＾ω＾）二⊃
```
* Clone the repository : git clone https://github.com/3point141/Alohomora-login-authenticator-microservice.git
* At the root directory of project run : mvn clean install -DskipTests
```
Now you have generated the jar file in the <b>target</b> folder. <br>
Run the jar file generated (Alohomora-1.0.jar).
```
java -jar Alohomora-1.0.jar -d <database connection url> -u <username> -p <password>
```

| CommandLine Argument  | Purpose |
|----|-------|
| -d| Database Connection URL |
| -u | Username required to login the database |
| -p | Password required to login the database |

# Feeling lazy? 🤨
I know the feeling. Sometimes all we need is something we can just plug and play. <b>Docker</b> to your rescue.

### Required ¯\_(ツ)_/¯
```
* Docker (Common! just one thing)
```

### Steps (^_^メ)
LOL Working on containerising the application. Just few more days ☕


# Author
Made with ❤️ by [Aman Kumar](https://github.com/3point141)<br>
:zap: This project is in very early stage. Some bugs can be noticed frequently. Feel free to test and report the bugs. 
