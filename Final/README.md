# README
## Source code
The project is zipped as an archieved compressed file, **5100.zip**. 

Please **import the zip file to any IDE** you're using. The project will be detected by your IDE.

##  Usage
The project entrance is in the **Main** class under the **main** packge, Please start from there. 

## Login Information
| UserName | Password | isAdmin |
|:--------:|:--------:|:-------:|
| Admin    | Admin    | true    |
| AAA      | AAA      | false   |

All the user data will be printed out in the console once the program launched, but the password is stored in encrypted text. So you may need above login informaiton.

## 3rd library
The only 3rd library used for this project is **sqlite-jdbc**. If you dont have it, please download from: https://github.com/xerial/sqlite-jdbc/releases

The project is mainly built on Java swing and SQLite. In order to access the file database, please make sure you have that.

## Error Handle
Most invalid and illegal inputs in any Panel are well-handled as alert will prompt to indicate there is something wrong.
