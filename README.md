graphql project
Deploy to heroku
If you haven't already, log in to your Heroku account and follow the prompts to create a new SSH public key.

$ heroku login
Clone the repository
Use Git to clone spring-graphql's source code to your local machine.

$ heroku git:clone -a spring-graphql
$ cd spring-graphql    
Deploy your changes
Make some changes to the code you just cloned and deploy them to Heroku using Git.

$ git add .
$ git commit -am "make it better"
$ git push heroku main

