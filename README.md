# solent_MAD
Exercises for Solent University Mobile Application Development SWD504

The course material for each session is available here
https://edward2.solent.ac.uk/course/mad (Only available for logged in Solent Students)

# Creating your repository

You can choose to save your work on a USB stick but it will be much safer and better practice to use Github to store your work as you go along. 

1. If you do not have one, create a new account on github

2. On github, create a new repository for the class. Name is something like CM504 or solent_MAD. 
IMPORTANT initialise the repository with the Android .gitignore file. (you may also select to create a README.md file). 
This will prevent you checking in intelij / Android specific build files which will filling up your repo with junk

3. check out your new repository onto your local machine. 
First create a new folder near the root of C: drive, call it gitrepos. 
Right click on the folder and Open a git bash terminal. 
Get the url of the repository by right clicking on CLONE OR DOWNLOAD. Copy the HTTPS url and in the git terminal type
```
git clone https://-YOUR REPOSITORY URL-
cd -YOUR REPOSITORY-
git status
```
This will check you have correctly checked out the repo. You will need to check out the repo every week as the C: drive will be wiped.

# Using your repository
Instead of creating a new repository for every project done in class, you should use the same repo for multiple projects but place each project in a seperate folder.

Create a new folder called session1. Use this folder to create your new android project as explained in Nicks notes in https://edward2.solent.ac.uk/course/mad/part1.xhtml . However you should create the project in the folder you have just created in your repo as below;

![alt text](../master/images/CreateProject.png "Figure CreateProject.png")

Note that if you have checked out your project into
```
C://gitrepos/solent_MAD/
```
and created a new session1 folder, then your HelloWorld project should be created in 
```
C://gitrepos/solent_MAD/session1/HelloWorld
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

# Next Time checking out your work
The next time you want to work on your project, you will need to point Androind Studio to the checked out project

1. check out your project again using git clone etc

2. open android studio and select your project as below
```
C://gitrepos/solent_MAD/session1/HelloWorld
```
![alt text](../master/images/WelcomeOpenProject.png "Figure WelcomeOpenProject.png")

![alt text](../master/images/OpenProject.png "Figure OpenProject.png")

Your project will be imported into Android Studio and built.




