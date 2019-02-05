# solent_MAD
Exercises for Solent University Mobile Application Development SWD504

The course material for each session is available here
https://edward2.solent.ac.uk/course/mad (Only available for logged in Solent Students)

# Example Answers
My examples are listed below (do not look at until you try for yourself)

[Topic 1 Introduction](../master/topic1)

[Topic 2 Layouts and Event Handling](../master/topic2)

[Topic 3 Mapping](../master/topic3)

[Topic 4 Menus and Multiple Activities](../master/topic4)

[Topic 5 Preferences](../master/topic5)

[Topic 6 Lists](../master/topic6)

[Topic 7 Exceptions](../master/topic7)

[Topic 8 File I/O](../master/topic8)

[Topic 9 AsyncTask and Network Communication](../master/topic9)

[Topic 10 JSON parsing](../master/topic10)

[Topic 11 Further Mapping: Markers](../master/topic11)

[Topic 12 Location and GPS](../master/topic12)

[Topic 13 Fragments](../master/topic13)

# Getting Started - Using Git

You can choose to save your work on a USB stick but it will be better practice (and less chance of loosing anything) if you use Github to store your work as you go along.  

You should check all of your class work into the folder [AAA_MyClassWork](../master/AAA_MyClassWork/)
(for conveniencec the AAA is to make sure it is alphabetically the top folder in your directory)

NOTE ONLY MAKE CHANGES IN YOUR [AAA_MyClassWork](../master/AAA_MyClassWork/) PROJECT DIRECTORY TO AVOID CLASHES WITH UPSTREAM REPO

# Creating your repository

1. If you do not have one, create a new account on github and / or sign into your account.

2. The easiest way to get started will be to fork my repository. Navigate to my repo https://github.com/gallenc/solent_MAD/ and click FORK on top right hand side. You will now have a copy (or clone) of this repo in your own github account.

(ALTERNATIVELY) if you are creating a new empty repo for android development on github, create a new repository for the class. Name is something like CM504 or solent_MAD. 

IMPORTANT initialise the repository with the Android .gitignore file. (you may also select to create a README.md file). 
This will prevent you checking in intelij / Android specific build files which will filling up your repo with junk.)

3. Check out your new repository onto your local machine. 
First create a new folder in a user accessable location near the root of C: drive or in your C:/users/-YOUR-USERNAME- folder. Call it something like gitrepos. Make sure it has no spaces in the classpath name. e.g.
```
C:\Users\gallenc\gitrepos\
```
Right click in the folder and open a git bash terminal. 
Get the url of the repository by right clicking on CLONE OR DOWNLOAD. Copy the HTTPS url (NOT the git:// url) and in the git terminal type
```
git clone https://-YOUR REPOSITORY URL-
cd -YOUR REPOSITORY-

cd C:\Users\gallenc\gitrepos\solent_MAD  # modify for your folder

git status
```
This will check you have correctly checked out the repo. 

IMPORTANT You will need to clone your every session as the C: drive will be wiped when you log out.

# Using your repository
Instead of creating a new repository for every exercise in class, you should use the same repo for multiple projects but place each project in a seperate folder.

To get started copy my example session1 folder into your [AAA_MyClassWork](../master/AAA_MyClassWork/) directory.

Now open android studio in that folder e.g in
```
C:\Users\gallenc\gitrepos\AAA_MyClassWork\session1\HelloWorld
```
Create a new folder called session1. Use this folder to create your new android project as explained in Nicks notes in https://edward2.solent.ac.uk/course/mad/part1.xhtml . However you should create the project in the folder you have just created in your repo as below;

![alt text](../master/images/CreateProject.png "Figure CreateProject.png")

Note that if you have checked out your project into
```
C://gitrepos/solent_MAD/
```
and created a new session1 folder, then your HelloWorld project should be created in 
```
C://gitrepos/solent_MAD/AAA_MyClassWork/session1/HelloWorld
```
IMPORTANT - DO NOT HAVE ANY SPACES IN YOUR CLASS PATH

# Checking in your work
You should regularly commit changes as you go along and at the end of your class you should push your changes back up to your repository
```
# add all of the changew to the latest commit
git add --all
# commit your changes
git commit -m 'this is my first commit...'
# check all is ok
git status
# push your changes
git push

```
IMPORTANT - MAKE SURE YOU CAN SEE YOUR FILES IN YOUR  GITHUB REPOSITORY AFTER YOU HAVE CHECKED THEM IN.

# Next Time checking out your work
The next time you want to work on your project, you will need to point Android Studio to the checked out project

1. check out your project again using git clone etc

2. open android studio and select your project as below
```
C://gitrepos/solent_MAD/AAA_MyClassWork/session1/HelloWorld
```
![alt text](../master/images/WelcomeOpenProject.png "Figure WelcomeOpenProject.png")

![alt text](../master/images/OpenProject.png "Figure OpenProject.png")

Your project will be imported into Android Studio and built.

Alternatively you can create a new folder for the next session.
```
C://gitrepos/solent_MAD/AAA_MyClassWork/session2/...
```




